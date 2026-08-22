package tests;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.LoginPage;
import testdata.TestData;

@Epic("Sudar UI")
@Feature("Авторизация")
@Story("Форма входа")
@Owner("Diplom")
public class LoginTests extends BaseTest {

    LoginPage loginPage = new LoginPage();

    @Test
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Открытие формы авторизации")
    void shouldOpenLoginFormTest() {
        mainPage.openPage()
                .openLoginPopup();
        loginPage.checkFormIsVisible();
    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("Валидация невалидного email в форме входа")
    void shouldShowErrorOnInvalidLoginTest() {
        mainPage.openPage()
                .openLoginPopup();
        loginPage.checkFormIsVisible()
                .setLogin(TestData.INVALID_EMAIL)
                .setPassword(TestData.INVALID_PASSWORD)
                .clickSubmit()
                .checkError(TestData.LOGIN_ERROR_EMAIL);
    }
}
