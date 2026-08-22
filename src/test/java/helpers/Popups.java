package helpers;

import static com.codeborne.selenide.Selenide.executeJavaScript;

public class Popups {

    public static void closeBrowserWarning() {
        executeJavaScript("document.querySelectorAll('.js-popup-warning').forEach(function(e){e.remove();});");
    }
}
