package com.example.finalassignment.adapters

import android.content.Context
import android.os.Build
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.finalassignment.R
import com.example.finalassignment.models.EmployeeModel
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.*
import java.util.Calendar.*

class EmployeeAdapter(var context: Context,var employeeModel: ArrayList<EmployeeModel>): RecyclerView.Adapter<EmployeeAdapter.EmployeeViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EmployeeViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_employee,parent,false)
        return EmployeeViewHolder(view)
    }

    override fun onBindViewHolder(holder: EmployeeViewHolder, position: Int) {
        holder.bind(employeeModel.get(position))
    }

    override fun getItemCount(): Int {
       return employeeModel.size
    }


    class EmployeeViewHolder(view: View):RecyclerView.ViewHolder(view) {
        val empName :TextView = view.findViewById(R.id.tvEmployeeName)
        val empDepartment :TextView = view.findViewById(R.id.tvEmployeeDepartmentName)
        val empTitle :TextView = view.findViewById(R.id.tvEmployeeTitle)
        val empGender :TextView = view.findViewById(R.id.tvEmployeeGender)
        val empWorkingYears :TextView = view.findViewById(R.id.tvTimeSpent)
        val hireDate :TextView = view.findViewById(R.id.tvHireDate)
        val salary : TextView = view.findViewById(R.id.tvEmployeeSalary)

        fun bind(data :EmployeeModel) {

            var name: String = data.first_name + " " + data.last_name
            empName.text = name
            empDepartment.text = data.department
            empTitle.text = data.title
            empGender.text = data.gender
            hireDate.text = data.hire_date
            empWorkingYears.text =getExperience(data.hire_date)
            salary.text = data.salary.toString()


        }

        fun  getExperience(date: String): String{

            val sdf = SimpleDateFormat("yyyy-mm-dd")
            val date1: Date = sdf.parse(date)
            val date2: Date? = sdf.parse(getCurrentDate())
            var exp = getDiffYears(date1,date2)
            Log.d("EXPP",exp.toString())
            return exp.toString()


        }
        fun getCurrentDate():String{
            val sdf = SimpleDateFormat("yyyy-MM-dd")
            return sdf.format(Date())
        }


        fun getDiffYears(first: Date?, last: Date?): Int {
            val a = getCalendar(first)
            val b = getCalendar(last)
            var diff = b[YEAR] - a[YEAR]
            if (a[MONTH] > b[MONTH] ||
                a[MONTH] === b[MONTH] && a[DATE] > b[DATE]
            ) {
                diff--
            }
            return diff
        }

        fun getCalendar(date: Date?): Calendar {
            val cal = Calendar.getInstance(Locale.US)
            cal.time = date
            return cal
        }

    }

}