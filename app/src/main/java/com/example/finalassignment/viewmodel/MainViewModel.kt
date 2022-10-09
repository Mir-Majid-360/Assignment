package com.example.finalassignment.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.finalassignment.models.*
import com.example.finalassignment.network.MyAPI
import com.example.finalassignment.network.RetrofitInstance
import com.example.finalassignment.repository.Repository
import com.example.finalassignment.utils.Event
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel() : ViewModel() {

    private var openHomeFragment: MutableLiveData<Event<Array<Any>>> =
        MutableLiveData<Event<Array<Any>>>()

    private var openEmployeeDetailsFragment: MutableLiveData<Event<Array<Any>>> =
        MutableLiveData<Event<Array<Any>>>()
    private var openDepartDetailsFragment: MutableLiveData<Event<Array<Any>>> =
        MutableLiveData<Event<Array<Any>>>()

    private var openEmployeesFragment: MutableLiveData<Event<Array<Any>>> =
        MutableLiveData<Event<Array<Any>>>()
    private var openDepartmentsFragment: MutableLiveData<Event<Array<Any>>> =
        MutableLiveData<Event<Array<Any>>>()



    var repository: Repository


    init {
        val myAPI = RetrofitInstance.getRetrofitInstance().create(MyAPI::class.java)
        repository = Repository(myAPI)
        viewModelScope.launch(Dispatchers.IO) {



            val departmentsData = repository.getDepartments()
            if (departmentsData.isSuccessful && departmentsData.code() == 200) {
                repository.saveDepartments(departmentsData.body()!!)


            }
            val managerData = repository.getDepartmentManager()

            if (managerData.isSuccessful && managerData.code() == 200) {

                repository.saveDepartmentsManager(managerData.body()!!)


            }

            val salariesData = repository.getSalaries()
            if (salariesData.isSuccessful && salariesData.code() == 200) {
                repository.saveSalaries(salariesData.body()!!)


            }



            val empDepartmentsData = repository.getEmpDepartment()
            if (empDepartmentsData.isSuccessful && empDepartmentsData.code() == 200) {
                repository.saveEmpDepartments(empDepartmentsData.body()!!)


            }
            val titleData = repository.getTitles()
            if (titleData.isSuccessful && titleData.code() == 200) {
                repository.saveTitles(titleData.body()!!)


            }
            val employeesData = repository.getEmployees()
            if (employeesData.isSuccessful && employeesData.code() == 200) {
                repository.saveEmployee(employeesData.body()!!)

            }




        }


    }




    fun getOpenHomeFragment(): MutableLiveData<Event<Array<Any>>> {
        return openHomeFragment
    }

    fun setOpenHomeFragment(objects: Array<Any>) {
        openHomeFragment.value = Event(objects)
    }



    fun getOpenEmployeeDetailsFragment(): MutableLiveData<Event<Array<Any>>> {
        return openEmployeeDetailsFragment
    }

    fun setOpenEmployeeDetailsFragment(objects: Array<Any>) {
        openEmployeeDetailsFragment.value = Event(objects)
    }
    fun getOpenDepartmentDetailsFragment(): MutableLiveData<Event<Array<Any>>> {
        return openDepartDetailsFragment
    }

    fun setOpenDepartmentDetailsFragment(objects: Array<Any>) {
        openDepartDetailsFragment.value = Event(objects)
    }
    fun getOpenDepartmentsFragment(): MutableLiveData<Event<Array<Any>>> {
        return openDepartmentsFragment
    }

    fun setOpenDepartmentsFragment(objects: Array<Any>) {
        openDepartmentsFragment.value = Event(objects)
    }
    fun getOpenEmployeesFragment(): MutableLiveData<Event<Array<Any>>> {
        return openEmployeesFragment
    }

    fun setOpenEmployeesFragment(objects: Array<Any>) {
        openEmployeesFragment.value = Event(objects)
    }






    fun getDepartments(): ArrayList<Departments> {

        return repository.getDepartmentsData()
    }
    fun getDepartmentsManager():ArrayList<DepartmentManager>{
        return repository.getDepartmentsManagerData()
    }
//    fun getDepartmentsManager():ArrayList<DepartmentManager>{
//        return repository.getDepartmentManagerData()
//    }
//    fun getDepartmentsManager():ArrayList<DepartmentManager>{
//        return repository.getDepartmentManagerData()
//    }
//    fun getDepartmentsManager():ArrayList<DepartmentManager>{
//        return repository.getDepartmentManagerData()
//    }
//    fun getDepartmentsManager():ArrayList<DepartmentManager>{
//        return repository.getDepartmentManagerData()
//    }

}