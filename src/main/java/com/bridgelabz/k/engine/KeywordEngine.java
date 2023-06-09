package com.bridgelabz.k.engine;

import com.bridgelabz.k.base.BaseClass;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.Set;

public class KeywordEngine {
    public WebDriver driver;
    public Properties properties;
    BaseClass baseClass;
    WebElement element;
    Actions actions;
    JavascriptExecutor js;

    public static Workbook workbook;
    public static Sheet sheet;

    public String scenario_sheet_path = System.getProperty("user.dir") + "/src/main/resources/AmazonIndia.xlsx";

    public void starExecution(String sheetName) {

        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream(scenario_sheet_path);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        try {
            workbook = WorkbookFactory.create(fileInputStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        sheet = workbook.getSheet(sheetName);

        int c = 0;
        for (int r = 0; r < sheet.getLastRowNum(); r++) {

            try {
                String locatorType = sheet.getRow(r + 1).getCell(c + 1).toString().trim();
                String locatorValue = sheet.getRow(r + 1).getCell(c + 2).toString().trim();
                String action = sheet.getRow(r + 1).getCell(c + 3).toString().trim();
                String value = sheet.getRow(r + 1).getCell(c + 4).toString().trim();

                switch (action) {
                    case "openBrowser":
                        baseClass = new BaseClass();

                        properties = baseClass.initializeProperties();

                        if (value.isEmpty() || value.equals("NA")) {
                            driver = baseClass.launchBrowser(properties.getProperty("browser"));
                        } else {
                            driver = baseClass.launchBrowser(value);
                        }
                        break;
                    case "enterUrl":
                        if (value.isEmpty() || value.equals("NA")) {
                            driver.get(properties.getProperty("url"));
                        } else {
                            driver.get(value);
                        }
                        break;
                    case "quit":
                        try {
                            Thread.sleep(4000);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                        driver.quit();
                        break;
                    case "close":
                        try {
                            Thread.sleep(4000);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                        driver.close();
                        break;
                    case "scroll":
                        String parentWindowHandleId = driver.getWindowHandle();
                        Set<String> windowHandles = driver.getWindowHandles();
                        for (String windowHandle : windowHandles) {
                            System.out.println("window handle Id: " + windowHandle);
                            if (!windowHandle.equals(parentWindowHandleId)) {
                                driver.switchTo().window(windowHandle);
                            }
                        }
                        break;
                    default:
                        break;
                }

                switch (locatorType) {
                    case "id":
                        element = driver.findElement(By.id(locatorValue));
                        if (action.equalsIgnoreCase("sendKeys")) {
                            element.sendKeys(value);
                        } else if (action.equalsIgnoreCase("click")) {
                            element.click();
                        } else if (action.equalsIgnoreCase("getText")) {
                            String elementText = element.getText();
                            System.out.println("text from element: " + elementText);

                        } else if (action.equalsIgnoreCase("isDisplayed")) {
                            element.isDisplayed();
                        } else if (action.equalsIgnoreCase("clear")) {
                            element.clear();
                        }else if (action.equalsIgnoreCase("doubleClick")) {
                            actions=new Actions(driver);
                            actions.doubleClick(element).perform();
                        }else if (action.equalsIgnoreCase("mouseOver")) {
                            actions=new Actions(driver);
                            actions.moveToElement(element).perform();
                        }else if (action.equalsIgnoreCase("scroll")) {
                            js=(JavascriptExecutor) driver;
                            int x=element.getLocation().getX();
                            int y=element.getLocation().getY();
                            js.executeScript("window.scrollBy("+x+","+y+")");
                        }
                        break;
                    case "name":
                        element = driver.findElement(By.name(locatorValue));
                        if (action.equalsIgnoreCase("sendKeys")) {
                            element.sendKeys(value);
                        } else if (action.equalsIgnoreCase("click")) {
                            element.click();
                        } else if (action.equalsIgnoreCase("getText")) {
                            String elementText = element.getText();
                            System.out.println("text from element: " + elementText);

                        } else if (action.equalsIgnoreCase("isDisplayed")) {
                            element.isDisplayed();
                        } else if (action.equalsIgnoreCase("clear")) {
                            element.clear();
                        }else if (action.equalsIgnoreCase("doubleClick")) {
                            actions=new Actions(driver);
                            actions.doubleClick(element).perform();
                        }else if (action.equalsIgnoreCase("mouseOver")) {
                            actions=new Actions(driver);
                            actions.moveToElement(element).perform();
                        }else if (action.equalsIgnoreCase("scroll")) {
                            js=(JavascriptExecutor) driver;
                            int x=element.getLocation().getX();
                            int y=element.getLocation().getY();
                            js.executeScript("window.scrollBy("+x+","+y+")");
                        }
                        break;
                    case "xpath":
                        element = driver.findElement(By.xpath(locatorValue));
                        if (action.equalsIgnoreCase("sendKeys")) {
                            element.sendKeys(value);
                        } else if (action.equalsIgnoreCase("click")) {
                            element.click();
                        } else if (action.equalsIgnoreCase("getText")) {
                            String elementText = element.getText();
                            System.out.println("text from element: " + elementText);

                        } else if (action.equalsIgnoreCase("isDisplayed")) {
                            element.isDisplayed();
                        } else if (action.equalsIgnoreCase("clear")) {
                            element.clear();
                        }else if (action.equalsIgnoreCase("doubleClick")) {
                            actions=new Actions(driver);
                            actions.doubleClick(element).perform();
                        }else if (action.equalsIgnoreCase("mouseOver")) {
                            actions=new Actions(driver);
                            actions.moveToElement(element).perform();
                        }else if (action.equalsIgnoreCase("scroll")) {
                            js=(JavascriptExecutor) driver;
                            int x=element.getLocation().getX();
                            int y=element.getLocation().getY();
                            js.executeScript("window.scrollBy("+x+","+y+")");
                        }
                        break;
                    case "cssSelector":
                        element = driver.findElement(By.cssSelector(locatorValue));
                        if (action.equalsIgnoreCase("sendKeys")) {
                            element.sendKeys(value);
                        } else if (action.equalsIgnoreCase("click")) {
                            element.click();
                        } else if (action.equalsIgnoreCase("getText")) {
                            String elementText = element.getText();
                            System.out.println("text from element: " + elementText);

                        } else if (action.equalsIgnoreCase("isDisplayed")) {
                            element.isDisplayed();
                        } else if (action.equalsIgnoreCase("clear")) {
                            element.clear();
                        }else if (action.equalsIgnoreCase("doubleClick")) {
                            actions=new Actions(driver);
                            actions.doubleClick(element).perform();
                        }else if (action.equalsIgnoreCase("mouseOver")) {
                            actions=new Actions(driver);
                            actions.moveToElement(element).perform();
                        }else if (action.equalsIgnoreCase("scroll")) {
                            js=(JavascriptExecutor) driver;
                            int x=element.getLocation().getX();
                            int y=element.getLocation().getY();
                            js.executeScript("window.scrollBy("+x+","+y+")");
                        }
                        break;
                    case "className":
                        element = driver.findElement(By.className(locatorValue));
                        if (action.equalsIgnoreCase("sendKeys")) {
                            element.sendKeys(value);
                        } else if (action.equalsIgnoreCase("click")) {
                            element.click();
                        } else if (action.equalsIgnoreCase("getText")) {
                            String elementText = element.getText();
                            System.out.println("text from element: " + elementText);

                        } else if (action.equalsIgnoreCase("isDisplayed")) {
                            element.isDisplayed();
                        } else if (action.equalsIgnoreCase("clear")) {
                            element.clear();
                        }else if (action.equalsIgnoreCase("doubleClick")) {
                            actions=new Actions(driver);
                            actions.doubleClick(element).perform();
                        }else if (action.equalsIgnoreCase("mouseOver")) {
                            actions=new Actions(driver);
                            actions.moveToElement(element).perform();
                        }else if (action.equalsIgnoreCase("scroll")) {
                            js=(JavascriptExecutor) driver;
                            int x=element.getLocation().getX();
                            int y=element.getLocation().getY();
                            js.executeScript("window.scrollBy("+x+","+y+")");
                        }
                        break;
                    case "tagName":
                        element = driver.findElement(By.tagName(locatorValue));
                        if (action.equalsIgnoreCase("sendKeys")) {
                            element.sendKeys(value);
                        } else if (action.equalsIgnoreCase("click")) {
                            element.click();
                        } else if (action.equalsIgnoreCase("getText")) {
                            String elementText = element.getText();
                            System.out.println("text from element: " + elementText);

                        } else if (action.equalsIgnoreCase("isDisplayed")) {
                            element.isDisplayed();
                        } else if (action.equalsIgnoreCase("clear")) {
                            element.clear();
                        }else if (action.equalsIgnoreCase("doubleClick")) {
                            actions=new Actions(driver);
                            actions.doubleClick(element).perform();
                        }else if (action.equalsIgnoreCase("mouseOver")) {
                            actions=new Actions(driver);
                            actions.moveToElement(element).perform();
                        }else if (action.equalsIgnoreCase("scroll")) {
                            js=(JavascriptExecutor) driver;
                            int x=element.getLocation().getX();
                            int y=element.getLocation().getY();
                            js.executeScript("window.scrollBy("+x+","+y+")");
                        }
                        break;
                    case "linkText":
                        element = driver.findElement(By.linkText(locatorValue));
                        if (action.equalsIgnoreCase("click")) {
                            element.click();
                        } else if (action.equalsIgnoreCase("getText")) {
                            String elementText = element.getText();
                            System.out.println("text from element: " + elementText);
                        }
                        break;
                    case "partialLinkText":
                        element = driver.findElement(By.partialLinkText(locatorValue));
                        if (action.equalsIgnoreCase("click")) {
                            element.click();
                        } else if (action.equalsIgnoreCase("getText")) {
                            String elementText = element.getText();
                            System.out.println("text from element: " + elementText);
                        }
                        break;
                    default:
                        break;
                }

            } catch (Exception e) {
                e.printStackTrace();
                Assert.assertTrue(false);
            }
        }
    }
}
