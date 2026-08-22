package tests;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import model.ProductData;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import pages.CatalogPage;
import pages.ProductPage;
import testdata.TestData;

import java.util.stream.Stream;

@Epic("Sudar UI")
@Feature("Каталог товаров")
@Story("Страница Костюмы и карточки товаров")
@Owner("Diplom")
public class CatalogTests extends BaseTest {

    CatalogPage catalogPage = new CatalogPage();
    ProductPage productPage = new ProductPage();

    static Stream<ProductData> productProvider() {
        return Stream.of(
                new ProductData(TestData.PRODUCT_UINDELL, TestData.PRODUCT_UINDELL_URL, TestData.PRODUCT_UINDELL_PRICE),
                new ProductData(TestData.PRODUCT_PRINSLI, TestData.PRODUCT_PRINSLI_URL, TestData.PRODUCT_PRINSLI_PRICE)
        );
    }

    @Test
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Отображение списка товаров на странице Костюмы")
    void shouldDisplayProductsOnKostyumyPageTest() {
        catalogPage.openPage(TestData.KOSTYUMY_URL)
                .checkHeading(TestData.HEADING_KOSTYUMY)
                .checkProductsAreDisplayed();
    }

    @ParameterizedTest(name = "Карточка товара: {0}")
    @MethodSource("productProvider")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Открытие карточки товара и проверка названия/цены")
    void shouldOpenProductPageAndCheckNameAndPriceTest(ProductData product) {
        productPage.openPage(product.getUrl(), product.getName())
                .checkProductName(product.getName())
                .checkProductPrice(product.getPrice());
    }
}
