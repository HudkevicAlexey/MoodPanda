package test;

import io.qameta.allure.Description;
import org.testng.annotations.Test;

import javax.management.DescriptorKey;

import static testdata.TestData.*;

public class MoodPandaTest extends BaseTest {

    @Test(description = "Тест входа")
    @Description("Логин с валидными кредами")
    public void loginTest() {
        loginPage
                .openPage()
                .login("sdfsdffsdf@mailinator.com", "poppoppop");
    }

    @Test(description = "Туст добавление новой муд записи")
    @Description("Проверка добавления новой записи настрояния")
    public void updateMoodTest() {
        loginTest();
        feedPage
                .openRateHappinessModal()
                .updateMood(MOOD_RATE)
                .goToMyDiary()
                .verificationLastMoodUpdate(MOOD_RATE);
    }

    @Test(description = "Тест добавления коментария")
    @Description("Добавление коментария и его верификация")
    public void addCommentTest() {
        loginTest();
        myDiaryPage
                .openPage()
                .addCommentToMoodRecord(COMMENT_TEXT)
                .verificationNewMessage(COMMENT_TEXT);
    }

    @Test
    public void hugTest() {
        loginTest();
        myDiaryPage
                .hugClick()
                .verificationHug();
    }


}
