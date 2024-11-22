package elements;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import java.time.Duration;

    public class Buttons {

        private String name;
        private SelenideElement selector;

        public Buttons(String name, SelenideElement selector) {
            this.name = name;
            this.selector = selector;
        }

        public Buttons buttonClick(){
            selector.shouldBe(Condition.visible, Duration.ofSeconds(10))
                    .click();
            return this;
        }

}
