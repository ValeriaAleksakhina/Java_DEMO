package test;

import data.ValidData;
import org.junit.jupiter.api.Test;
import pages.DemoQaPage;
import settings.BaseTest;

import static com.codeborne.selenide.Selenide.$;

public class UITest extends BaseTest {
    DemoQaPage demoQaPage = new DemoQaPage();
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

    }}


