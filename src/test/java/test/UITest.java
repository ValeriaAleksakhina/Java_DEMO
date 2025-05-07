package test;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import data.ValidData;
import org.junit.jupiter.api.Test;
import pages.DemoQaPage;
import pages.ResultTable;
import settings.BaseTest;


public class UITest extends BaseTest {
    DemoQaPage demoQaPage = new DemoQaPage();
    ResultTable resultTable = new ResultTable();

    @Test
    void testForm() {
        demoQaPage.openPage(ValidData.getUrl())
                .titleTextCheck(new ValidData().getText())
                .fillName()
                .fillLastName()
                .fillEmail()
                .fillGender()
                .fillUserNumber()
                .fillDate()
                .fillSubject()
                .fillHobbies()
                .fillImageField()
                .fillCurrentAddress()
                .fillStateField()
                .fillCityField()
                .submitButtonClick();
        Configuration.timeout = 6000;
        resultTable.checkName();
        resultTable.checkEmail();
        resultTable.checkGender();
        resultTable.checkPhone();
        resultTable.checkDateOfBirth();
        resultTable.checkSubject();
        resultTable.checkHobby();
        resultTable.checkImage();
        resultTable.checkAddress();
        resultTable.checkFullAddress();
        resultTable.closeButtonClick();
    }

    @Test
    void fieldsValidation() {
        demoQaPage.openPage(ValidData.getUrl());
        Configuration.timeout = 5000;
        demoQaPage.submitButtonClick();
        Selenide.sleep(5000);
        demoQaPage.checkColorName(ValidData.color)
                .checkColorLastName(ValidData.color)
                .checkColorGender(ValidData.color)
                .checkColorPhone(ValidData.color);


    }
}



