package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class CatalogPage {
    private final ElementsCollection products = $$(".b-card");
    private final SelenideElement heading = $("h1");

    @Step("Открыть страницу каталога {path}")
    public CatalogPage openPage(String path) {
        open(path);
        return this;
    }

    @Step("Проверить, что товары отображаются")
    public CatalogPage checkProductsAreDisplayed() {
        products.shouldHave(sizeGreaterThan(0));
        return this;
    }

    @Step("Проверить заголовок раздела: {expectedHeading}")
    public CatalogPage checkHeading(String expectedHeading) {
        heading.shouldBe(visible).shouldHave(text(expectedHeading));
        return this;
    }

    @Step("Проверить, что в выдаче есть результаты по запросу «{query}»")
    public CatalogPage checkSearchResult(String query) {
        heading.shouldBe(visible).shouldHave(text(query));
        products.shouldHave(sizeGreaterThan(0));
        return this;
    }
}
