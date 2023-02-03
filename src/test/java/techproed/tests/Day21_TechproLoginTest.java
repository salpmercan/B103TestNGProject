package techproed.tests;
import org.testng.Assert;
import org.testng.annotations.Test;
import techproed.pages.TechproHomePage;
import techproed.pages.TechproLoginPage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;
public class Day21_TechproLoginTest {
    @Test(groups = "regression-tests")
    public void loginTest(){
        //objeleri genellikle bas tarafta yer veriyoruz
        TechproLoginPage techproLoginPage = new TechproLoginPage();
        TechproHomePage techproHomePage=new TechproHomePage();

        Driver.getDriver().get(ConfigReader.getProperty("techpro_test_url"));
        techproLoginPage.username.sendKeys(ConfigReader.getProperty("techpro_test_username"));
        techproLoginPage.password.sendKeys(ConfigReader.getProperty("techpro_test_password"));
        techproLoginPage.submitButton.click();

        //assertion
        //login yapildi driver su an homepage de
        Assert.assertTrue(techproHomePage.homeHeader.isDisplayed());

        //sayfadan cikis yap ve cikis yaptigini dogrula
        techproHomePage.homeLogoutButton.click();

        //cikis oldugununa dair assert yap
        Assert.assertTrue(techproLoginPage.submitButton.isDisplayed());

        //Driveri kapat
        Driver.closeDriver();
    }
}
