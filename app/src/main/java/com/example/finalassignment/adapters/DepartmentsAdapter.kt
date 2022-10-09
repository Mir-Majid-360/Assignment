package com.example.finalassignment.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.finalassignment.R
import com.example.finalassignment.models.Departments

class DepartmentsAdapter(var context: Context, var departments: ArrayList<Departments>) :RecyclerView.Adapter<DepartmentsAdapter.DepartmentsViewHolder>(){





    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DepartmentsViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_dapartment,parent,false)
        return DepartmentsViewHolder(view)
    }

    override fun onBindViewHolder(holder: DepartmentsViewHolder, position: Int) {
        holder.bind(departments.get(position))

        holder.itemView


    }

    override fun getItemCount(): Int {
        return departments.size
    }


    class DepartmentsViewHolder(view: View):RecyclerView.ViewHolder(view) {

        val depName :TextView = view.findViewById(R.id.tvDepartmentName)
        fun bind(data:Departments){
            depName.text = data.dept_name
        }

    }
}