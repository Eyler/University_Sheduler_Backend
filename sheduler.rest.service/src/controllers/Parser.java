package controllers;

import models.YarikStudentGroup;
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

    private void init() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        studentsSchedulePage = new StudentsSchedulePage(driver);
        instituteNames = new LinkedList<String>();
        studentGroupNames = new LinkedList<String>();
        studentGroups = new LinkedList<YarikStudentGroup>();
    }

    public List<YarikStudentGroup> start() throws InterruptedException {
        init();
        studentsSchedulePage.open();
        instituteNames = studentsSchedulePage.getInstituteNames();
        //for (String instituteName : instituteNames) {
            studentGroupNames = studentsSchedulePage.getStudentGroupNames("ІКНІ");
            for (String studentGroupName : studentGroupNames) {
                studentsSchedulePage.openScheduleForGroup(studentGroupName);
                YarikStudentGroup studentGroup = new YarikStudentGroup(studentGroupName, "ІКНІ", studentsSchedulePage.getPeriods());
                studentGroups.add(studentGroup);
            }

      //  }
        driver.close();
        return studentGroups;
    }
}
