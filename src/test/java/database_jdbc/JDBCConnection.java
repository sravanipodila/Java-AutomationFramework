package database_jdbc;

import org.junit.Test;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JDBCConnection {
    // URL is Host-name which coming from you EC2 server , use host-name from you machine ! ! !
    String oracledbUrl = "jdbc:oracle:thin:@ec2-3-92-65-237.compute-1.amazonaws.com:1521:xe";
    //1521->port//xe->SID
    // Username from Data-Base
    String oracledbUsername = "hr";
    // Password from Data-Base
    String oracledbPassword =  "hr";

    @Test
    public void oracleJDBC() throws SQLException {

        // Creating Connection Interface which coming from SQL, we need to handle SQLException
        Connection connection = DriverManager.getConnection(oracledbUrl, oracledbUsername, oracledbPassword);
//        Statement statement = connection.createStatement();
        Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);

        // Writing actual query
        ResultSet resultSet = statement.executeQuery("select * from countries");

//        resultSet.next();
//        System.out.println(resultSet.getString("country_name"));
//        System.out.println(resultSet.getString("region_id"));

//        for (int i = 0 ; i <resultSet.getFetchSize();i++){
//            resultSet.next();
//            System.out.println(resultSet.getString(i+1));
//            System.out.println(resultSet.getString("country_name"));
////            System.out.println(resultSet.getString("region_id"));
//
//        }    WHILE LOOP BEST FOR PRINTING ALL COUNTRIES



        // LOOPING THROUGH ALL COUNTRY NAME ID'S AND REGION ID , Returning us whole countries table
//        while (resultSet.next()){
//            System.out.print(resultSet.getString("country_id") + "  ");
//            System.out.print(resultSet.getString("country_name")+ "  ");
//            System.out.print(resultSet.getString("region_id"));
//
//            System.out.println();
//        }
//
        resultSet.next();
        System.out.println(resultSet.getRow());
        resultSet.previous();
        resultSet.first();
        resultSet.last();
        System.out.println(resultSet.getRow());

        // Find out how many records in the resultset
        resultSet.last();
        int rowsCount = resultSet.getRow();
        System.out.println("rowsCount = " + rowsCount);

        // it will put us before first value ---> that means it will read first value , when we use next();
        resultSet.beforeFirst();



        resultSet.close();
        statement.close();
        connection.close();

    }


    // META DATA-

    @Test
    public void jdbcMetaData() throws SQLException{
        // Creating Connection Interface which coming from SQL, we need to handle SQLException
        Connection connection = DriverManager.getConnection(oracledbUrl, oracledbUsername, oracledbPassword);
//        Statement statement = connection.createStatement();
        Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);

        // query
        String sql = "select employee_id, last_name,job_id, salary from employees";

        ResultSet resultSet = statement.executeQuery(sql);

        // DATA BASE META-DATA
        DatabaseMetaData dbMetadat = connection.getMetaData();
        System.out.println("USER: " + dbMetadat.getUserName() );
        System.out.println("DATAbase type = " + dbMetadat.getDatabaseProductName());

        // resultsSet metadata
        ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
        System.out.println(    "Columns count = "+    resultSetMetaData.getColumnCount());
        System.out.println("Table name =  " + resultSetMetaData.getColumnName(1));

        System.out.println();
        // print all columns name using loop

        for (int i = 1; i <= resultSetMetaData.getColumnCount(); i++) {
            System.out.println(resultSetMetaData.getColumnName(i));
        }

        // Throw resultser int a list Of maps
        // Create a list od maps

        List<Map<String, Object>> list = new ArrayList<>();
        ResultSetMetaData rsMdata = resultSet.getMetaData();

        int colCount = rsMdata.getColumnCount();

        while (resultSet.next()){
            Map<String,Object> rowMap = new HashMap<>();

            for (int col = 1; col < colCount ; col++) {

                rowMap.put(rsMdata.getColumnName(col),resultSet.getObject(col));

            }

            list.add(rowMap);


        }
//        System.out.println("list = " + list);

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).get("EMPLOYEE_ID"));

        }


        resultSet.close();
        statement.close();
        connection.close();

    }
    // Checking git

}










