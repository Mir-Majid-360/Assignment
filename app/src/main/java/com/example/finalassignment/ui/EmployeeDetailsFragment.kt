package com.example.finalassignment.ui

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.finalassignment.adapters.DepartmentsAdapter
import com.example.finalassignment.adapters.EmployeeAdapter
import com.example.finalassignment.databinding.FragmentEmployeeDetailsBinding
import com.example.finalassignment.models.Employees
import com.example.finalassignment.viewmodel.MainViewModel

class EmployeeDetailsFragment : Fragment() {
    lateinit var  binding: FragmentEmployeeDetailsBinding
    lateinit var mainViewModel: MainViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentEmployeeDetailsBinding.inflate(inflater,container,false)
        return  binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initViewModel()
//      list= mainViewModel.getDepartments()




    }



    companion object {

        @JvmStatic
        fun newInstance() =
            EmployeeDetailsFragment()
    }

    private fun initViewModel() {


        mainViewModel = ViewModelProvider(requireActivity()).get(MainViewModel::class.java)
    }
}