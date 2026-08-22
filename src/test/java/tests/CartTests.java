package tests;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.CartPage;
import testdata.TestData;

@Epic("Sudar UI")
@Feature("Корзина")
@Story("Пустая корзина")
@Owner("Diplom")
public class CartTests extends BaseTest {

    CartPage cartPage = new CartPage();

    @Test
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Отображение пустой корзины")
    void shouldShowEmptyCartTest() {
        mainPage.openPage()
                .clickCart();
        cartPage.checkEmptyCart(TestData.HEADING_EMPTY_CART);
    }
}
