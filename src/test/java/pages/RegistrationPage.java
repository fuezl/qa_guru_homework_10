package pages;

import components.Calendar;
import io.qameta.allure.Step;

import java.io.File;

import static com.codeborne.selenide.Condition.matchText;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static java.lang.String.format;

public class RegistrationPage extends BasePage {

    private Calendar calendar = new Calendar();

    @Step("Вводим First Name")
    public void inputFirstName(String firstName) {
        $("input#firstName").val(firstName);
    }

    @Step("Вводим Last Name")
    public void inputLastName(String lastName) {
        $("input#lastName").val(lastName);
    }

    @Step("Вводим Email")
    public void inputUserEmail(String email) {
        $("input#userEmail").val(email);
    }

    @Step("Выбираем Gender")
    public void selectGender(String gender) {
        $(format("[name=gender][value=%s]", gender)).parent().click();
    }

    @Step("Вводим Phone")
    public void inputPhone(String phone) {
        $("input#userNumber").val(phone);
    }

    @Step("Выбираем дату рождения")
    public void setDateOfBirth(String day, String month, String year) {
        calendar.setDate(day, month, year);
    }

    @Step("Выбираем Subjects")
    public void typeSubjects(String subjects) {
        $("#subjectsInput").setValue(subjects).pressEnter();
    }

    @Step("Выбираем Hobbies")
    public void typeHobbies(String hobbies) {
        $("#hobbiesWrapper").$(byText(hobbies)).click();
    }

    @Step("Загружаем картинку")
    public void uploadFile(String picture) {
        $("#uploadPicture").uploadFile(new File(format("src/test/resources/%s", picture)));
    }

    @Step("Вводим Address")
    public void typeAddress(String address) {
        $("#currentAddress").setValue(address);
    }

    @Step("Выбираем State")
    public void selectState(String state) {
        $("#react-select-3-input").setValue(state).pressEnter();
    }

    @Step("Выбираем City")
    public void selectCity(String city) {
        $("#react-select-4-input").setValue(city).pressEnter();
    }

    @Step("Проверяем поле '{locator}' на соответствие ожидаемому тексту")
    public void textCheck(String locator, String value) {
        $("tbody").$(byText(locator)).sibling(0).shouldHave(matchText(value));
    }
}
