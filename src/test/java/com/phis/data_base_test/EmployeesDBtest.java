package com.phis.data_base_test;

import com.phis.utilities.DBType;
import com.phis.utilities.DBUtility;
import org.junit.*;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import static junit.framework.TestCase.assertTrue;


public class EmployeesDBtest {

    @Before
    public void setUp() throws SQLException{
        DBUtility.establishConnection(DBType.ORACLE);
    }

    @After
    public void tearDown() throws SQLException{
        DBUtility.closeConnection();
    }
    @Test
    public void countTest() throws SQLException {
        // connect to oracle data base
        // run followoing sql queri
        // select* from employees where job_id = 'IT PROG'
        // more than 0 records should be returned


        int rowsCount = DBUtility.getRowsCount("select * from employees where job_id = 'IT_PROG'");


        assertTrue(rowsCount>0);


    }

    @Test
    public void nameTestByID() throws SQLException{
        // connect to oracle data base
        // employees full name  with Employee id 105 should be DAVID austin
        // run followoing sql query



        List<Map<String,Object>> empData = DBUtility.runSQLQuery("SELECT first_name, last_name FROM employees WHERE employee_id = 105");

        System.out.println(empData.get(0).get("LAST_NAME"));

        Assert.assertEquals("David", empData.get(0).get("FIRST_NAME"));
        Assert.assertEquals("Austin", empData.get(0).get("LAST_NAME"));


    }
}
