package com.example.finalassignment.repository

import androidx.lifecycle.MutableLiveData
import com.example.finalassignment.BaseApp
import com.example.finalassignment.database.MyDatabase
import com.example.finalassignment.models.*
import com.example.finalassignment.network.MyAPI
import retrofit2.Response

class Repository(val myAPI: MyAPI) {


    lateinit var myDatabase: MyDatabase

    init {
        myDatabase = MyDatabase(BaseApp.context)
    }


    suspend fun getDepartments(): Response<ArrayList<Departments>> {
        return myAPI.getDepartments()
    }

    suspend fun getDepartmentManager(): Response<ArrayList<DepartmentManager>> {
        return myAPI.getDepartmentManager()
    }


    suspend fun getSalaries(): Response<ArrayList<Salaries>> {
        return myAPI.getSalaries()
    }


    suspend fun getEmpDepartment(): Response<ArrayList<EmpDepartments>> {
        return myAPI.getEmpDepartments()
    }


    suspend fun getTitles(): Response<ArrayList<Titles>> {
        return myAPI.getTitles()
    }

    suspend fun getEmployees(): Response<ArrayList<Employees>> {
        return myAPI.getEmployees()
    }

    fun saveDepartmentsManager(list: ArrayList<DepartmentManager>) {
        for (departmentsManager in list) {

            myDatabase.addDepartmentManager(departmentsManager)
        }


    }

    fun saveDepartments(list: ArrayList<Departments>) {
        for (departments in list) {

            myDatabase.addDepartment(departments)
        }


    }

    fun saveEmpDepartments(list: ArrayList<EmpDepartments>) {
        for (employeeDept in list) {

            myDatabase.addEmpDepartment(employeeDept)
        }


    }

    fun saveEmployee(list: ArrayList<Employees>) {
        for (employee in list) {

            myDatabase.addEmployee(employee)
        }


    }

    fun saveSalaries(list: ArrayList<Salaries>) {
        for (salaries in list) {

            myDatabase.addSalaries(salaries)
        }


    }

    fun saveTitles(list: ArrayList<Titles>) {
        for (titles in list) {

            myDatabase.addTitles(titles)
        }


    }

    fun getDepartmentsData(): ArrayList<Departments> {

        return myDatabase.getDepartments()
    }

    fun getDepartmentsManagerData(): ArrayList<DepartmentManager> {
        return myDatabase.getDepartmentManager()
    }

    fun getEmployeeModelDaa():ArrayList<EmployeeModel>{
        return  myDatabase.getEmployeeModel()
    }


}