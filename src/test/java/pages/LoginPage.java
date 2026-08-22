package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class LoginPage {
    private final SelenideElement authPopup = $("#authorization");
    private final SelenideElement loginInput = $("#authorization input[name='EMAIL']");
    private final SelenideElement passwordInput = $("#authorization input[name='PASSWORD']");
    private final SelenideElement submitButton = $("#authorization button.entry");
    private final SelenideElement emailError = $$("#authorization .b-form-row__error").findBy(visible);

    @Step("Проверить, что форма входа отображается")
    public LoginPage checkFormIsVisible() {
        authPopup.shouldBe(visible);
        loginInput.shouldBe(visible);
        passwordInput.shouldBe(visible);
        return this;
    }

    @Step("Ввести логин {login}")
    public LoginPage setLogin(String login) {
        loginInput.shouldBe(visible).setValue(login);
        return this;
    }

    @Step("Ввести пароль")
    public LoginPage setPassword(String password) {
        passwordInput.shouldBe(visible).setValue(password);
        return this;
    }

    @Step("Нажать Войти")
    public LoginPage clickSubmit() {
        submitButton.shouldBe(visible).click();
        return this;
    }

    @Step("Проверить сообщение об ошибке: {expectedError}")
    public LoginPage checkError(String expectedError) {
        emailError.shouldBe(visible).shouldHave(text(expectedError));
        return this;
    }
}
