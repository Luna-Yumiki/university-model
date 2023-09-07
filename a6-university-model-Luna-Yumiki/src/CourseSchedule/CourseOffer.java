/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CourseSchedule;

import CourseCatalog.Course;
import Persona.Faculty.FacultyAssignment;
import Persona.Faculty.FacultyProfile;
import java.util.ArrayList;

/**
 *
 * @author kal bugrara
 */
public class CourseOffer {

    Course course;
    ArrayList<Seat> seatlist;
    FacultyAssignment facultyassignment;

    public CourseOffer(Course c) {
        course = c;
        seatlist = new ArrayList<Seat>();
    }
     
    public void AssignAsTeacher(FacultyProfile fp) {

        facultyassignment = new FacultyAssignment(fp, this);
    }

    public FacultyProfile getFacultyProfile() {
        return facultyassignment.getFacultyProfile();
    }

    public String getCourseNumber() {
        return course.getCOurseNumber();
    }

    public void generatSeats(int n) {

        for (int i = 0; i < n; i++) {

            seatlist.add(new Seat(this, i));

        }

    }

    public Seat getEmptySeat() {

        for (Seat s : seatlist) {

            if (!s.isOccupied()) {
                return s;
            }
        }
        return null;
    }

    public int getNumberofEmptySeats() {
        int n = 0;
        for (Seat s : seatlist) {
            if (!s.isOccupied()) {
                n = n + 1;
            }
        }
        return n;
    }



    public SeatAssignment assignEmptySeat(CourseLoad cl) {

        Seat seat = getEmptySeat();
        if (seat == null) {
            return null;
        }
        SeatAssignment sa = seat.newSeatAssignment(cl); //seat is already linked to course offer
        cl.registerStudent(sa); //coures offer seat is now linked to student
        return sa;
    }

    public int getTotalCourseRevenues() {
        System.out.print(course.getName() + ": ");
        int sum = 0;

        for (Seat s : seatlist) {
            if (s.isOccupied() == true) {
                sum = sum + course.getCoursePrice();
            }
        }
        System.out.println(sum);
        return sum;
    }
    public Course getSubjectCourse(){
        return course;
    }
    public int getCreditHours(){
        return course.getCredits();
    }

    public void printOfferInformation(){
        System.out.println(" - " + course.getCOurseNumber() + " - " + course.getName() + " - " + getNumberofEmptySeats() + " avail. out of " + seatlist.size() + "total.");
    }


    public void printCollegeInformation(){
        int numberOfEmptySeats = getNumberofEmptySeats();
        String courseNumber = course.getCOurseNumber();
        String courseName = course.getName();
        int totalSeats = seatlist.size();
        String teacherName = "No teacher assigned";
        if (facultyassignment != null){
            teacherName = facultyassignment.getTeacherName();
        }
        
        String singleLine = "-" + courseNumber + "-" + courseName + "-" + teacherName + "-" + numberOfEmptySeats 
        + "avail. out of " + totalSeats + "total.";

        System.out.println(singleLine);
    }



}
