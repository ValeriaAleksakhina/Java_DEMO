package elements;

import com.codeborne.selenide.SelenideElement;
import data.ValidData;

import static com.codeborne.selenide.Selectors.byText;

public class Checkbox {
    private SelenideElement selector;
    private String name;
    public Checkbox(SelenideElement selector, String name){
        this.selector = selector;
        this.name = name;
    }



    }

