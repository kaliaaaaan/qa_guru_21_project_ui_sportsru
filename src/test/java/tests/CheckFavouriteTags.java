package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import page.MainPage;

public class CheckFavouriteTags extends TestBase{

    MainPage mainPage = new MainPage();

    @Test
    @DisplayName("Тест отображения избранных тегов")
    void positiveTest() {
        mainPage.openSportsRu()
                .clickLoginButton()
                .setLoginPassword("Qaguru21autotest@gmail.com", "13371337")
                .personalMenuOpen()
                .personalMenuCheckFavouriteTags("cska");
    }
}
