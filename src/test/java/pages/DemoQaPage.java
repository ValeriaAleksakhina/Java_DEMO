package pages;

import com.codeborne.selenide.Condition;
import data.ValidData;
import elements.Checkbox;
import elements.DateFields;
import elements.RadioButtons;
import elements.TextField;


import java.io.File;
import java.time.Duration;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$x;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class DemoQaPage {
    private final TextField textField = new TextField("Название формы", $(".text-center"));
    private final TextField nameSelector = new TextField("Имя", $("#firstName"));
    private final TextField lastNameSelector = new TextField("Фамилия", $("#lastName"));
    private final TextField userEmailSelector = new TextField("Электронная почта", $("#userEmail"));
    private final RadioButtons genderSelector = new RadioButtons("Пол", $("#gender-radio-2"));
    private final TextField phoneNumberSelector = new TextField("Телефон", $("#userNumber"));
    private final DateFields dateOfBirthSelector = new DateFields($("#dateOfBirthInput"), $(".react-datepicker__month-select"), $(".react-datepicker__year-select"), $x("//DIV[@class='react-datepicker__day react-datepicker__day--003 react-datepicker__day--weekend'][text()='3']"));
    private final TextField subjectSelector = new TextField("Subject", $("subjectsInput"));
    private final Checkbox hobbiesSelector = new Checkbox("Хобби", $("hobbiesWrapper"));
    private final TextField fileSelector = new TextField("Изображение", $("uploadPicture"));
    private final TextField currentAddressSelector = new TextField("Текущий адрес", $("currentAddress"));
    private final TextField stateSelector = new TextField("Штат", $x("//div[@id=\"stateCity-wrapper\"]//div[@id=\"state\"]"));
    private final TextField stateNameSelector = new TextField("Название штата", $("#react-select-3-option-3"));
    private final TextField citySelector = new TextField("Город", $x("//div[@id=\"stateCity-wrapper\"]//div[@id=\"city\"]"));
    private final TextField cityNameSelector = new TextField("Название города", $("#react-select-4-option-0"));
    private final TextField submitButtonSelector = new TextField("Кнопка Submit", $("#submit"));

    // объявление селекторов


    // методы заполнения полей
    public DemoQaPage fillName(){
        nameSelector.fillFieldValue(ValidData.name);
        return this;
    }
    public DemoQaPage fillLastName(){
        lastNameSelector.fillFieldValue(ValidData.lastName);
        return this;
    }
    public DemoQaPage fillEmail(){
        userEmailSelector.fillFieldValue(ValidData.userEmail);
        return this;
    }
    public DemoQaPage fillUserNumber(){
        phoneNumberSelector.fillFieldValue(ValidData.userNumber);
        return this;
    }
    public DemoQaPage fillGender(){
        genderSelector.radioSetValue();
        return this;
    }
    public DemoQaPage fillDate(){
        dateOfBirthSelector.DateSetValue("February", "1985");
        return this;
    }

    public DemoQaPage fillSubject(){
        subjectSelector.fillSubjectValue(ValidData.subject);
        return this;
    }
    public DemoQaPage fillHobbies(){
        hobbiesSelector.fillHobby(ValidData.hobby);
        return this;

    }
//    public DemoQaPage loadFile(){
//        $(fileSelector).uploadFile(new File(ValidData.filePath));
//        return this;
//    }
//    public DemoQaPage fillStateAndCity(){
//        $(currentAddressSelector).setValue(ValidData.currentAddress);
//        $x(stateSelector).click();
//        $(stateNameSelector).click();
//        $x(citySelector).click();
//        $(cityNameSelector).click();
//        return this;
//    }



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
