package elements;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import java.time.Duration;

public class RadioButtons {
    private String name;
    private SelenideElement selector;

    public RadioButtons(String name, SelenideElement selector) {
        this.name = name;
        this.selector = selector;
    }

    public RadioButtons radioSetValue(){
        selector.shouldBe(Condition.visible, Duration.ofSeconds(10))
                .parent().click();
        return this;
    }
}
