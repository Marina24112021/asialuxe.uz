package pages;

import com.codeborne.selenide.*;
import io.qameta.allure.Step;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class MainPage {
    final LocalDate currentDate = LocalDate.now();
    final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
    final SelenideElement button = $("#main_search").lastChild().lastChild();
    final SelenideElement input = $("input[placeholder='Дата вылета']");
    final SelenideElement fromInput = $("[placeholder='Откуда']");
    final SelenideElement toInput = $("[placeholder='Куда']");
    static final SelenideElement mainSearch = $("#main_search");
    static final ElementsCollection colOfTickets = mainSearch.parent().parent().sibling(0).lastChild().lastChild().lastChild().$$("div");;
    final ElementsCollection listWhereFrom = fromInput.parent().sibling(0).$$("ul li");
    final ElementsCollection listWhereTo = toInput.parent().sibling(0).$$("li");
    final ElementsCollection textsOfMenu = $$("main.container div div a div p");
    final SelenideElement sidebar = $("#sidebar");
    final SelenideElement logEmail = $("#logEmail");
    final SelenideElement logPass = $("#logPass");
    final SelenideElement logButton = $("[for='logPass']").parent().parent().lastChild().$("[type='button']");
    final SelenideElement logAlert = $("div[role='alert'] p");
    final SelenideElement buttonBook = $("button[type='primary']");
    final SelenideElement fullName = $("#fullname");
    final SelenideElement email = $("#email");
    final SelenideElement password = $("#password");
    final SelenideElement lablePhone = $("[for='phone']");
    final SelenideElement reset = $(byText("Сброс пароля"));
    final SelenideElement emailReset = $("[placeholder='Email']");
    final SelenideElement buttonRegistration = $(byText("Зарегистрироваться"));


    @Step("Открыть главную страницу")
    public MainPage openMainPage() {
        open("/ru");
        return this;
    }

    @Step("Нажать на поле Откуда")
    public MainPage clickOnFieldWhere() {
        fromInput.shouldBe(visible).click();
        return this;
    }

    @Step("Заполнить поле Откуда")
    public MainPage fillInputWhereFrom(String WhereFrom) {
        fromInput.shouldBe(editable).setValue(WhereFrom);
        return this;
    }

    @Step("Выбрать первое значение из выпадающего списка")
    public MainPage selectFirstValueWhereFrom() {
        listWhereFrom.first().click();
        return this;
    }

    @Step("Заполнить поле Куда")
    public MainPage fillInputWhereTo(String WhereTo) {
        toInput.shouldBe(visible).setValue(WhereTo);
        return this;
    }

    @Step("Выбрать первое значение из выпадающего списка")
    public MainPage selectFirstValueWhereTo() {
        listWhereTo.first().click();
        return this;
    }

    @Step("Удалить аттрибут")
    public MainPage removeAttr() {
        executeJavaScript("arguments[0].removeAttribute('readonly')", input);
        return this;
    }

    @Step("Заполнить поле Дата ")
    public MainPage fillInputDate() {
        input.setValue(currentDate.plusDays(2).format(formatter));
        return this;
    }

    @Step("Нажать на Поиск")
    public MainPage clickOnSearch() {
        button.click();
        return this;
    }

    @Step("Проверить что отображается сообщение о поиске билетов ")
    public MainPage checkMessageOfSearching() {
        mainSearch.parent().sibling(0).shouldHave(text("Пожалуйста, подождите, мы находим для вас лучшие варианты..."));
        return this;
    }

    public void checkTextInMenu(String... listMenuText) {
            textsOfMenu.shouldHave(CollectionCondition.textsInAnyOrder(listMenuText));
    }

    @Step("Нажать на Войти с главной страницы")
    public MainPage clickOnOpenLoginForm() {
        sidebar.click();
        return this;
    }

    @Step("Нажать на Сброс пароля")
    public MainPage clickOnPasswordReset() {
        reset.click();
        return this;
    }

    @Step("Заполнить email")
    public MainPage setEmailReset(String email) {
        emailReset.setValue(email);
        return this;
    }

    @Step("Нажать на Сброс пароля")
    public MainPage clickReset() {
        buttonBook.click();
        return this;
    }

    @Step("Установить некорректный логин")
    public MainPage setLogin(String lastName) {
        logEmail.setValue(lastName);
        return this;
    }

    @Step("Установить некорректный пароль")
    public MainPage setPassword(String password) {
        logPass.setValue(password);
        return this;
    }

    @Step("Нажать на кнопку Войти")
    public void clickOnLogin() {
        logButton.click();
    }

    @Step("Нажать на кнопку Зарегистрироваться")
    public void clickOnRegistration() {
        buttonBook.click();
    }

    @Step("Нажать на кнопку Зарегистрироваться")
    public void clickOnRegistrationFromForm() {
        buttonRegistration.click();
    }

    @Step("Заполнить ФИО")
    public MainPage setFullName(String fullFakeName) {
        fullName.setValue(fullFakeName);
        return this;
    }

    @Step("Заполнить email")
    public MainPage setEmail(String emailFaker) {
        email.setValue(emailFaker);
        return this;
    }

    @Step("Заполнить password")
    public void setPasswordRegistration(String passwordFake) {
        password.setValue(passwordFake);
    }

    @Step("Запустить скрипт по заморозке сообщения об ошибке")
    public void runScriptToFrozenAlertMessage() {
        Selenide.executeJavaScript(
                "var toastProgressBar = document.querySelector('.Vue-Toastification__progress-bar');" +
                        "if (toastProgressBar) { toastProgressBar.remove(); }");
    }

    @Step("Получить сообщение об ошибке не корректного ввода логина или пароля ")
    public void checkAlertMessageIsAppeared() {
        logAlert.shouldHave(Condition.text("Логин или пароль не верный"));
    }

    @Step("Цвет текста соответствует дизайну")
    public void checkStyleOfInputPassword() {
        lablePhone.shouldBe(cssValue("color", "rgba(255, 0, 0, 1)"));
    }

    @Step("Сообщение что код отправлен на почту корректно отображается ")
    public void checkMessageToResetPassword() {
        logAlert.shouldHave(Condition.text("Код подтверждения был отправлен на вашу электронную почту!"));
    }
    public MainPage blockShouldBeVisible(){
        mainSearch.parent().parent().sibling(0).shouldBe(Condition.visible);
        return this;
    }
    public static int collectionsAreNotEmpty(){
        return colOfTickets.size();
    }
}
