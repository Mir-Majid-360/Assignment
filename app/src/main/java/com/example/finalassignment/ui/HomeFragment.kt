package com.example.finalassignment.ui

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.finalassignment.R
import com.example.finalassignment.adapters.DepartmentsAdapter
import com.example.finalassignment.databinding.FragmentHomeBinding
import com.example.finalassignment.models.DepartmentManager
import com.example.finalassignment.models.Departments
import com.example.finalassignment.viewmodel.MainViewModel

class HomeFragment : Fragment() {

    lateinit var binding: FragmentHomeBinding
    lateinit var mainViewModel: MainViewModel



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    @SuppressLint("FragmentLiveDataObserve")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initViewModel()
        initListeners()



    }

    private fun initListeners() {
        binding.toolbar.tvTitle.text ="Home"
        binding.itemDepartments.tvTitle.text ="Departments"
        binding.itemEmployees.tvTitle.text ="Employees"
        binding.itemDepartments.root.setOnClickListener {
            mainViewModel.setOpenDepartmentsFragment(arrayOf<Any>(1,2))
        }
        binding.itemEmployees.root.setOnClickListener {
            mainViewModel.setOpenEmployeesFragment(arrayOf<Any>(1,2))
        }
    }


    companion object {

        @JvmStatic
        fun newInstance() =
            HomeFragment()
    }


    private fun initViewModel() {


        mainViewModel = ViewModelProvider(requireActivity()).get(MainViewModel::class.java)
    }
}