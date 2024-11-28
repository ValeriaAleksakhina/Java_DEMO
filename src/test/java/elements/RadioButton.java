package elements;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import java.time.Duration;

public class RadioButton {
    private String name;
    private SelenideElement selector;

    public RadioButton(String name, SelenideElement selector) {
        this.name = name;
        this.selector = selector;
    }

    public void radioSetValue(){
        selector.click();

    }
}
