package google.tests;

import org.junit.jupiter.api.Test;
import google.pages.MainPage;
import google.pages.SearchPage;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class SearchTests {
    @Test
    void successfulSearchTest() {
        open("https://google.com");
        $("[name=q]").setValue("Selenide").pressEnter();
        $("[id=search]").shouldHave(text("selenide.org"));
    }

    @Test
    void successfulSearchWithPageObjectsTest1() {
       new MainPage().openPage();
       new MainPage().typeSearch("Selenide");
       new SearchPage().checkSearch("selenide.org");
    }

    @Test
    void successfulSearchWithPageObjectsTest2() {
        MainPage mainPage = new MainPage();
        SearchPage searchPage = new SearchPage();
        mainPage.openPage();
        mainPage.typeSearch("Selenide");
        searchPage.checkSearch("selenide.org");
    }

    //Fluent подход
    @Test
    void successfulSearchWithPageObjectsTest3() {
        MainPage mainPage = new MainPage();
        mainPage.openPage()
                .typeSearch("Selenide")
                .checkSearch("selenide.org");
    }
}