package steps;



import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.File;
import java.io.IOException;
import java.util.logging.Logger;

import static steps.Initiator.chrome;

public class MyStepdefs {




        private final Logger logger = Logger.getLogger(String.valueOf(MyStepdefs.class));
        private final RemoteWebDriver driver = chrome.getWebDriver();


        @Given("Je suis sur la page {string}")
        public void jeSuisSurLaPage(String arg1) throws InterruptedException {

                        logger.info("Ouverture navigateur sur la page google");
                        driver.manage().window().maximize();
                        driver.get(arg1);
                        Thread.sleep(3000);
                        String actualTitle1 = driver.getTitle();
                        String expectedTitle1 = "Google";
                        Assert.assertEquals("Condition true", actualTitle1, expectedTitle1);
                }


        @And("Naviguer a la page {string}")
        public void naviguerALaPage(String arg0) {
                logger.info("Ouverture de la page LDLC");
                driver.get(arg0);

        }

        @Then("Valider l affichage de la page d acceuil LDLC")
        public void validerLAffichageDeLaPageDAcceuilLDLC() {
                logger.info("Validation de l'affichage de la page LDLC");
                String actualTitle2 = driver.getTitle();
                String expectedTitle2 = "LDLC.com - High-Tech Expérience";
                Assert.assertEquals("Condition true", expectedTitle2, actualTitle2);

        }


        @And("Effectuer une recherche de {string}")
        public void effectuerUneRechercheDe(String arg0) {
                logger.info("Recherche de TV");
                driver.findElement(By.xpath("//*[@id=\"search_search_text\"]")).sendKeys(arg0);
                driver.findElement(By.className("submit")).click();


        }

        @Then("Valider la recherche")
        public void validerLaRecherche() {
                logger.info("Validation de l'affichage du resultat de la recherche");
                Assert.assertTrue(driver.getPageSource().contains("Les résultats pour tv"));

                File localScreenshots = new File(new File("target"), "screenshots");
                if (!localScreenshots.exists() || !localScreenshots.isDirectory()) {
                        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
                        try {
                                FileUtils.copyFile(src, new File(localScreenshots.getPath().concat("/test1.png")));
                        } catch (IOException e) {
                                e.printStackTrace();
                        }


                }

        }


}

