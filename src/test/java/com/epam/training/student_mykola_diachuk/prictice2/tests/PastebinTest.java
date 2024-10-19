package com.epam.training.student_mykola_diachuk.prictice2.tests;


import com.epam.training.student_mykola_diachuk.practice2.pages.PastebinHomePage;
import com.epam.training.student_mykola_diachuk.practice2.pages.PastebinResultPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;



import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PastebinTest {
    private WebDriver driver;
    private PastebinHomePage homePage;
    private PastebinResultPage pastebinResultPage;

    private final String code = "git config --global user.name  \"New Sheriff in Town\"\n" +
            "git reset $(git commit-tree HEAD^{tree} -m \"Legacy code\")\n" +
            "git push origin master --force";
    private final String title = "how to gain dominance among developers";

    @BeforeEach
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://pastebin.com/");
        homePage = new PastebinHomePage(driver);
    }

    @Test
    public void testCreatePaste() {

        homePage.enterCode(code);
        homePage.selectSyntaxHighlighting("Bash");
        homePage.selectPasteExpiration("10 Minutes");
        homePage.enterPasteName(title);
        homePage.clickCreatePaste();

        pastebinResultPage = new PastebinResultPage(driver);

        assertEquals(title, pastebinResultPage.getPageTitle());
        assertTrue(pastebinResultPage.getSyntaxLabel().contains("Bash"));
        assertEquals(code, pastebinResultPage.getCode().trim());
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
