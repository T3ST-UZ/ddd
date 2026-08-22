package tests;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import pages.CatalogPage;
import testdata.TestData;

@Epic("Sudar UI")
@Feature("Поиск")
@Story("Поиск товаров по каталогу")
@Owner("Diplom")
public class SearchTests extends BaseTest {

    CatalogPage catalogPage = new CatalogPage();

    @ParameterizedTest(name = "Поиск по запросу «{0}»")
    @ValueSource(strings = {TestData.SEARCH_KOSTYUM, TestData.SEARCH_PIDZHAK})
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Поиск товара по запросу из шапки")
    void shouldFindProductsBySearchQueryTest(String query) {
        mainPage.openPage()
                .search(query);
        catalogPage.checkSearchResult(query);
    }
}
