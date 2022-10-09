package com.example.finalassignment.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.finalassignment.R
import com.example.finalassignment.models.Employees

class EmployeeAdapter(var context: Context,var employees: ArrayList<Employees>): RecyclerView.Adapter<EmployeeAdapter.EmployeeViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EmployeeViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_employee,parent,false)
        return EmployeeAdapter.EmployeeViewHolder(view)
    }

    override fun onBindViewHolder(holder: EmployeeViewHolder, position: Int) {

        holder.itemView
    }

    override fun getItemCount(): Int {
       return employees.size
    }


    class EmployeeViewHolder(view: View):RecyclerView.ViewHolder(view) {
        val empName :TextView = view.findViewById(R.id.tvEmployeeName)
        val empDepartment :TextView = view.findViewById(R.id.tvDepartmentName)
        val empTitle :TextView = view.findViewById(R.id.tvEmployeeTitle)
        val empGender :TextView = view.findViewById(R.id.tvGender)
        val empWorkingYears :TextView = view.findViewById(R.id.tvYearsSpent)

        fun bind(data :Employees){

            empDepartment.text = data.first_name
            empGender.text = data.gender


        }

    }

}