package elements;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import data.ValidData;
import org.junit.jupiter.api.Assertions;

import java.time.Duration;

import static com.codeborne.selenide.Condition.cssValue;
import static com.codeborne.selenide.Condition.visible;
import static java.time.Duration.ofSeconds;

public class TextField {
    public TextField(String name, SelenideElement selector) {

        this.name = name;
        this.selector = selector;
    }

    String name;
    SelenideElement selector;

    public String getText(){
        selector.scrollIntoView(true);
        selector.shouldBe(visible, Duration.ofSeconds(30));
        return selector.getText();
    }

    public void fillFieldValue(String value){
        selector.shouldBe(visible, ofSeconds(10))
                .setValue(value);
    }

    public String getCssValue(String Css) {
        var color = selector.getCssValue(Css);
        return color;
    }


    }



