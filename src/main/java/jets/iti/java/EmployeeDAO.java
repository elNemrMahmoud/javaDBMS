package jets.iti.java;


import oracle.jdbc.pool.OracleDataSource;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.*;
import java.util.*;


class EmployeeDAO{

    public static ArrayList<Employee> loadEmpsFromDB()
    {
        ArrayList<Employee> employees = new ArrayList<>();
        OracleDataSource oracleDS = DataSourceUtil.getOracleDataSource();
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try{

            conn = oracleDS.getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery("SELECT * FROM Employee");
            while(rs.next())
            {
                Employee employee = new Employee();
                employee.setId(rs.getInt("id"));
                employee.setFname(rs.getString("fname"));
                employee.setLname(rs.getString("lname"));
                employee.setGender(rs.getString("gender"));
                employee.setAddress(rs.getString("address"));
                employee.setPhoneNum(rs.getString("phoneNum"));
                employee.setVacationBalance(rs.getInt("vacationBalance"));
                employee.setAge(rs.getInt("age"));

                employees.add(employee);
            }
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }finally{
            try{
                if(rs != null) rs.close();
                if(stmt != null) stmt.close();
                if(conn != null) conn.close();
            }catch(SQLException e){
                e.printStackTrace();
            }
        }

        return employees;

    }

    public static boolean createEmployeeTable()
    {
        OracleDataSource oracleDS = DataSourceUtil.getOracleDataSource();
        Connection conn = null;
        Statement  statement = null;

        try{
            conn = oracleDS.getConnection();
            statement = conn.createStatement();

                    String createTableSQL = "CREATE TABLE Employee ("
                    + "id INT PRIMARY KEY, "
                    + "fname VARCHAR(255), "
                    + "lname VARCHAR(255), "
                    + "gender VARCHAR(10), "
                    + "address VARCHAR(255), "
                    + "phoneNum VARCHAR(20), "
                    + "vacationBalance INT, "
                    +"age INT)";

            statement.executeUpdate(createTableSQL);
            System.out.println("Employee Table Created");
            return true;
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static boolean insertTestEmployees()
    {
        OracleDataSource oracleDS = DataSourceUtil.getOracleDataSource();
        Connection conn = null;
        Statement  statement = null;

        try{

            conn = oracleDS.getConnection();
            statement = conn.createStatement();            
            conn.setAutoCommit(false);
            String insertSQL;
            for(int i = 0;i<10;i++)
            {
                if(i % 2 == 0)
                {
                    insertSQL = "INSERT INTO Employee (id, fname, lname, gender, address, phoneNum, vacationBalance,age) " +
                        "VALUES (" + i + ", 'SampleFname" + i + "', 'SampleLname" + i + "', 'Male', 'SampleAddress" + i + "', '1234567890', 30,24)";
                    statement.addBatch(insertSQL);
                }
                else
                {
                    insertSQL =  "INSERT INTO Employee (id, fname, lname, gender, address, phoneNum, vacationBalance,age) " +
                        "VALUES (" + i + ", 'SampleFname" + i + "', 'SampleLname" + i + "', 'Female', 'SampleAddress" + i + "', '1234567890', 30,48)";
                    statement.addBatch(insertSQL);                    
                }

                
            }
            int[] updateCounts = statement.executeBatch();
            conn.commit();
            System.out.println("Data Added successfully");

            return true;

        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }

        return false;
    }

    public static void updateVacationBalance() {

        OracleDataSource oracleDS = DataSourceUtil.getOracleDataSource();
        Connection conn = null;
        Statement  pStatement = null;

        try{
            conn = oracleDS.getConnection();
            pStatement = conn.createStatement();    
            String updateSQL = "UPDATE Employee SET vacationBalance = 45 WHERE id IN (SELECT id FROM Employee WHERE AGE > 45)";
            pStatement.executeUpdate(updateSQL);
            System.out.println("Vacation balance updated successfully.");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void updateFnameWithGenderTitle() {


        OracleDataSource oracleDS = DataSourceUtil.getOracleDataSource();
        Connection conn = null;
        Statement  statement = null;

        try{
            conn = oracleDS.getConnection();
            statement = conn.createStatement();    

            conn.setAutoCommit(false);

            String updateMaleSQL = "UPDATE Employee SET fname = 'Mr. ' || fname WHERE gender = 'Male'";
            String updateFemaleSQL = "UPDATE Employee SET fname = 'Mrs. ' || fname WHERE gender = 'Female'";

            statement.addBatch(updateMaleSQL);
            statement.addBatch(updateFemaleSQL);

            int[] updateCounts = statement.executeBatch();
            conn.commit();

            System.out.println("Fname updated with gender title successfully.");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}