package elements;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import java.time.Duration;

public class TextField {
    public TextField(String name, SelenideElement selenideElement) {

        this.name = name;
        this.selenideElement = selenideElement;
    }

    String name;
    SelenideElement selenideElement;

    public String getText(){
        selenideElement.scrollIntoView(true);
        selenideElement.shouldBe(Condition.visible, Duration.ofSeconds(30));
        return selenideElement.getText();
    }


}
