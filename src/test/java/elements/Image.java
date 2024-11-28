package elements;

import com.codeborne.selenide.SelenideElement;
import java.io.File;

public class Image {
    String name;
    SelenideElement selector;

    public Image(String name, SelenideElement selector){
        this.name = name;
        this.selector = selector;
    }
    public void addImage(String filePath){
       File loadFile  = new File(filePath);
       selector.uploadFile(loadFile);

    }
}
