package tests;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import testdata.TestData;

@Epic("Sudar UI")
@Feature("Навигация по сайту")
@Story("Переходы по меню и главная страница")
@Owner("Diplom")
public class NavigationTests extends BaseTest {

    @Test
    @Severity(SeverityLevel.BLOCKER)
    @DisplayName("Открытие главной страницы с корректным title")
    void shouldOpenMainPageWithCorrectTitleTest() {
        mainPage.openPage()
                .checkTitle(TestData.PAGE_TITLE);
    }

    @Test
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Переход в раздел Костюмы из каталожного меню")
    void shouldNavigateToKostyumyFromMenuTest() {
        mainPage.openPage()
                .clickMenuCategory(TestData.MENU_KOSTYUMY)
                .checkUrlContains(TestData.URL_PART_KOSTYUMY)
                .checkHeading(TestData.HEADING_KOSTYUMY);
    }

    @Test
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Переход на страницу адресов магазинов из шапки")
    void shouldNavigateToStoresFromHeaderTest() {
        mainPage.openPage()
                .clickShops()
                .checkUrlContains(TestData.URL_PART_STORES)
                .checkHeading(TestData.HEADING_STORES);
    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("Переход в раздел Жилеты костюмные из выпадающего меню Костюмы")
    void shouldNavigateToZhiletyFromKostyumyDropdownTest() {
        mainPage.openPage()
                .hoverMenu(TestData.MENU_KOSTYUMY)
                .clickDropdownItem(TestData.MENU_KOSTYUMY, TestData.MENU_ITEM_ZHILETY)
                .checkUrlContains(TestData.URL_PART_ZHILETY);
    }
}
