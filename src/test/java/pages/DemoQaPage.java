package pages;

import com.codeborne.selenide.Condition;
import data.ValidData;
import elements.*;
import org.junit.jupiter.api.Assertions;


import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$x;
import static org.junit.jupiter.api.Assertions.assertEquals;

// объявление селекторов
public class DemoQaPage {
    private final TextField textField = new TextField("Название формы", $(".text-center"));
    private final TextField nameSelector = new TextField("Имя", $("#firstName"));
    private final TextField lastNameSelector = new TextField("Фамилия", $("#lastName"));
    private final TextField userEmailSelector = new TextField("Электронная почта", $("#userEmail"));
    private final RadioButton genderSelector = new RadioButton("Пол", $x("//label[@for = \"gender-radio-2\"]"));
    private final TextField phoneNumberSelector = new TextField("Телефон", $("#userNumber"));
    private final DateFields dateOfBirthSelector = new DateFields($("#dateOfBirthInput"), $(".react-datepicker__month-select"), $(".react-datepicker__year-select"), $x("//DIV[@class='react-datepicker__day react-datepicker__day--003 react-datepicker__day--weekend'][text()='3']"));
    private final AutoComplete subjectSelector = new AutoComplete("Subject", $x("//input[@id=\"subjectsInput\"]"));
    private final Checkbox hobbiesSelector = new Checkbox("Хобби", $x("//label[@for = \"hobbies-checkbox-3\"]"));
    private final Image fileSelector = new Image("Изображение", $x("//input[@type=\"file\"]"));
    private final TextField currentAddressSelector = new TextField("Текущий адрес", $x("//textarea[@id=\"currentAddress\"]"));
    private final AutoComplete stateSelector = new AutoComplete("Штат", $x("//input[@id=\"react-select-3-input\"]"));
    private final AutoComplete citySelector = new AutoComplete("Город", $x("//input[@id=\"react-select-4-input\"]"));
    private final Buttons submitButtonSelector = new Buttons("Кнопка Submit", $("#submit"));
    private final TextField colorGenderSelector = new TextField("Цвет", $x("//*[@id=\"genterWrapper\"]/div[2]/div[1]/label\""));




    public DemoQaPage titleTextCheck(String textValue){
        assertEquals(textField.getText(), textValue, "заголовок не совпадает");
        return this;
    }
    public DemoQaPage openPage(String Url){
        open(Url);
        return this;
    }
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
        subjectSelector.fillAutoCompleteField(ValidData.subject);
        return this;
    }
    public DemoQaPage fillHobbies(){
        hobbiesSelector.setCheked(ValidData.hobby, true);
        return this;

    }
    public DemoQaPage fillImageField(){
        fileSelector.addImage(ValidData.filePath);
        return this;
    }
    public DemoQaPage fillCurrentAddress(){
        currentAddressSelector.fillFieldValue(ValidData.currentAddress);
        return this;
    }
    public DemoQaPage fillStateField(){
        stateSelector.fillAutoCompleteField(ValidData.state);
        return this;
    }
    public DemoQaPage fillCityField(){
        citySelector.fillAutoCompleteField(ValidData.city);
        return this;
    }


    public DemoQaPage submitButtonClick(){
        submitButtonSelector.buttonClick();
        return this;

    }

    public DemoQaPage checkColorName(String expectedColor){
        String actualColor = nameSelector.getCssValue("border-color");
        Assertions.assertEquals(expectedColor, actualColor);
        return this;
    }

    public DemoQaPage checkColorLastName(String expectedColor){
        String actualColor = lastNameSelector.getCssValue("border-color");
        Assertions.assertEquals(expectedColor, actualColor);
        return this;
    }

    public DemoQaPage checkColorGender(String expectedColor){
        String actualColor = genderSelector.getCssValue("border-color");
        Assertions.assertEquals(expectedColor, actualColor);
        return this;
    }

    public DemoQaPage checkColorPhone(String expectedColor){
        String actualColor = phoneNumberSelector.getCssValue("border-color");
        Assertions.assertEquals(expectedColor, actualColor);
        return this;
    }



}
