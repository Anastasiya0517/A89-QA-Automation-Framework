import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework17 extends BaseTest {

    @Test
    public void  addSongToPlaylist() throws InterruptedException{
         navigateToLogInPage();

         provideEmail("anastasiya.hutsalyuk@testpro.io");
         providePassword("D5wS5XP1");
         clickLogIn();

        WebElement searchField =driver.findElement(By.cssSelector("[type='search']"));
        searchField.clear();
        searchField.sendKeys("dark");

        WebElement viewAllButton =driver.findElement(By.cssSelector("[data-test='view-all-songs-btn']"));
        viewAllButton.click();

        WebElement selectFirstSong =driver.findElement(By.cssSelector("#songResultsWrapper > div > div > div.item-container > table > tr:nth-child(1)"));
        selectFirstSong.click();

        WebElement addToButton =driver.findElement(By.cssSelector("[data-test='add-to-btn']"));
        addToButton.click();

        WebElement newPlaylistField =driver.findElement(By.cssSelector("#songResultsWrapper > header > div.song-list-controls > div > section.new-playlist > form > input[type=text]"));
        newPlaylistField.clear();
        newPlaylistField.sendKeys("Homework17");

        WebElement saveButton=driver.findElement(By.cssSelector("#songResultsWrapper > header > div.song-list-controls > div > section.new-playlist > form > button"));
        saveButton.click();


        WebElement alert=driver.findElement(By.cssSelector("[class='success show']"));
Alert alertMessage=driver.switchTo().alert();
String actualMessage= alertMessage.getText();
String expectedMessage="Created playlist 'Homework17'.";
Assert.assertEquals(actualMessage, expectedMessage);

Thread.sleep(2000);



        driver.quit();






    }
}
