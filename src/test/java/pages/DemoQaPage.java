package pages;

import com.codeborne.selenide.Condition;
import data.ValidData;
import elements.TextField;


import java.io.File;
import java.time.Duration;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$x;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class DemoQaPage {
    private final TextField textField = new TextField("Название формы", $(".text-center"));

    // объявление селекторов
    public final static String nameSelector = "#firstName";
    public final static String lastNameSelector = "#lastName";
    public final static String userEmailSelector = "#userEmail";
    public final static String genderSelector = "#gender-radio-2";
    public final static String phoneNumberSelector = "#userNumber";
    public final static String dateOfBirthSelector = "#dateOfBirthInput";
    public final static String dateOfBirthMonthSelector = ".react-datepicker__month-select";
    public final static String dateOfBirthYearSelector = ".react-datepicker__year-select";
    public final static String dateOfBirthDate = "//DIV[@class='react-datepicker__day react-datepicker__day--003 react-datepicker__day--weekend'][text()='3']";
    public final static String subjectSelector = "#subjectsInput";
    public final static String hobbiesSelector = "#hobbiesWrapper";
    public final static String fileSelector = "#uploadPicture";
    public final static String currentAddressSelector = "#currentAddress";
    public final static String stateSelector = "//div[@id=\"stateCity-wrapper\"]//div[@id=\"state\"]";
    public final static String stateNameSelector = "#react-select-3-option-3";
    public final static String citySelector = "//div[@id=\"stateCity-wrapper\"]//div[@id=\"city\"]";
    public final static String cityNameSelector = "#react-select-4-option-0";
    public final static String submitButtonSelector = "#submit";

    // методы заполнения полей
    public DemoQaPage fillName(){
        $(nameSelector).setValue(ValidData.name);
        return this;
    }
    public DemoQaPage fillLastName(){
        $(lastNameSelector).setValue(ValidData.lastName);
        return this;
    }
    public DemoQaPage fillEmail(){
        $(userEmailSelector).setValue(ValidData.userEmail);
        return this;
    }
    public DemoQaPage fillUserNumber(){
        $(phoneNumberSelector).setValue(ValidData.userNumber);
        return this;
    }
    public DemoQaPage fillGender(){
        $(genderSelector).parent().click();
        return this;
    }
    public DemoQaPage fillDate(){
        $(dateOfBirthSelector).parent().click();
        $(dateOfBirthMonthSelector).selectOption("February");
        $(dateOfBirthYearSelector).selectOption("1985");
        $x(dateOfBirthDate).click();
        return this;

    }
    public DemoQaPage fillSubject(){
        $(subjectSelector).setValue(ValidData.subject).pressEnter();
        return this;
    }
    public DemoQaPage fillHobbies(){
        $(hobbiesSelector).$(byText(ValidData.hobby)).click();
        return this;

    }
    public DemoQaPage loadFile(){
        $(fileSelector).uploadFile(new File(ValidData.filePath));
        return this;
    }
    public DemoQaPage fillStateAndCity(){
        $(currentAddressSelector).setValue(ValidData.currentAddress);
        $x(stateSelector).click();
        $(stateNameSelector).click();
        $x(citySelector).click();
        $(cityNameSelector).click();
        return this;
    }



    public DemoQaPage titleTextCheck(String textValue){
        assertEquals(textField.getText(), textValue, "заголовок не совпадает");
        return this;
    }
    public DemoQaPage openPage(String Url){
        open(Url);
        return this;
    }
    public DemoQaPage submitButtonClick(){
        $(submitButtonSelector).scrollIntoView(true);
        $(submitButtonSelector).shouldBe(Condition.visible, Duration.ofSeconds(30));
        $(submitButtonSelector).click();
        return this;

    }
    public DemoQaPage checkColorName(){
        $(nameSelector).shouldHave(Condition.cssValue("border-color", ValidData.color));
        return this;

    };
    public DemoQaPage checkColorLastName(){
        $(lastNameSelector).shouldHave(Condition.cssValue("border-color", ValidData.color));
        return this;
    };
    public DemoQaPage checkColorGender(){
        $x("//*[@id=\"genterWrapper\"]/div[2]/div[1]/label").shouldHave(Condition.cssValue("color", ValidData.colorGender));
        return this;
    }
    public DemoQaPage checkColorPhone(){
        $(phoneNumberSelector).shouldHave(Condition.cssValue("border-color", ValidData.color));
        return this;
    }

};
