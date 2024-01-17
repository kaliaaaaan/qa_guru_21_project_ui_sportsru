package page.component;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.ElementsCollection;

import java.util.List;

import static com.codeborne.selenide.Condition.href;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$$;

public class NavigationMenu {
    private ElementsCollection navigationMenuLinks = $$(".navigation-navbar__list a");

    public NavigationMenu clickOnMenuItem(String page) {
        navigationMenuLinks.find(href(page)).click();
        return this;
    }

    public NavigationMenu verifyMenuItems(List<String> expectedButtons) {
        navigationMenuLinks.filter(visible).shouldHave(CollectionCondition.texts(expectedButtons));
        return this;
    }
}