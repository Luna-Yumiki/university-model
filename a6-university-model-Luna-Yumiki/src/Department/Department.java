/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Department;

import CourseCatalog.Course;
import CourseCatalog.CourseCatalog;
import CourseSchedule.CourseLoad;
import CourseSchedule.CourseOffer;
import CourseSchedule.CourseSchedule;
import CourseSchedule.SeatAssignment;
import Degree.Degree;
import Employer.EmployerDirectory;
import Persona.Faculty.FacultyDirectory;
import Persona.PersonDirectory;
import Persona.StudentDirectory;
import Persona.StudentProfile;
import java.util.HashMap;

/**
 *
 * @author kal bugrara
 */
public class Department {

    String name;
    CourseCatalog coursecatalog;
    PersonDirectory persondirectory;
    StudentDirectory studentdirectory;
    FacultyDirectory facultydirectory;
    EmployerDirectory employerdirectory;
    Degree degree;

    public void setCoursecatalog(CourseCatalog coursecatalog) {
        this.coursecatalog = coursecatalog;
    }

    HashMap<String, CourseSchedule> mastercoursecatalog;

    public Department(String n, String degreeName) {
        name = n;
        mastercoursecatalog = new HashMap<String, CourseSchedule>();
        coursecatalog = new CourseCatalog(this);
        studentdirectory = new StudentDirectory(this); // pass the department object so it stays linked to it
        persondirectory = new PersonDirectory();
        facultydirectory = new FacultyDirectory(this);
        degree = new Degree(degreeName);

    }

    // public Department(String programName, String degreeName) {
    // }
    public void addCoreCourse(Course c) {
        degree.addCoreCourse(c);

    }

    public void addElectiveCourse(Course c) {
        degree.addElectiveCourse(c);

    }

    public PersonDirectory getPersonDirectory() {

        return persondirectory;

    }

    public StudentDirectory getStudentDirectory() {
        return studentdirectory;
    }

    public CourseSchedule newCourseSchedule(String semester) {

        CourseSchedule cs = new CourseSchedule(semester, coursecatalog);
        mastercoursecatalog.put(semester, cs);
        return cs;
    }

    public CourseSchedule getCourseSchedule(String semester) {

        return mastercoursecatalog.get(semester);

    }

    public CourseCatalog getCourseCatalog() {

        return coursecatalog;

    }

    public Course newCourse(String n, String nm, int cr) {

        Course c = coursecatalog.newCourse(n, nm, cr);
        return c;
    }

    public int calculateRevenuesBySemester(String semester) {

        CourseSchedule css = mastercoursecatalog.get(semester);
        if (css == null) {
            System.out.println("------------------------------------------------");
            System.out.println("Revenue for " + name + ":0, Since there is no course schedule for" + semester);
            return 0;
        }
        int revenue = css.calculateTotalRevenues();
        System.out.println("Revenue for " + name + " during " + semester + ":" + revenue);
        System.out.println("***********************************************");
        return revenue;

    }

    public void RegisterForAClass(String studentid, String cn, String semester) {

        StudentProfile sp = studentdirectory.findStudent(studentid);
        if (sp == null) {
            System.out.println("Student with id" + studentid + " was not found");
            return;
        }
        System.out.println("Student" + studentid + " was found");

        CourseSchedule cs = mastercoursecatalog.get(semester);

        if (cs == null) {
            System.out.println("There is not schedule for " + semester + ". Pls add a course schedule first");
            return;
        }

        CourseOffer co = cs.getCourseOfferByNumber(cn);
        if (co == null) {
            System.out.println("There is no such course in " + semester + ".");
            return;
        }

        CourseLoad cl = sp.getCurrentCourseLoad();
        if (cl == null) {
            System.out.println("This is first time student is registering... creating new section in transcript.");
            cl = sp.newCourseLoad(semester);
        }

        SeatAssignment sa = co.assignEmptySeat(cl);
        if (sa == null) {
            System.out.println("Unfortunately, there were no empty seats.");
            return;
        }
        System.out.println("Congrats, you are registered for " + co.getCourseNumber());

    }

    public FacultyDirectory getFacultydirectory() {
        return facultydirectory;
    }

    public void printDepartmentInformation() {
        System.out.println("Department" + name);
        degree.printDegreeInformation();
        System.out.println("-------------------------------------");
        coursecatalog.printCourseList();
        System.out.println("-------------------------------------");
        printMasterCourseCatalog();
        studentdirectory.printStudentList();
    }

    public void printMasterCourseCatalog() {
        System.out.println("List of Semester");
        for (String semester : mastercoursecatalog.keySet()) {
            CourseSchedule courseScheduleForSemester = mastercoursecatalog.get(semester);
            courseScheduleForSemester.printScheduleInformation();
        }

    }

}
