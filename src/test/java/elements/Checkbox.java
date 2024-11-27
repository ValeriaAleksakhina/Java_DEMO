package elements;

import com.codeborne.selenide.SelenideElement;
import data.ValidData;

import static com.codeborne.selenide.Selectors.byText;

public class Checkbox {
    String name;
    SelenideElement selector;

    public Checkbox(String name, SelenideElement selector){
        this.name = name;
        this.selector = selector;

    }
    public void fillHobby(String value){
        selector.$(byText(ValidData.hobby)).click();
    }



    }

