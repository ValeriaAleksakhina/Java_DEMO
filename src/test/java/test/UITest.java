package test;

import com.codeborne.selenide.Configuration;
import data.ValidData;
import org.junit.jupiter.api.Test;
import pages.DemoQaPage;
import pages.ResultTable;
import settings.BaseTest;

import static com.codeborne.selenide.Selenide.$;

public class UITest extends BaseTest {
    DemoQaPage demoQaPage = new DemoQaPage();
    ResultTable resultTable = new ResultTable();
    @Test
    void openPage(){
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
                 .loadFile()
                 .fillStateAndCity()
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
        resultTable.checkAdress();
        resultTable.checkFullAdress();


    }








}



