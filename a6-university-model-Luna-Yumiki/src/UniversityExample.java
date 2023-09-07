/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import College.College;
import CourseCatalog.Course;
import CourseCatalog.CourseCatalog;
import CourseSchedule.CourseLoad;
import CourseSchedule.CourseOffer;
import CourseSchedule.CourseSchedule;
import Department.Department;
import Persona.Person;
import Persona.PersonDirectory;
import Persona.StudentDirectory;
import Persona.StudentProfile;
import Persona.Faculty.FacultyDirectory;
import Persona.Faculty.FacultyProfile;

/**
 *
 * @author kal bugrara
 */
public class UniversityExample {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
//         Department department = new Department("Information Systems");
//         CourseCatalog coursecatalog = department.getCourseCatalog();
        
//         Course course = coursecatalog.newCourse("app eng", "info 5100", 4);
        
//         CourseSchedule courseschedule = department.newCourseSchedule("Fall2020");

//         CourseOffer courseoffer = courseschedule.newCourseOffer("info 5100");
//         if (courseoffer==null)return;
//         courseoffer.generatSeats(10);
//         PersonDirectory pd = department.getPersonDirectory();
//         Person person = pd.newPerson("0112303");
//         StudentDirectory sd = department.getStudentDirectory();
//         StudentProfile student = sd.newStudentProfile(person);
//         CourseLoad courseload = student.newCourseLoad("Fall2020"); 
// //        
//         courseload.newSeatAssignment(courseoffer); //register student in class
        
//         int total = department.calculateRevenuesBySemester("Fall2020");
//         System.out.print("Total: " + total);


        // ---------------------------------- Part1 ----------------------------------------

        // Create a college 
        College coe = new College("NEU - College of engineering");

        // create 3 programs
        Department mgenDepartment = coe.newDepartment("MGEN", "MS in Information Systems");
        Department damgDepartment = coe.newDepartment("DAMG", "Data engineering degree");
        Department csyeDepartment = coe.newDepartment("CSYE", "Software engineering systems");

        // pulling out the directories and catalogs from the department
        // 1.mgenDepartment
        CourseCatalog mgenCatalog = mgenDepartment.getCourseCatalog();
        StudentDirectory sd = mgenDepartment.getStudentDirectory();
        PersonDirectory pd = mgenDepartment.getPersonDirectory();
        FacultyDirectory fd = mgenDepartment.getFacultydirectory();
        // 2.damgDepartment
        CourseCatalog damgCatalog = damgDepartment.getCourseCatalog();
        StudentDirectory sdDamg = damgDepartment.getStudentDirectory();
        PersonDirectory pdDamg = damgDepartment.getPersonDirectory();
        FacultyDirectory fdDamg = damgDepartment.getFacultydirectory();
        // 3.csyeDepartment
        CourseCatalog csyeCatalog = csyeDepartment.getCourseCatalog();
        StudentDirectory sdCsye = csyeDepartment.getStudentDirectory();
        PersonDirectory pdCsye = csyeDepartment.getPersonDirectory();
        FacultyDirectory fdCsye = csyeDepartment.getFacultydirectory();

        // Three courses per program, adding 9 courses
        // 1.mgenDepartment
        mgenCatalog.newCourse("Application Engineer", "5100", 4);
        mgenCatalog.newCourse("Data Engineer with Python", "6105", 4);
        mgenCatalog.newCourse("Web development", "6150", 4);
        mgenDepartment.setCoursecatalog(mgenCatalog);
        // 2.damgDepartment
        damgCatalog.newCourse("Data management", "7150", 4);
        damgCatalog.newCourse("Data Management and Database Design", "7210", 4);
        damgCatalog.newCourse("Big Data Architecture and Governance", "7250", 4);
        damgDepartment.setCoursecatalog(damgCatalog);
        // 3.csyeDepartment
        csyeCatalog.newCourse("Concepts of Object-Oriented Design", "6200", 4);
        csyeCatalog.newCourse("Program Structure and Algorithms", "6205", 4);
        csyeCatalog.newCourse("Web Development Tools and Methods", "6250", 4);
        csyeDepartment.setCoursecatalog(csyeCatalog);

        // One faculty for each course, adding 9 faculty
        Person aPerson = pd.newPerson("0001");
        Person bPerson = pd.newPerson("0002");
        Person cPerson = pd.newPerson("0003");
        Person dPerson = pdDamg.newPerson("0004");
        Person ePerson = pdDamg.newPerson("0005");
        Person fPerson = pdDamg.newPerson("0006");
        Person gPerson = pdCsye.newPerson("0007");
        Person hPerson = pdCsye.newPerson("0008");
        Person iPerson = pdCsye.newPerson("0009");

        FacultyProfile facultylist1 = fd.newFacultyProfile(aPerson);
        FacultyProfile facultylist2 = fd.newFacultyProfile(bPerson);
        FacultyProfile facultylist3 = fd.newFacultyProfile(cPerson);
        FacultyProfile facultylist4 = fdDamg.newFacultyProfile(dPerson);
        FacultyProfile facultylist5 = fdDamg.newFacultyProfile(ePerson);
        FacultyProfile facultylist6 = fdDamg.newFacultyProfile(fPerson);
        FacultyProfile facultylist7 = fdCsye.newFacultyProfile(gPerson);
        FacultyProfile facultylist8 = fdCsye.newFacultyProfile(hPerson);
        FacultyProfile facultylist9 = fdCsye.newFacultyProfile(iPerson);

        // Ten students in each program, adding students
        // 1.mgenDepartment
        Person mgen1Person = pd.newPerson("10001");
        StudentProfile mgen1Student = sd.newStudentProfile(mgen1Person);
        Person mgen2Person = pd.newPerson("10002");
        StudentProfile mgen2Student = sd.newStudentProfile(mgen2Person);
        Person mgen3Person = pd.newPerson("10003");
        StudentProfile mgen3Student = sd.newStudentProfile(mgen3Person);
        Person mgen4Person = pd.newPerson("10004");
        StudentProfile mgen4Student = sd.newStudentProfile(mgen4Person);
        Person mgen5Person = pd.newPerson("10005");
        StudentProfile mgen5Student = sd.newStudentProfile(mgen5Person);
        Person mgen6Person = pd.newPerson("10006");
        StudentProfile mgen6Student = sd.newStudentProfile(mgen6Person);
        Person mgen7Person = pd.newPerson("10007");
        StudentProfile mgen7Student = sd.newStudentProfile(mgen7Person);
        Person mgen8Person = pd.newPerson("10008");
        StudentProfile mgen8Student = sd.newStudentProfile(mgen8Person);
        Person mgen9Person = pd.newPerson("10009");
        StudentProfile mgen9Student = sd.newStudentProfile(mgen9Person);
        Person mgen10Person = pd.newPerson("10010");
        StudentProfile mgen10Student = sd.newStudentProfile(mgen10Person);
        
        // 2.damgDepartment
        Person damg1Person = pdDamg.newPerson("20001");
        StudentProfile damg1Student = sdDamg.newStudentProfile(damg1Person);
        Person damg2Person = pdDamg.newPerson("20002");
        StudentProfile damg2Student = sdDamg.newStudentProfile(damg2Person);
        Person damg3Person = pdDamg.newPerson("20003");
        StudentProfile damg3Student = sdDamg.newStudentProfile(damg3Person);
        Person damg4Person = pdDamg.newPerson("20004");
        StudentProfile damg4Student = sdDamg.newStudentProfile(damg4Person);
        Person damg5Person = pdDamg.newPerson("20005");
        StudentProfile damg5Student = sdDamg.newStudentProfile(damg5Person);
        Person damg6Person = pdDamg.newPerson("20006");
        StudentProfile damg6Student = sdDamg.newStudentProfile(damg6Person);
        Person damg7Person = pdDamg.newPerson("20007");
        StudentProfile damg7Student = sdDamg.newStudentProfile(damg7Person);
        Person damg8Person = pdDamg.newPerson("20008");
        StudentProfile damg8Student = sdDamg.newStudentProfile(damg8Person);
        Person damg9Person = pdDamg.newPerson("20009");
        StudentProfile damg9Student = sdDamg.newStudentProfile(damg9Person);
        Person damg10Person = pdDamg.newPerson("20010");
        StudentProfile damg10Student = sdDamg.newStudentProfile(damg10Person);

        // 3.csyeDepartment
        Person csye1Person = pdCsye.newPerson("30001");
        StudentProfile csye1Student = sdCsye.newStudentProfile(csye1Person);
        Person csye2Person = pdCsye.newPerson("30002");
        StudentProfile csye2Student = sdCsye.newStudentProfile(csye2Person);
        Person csye3Person = pdCsye.newPerson("30003");
        StudentProfile csye3Student = sdCsye.newStudentProfile(csye3Person);
        Person csye4Person = pdCsye.newPerson("30004");
        StudentProfile csye4Student = sdCsye.newStudentProfile(csye4Person);
        Person csye5Person = pdCsye.newPerson("30005");
        StudentProfile csye5Student = sdCsye.newStudentProfile(csye5Person);
        Person csye6Person = pdCsye.newPerson("30006");
        StudentProfile csye6Student = sdCsye.newStudentProfile(csye6Person);
        Person csye7Person = pdCsye.newPerson("30007");
        StudentProfile csye7Student = sdCsye.newStudentProfile(csye7Person);
        Person csye8Person = pdCsye.newPerson("30008");
        StudentProfile csye8Student = sdCsye.newStudentProfile(csye8Person);
        Person csye9Person = pdCsye.newPerson("30009");
        StudentProfile csye9Student = sdCsye.newStudentProfile(csye9Person);
        Person csye10Person = pdCsye.newPerson("30010");
        StudentProfile csye10Student = sdCsye.newStudentProfile(csye10Person);
        

        // ---------------------------------- Part2 ----------------------------------------
        // Create a course schedule for Spring 2023 semester
        CourseSchedule cs1Spring2023 = mgenDepartment.newCourseSchedule("Spring 2023 semester");
        CourseSchedule cs2Spring2023 = damgDepartment.newCourseSchedule("Spring 2023 semester");
        CourseSchedule cs3Spring2023 = csyeDepartment.newCourseSchedule("Spring 2023 semester");

        //Create course offerings for each course for the semester
        // 1.mgenDepartment
        CourseOffer co5100 = cs1Spring2023.newCourseOffer("5100");
        CourseOffer co6105 = cs1Spring2023.newCourseOffer("6105");
        CourseOffer co6150 = cs1Spring2023.newCourseOffer("6150");
        // 2.damgDepartment
        CourseOffer co7150 = cs2Spring2023.newCourseOffer("7150");
        CourseOffer co7210 = cs2Spring2023.newCourseOffer("7210");
        CourseOffer co7250 = cs2Spring2023.newCourseOffer("7250");
        // 3.csyeDepartment
        CourseOffer co6200 = cs3Spring2023.newCourseOffer("6200");
        CourseOffer co6205 = cs3Spring2023.newCourseOffer("6205");
        CourseOffer co6250 = cs3Spring2023.newCourseOffer("6250");

        
        // adding seats for courses
        cs1Spring2023.generatSeatsForCourse("5100", 50);
        cs1Spring2023.generatSeatsForCourse("6105", 30);
        cs1Spring2023.generatSeatsForCourse("6150", 25);

        cs2Spring2023.generatSeatsForCourse("7150", 40);
        cs2Spring2023.generatSeatsForCourse("7210", 30);
        cs2Spring2023.generatSeatsForCourse("7250", 20);

        cs3Spring2023.generatSeatsForCourse("6200", 35);
        cs3Spring2023.generatSeatsForCourse("6205", 30);
        cs3Spring2023.generatSeatsForCourse("6250", 20);

        // Assign teachers (faculty) to their classes
        cs1Spring2023.assignAsTeacher("5100", facultylist1);
        cs1Spring2023.assignAsTeacher("6105", facultylist2);
        cs1Spring2023.assignAsTeacher("6150", facultylist3);

        cs2Spring2023.assignAsTeacher("7150", facultylist4);
        cs2Spring2023.assignAsTeacher("7210", facultylist5);
        cs2Spring2023.assignAsTeacher("7250", facultylist6);

        cs3Spring2023.assignAsTeacher("6200", facultylist7);
        cs3Spring2023.assignAsTeacher("6205", facultylist8);
        cs3Spring2023.assignAsTeacher("6250", facultylist9);

        // Register students for the courses
        // 1.mgenDepartment
        mgenDepartment.RegisterForAClass("10001", "5100", "Spring 2023 semester");
        mgenDepartment.RegisterForAClass("10002", "5100", "Spring 2023 semester");
        mgenDepartment.RegisterForAClass("10003", "5100", "Spring 2023 semester");
        mgenDepartment.RegisterForAClass("10004", "6105", "Spring 2023 semester");
        mgenDepartment.RegisterForAClass("10005", "6105", "Spring 2023 semester");
        mgenDepartment.RegisterForAClass("10006", "6105", "Spring 2023 semester");
        mgenDepartment.RegisterForAClass("10007", "6105", "Spring 2023 semester");
        mgenDepartment.RegisterForAClass("10008", "6150", "Spring 2023 semester");
        mgenDepartment.RegisterForAClass("10009", "6150", "Spring 2023 semester");
        mgenDepartment.RegisterForAClass("10010", "6150", "Spring 2023 semester");

        // 2.damgDepartment
        damgDepartment.RegisterForAClass("20001", "7150", "Spring 2023 semester");
        damgDepartment.RegisterForAClass("20002", "7150", "Spring 2023 semester");
        damgDepartment.RegisterForAClass("20003", "7210", "Spring 2023 semester");
        damgDepartment.RegisterForAClass("20004", "7210", "Spring 2023 semester");
        damgDepartment.RegisterForAClass("20005", "7210", "Spring 2023 semester");
        damgDepartment.RegisterForAClass("20006", "7210", "Spring 2023 semester");
        damgDepartment.RegisterForAClass("20007", "7250", "Spring 2023 semester");
        damgDepartment.RegisterForAClass("20008", "7250", "Spring 2023 semester");
        damgDepartment.RegisterForAClass("20009", "7250", "Spring 2023 semester");
        damgDepartment.RegisterForAClass("20010", "7250", "Spring 2023 semester");

        // 3.csyeDepartment
        csyeDepartment.RegisterForAClass("30001", "6200", "Spring 2023 semester");
        csyeDepartment.RegisterForAClass("30002", "6200", "Spring 2023 semester");
        csyeDepartment.RegisterForAClass("30003", "6200", "Spring 2023 semester");
        csyeDepartment.RegisterForAClass("30004", "6205", "Spring 2023 semester");
        csyeDepartment.RegisterForAClass("30005", "6205", "Spring 2023 semester");
        csyeDepartment.RegisterForAClass("30006", "6205", "Spring 2023 semester");
        csyeDepartment.RegisterForAClass("30007", "6250", "Spring 2023 semester");
        csyeDepartment.RegisterForAClass("30008", "6250", "Spring 2023 semester");
        csyeDepartment.RegisterForAClass("30009", "6250", "Spring 2023 semester");
        csyeDepartment.RegisterForAClass("30010", "6250", "Spring 2023 semester");

        //System.out.println("************");
        coe.printCollegeInformation();
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        
        // ---------------------------------- Part3 ----------------------------------------
        // Implement a method to calculate Department revenue
        //Implement a method to calculate College revenue and print out revenues for each department as well as the college
        System.out.println("-------------------------------------");
        int totalRevenue = coe.calculateRevenuesBySemester("Spring 2023 semester");
        System.out.println("Total revenue " + totalRevenue);   

    }

}
