/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CourseSchedule;

import CourseCatalog.Course;
import CourseCatalog.CourseCatalog;
import Persona.Faculty.FacultyProfile;

import java.util.ArrayList;

/**
 *
 * @author kal bugrara
 */
public class CourseSchedule {

    CourseCatalog coursecatalog;

    ArrayList<CourseOffer> schedule;
    String semester;

    public CourseSchedule(String s, CourseCatalog cc) {
        semester = s;
        coursecatalog = cc;
        schedule = new ArrayList<CourseOffer>();

    }

    public CourseOffer newCourseOffer(String  n) {

        Course c = coursecatalog.getCourseByNumber(n);
        if(c==null) {
            System.out.println("Course number" + n + " was noy found for " + semester);
            return null;
        }
            
        CourseOffer co = new CourseOffer(c);
        schedule.add(co);
        return co;
    }

    public CourseOffer getCourseOfferByNumber(String n) {

        for (CourseOffer co : schedule) {

            if (co.getCourseNumber().equals(n)) {
                return co;
            }
        }
        return null;
    }

    public int calculateTotalRevenues() {
        int sum = 0;
        for (CourseOffer co : schedule) {

            sum = sum + co.getTotalCourseRevenues();

        }
        return sum;
    }

    public void printScheduleInformation(){
        if (schedule.size() == 0){
            System.out.println("No course available for " + semester);
        } else;{
        System.out.println(semester + ": " + "These courses are available");
        for (CourseOffer eaCourseOffer: schedule){
            eaCourseOffer.printOfferInformation();
        }
    }
    }


    public void generatSeatsForCourse(String courseNumber, int seatCount){
        CourseOffer c = getCourseOfferByNumber(courseNumber);
        if (c == null) {
            System.out.println("You are trying to add a teacher to a course that wasn't in the semester. " + courseNumber + "was not found" + semester);
            return;
        }
        c.generatSeats(seatCount);
    }
    
    
    public void assignAsTeacher(String courseNumber, FacultyProfile facultyProfile){
        CourseOffer c = getCourseOfferByNumber(courseNumber);
        if (c == null) {
            System.out.println("You are trying to add a teacher to a course that wasn't in the semester. " + courseNumber + "was not found" + semester);
            return;
        }
        c.AssignAsTeacher(facultyProfile);

    }








}
