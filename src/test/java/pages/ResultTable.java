package pages;

import data.ValidData;
import org.junit.jupiter.api.Assertions;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class ResultTable {

    public final static String resultNameValueSelector = "//tbody/tr[1]/td[2]";
    public final static String resultEmailValueSelector = "//tbody/tr[2]/td[2]";
    public final static String resultGenderValueSelector = "//tbody/tr[3]/td[2]";
    public final static String resultPhoneValueSelector = "//tbody/tr[4]/td[2]";
    public final static String resultDateOfBirthValueSelector = "//tbody/tr[5]/td[2]";
    public final static String resultSubjectValueSelector = "//tbody/tr[6]/td[2]";
    public final static String resultHobbyValueSelector = "//tbody/tr[7]/td[2]";
    public final static String resultImageValueSelector = "//tbody/tr[8]/td[2]";
    public final static String resultAdressValueSelector = "//tbody/tr[9]/td[2]";
    public final static String resultFullAdressValueSelector = "//tbody/tr[10]/td[2]";
    public final static String closeButtonSelector = "#closeLargeModal";

    public void checkName(){
        Assertions.assertEquals(ValidData.nameResult, $x(resultNameValueSelector).getText(), "Имя не соответствует заданному");
    }
    public void checkEmail(){
        Assertions.assertEquals(ValidData.userEmail, $x(resultEmailValueSelector).getText(), "Почта не соответствует заданной");
    }
    public void checkGender(){
        Assertions.assertEquals(ValidData.gender, $x(resultGenderValueSelector).getText(), "Пол не соответствует заданному");
    }
    public void checkPhone(){
        Assertions.assertEquals(ValidData.userNumber, $x(resultPhoneValueSelector).getText(), "Телефон не соответствует заданному");
    }
    public void checkDateOfBirth(){
        Assertions.assertEquals(ValidData.dateOfBirth, $x(resultDateOfBirthValueSelector).getText(), "Дата рождения не соответствует заданной");
    }
    public void checkSubject(){
        Assertions.assertEquals(ValidData.subject, $x(resultSubjectValueSelector).getText(), "subject не соответствует заданному");
    }
    public void checkHobby(){
        Assertions.assertEquals(ValidData.hobby, $x(resultHobbyValueSelector).getText(), "хобби не соответствует заданному");
    }
    public void checkImage(){
        Assertions.assertEquals(ValidData.fileName, $x(resultImageValueSelector).getText(), "название картинки не соответствует заданному");
    }
    public void checkAdress(){
        Assertions.assertEquals(ValidData.currentAddress, $x(resultAdressValueSelector).getText(), "адрес не соответствует заданному");
    }
    public void checkFullAdress(){
        Assertions.assertEquals(ValidData.fullAdress, $x(resultFullAdressValueSelector).getText(), "адрес не соответствует заданному");
    }
    public ResultTable closeButtonClick(){
        $(closeButtonSelector).click();
        return this;

    }
}
