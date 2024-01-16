package jets.iti.java;

import java.util.*;

public class App 
{
    public static void main( String[] args )
    {
        ArrayList<Employee> employees ;
        EmployeeDAO.createEmployeeTable();

        EmployeeDAO.insertTestEmployees();

        employees = EmployeeDAO.loadEmpsFromDB();
        System.out.println("Employees Before update");
        for(Employee e : employees)
        {
            System.out.println(e.toString());
        }
        EmployeeDAO.updateVacationBalance();

        EmployeeDAO.updateFnameWithGenderTitle();
        
        employees = EmployeeDAO.loadEmpsFromDB();

        System.out.println("Updated Employees");
        for(Employee e : employees)
        {
            System.out.println(e.toString());
        }

    }
}
