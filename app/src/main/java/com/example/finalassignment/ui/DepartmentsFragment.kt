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
import com.example.finalassignment.R
import com.example.finalassignment.adapters.DepartmentsAdapter
import com.example.finalassignment.databinding.FragmentDepartmentsBinding
import com.example.finalassignment.models.Departments
import com.example.finalassignment.viewmodel.MainViewModel

class DepartmentsFragment : Fragment() {
    lateinit var binding: FragmentDepartmentsBinding
    lateinit var mainViewModel: MainViewModel
    var list = ArrayList<Departments>()


    lateinit var recyclerView: RecyclerView
    lateinit var departmentsAdapter: DepartmentsAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentDepartmentsBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViewModel()
        initAdapter()
        setListeners()

    }

    private fun setListeners() {
        binding.toolbar.tvTitle.text ="Departments"
    }

    fun initAdapter() {
        list.clear()
        list = mainViewModel.getDepartments()
        recyclerView = binding.departmentsRecyclerView
        departmentsAdapter = DepartmentsAdapter(activity as Context, list)
        recyclerView.layoutManager = LinearLayoutManager(activity)
        recyclerView.adapter = departmentsAdapter
        departmentsAdapter.notifyDataSetChanged()

    }


    companion object {

        @JvmStatic
        fun newInstance() =
            DepartmentsFragment()
    }
    private fun initViewModel() {


        mainViewModel = ViewModelProvider(requireActivity()).get(MainViewModel::class.java)
    }
}