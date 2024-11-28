package elements;

import com.codeborne.selenide.SelenideElement;

public class AutoComplete {
    String name;
    SelenideElement selector;

    public AutoComplete(String name, SelenideElement selector) {
        this.name = name;
        this.selector = selector;
    }
    public void fillAutoCompleteField(String value){
        selector.setValue(value).pressEnter();
    }




}
