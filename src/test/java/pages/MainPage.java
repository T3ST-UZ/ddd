package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverConditions.title;
import static com.codeborne.selenide.WebDriverConditions.urlContaining;

public class MainPage {
    private final SelenideElement searchInput = $("#smart-title-search-input");
    private final SelenideElement searchIcon = $(".b-header-middle__search-ico");
    private final SelenideElement loginLink = $$("a.b-header-top__entry").findBy(visible);
    private final SelenideElement shopsLink = $$("a[title='Магазины СУДАРЬ']").findBy(visible);
    private final SelenideElement cartBox = $(".b-header-middle__cart-box");
    private final SelenideElement pageHeading = $("h1");

    @Step("Открыть главную страницу")
    public MainPage openPage() {
        open("");
        return this;
    }

    @Step("Навести на меню {menuName}")
    public MainPage hoverMenu(String menuName) {
        menuItem(menuName).shouldBe(visible).hover();
        return this;
    }

    @Step("Кликнуть пункт {itemName} в меню {menuName}")
    public MainPage clickDropdownItem(String menuName, String itemName) {
        dropdownLinks(menuName).findBy(text(itemName)).shouldBe(visible).click();
        return this;
    }

    @Step("Кликнуть пункт меню {menuName}")
    public MainPage clickMenuCategory(String menuName) {
        menuItem(menuName).$("a.theme-dblue").shouldBe(visible).click();
        return this;
    }

    @Step("Проверить количество пунктов меню {menuName}")
    public MainPage checkDropdownSize(String menuName, int expectedSize) {
        dropdownLinks(menuName).filter(visible).shouldHave(size(expectedSize));
        return this;
    }

    @Step("Проверить названия пунктов меню {menuName}")
    public MainPage checkDropdownTexts(String menuName, String... expectedTexts) {
        dropdownLinks(menuName).filter(visible).shouldHave(texts(expectedTexts));
        return this;
    }

    @Step("Ввести запрос «{query}» и выполнить поиск")
    public MainPage search(String query) {
        if (!searchInput.is(visible)) {
            searchIcon.shouldBe(visible).click();
        }
        searchInput.shouldBe(visible).setValue(query).pressEnter();
        return this;
    }

    @Step("Нажать Вход в шапке")
    public MainPage openLoginPopup() {
        loginLink.shouldBe(visible).click();
        return this;
    }

    @Step("Кликнуть Магазины в шапке")
    public MainPage clickShops() {
        shopsLink.shouldBe(visible).click();
        return this;
    }

    @Step("Перейти в корзину из шапки")
    public MainPage clickCart() {
        cartBox.shouldBe(visible).$("button").click();
        return this;
    }

    @Step("Проверить title страницы")
    public MainPage checkTitle(String expectedTitle) {
        webdriver().shouldHave(title(expectedTitle));
        return this;
    }

    @Step("Проверить, что URL содержит {urlPart}")
    public MainPage checkUrlContains(String urlPart) {
        webdriver().shouldHave(urlContaining(urlPart));
        return this;
    }

    @Step("Проверить заголовок: {expectedHeading}")
    public MainPage checkHeading(String expectedHeading) {
        pageHeading.shouldBe(visible).shouldHave(text(expectedHeading));
        return this;
    }

    private SelenideElement menuItem(String menuName) {
        return $$("div.b-nav-item").findBy(text(menuName));
    }

    private ElementsCollection dropdownLinks(String menuName) {
        return menuItem(menuName).$$(".b-nav-item__content a");
    }
}
