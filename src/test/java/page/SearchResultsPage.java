package page;

import com.codeborne.selenide.SelenideElement;
import tests.TestBase;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static java.time.Duration.ofSeconds;


public class SearchResultsPage extends TestBase {

    private SelenideElement

            searchResults = $(".search-result");


    public SearchResultsPage searchResults(String value) {
        searchResults.shouldHave(visible, ofSeconds(25));
        searchResults.shouldHave(text(value));
        return this;
    }

}
