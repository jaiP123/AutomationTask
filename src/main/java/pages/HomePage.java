    package pages;

    import org.openqa.selenium.JavascriptExecutor;
    import org.openqa.selenium.WebElement;
    import org.openqa.selenium.support.FindBy;
    import org.openqa.selenium.support.PageFactory;
    import org.openqa.selenium.support.ui.ExpectedConditions;
    import org.openqa.selenium.support.ui.WebDriverWait;
    import java.time.Duration;
    import static base.TestBase.driver;

    public class HomePage {
       @FindBy(xpath = "//li[@role=\"menuitem\"]//a[contains(text(),'Brands')]")
        WebElement BrandsDropdown;
        @FindBy(xpath = "//button[@type=\"button\"]//span[contains(text(),'Inspiration')]")
        WebElement inspirationsBtn;
        @FindBy(xpath = "//span[text()='Børn & Baby']")
        WebElement selectchildBaby;
        @FindBy(xpath = "//h2[contains(text(),'Plysdyr')]//parent::div")
        WebElement PlysdyrLink;
        @FindBy(xpath = "//button[@type=\"button\"]//div[contains(text(),'Indlæs flere')]")
        WebElement loadMore;
        @FindBy(xpath = "//div[contains(text(),'De største bamser')]")
        WebElement bamserLink;
        @FindBy(xpath = "//button[@id='follow-trending-list']/following-sibling::p")
        WebElement followersCount;
        @FindBy(className = "coi-banner__summary")
        WebElement bannerPage;
        @FindBy(xpath = " //button[@class=\"coi-banner__accept\"]")
        WebElement acceptBtn;


        public HomePage() {
            PageFactory.initElements(driver, this);
        }
        public void acceptCookies(){
            if(bannerPage.isDisplayed()){
                acceptBtn.click();
            }
        }
        public String verifyHomePageTitle(){
            return driver.getTitle();
        }
        public void clickOnBrands(){
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            wait.until(ExpectedConditions.elementToBeClickable(inspirationsBtn)).click();
            wait.until(ExpectedConditions.elementToBeClickable(BrandsDropdown)).click();
        }
        public void clickOnChild(){
            selectchildBaby.click();
        }
        public void clickPlysdyr() {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].scrollIntoView();", loadMore);
            js.executeScript("arguments[0].click();", loadMore);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            js.executeScript("arguments[0].scrollIntoView();", loadMore);
            js.executeScript("arguments[0].click();", loadMore);
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            js.executeScript("arguments[0].scrollIntoView();", PlysdyrLink);
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            //Element is hidden so scroll up to click element
            js.executeScript("scroll(0, -250);");
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            wait.until(ExpectedConditions.elementToBeClickable(PlysdyrLink)).click();
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            js.executeScript("arguments[0].scrollIntoView();", bamserLink);
            js.executeScript("arguments[0].click();", bamserLink);

        }
        public String followersCount(){
            return followersCount.getText();
        }

    }
