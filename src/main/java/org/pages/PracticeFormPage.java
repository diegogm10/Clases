package org.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class PracticeFormPage extends BasePages{

    public PracticeFormPage(WebDriver driver) {
        super(driver);
    }

    //LOCATORS
    By btnForm = By.xpath("//a[@href='/forms']");
    By btnPracticeForm = By.xpath("(//a[@href='/automation-practice-form'])[1]");
    By textFirstName = By.id("firstName");
    By textLastName = By.id("lastName");
    By textEmail = By.id("userEmail");
    By btnGender = By.id("gender-radio-1");
    By textPhone = By.id("userNumber");
    By DateBirth = By.id("dateOfBirthInput");
    By textSubject = By.id("subjectsInput");
    By btnHobbies = By.id("hobbies-checkbox-1");
    By btnHobbies1 = By.id("hobbies-checkbox-3");
    By btnUpload = By.id("uploadPicture");
    By textCurrAddress = By.id("currentAddress");
    By textSelectState = By.id("react-select-3-input");
    By textSelectCity = By.id("react-select-4-input");
    By btnSubmit = By.id("submit");

    public void open (){
        driver.get("https://demoqa.com/");
    }

    public void fillForm (String img){
        click(btnForm);
        click(btnPracticeForm);
        type(textFirstName,"Vander Grap");
        type(textLastName, "Monkey D.");
        type(textEmail, "MonkeyDVanderGrap@test.com");
        click(btnGender);
        type(textPhone,"3101234567");
        WebElement txtDateBirth = wait.until(ExpectedConditions.visibilityOfElementLocated(DateBirth));
        click(DateBirth);
        txtDateBirth.sendKeys(Keys.TAB);
        WebElement txtSubject = wait.until(ExpectedConditions.visibilityOfElementLocated(textSubject));
        type(textSubject,"Computer Science");
        txtSubject.sendKeys(Keys.TAB);
        click(btnHobbies);
        click(btnHobbies1);
        //click(btnUpload);
        WebElement btnUpload1 = driver.findElement(By.id("uploadPicture"));
        btnUpload1.sendKeys(img);
        type(textCurrAddress,"Calle falsa 123");
        WebElement txtSelectState = wait.until(ExpectedConditions.visibilityOfElementLocated(textSelectState));
        type(textSelectState, "NCR");
        txtSelectState.sendKeys(Keys.TAB);
        WebElement txtSelectCity = wait.until(ExpectedConditions.visibilityOfElementLocated(textSelectCity));
        type(textSelectCity, "Gurgaon");
        txtSelectCity.sendKeys(Keys.TAB);
        click(btnSubmit);
    }
}
