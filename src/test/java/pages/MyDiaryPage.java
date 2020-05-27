package pages;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.testng.Assert;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class MyDiaryPage extends BasePage {
    By MOOD_IN_DIARY = By.xpath("//div[@class='p7662726 media m1 rounded-top-corner']//span");
    By COMMENTS = By.id("mcw1");
    By COMMENTS_TEXT_AREA = By.id("mcr1");
    By REPLY_BUTTON = By.cssSelector(".ButtonReply ");
    By COMMENT = By.xpath("//div[@class='media-body media-body-comment']//p");
    By HUG_BUTTON = By.cssSelector("div.p7662726 media m1 rounded-top-corner>span.ButtonHug");

    public MyDiaryPage openPage() {
        open("https://moodpanda.com/Feed/?Me=1");
        return this;
    }

    public MyDiaryPage isPageOpened() {
        return this;
    }

    @Step("Верификация рейтинга настроения")
    public MyDiaryPage verificationLastMoodUpdate(String moodRating) {
        Assert.assertEquals($(MOOD_IN_DIARY).getText(), moodRating, "Mood rating is not matching or not displayed");
        return this;
    }

    @Step("Добавление коммента")
    public MyDiaryPage addCommentToMoodRecord(String commentText) {
        $(COMMENTS).click();
        $(COMMENTS_TEXT_AREA).sendKeys(commentText);
        $(REPLY_BUTTON).click();
        return this;
    }

    @Step("Верификация отображения комента")
    public MyDiaryPage verificationNewMessage(String commentText) {
        Assert.assertEquals($(COMMENT).getText(), commentText, "Comment text is not valid or not displayed");
        return this;
    }

    @Step("Hug сообщения")
    public MyDiaryPage hugClick() {
        $(HUG_BUTTON).click();
        return this;
    }
    @Step("Верификация отображения Hug клика")
    public MyDiaryPage verificationHug(){
        return this;
    }
}
