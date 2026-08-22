package tests;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Epic("Sudar UI")
@Feature("Ручное тестирование")
@Story("Проверки, выполняемые вручную")
@Owner("Diplom")
@Tag("manual")
public class ManualUiTest {

    @Test
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Оформление заказа с выбором размера и магазина")
    @Description("""
            Предусловия: открыт сайт https://sudar.su, корзина пуста.
            Шаги:
            1. Открыть каталог, выбрать товар
            2. Выбрать размер, ростовку и силуэт
            3. Добавить товар в корзину
            4. Перейти в корзину и оформить самовывоз
            Ожидаемый результат: заказ оформлен, отображается подтверждение.
            """)
    void checkoutOrderManuallyTest() {
    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("Адаптивная вёрстка меню на мобильном разрешении")
    @Description("""
            Предусловия: DevTools, ширина viewport 375px.
            Шаги:
            1. Открыть главную страницу
            2. Проверить отображение бургер-меню / нижней панели
            3. Открыть разделы каталога
            Ожидаемый результат: меню удобно использовать, элементы не перекрываются.
            """)
    void checkMobileMenuManuallyTest() {
    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("Проверка страницы условий возврата")
    @Description("""
            Шаги:
            1. Открыть меню Информация → Условия возврата
            2. Прочитать условия обмена и возврата
            Ожидаемый результат: информация актуальна и читаема, ссылки работают.
            """)
    void checkReturnInfoManuallyTest() {
    }
}
