package pages;

import data.ValidData;
import elements.Buttons;
import elements.TextField;
import org.junit.jupiter.api.Assertions;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class ResultTable {

    //private final TextField textField = new TextField("Название формы", $(".text-center"));
    public final TextField resultNameValueSelector = new TextField("Имя", $x("//tbody/tr[1]/td[2]"));
    public final TextField resultEmailValueSelector = new TextField ("Email", $x("//tbody/tr[2]/td[2]"));
    public final TextField resultGenderValueSelector = new TextField("Пол", $x("//tbody/tr[3]/td[2]"));
    public final TextField resultPhoneValueSelector = new TextField ("Телефон", $x("//tbody/tr[4]/td[2]"));
    public final TextField resultDateOfBirthValueSelector = new TextField("Дата рождения", $x("//tbody/tr[5]/td[2]"));
    public final TextField resultSubjectValueSelector = new TextField("Subject", $x("//tbody/tr[6]/td[2]"));
    public final TextField resultHobbyValueSelector = new TextField("Хобби", $x("//tbody/tr[7]/td[2]"));
    public final TextField resultImageValueSelector = new TextField("Изображение", $x("//tbody/tr[8]/td[2]"));
    public final TextField resultAddressValueSelector = new TextField("Адрес", $x("//tbody/tr[9]/td[2]"));
    public final TextField resultFullAddressValueSelector = new TextField("Полный адрес", $x("//tbody/tr[10]/td[2]"));
    public final Buttons closeButtonSelector = new Buttons("Закрыть", $("#closeLargeModal"));

    public void checkName(){
        Assertions.assertEquals(ValidData.nameResult, resultNameValueSelector.getText(), "Имя не соответствует заданному");
    }
    public void checkEmail(){
        Assertions.assertEquals(ValidData.userEmail, resultEmailValueSelector.getText(), "Почта не соответствует заданной");
    }
    public void checkGender(){
        Assertions.assertEquals(ValidData.gender, resultGenderValueSelector.getText(), "Пол не соответствует заданному");
    }
    public void checkPhone(){
        Assertions.assertEquals(ValidData.userNumber, resultPhoneValueSelector.getText(), "Телефон не соответствует заданному");
    }
    public void checkDateOfBirth(){
        Assertions.assertEquals(ValidData.dateOfBirth, resultDateOfBirthValueSelector.getText(), "Дата рождения не соответствует заданной");
    }
    public void checkSubject(){
        Assertions.assertEquals(ValidData.subject, resultSubjectValueSelector.getText(), "subject не соответствует заданному");
    }
    public void checkHobby(){
        Assertions.assertEquals(ValidData.hobby, resultHobbyValueSelector.getText(), "хобби не соответствует заданному");
    }
    public void checkImage(){
        Assertions.assertEquals(ValidData.fileName, resultImageValueSelector.getText(), "название картинки не соответствует заданному");
    }
    public void checkAddress(){
        Assertions.assertEquals(ValidData.currentAddress, resultAddressValueSelector.getText(), "адрес не соответствует заданному");
    }
    public void checkFullAddress(){
        Assertions.assertEquals(ValidData.fullAdress, resultFullAddressValueSelector.getText(), "адрес не соответствует заданному");
    }
    public void closeButtonClick(){
        closeButtonSelector.buttonClick();
    }
}
