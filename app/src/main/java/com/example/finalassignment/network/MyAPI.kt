package com.example.finalassignment.network

import com.example.finalassignment.models.*
import retrofit2.Response
import retrofit2.http.GET

interface MyAPI {

        //https://firebasestorage.googleapis.com

    @GET("/v0/b/final-assignment-ce90b.appspot.com/o/department_manager.json?alt=media&token=c9a2aa04-a27c-4d7f-9f54-4969464ffe14")
    suspend fun getDepartmentManager(): Response<ArrayList<DepartmentManager>>

    //gs://final-assignment-ce90b.appspot.com/departments.json
    @GET("/v0/b/final-assignment-ce90b.appspot.com/o/departments.json?alt=media&token=6afe311d-e469-49e7-b7fa-66c8a0c4e025")
    suspend fun getDepartments(): Response<ArrayList<Departments>>

    @GET("/v0/b/final-assignment-ce90b.appspot.com/o/emp_departments.json?alt=media&token=c9a2aa04-a27c-4d7f-9f54-4969464ffe14")
    suspend fun getEmpDepartments(): Response<ArrayList<EmpDepartments>>


    @GET("/v0/b/final-assignment-ce90b.appspot.com/o/employees.json?alt=media&token=c9a2aa04-a27c-4d7f-9f54-4969464ffe14")
    suspend fun getEmployees(): Response<ArrayList<Employees>>

    @GET("/v0/b/final-assignment-ce90b.appspot.com/o/salaries.json?alt=media&token=c9a2aa04-a27c-4d7f-9f54-4969464ffe14")
    suspend fun getSalaries(): Response<ArrayList<Salaries>>

    @GET("/v0/b/final-assignment-ce90b.appspot.com/o/titles.json?alt=media&token=c9a2aa04-a27c-4d7f-9f54-4969464ffe14")
    suspend fun getTitles(): Response<ArrayList<Titles>>








}