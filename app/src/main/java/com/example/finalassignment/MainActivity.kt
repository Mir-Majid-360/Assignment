package com.example.finalassignment

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import androidx.lifecycle.ViewModelProvider
import com.example.finalassignment.databinding.ActivityMainBinding
import com.example.finalassignment.ui.*
import com.example.finalassignment.viewmodel.MainViewModel

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    lateinit var mainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initViewModel()
        observeViewModel()
        mainViewModel.setOpenHomeFragment(arrayOf(1, 2))
    }




    private fun observeViewModel() {

        mainViewModel.getOpenHomeFragment().observe(this) { event ->
            val objects: Array<Any>? = event.getContentIfNotHandled()
            if (objects != null) {
                openFragment(HomeFragment.newInstance(), "")
            }
        }
        mainViewModel.getOpenEmployeeDetailsFragment().observe(this) { event ->
            val objects: Array<Any>? = event.getContentIfNotHandled()
            if (objects != null) {
                openFragment(EmployeeDetailsFragment.newInstance(), "")
            }
        }
        mainViewModel.getOpenDepartmentsFragment().observe(this) { event ->
            val objects: Array<Any>? = event.getContentIfNotHandled()
            if (objects != null) {
                openFragment(DepartmentsFragment.newInstance(), "")
            }
        }
        mainViewModel.getOpenDepartmentDetailsFragment().observe(this) { event ->
            val objects: Array<Any>? = event.getContentIfNotHandled()
            if (objects != null) {
                openFragment(DepartmentDetailsFragment.newInstance(), "")
            }
        }
        mainViewModel.getOpenEmployeesFragment().observe(this) { event ->
            val objects: Array<Any>? = event.getContentIfNotHandled()
            if (objects != null) {
                openFragment(EmployeesFragment.newInstance(), "")
            }
        }


    }

    private fun openFragment(fragment: Fragment, tag: String) {
        val transaction = supportFragmentManager.beginTransaction()
        setFragmentTransactionAnimation(transaction, tag)
        transaction.replace(R.id.main_container, fragment, tag)
        transaction.addToBackStack(tag)
        transaction.commit()
    }

    private fun setFragmentTransactionAnimation(transaction: FragmentTransaction, tag: String) {
        transaction.setCustomAnimations(
            R.anim.enter_from_right,
            R.anim.exit_to_left,
            R.anim.enter_from_left,
            R.anim.exit_to_right
        )
    }


    private fun initViewModel() {

        mainViewModel = ViewModelProvider(this).get(MainViewModel::class.java)
    }
}