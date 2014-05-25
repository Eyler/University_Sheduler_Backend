package controllers;

import models.StudentGroup;
import models.YarikStudentGroup;
import models.page_objects.Lecturer;
import models.page_objects.LecturerSchedulePage;
import models.page_objects.StudentsSchedulePage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by ykoby_000 on 09.05.2014.
 */
public class Parser {
    private WebDriver driver;

    private StudentsSchedulePage studentsSchedulePage;
    private List<String> instituteNames;
    private List<String> studentGroupNames;
    private List<YarikStudentGroup> studentGroups;

    private LecturerSchedulePage lecturerSchedulePage;
    private List<String> departmentNames;
    private List<String> lecturerCredentials;
    private List<Lecturer> lecturers;

    private void init() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        studentsSchedulePage = new StudentsSchedulePage(driver);
        instituteNames = new LinkedList<String>();
        studentGroupNames = new LinkedList<String>();
        studentGroups = new LinkedList<YarikStudentGroup>();

        lecturerSchedulePage = new LecturerSchedulePage(driver);
        departmentNames = new LinkedList<String>();
        lecturerCredentials = new LinkedList<String>();
        lecturers = new LinkedList<Lecturer>();

    }

    public List<YarikStudentGroup> startStudent() throws InterruptedException {
        init();
        studentsSchedulePage.open();
        instituteNames = studentsSchedulePage.getInstituteNames();
        String instituteName = instituteNames.get(0);
        //for (String instituteName : instituteNames) {
        studentGroupNames = studentsSchedulePage.getStudentGroupNames("ІКНІ");
        for (String studentGroupName : studentGroupNames) {
            studentsSchedulePage.openScheduleForGroup(studentGroupName);
            YarikStudentGroup studentGroup = new YarikStudentGroup(studentGroupName, "ІКНІ", studentsSchedulePage.getPeriods());
            studentGroups.add(studentGroup);
        }

        // }
        driver.close();
        System.out.println(studentGroups);
        return studentGroups;
    }

    public List<Lecturer> startLecturer() throws InterruptedException {
        init();
        lecturerSchedulePage.open();
        departmentNames = lecturerSchedulePage.getDepartmentNames();
        String department = departmentNames.get(79);
        //for (String department : departmentNames) {
            lecturerCredentials = lecturerSchedulePage.getLecturersCredenitals(department);
            for (String credentials : lecturerCredentials) {
                lecturerSchedulePage.openScheduleForLecturer(credentials);
                Lecturer lecturer = new Lecturer(department, credentials, lecturerSchedulePage.getPeriods());
                lecturers.add(lecturer);
                System.out.println(lecturer);

            }

        //}
        driver.close();

        return lecturers;
    }
}
