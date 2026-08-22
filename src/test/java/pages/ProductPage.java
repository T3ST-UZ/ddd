package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class ProductPage {
    private final SelenideElement productName = $("h1");
    private final SelenideElement productPrice = $(".b-price");

    @Step("Открыть карточку товара {name}")
    public ProductPage openPage(String path, String name) {
        open(path);
        return this;
    }

    @Step("Проверить название товара: {expectedName}")
    public ProductPage checkProductName(String expectedName) {
        productName.shouldBe(visible).shouldHave(text(expectedName));
        return this;
    }

    @Step("Проверить цену товара: {expectedPrice}")
    public ProductPage checkProductPrice(String expectedPrice) {
        productPrice.shouldBe(visible).shouldHave(text(expectedPrice));
        return this;
    }
}
