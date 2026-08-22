package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class CartPage {
    private final SelenideElement heading = $("h1");

    @Step("Проверить текст пустой корзины: {expectedText}")
    public CartPage checkEmptyCart(String expectedText) {
        $(byText(expectedText)).shouldBe(visible);
        heading.shouldHave(text(expectedText));
        return this;
    }
}
