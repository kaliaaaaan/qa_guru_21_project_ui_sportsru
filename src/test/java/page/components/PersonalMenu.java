package page.components;

import com.codeborne.selenide.SelenideElement;
import tests.TestBase;

import static com.codeborne.selenide.Condition.href;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static java.time.Duration.ofSeconds;

public class PersonalMenu extends TestBase {
    SelenideElement

                personalMenu = $(".personal-menu__toggle"),
                personalMenuTags = $(".personal-menu-tags__tag-link");

    public PersonalMenu personalMenuOpen() {
        personalMenu.click();
        return this;
    }

    public PersonalMenu personalMenuCheckFavouriteTags(String value) {
        personalMenuTags.shouldHave(visible, ofSeconds(25));
        personalMenuTags.shouldHave(href(value));
        return this;
    }
}
