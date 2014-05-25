

package models.page_objects;

import models.Auditorium;
import models.Period;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.*;

/**
 * Created by ykoby_000 on 09.05.2014.
 */
public class LecturerSchedulePage {
    private WebDriver driver;
    private String departmentSelector = "//select[@name='kaf']";
    private String credentialsSelector = "//select[@name='fnsn']";

    public LecturerSchedulePage(WebDriver driver) {
        this.driver = driver;
    }

    public void open() {
        driver.get("http://lp.edu.ua/node/41");
    }

    public List<String> getDepartmentNames() {
        List<WebElement> webElements = driver.findElements(By.xpath("//select[@id='dep']" + "/option"));
        List<String> departmentNames = new LinkedList<String>();
        for (WebElement webElement : webElements) {
            if (!webElement.getText().isEmpty())
                departmentNames.add(webElement.getText());
        }
        return departmentNames;
    }

    public List<String> getLecturersCredenitals(String department) {
        selectElementByLinkText(departmentSelector, department);
        List<WebElement> webElements = driver.findElements(By.xpath(credentialsSelector + "/option"));
        List<String> studentGroupNames = new LinkedList<String>();
        for (WebElement webElement : webElements) {
            if (!webElement.getText().isEmpty())
                studentGroupNames.add(webElement.getText());
        }
        return studentGroupNames;
    }

    public void openScheduleForLecturer(String credentials) {
        selectElementByLinkText(credentialsSelector, credentials);
    }

    public List<Period> getPeriods() {
        List<WebElement> webElements = driver.findElements(By.xpath("//div[@id='vykl']/div/table/tbody/tr"));
        webElements.remove(0);
        List<Period> periods = new LinkedList<Period>();
        String day = "";
        int number = 0;
        for (WebElement webElement : webElements) {
            try {
                if (webElement.findElements(By.xpath("td")).size() == 1) {
                    day = webElement.findElement(By.xpath("td[1]")).getText();
                } else if (webElement.findElements(By.xpath("td")).size() == 3) {
                    day = webElement.findElement(By.xpath("td[1]")).getText();
                    number = Integer.parseInt(webElement.findElement(By.xpath("td[2]")).getText());
                    if (webElement.findElements(By.xpath("td[3]/table/tbody/tr")).size() == 2) {
                        String tmp = webElement.findElement(By.xpath("td[3]/table/tbody/tr[@class='color']/td")).getText();
                        if (!tmp.isEmpty()) {
                            String discipline = webElement.findElement(By.xpath("td[3]/table/tbody/tr[@class='color']/td/div/b")).getText();
                            String lecturer = webElement.findElement(By.xpath("td[3]/table/tbody/tr[@class='color']/td/div/i")).getText();
                            String auditoriumLocation = "";
                            String auditoriumNumber = "";
                            if (webElement.findElement(By.xpath("td[3]/table/tbody/tr[@class='color']/td/div"))
                                    .getText().contains("каф")) {
                                auditoriumLocation = "каф.";
                                auditoriumNumber = "unknown";
                            } else {
                                auditoriumLocation = webElement.findElement(By.xpath("td[3]/table/tbody/tr[@class='color']/td/div"))
                                        .getText().replace(discipline, "").replace(lecturer, "").split(",")[0].split("н.к.")[0].trim();
                                auditoriumNumber = webElement.findElement(By.xpath("td[3]/table/tbody/tr[@class='color']/td/div"))
                                        .getText().replace(discipline, "").replace(lecturer, "").split(",")[0].split("н.к.")[1].trim();
                            }
                            periods.add(new Period(day, number, discipline, new Auditorium(auditoriumLocation, auditoriumNumber, true), lecturer));
                        }
                    } else if (webElement.findElements(By.xpath("td[3]/table/tbody/tr")).size() == 1) {
                        String tmp = webElement.findElement(By.xpath("td[3]/table/tbody/tr[@class='color']/td")).getText();
                        if (!tmp.isEmpty()) {
                            String discipline = webElement.findElement(By.xpath("td[3]/table/tbody/tr[@class='color']/td/div/b")).getText();
                            String lecturer = webElement.findElement(By.xpath("td[3]/table/tbody/tr[@class='color']/td/div/i")).getText();
                            String auditoriumLocation = "";
                            String auditoriumNumber = "";
                            if (webElement.findElement(By.xpath("td[3]/table/tbody/tr[@class='color']/td/div"))
                                    .getText().contains("каф")) {
                                auditoriumLocation = "каф.";
                                auditoriumNumber = "unknown";
                            } else {
                                auditoriumLocation = webElement.findElement(By.xpath("td[3]/table/tbody/tr[@class='color']/td/div"))
                                        .getText().replace(discipline, "").replace(lecturer, "").split(",")[0].split("н.к.")[0].trim();
                                auditoriumNumber = webElement.findElement(By.xpath("td[3]/table/tbody/tr[@class='color']/td/div"))
                                        .getText().replace(discipline, "").replace(lecturer, "").split(",")[0].split("н.к.")[1].trim();
                            }
                            periods.add(new Period(day, number, discipline, new Auditorium(auditoriumLocation, auditoriumNumber, true), lecturer));
                        }
                    }
                } else if (webElement.findElements(By.xpath("td")).size() == 2) {
                    number = Integer.parseInt(webElement.findElement(By.xpath("td[1]")).getText());
                    if (webElement.findElements(By.xpath("td[2]/table/tbody/tr")).size() == 2) {
                        String tmp = webElement.findElement(By.xpath("td[2]/table/tbody/tr[@class='color']/td")).getText();
                        if (!tmp.isEmpty()) {
                            String discipline = webElement.findElement(By.xpath("td[2]/table/tbody/tr[@class='color']/td/div/b")).getText();
                            String lecturer = webElement.findElement(By.xpath("td[2]/table/tbody/tr[@class='color']/td/div/i")).getText();
                            String auditoriumLocation = "";
                            String auditoriumNumber = "";
                            if (webElement.findElement(By.xpath("td[2]/table/tbody/tr[@class='color']/td/div"))
                                    .getText().contains("каф")) {
                                auditoriumLocation = "каф.";
                                auditoriumNumber = "unknown";
                            } else {
                                auditoriumLocation = webElement.findElement(By.xpath("td[2]/table/tbody/tr[@class='color']/td/div"))
                                        .getText().replace(discipline, "").replace(lecturer, "").split(",")[0].split("н.к.")[0].trim();
                                auditoriumNumber = webElement.findElement(By.xpath("td[2]/table/tbody/tr[@class='color']/td/div"))
                                        .getText().replace(discipline, "").replace(lecturer, "").split(",")[0].split("н.к.")[1].trim();
                            }
                            periods.add(new Period(day, number, discipline, new Auditorium(auditoriumLocation, auditoriumNumber, true), lecturer));
                        }
                    } else if (webElement.findElements(By.xpath("td[2]/table/tbody/tr")).size() == 1) {
                        String tmp = webElement.findElement(By.xpath("td[2]/table/tbody/tr[@class='color']/td")).getText();
                        if (!tmp.isEmpty()) {
                            String discipline = webElement.findElement(By.xpath("td[2]/table/tbody/tr[@class='color']/td/div/b")).getText();
                            String lecturer = webElement.findElement(By.xpath("td[2]/table/tbody/tr[@class='color']/td/div/i")).getText();
                            String auditoriumLocation = "";
                            String auditoriumNumber = "";
                            if (webElement.findElement(By.xpath("td[2]/table/tbody/tr[@class='color']/td/div"))
                                    .getText().contains("каф")) {
                                auditoriumLocation = "каф.";
                                auditoriumNumber = "unknown";
                            } else {
                                auditoriumLocation = webElement.findElement(By.xpath("td[2]/table/tbody/tr[@class='color']/td/div"))
                                        .getText().replace(discipline, "").replace(lecturer, "").split(",")[0].split("н.к.")[0].trim();
                                auditoriumNumber = webElement.findElement(By.xpath("td[2]/table/tbody/tr[@class='color']/td/div"))
                                        .getText().replace(discipline, "").replace(lecturer, "").split(",")[0].split("н.к.")[1].trim();
                            }
                            periods.add(new Period(day, number, discipline, new Auditorium(auditoriumLocation, auditoriumNumber, true), lecturer));
                        }
                    }
                }
            } catch (org.openqa.selenium.NoSuchElementException e) {
                break;
            } catch (ArrayIndexOutOfBoundsException e) {
                break;
            }
        }
        return periods;
    }

    private void selectElementByLinkText(String xpathSelector, String linkText) {
        Select select = new Select(driver.findElement(By.xpath(xpathSelector)));
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpathSelector)));
        select.selectByVisibleText(linkText);
    }
}
