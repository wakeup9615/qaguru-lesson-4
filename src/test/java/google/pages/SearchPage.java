package google.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class SearchPage {
    SelenideElement searchResult =   $("#search");

    public SearchPage checkSearch(String value) {
        searchResult.shouldHave(text(value));
        return this;
    }

}
