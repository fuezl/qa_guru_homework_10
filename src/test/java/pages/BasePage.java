package pages;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class BasePage {

    @Step("Открываем страницу '{url}'")
    public void openPage(String url) {
        open(url);
    }

    @Step("Нажимаем кнопку 'Submit'")
    public void clickSubmit() {
        $("#submit").click();
    }
}
