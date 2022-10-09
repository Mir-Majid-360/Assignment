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
import com.example.finalassignment.adapters.EmployeeAdapter
import com.example.finalassignment.databinding.FragmentEmployeesBinding
import com.example.finalassignment.models.Employees
import com.example.finalassignment.viewmodel.MainViewModel

class EmployeesFragment : Fragment() {
    lateinit var binding: FragmentEmployeesBinding
    lateinit var mainViewModel: MainViewModel
    var list = ArrayList<Employees>()

    lateinit var recyclerView: RecyclerView
    lateinit var employeeAdapter: EmployeeAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentEmployeesBinding.inflate(inflater,container,false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViewModel()
//      list= mainViewModel.getDepartments()
        initAdapter()

    }
    fun initAdapter() {
        list.clear()
        recyclerView = binding.employeesRecyclerView
        employeeAdapter = EmployeeAdapter(activity as Context, list)
        recyclerView.layoutManager = LinearLayoutManager(activity)
        recyclerView.adapter = employeeAdapter
        employeeAdapter.notifyDataSetChanged()

    }


    companion object {

        @JvmStatic
        fun newInstance() =
            EmployeesFragment()
    }

    private fun initViewModel() {


        mainViewModel = ViewModelProvider(requireActivity()).get(MainViewModel::class.java)
    }
}