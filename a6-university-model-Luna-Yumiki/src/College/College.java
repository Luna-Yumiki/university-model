/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package College;

import Department.Department;
import java.util.ArrayList;

/**
 *
 * @author kal bugrara
 */
public class College {
    ArrayList<Department> departments;
    String name;
    
    public College(String name){
        this.name = name;
        departments = new ArrayList<Department>();
    }


    // NEW 
    public Department newDepartment(String programName, String degreeName){
        Department d = new Department(programName, degreeName);
        departments.add(d);
        return d;
    }

    public void printCollegeInformation(){
        System.out.println("College" + name);
        System.out.println("---------------------------------------");
        System.out.println("List of programs:");
        for (Department d : departments){
            d.printDepartmentInformation();
        }
    }

    public int calculateRevenuesBySemester(String semester){
        int sum = 0;
        for (Department d: departments){
            sum = sum + d.calculateRevenuesBySemester(semester);
        }
        return sum;
    }


}
