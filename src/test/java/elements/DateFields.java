package elements;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$x;

public class DateFields {
    private SelenideElement selector;
    private SelenideElement month;
    private SelenideElement year;
    private SelenideElement day;

    public DateFields(SelenideElement selector, SelenideElement month, SelenideElement year, SelenideElement day) {
        this.selector = selector;
        this.month = month;
        this.year = year;
        this.day = day;
    }

    public DateFields DateSetValue(String month, String year){
        this.selector.parent().click();
        this.month.selectOption(month);
        this.year.selectOption(year);
        this.day.click();
        return this;
    }
}
