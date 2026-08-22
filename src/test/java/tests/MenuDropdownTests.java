package tests;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import model.MenuData;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import testdata.TestData;

import java.util.stream.Stream;

@Epic("Sudar UI")
@Feature("Навигационное меню")
@Story("Выпадающие списки")
@Owner("Diplom")
public class MenuDropdownTests extends BaseTest {

    static Stream<MenuData> menuProvider() {
        return Stream.of(
                new MenuData(TestData.MENU_KOSTYUMY, TestData.KOSTYUMY_SIZE, TestData.KOSTYUMY_ITEMS),
                new MenuData(TestData.MENU_BRYUKI, TestData.BRYUKI_SIZE, TestData.BRYUKI_ITEMS),
                new MenuData(TestData.MENU_RUBASHKI, TestData.RUBASHKI_SIZE, TestData.RUBASHKI_ITEMS)
        );
    }

    @ParameterizedTest(name = "Проверка выпадающего списка {0}")
    @MethodSource("menuProvider")
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("Проверка выпадающего списка меню")
    void shouldCheckDropdownMenuTest(MenuData menuData) {
        mainPage.openPage()
                .hoverMenu(menuData.getMenuName())
                .checkDropdownSize(menuData.getMenuName(), menuData.getExpectedSize())
                .checkDropdownTexts(menuData.getMenuName(), menuData.getExpectedItems());
    }
}
