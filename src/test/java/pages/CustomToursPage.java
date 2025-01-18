package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.github.javafaker.Faker;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class CustomToursPage {
    final Faker faker = new Faker();
    final SelenideElement buttonBook = $(".grow button[type='primary']");
    final SelenideElement messageText = $$("div[data-headlessui-state='open']").last().lastChild().$("div");
    final ElementsCollection dataField = $$("input[data-test='dp-input']");
    final ElementsCollection listBox = $$(".block.truncate");
    final SelenideElement fullName = $("input[placeholder='Полное имя']");
    final SelenideElement email = $("input[placeholder='Эл. адрес']");
    final SelenideElement phoneNum = $("div[aria-label='Country Code Selector']");
    final SelenideElement lastName = $("[placeholder='Фамилия']");
    final SelenideElement name = $("[placeholder='Имя']");
    final SelenideElement passportNum = $("[placeholder='Серия и № паспорта']");
    final SelenideElement checkboxCheck = $("input[type=checkbox]");
    final SelenideElement bookTour = $(byText("Забронировать"));
    final SelenideElement successMessage = $("div.Vue-Toastification__toast-component-body");

    @Step("Открыть главную страницу")
    public CustomToursPage openTour(String path) {
        open(path);
        return this;
    }

    @Step("Нажать на кнопку Заказать тур")
    public CustomToursPage clickOnBookTour() {
        buttonBook.click();
        return this;
    }

    @Step("Текст сообщения о требовании авторизации корректный ")
    public void checkTexts(String expectedText) {
        messageText.shouldHave(Condition.exactText(expectedText));
    }

    public CustomToursPage setFullName() {
        fullName.setValue(faker.name().fullName());
        return this;
    }

    public CustomToursPage setEmail() {
        email.setValue(faker.internet().emailAddress());
        return this;
    }

    public CustomToursPage setPhoneNum() {
        phoneNum.sibling(0).setValue("");
        return this;
    }

    public CustomToursPage setLastName() {
        lastName.setValue(faker.name().lastName());
        return this;
    }

    public CustomToursPage setName() {
        name.setValue(faker.name().firstName());
        return this;
    }

    public CustomToursPage setBirthday() {
        dataField.first().setValue("11/11/1980");
        return this;
    }

    public CustomToursPage setGender() {
        listBox.first().parent().click();
        $(byText("Мужской")).click();
        return this;
    }

    public CustomToursPage setCitizenship() {
        listBox.last().parent().click();
        $(byText("UZB-Uzbekistan")).click();
        return this;
    }

    public CustomToursPage setPassportNum() {
        passportNum.setValue("AD" + faker.number().digits(7));
        return this;
    }

    public void setPassportExpiration() {
        dataField.last().setValue("11/11/2027");
    }

    public CustomToursPage closeCalender() {
        name.click();
        return this;
    }

    public CustomToursPage checkThePolicy() {
        checkboxCheck.click();
        return this;
    }

    public void runScriptToFrozenAlertMessage() {
        Selenide.executeJavaScript(
                "var toastProgressBar = document.querySelector('.Vue-Toastification__progress-bar');" +
                        "if (toastProgressBar) { toastProgressBar.remove(); }");
    }

    public CustomToursPage bookTour() {
        bookTour.click();
        return this;
    }

    public CustomToursPage getSuccessMessage() {
        successMessage.shouldHave(Condition.text("Ошибка валидации"));
        return this;
    }
}
