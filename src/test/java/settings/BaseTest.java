package settings;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BaseTest {
    private static void selLocalDriver(){
    Configuration.browser = "chrome";
    Configuration.browserSize = "1920x1080";
    Configuration.pageLoadTimeout = 100000;

    }

@BeforeEach
    public void setDriver(){
        selLocalDriver();
}

@AfterEach
    public void closeDriver(){
    Selenide.closeWebDriver();
}

}
