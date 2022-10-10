package com.example.finalassignment.database

import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.SQLException
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log
import com.example.finalassignment.models.*

const val DATABASE_NAME = "myDatabase"

class MyDatabase(context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, 1) {


    /** Table Names **/
    private val TABLE_DEPARTMENT_MANAGER = "department_manager"
    private val TABLE_DEPARTMENTS = "departments"
    private val TABLE_EMP_DEPARTMENTS = "emp_departments"
    private val TABLE_EMPLOYEES = "employees"
    private val TABLE_SALARIES = "salaries"
    private val TABLE_TITLE = "title"

    /**Common Column Names and Department_Manager,Emp._Departments **/
    private val KEY_EMP_NO = "emp_no"
    private val KEY_DEPARTMENT_NO = "dept_no"
    private val KEY_FROM_DATE = "from_date"
    private val KEY_TO_DATE = "to_date"


    /**Departments  Column Names **/
    private val KEY_DEPARTMENT_NAME = "dept_name"

    /**Employees Column Names **/
    private val KEY_BIRTH_DATE = "birth_date"
    private val KEY_FIRST_NAME = "first_name"
    private val KEY_LAST_NAME = "last_name"
    private val KEY_GENDER = "gender"
    private val KEY_HIRE_DATE = "hire_date"

    /**Salaries Column Names **/
    private val KEY_SALARY = "salary"

    /**Title Column Names **/
    private val KEY_TITLE = "title"


    override fun onCreate(db: SQLiteDatabase?) {


        db?.execSQL(
            "CREATE TABLE $TABLE_DEPARTMENT_MANAGER($KEY_EMP_NO INTEGER PRIMARY KEY," +
                    "$KEY_DEPARTMENT_NO TEXT," +
                    "$KEY_FROM_DATE TEXT," +
                    "$KEY_TO_DATE TEXT)"
        )
        db?.execSQL(
            "CREATE TABLE $TABLE_DEPARTMENTS($KEY_DEPARTMENT_NO TEXT PRIMARY KEY," +
                    "$KEY_DEPARTMENT_NAME TEXT)"
        )
        db?.execSQL(
            "CREATE TABLE $TABLE_EMP_DEPARTMENTS($KEY_EMP_NO INTEGER PRIMARY KEY," +
                    "$KEY_DEPARTMENT_NO TEXT," +
                    "$KEY_FROM_DATE TEXT," +
                    "$KEY_TO_DATE TEXT)"
        )
        db?.execSQL(
            "CREATE TABLE $TABLE_EMPLOYEES($KEY_EMP_NO INTEGER PRIMARY KEY," +
                    "$KEY_BIRTH_DATE TEXT," +
                    "$KEY_FIRST_NAME TEXT," +
                    "$KEY_LAST_NAME TEXT," +
                    "$KEY_GENDER TEXT," +
                    "$KEY_HIRE_DATE TEXT)"
        )
        db?.execSQL(
            "CREATE TABLE $TABLE_SALARIES($KEY_EMP_NO INTEGER PRIMARY KEY," +
                    "$KEY_SALARY INTEGER," +
                    "$KEY_FROM_DATE TEXT," +
                    "$KEY_TO_DATE TEXT)"
        )
        db?.execSQL(
            "CREATE TABLE $TABLE_TITLE($KEY_EMP_NO INTEGER PRIMARY KEY," +
                    "$KEY_TITLE TEXT," +
                    "$KEY_FROM_DATE TEXT," +
                    "$KEY_TO_DATE TEXT)"
        )


    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        onCreate(db)
    }

    fun addDepartmentManager(departmentManager: DepartmentManager) {
        try {
            if (isDepartmentManagerDataExist(departmentManager.emp_no)) {
                updateDepartmentsManager(departmentManager)
                return

            }
            val db = writableDatabase
            val contentValues = ContentValues()

                contentValues.put(KEY_EMP_NO, departmentManager.emp_no)
                contentValues.put(KEY_DEPARTMENT_NO, departmentManager.dept_no)
                contentValues.put(KEY_FROM_DATE, departmentManager.from_date)
                contentValues.put(KEY_TO_DATE, departmentManager.to_date)

                db.insert(TABLE_DEPARTMENT_MANAGER, null, contentValues)

        } catch (e: Exception) {

        }
    }

    private fun updateDepartmentsManager(departmentManager: DepartmentManager) {
        try {
            val db = writableDatabase
            val contentValues = ContentValues()

            contentValues.put(KEY_EMP_NO, departmentManager.emp_no)
            contentValues.put(KEY_DEPARTMENT_NO, departmentManager.dept_no)
            contentValues.put(KEY_FROM_DATE, departmentManager.from_date)
            contentValues.put(KEY_TO_DATE, departmentManager.to_date)
            db.update(
                TABLE_DEPARTMENT_MANAGER,
                contentValues,
                KEY_EMP_NO,
                arrayOf(KEY_EMP_NO.toString())
            )
        } catch (e: Exception) {

        }

    }

    private fun isDepartmentManagerDataExist(empNo: Int): Boolean {

        var db = writableDatabase
        var exist = false
        var cursor: Cursor? = null
        try {
            cursor = db.query(
                TABLE_DEPARTMENT_MANAGER,
                arrayOf(KEY_EMP_NO),
                KEY_EMP_NO + "=${KEY_EMP_NO}",
                null,
                null,
                null,
                null
            )
            if (cursor.count > 0) {
                exist = true
            }
            cursor.close()
        } catch (e: SQLException) {

            Log.e("DB Error", e.toString())
        }
        return exist

    }

    fun addDepartment(departments: Departments) {
        try {
            if (isDepartmentDataExist(departments.dept_no)) {
                updateDepartments(departments)
                return

            }
            val db = writableDatabase
            val contentValues = ContentValues()

            contentValues.put(KEY_DEPARTMENT_NO, departments.dept_no)
            contentValues.put(KEY_DEPARTMENT_NAME, departments.dept_name)
            db.insert(TABLE_DEPARTMENTS, null, contentValues)
        } catch (e: Exception) {

        }
    }

    private fun updateDepartments(departments: Departments) {
        try {
            val db = writableDatabase
            val contentValues = ContentValues()

            contentValues.put(KEY_DEPARTMENT_NO, departments.dept_no)
            contentValues.put(KEY_DEPARTMENT_NAME, departments.dept_name)
            db.update(
                TABLE_DEPARTMENTS,
                contentValues,
                KEY_DEPARTMENT_NO,
                arrayOf(KEY_DEPARTMENT_NO.toString())
            )

        } catch (e:Exception){

        }

    }

    private fun isDepartmentDataExist(deptNo: String): Boolean {
        var db = writableDatabase
        var exist = false
        var cursor: Cursor? = null
        try {
            cursor = db.query(
                TABLE_DEPARTMENTS,
                arrayOf(KEY_DEPARTMENT_NO),
                KEY_DEPARTMENT_NO + "=${KEY_DEPARTMENT_NO}",
                null,
                null,
                null,
                null
            )
            if (cursor.count > 0) {
                exist = true
            }
            cursor.close()
        } catch (e: SQLException) {

            Log.e("DB Error", e.toString())
        }
        return exist

    }

    fun addEmpDepartment(empDepartments: EmpDepartments) {
       try {
           if (isEmpDepartmentDataExist(empDepartments.emp_no)) {
               updateEmpDepartments(empDepartments)
               return

           }
           val db = writableDatabase
           val contentValues = ContentValues()

           contentValues.put(KEY_EMP_NO, empDepartments.emp_no)
           contentValues.put(KEY_DEPARTMENT_NO, empDepartments.dept_no)
           contentValues.put(KEY_FROM_DATE, empDepartments.from_date)
           contentValues.put(KEY_TO_DATE, empDepartments.to_date)
           db.insert(TABLE_EMP_DEPARTMENTS, null, contentValues)

       }catch (e:Exception){

       }
    }

    private fun updateEmpDepartments(empDepartments: EmpDepartments) {
        try {

            val db = writableDatabase
            val contentValues = ContentValues()

            contentValues.put(KEY_EMP_NO, empDepartments.emp_no)
            contentValues.put(KEY_DEPARTMENT_NO, empDepartments.dept_no)
            contentValues.put(KEY_FROM_DATE, empDepartments.from_date)
            contentValues.put(KEY_TO_DATE, empDepartments.to_date)
            db.update(
                TABLE_EMP_DEPARTMENTS,
                contentValues,
                KEY_DEPARTMENT_NO,
                arrayOf(KEY_DEPARTMENT_NO.toString())
            )

        }catch (e : SQLException){

        }

    }

    private fun isEmpDepartmentDataExist(empNo: Int): Boolean {
        var db = writableDatabase
        var exist = false
        var cursor: Cursor? = null
        try {
            cursor = db.query(
                TABLE_EMP_DEPARTMENTS,
                arrayOf(KEY_EMP_NO),
                KEY_EMP_NO + "=${KEY_EMP_NO}",
                null,
                null,
                null,
                null
            )
            if (cursor.count > 0) {
                exist = true
            }
            cursor.close()
        } catch (e: SQLException) {

            Log.e("DB Error", e.toString())
        }
        return exist

    }

    fun addEmployee(employees: Employees) {
       try {
           if (isEmployeeDataExist(employees.emp_no)) {
               updateEmployee(employees)
               return

           }
           val db = writableDatabase
           val contentValues = ContentValues()

           contentValues.put(KEY_EMP_NO, employees.emp_no)
           contentValues.put(KEY_BIRTH_DATE, employees.birth_date)
           contentValues.put(KEY_FIRST_NAME, employees.first_name)
           contentValues.put(KEY_LAST_NAME, employees.last_name)
           contentValues.put(KEY_GENDER, employees.gender)
           contentValues.put(KEY_HIRE_DATE, employees.hire_date)
           db.insert(TABLE_EMPLOYEES, null, contentValues)

       }catch (e :Exception){

       }

    }

    private fun updateEmployee(employees: Employees) {
        try {

            val db = writableDatabase
            val contentValues = ContentValues()

            contentValues.put(KEY_EMP_NO, employees.emp_no)
            contentValues.put(KEY_BIRTH_DATE, employees.birth_date)
            contentValues.put(KEY_FIRST_NAME, employees.first_name)
            contentValues.put(KEY_LAST_NAME, employees.last_name)
            contentValues.put(KEY_GENDER, employees.gender)
            contentValues.put(KEY_HIRE_DATE, employees.hire_date)
            db.update(
                TABLE_EMPLOYEES,
                contentValues,
                KEY_EMP_NO,
                arrayOf(KEY_EMP_NO.toString())
            )
        }catch (e:SQLException){

        }

    }

    private fun isEmployeeDataExist(empNo: Int): Boolean {
        var db = writableDatabase
        var exist = false
        var cursor: Cursor? = null
        try {
            cursor = db.query(
                TABLE_EMPLOYEES,
                arrayOf(KEY_EMP_NO),
                KEY_EMP_NO + "=${KEY_EMP_NO}",
                null,
                null,
                null,
                null
            )
            if (cursor.count > 0) {
                exist = true
            }
            cursor.close()
        } catch (e: SQLException) {

            Log.e("DB Error", e.toString())
        }
        return exist




    }

    fun addSalaries(salaries: Salaries) {
       try {
           if (isSalariesDataExist(salaries.emp_no)) {
               updateSalaries(salaries)
               return

           }
           val db = writableDatabase
           val contentValues = ContentValues()

           contentValues.put(KEY_EMP_NO, salaries.emp_no)
           contentValues.put(KEY_SALARY, salaries.salary)
           contentValues.put(KEY_FROM_DATE, salaries.from_date)
           contentValues.put(KEY_TO_DATE, salaries.to_date)
           db.insert(TABLE_SALARIES, null, contentValues)

       }catch (e :Exception){

       }
    }

    private fun updateSalaries(salaries: Salaries) {
        try {
            val db = writableDatabase
            val contentValues = ContentValues()

            contentValues.put(KEY_EMP_NO, salaries.emp_no)
            contentValues.put(KEY_SALARY, salaries.salary)
            contentValues.put(KEY_FROM_DATE, salaries.from_date)
            contentValues.put(KEY_TO_DATE, salaries.to_date)
            db.update(
                TABLE_SALARIES,
                contentValues,
                KEY_EMP_NO,
                arrayOf(KEY_EMP_NO.toString())
            )
        }catch (e :SQLException){

        }

    }

    private fun isSalariesDataExist(empNo: Int): Boolean {
        var db = writableDatabase
        var exist = false
        var cursor: Cursor? = null
        try {
            cursor = db.query(
                TABLE_SALARIES,
                arrayOf(KEY_EMP_NO),
                KEY_EMP_NO + "=${KEY_EMP_NO}",
                null,
                null,
                null,
                null
            )
            if (cursor.count > 0) {
                exist = true
            }
            cursor.close()
        } catch (e: SQLException) {

            Log.e("DB Error", e.toString())
        }
        return exist





    }

    fun addTitles(titles: Titles) {
       try {
           if (isTitlesDataExist(titles.emp_no)) {
               updateTitles(titles)
               return

           }
           val db = writableDatabase
           val contentValues = ContentValues()

           contentValues.put(KEY_EMP_NO, titles.emp_no)
           contentValues.put(KEY_TITLE, titles.title)
           contentValues.put(KEY_FROM_DATE, titles.from_date)
           contentValues.put(KEY_TO_DATE, titles.to_date)
           db.insert(TABLE_TITLE, null, contentValues)
       }catch (e :Exception){

       }

    }

    private fun updateTitles(titles: Titles) {
        try {
            val db = writableDatabase
            val contentValues = ContentValues()

            contentValues.put(KEY_EMP_NO, titles.emp_no)
            contentValues.put(KEY_TITLE, titles.title)
            contentValues.put(KEY_FROM_DATE, titles.from_date)
            contentValues.put(KEY_TO_DATE, titles.to_date)
            db.update(
                TABLE_TITLE,
                contentValues,
                KEY_EMP_NO,
                arrayOf(KEY_EMP_NO.toString())
            )

        }catch (e :SQLException){

        }

    }

    private fun isTitlesDataExist(empNo: Int): Boolean {
        var db = writableDatabase
        var exist = false
        var cursor: Cursor? = null
        try {
            cursor = db.query(
                TABLE_TITLE,
                arrayOf(KEY_EMP_NO),
                KEY_EMP_NO + "=${KEY_EMP_NO}",
                null,
                null,
                null,
                null
            )
            if (cursor.count > 0) {
                exist = true
            }
            cursor.close()
        } catch (e: SQLException) {

            Log.e("DB Error", e.toString())
        }
        return exist



    }

    fun getDepartments(): ArrayList<Departments> {
        val db = this.readableDatabase
        val cursor: Cursor = db.rawQuery("SELECT * FROM $TABLE_DEPARTMENTS", null)
        val arrdepartments: ArrayList<Departments> = ArrayList()
        while (cursor.moveToNext()) {
            var departments = Departments()
            departments.dept_no = cursor.getString(0)
            departments.dept_name = cursor.getString(1)
            arrdepartments.add(departments)

        }
        return arrdepartments
    }

    fun getDepartmentManager(): ArrayList<DepartmentManager> {
        val db = this.readableDatabase
        val cursor: Cursor = db.rawQuery("SELECT * FROM $TABLE_DEPARTMENT_MANAGER", null)
        val departmentManager: ArrayList<DepartmentManager> = ArrayList()
        while (cursor.moveToNext()) {
            var departmentManager = DepartmentManager()
            departmentManager.emp_no = cursor.getInt(0)
            departmentManager.dept_no = cursor.getString(1)
            departmentManager.from_date = cursor.getString(2)
            departmentManager.to_date = cursor.getString(3)
        }
        return departmentManager
    }

    @SuppressLint("Range")
    fun getEmployeeModel():ArrayList<EmployeeModel>{
        var arrEmployeeModel: ArrayList<EmployeeModel> = ArrayList()
        try {


            val db = this.readableDatabase
            var sql ="SELECT E.$KEY_FIRST_NAME,E.$KEY_LAST_NAME, E.$KEY_GENDER,E.$KEY_HIRE_DATE,"+
                    "D.$KEY_DEPARTMENT_NAME ,T.$KEY_TITLE,S.$KEY_SALARY  FROM $TABLE_DEPARTMENTS as D"+
                    " JOIN $TABLE_EMP_DEPARTMENTS  as ED ON D.dept_no = ED.dept_no "+
                    "JOIN $TABLE_EMPLOYEES as E ON ED.emp_no = E.emp_no "+
                    "JOIN $TABLE_TITLE as T ON E.emp_no = T.emp_no "+
                    "JOIN $TABLE_SALARIES as S ON S.$KEY_EMP_NO = E.$KEY_EMP_NO ORDER BY(S.$KEY_SALARY)"




            val cursor: Cursor? = db?.rawQuery(sql, null)
            if (cursor?.moveToFirst()!!) {
                while (cursor?.moveToNext()!!) {
                    var employeeModel = EmployeeModel()
                    employeeModel.first_name = cursor.getString(cursor.getColumnIndex(KEY_FIRST_NAME))
                    employeeModel.last_name = cursor.getString(cursor.getColumnIndex(KEY_LAST_NAME))
                    employeeModel.gender = cursor.getString(cursor.getColumnIndex(KEY_GENDER))
                    employeeModel.title = cursor.getString(cursor.getColumnIndex(KEY_TITLE))
                    employeeModel.hire_date = cursor.getString(cursor.getColumnIndex(KEY_HIRE_DATE))
                    employeeModel.department = cursor.getString(cursor.getColumnIndex(KEY_DEPARTMENT_NAME))
                    employeeModel.salary = cursor.getInt(cursor.getColumnIndex(KEY_SALARY))

                    arrEmployeeModel.add(employeeModel)

                }
            }
        }catch (e:Exception) {

        }
        return arrEmployeeModel
    }

}