package models;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import java.text.ParseException;
import java.time.format.DateTimeFormatter;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Random;

import org.junit.Assert;


public class HomeModel extends BaseModel {

    public String clkWater = "//android.support.v7.app.ActionBar.Tab[@content-desc=\"Water\"]";
    public String neredenRota = "//input[@id='OriginInput']";
    public String nereyeRota = "//input[@id='DestinationInput']";
    public String rotatikla = "//div[@id=\"react-autowhatever-1\"]//li[@data-suggestion-index=\"0\"]";
    public String checkTekYon = "//input[@id='oneWayCheckbox']";
    public String gidisTarih = "//div[@class=\"DateInput DateInput_1\"]//input[@id=\"DepartureDate\"]";
    public String donusTarih = "//div[@class=\"DateInput DateInput_1\"]//input[@id=\"ReturnDate\"]";
    public String chechAktarmasız = "//div[@class=\"D_FSF__col \"]//input[@id=\"transitFilter\"]";
    public String yolcuButton = "//button[@class=\"default-btn block passenger-select-button\"]";
    public String yetiskinYolcuArttir = "//div[@class=\"PassengerBox__type\"][.//span /text()='Yetişkin']//button[2]";
    public String yetiskinYolcuSayi = "//div[@class=\"PassengerBox__type\"][.//span /text()='Yetişkin']//span[@class=\"PassengerBox__type__count\"]";
    public String yetiskinYolcuAzalt = "//div[@class=\"PassengerBox__type\"][.//span /text()='Yetişkin']//button[1]";
    public String cocukYolcuArttir = "//div[@class=\"PassengerBox__type\"][.//span /text()='Çocuk']//button[2]";
    public String cocukYolcuSayi = "//div[@class=\"PassengerBox__type\"][.//span /text()='Çocuk']//span[@class=\"PassengerBox__type__count\"]";
    public String cocukYolcuAzalt = "//div[@class=\"PassengerBox__type\"][.//span /text()='Çocuk']//button[1]";
    public String bebekYolcuArttir = "//div[@class=\"PassengerBox__type\"][.//span /text()='Bebek']//button[2]";
    public String bebekYolcuSayi = "//div[@class=\"PassengerBox__type\"][.//span /text()='Bebek']//span[@class=\"PassengerBox__type__count\"]";
    public String bebekYolcuAzalt = "//div[@class=\"PassengerBox__type\"][.//span /text()='Bebek']//button[1]";
    public String altmisbesYolcuArttir = "//div[@class=\"PassengerBox__type\"][.//span /text()='65 yaş üstü']//button[2]";
    public String altmisbesYolcuSayi = "//div[@class=\"PassengerBox__type\"][.//span /text()='65 yaş üstü']//span[@class=\"PassengerBox__type__count\"]";
    public String altmisbesYolcuAzalt = "//div[@class=\"PassengerBox__type\"][.//span /text()='65 yaş üstü']//button[1]";
    public String ogrenciYolcuArttir = "//div[@class=\"PassengerBox__type\"][.//span /text()='Öğrenci']//button[2]";
    public String ogrenciYolcuSayi = "//div[@class=\"PassengerBox__type\"][.//span /text()='Öğrenci']//span[@class=\"PassengerBox__type__count\"]";
    public String ogrenciYolcuAzalt = "//div[@class=\"PassengerBox__type\"][.//span /text()='Öğrenci']//button[1]";
    public String buttonEkonomi = "//div[@class=\"PassengerBox__body cabinClassButtonGroup\"][1]//button[text()=\"Ekonomi\"]";
    public String buttonBusiness = "//div[@class=\"PassengerBox__body cabinClassButtonGroup\"]//button[text()=\"Business\"]";
    public String buttonPremiumEconomy = "//div[@class=\"PassengerBox__body cabinClassButtonGroup\"]//button[text()=\"Premium Economy\"]";
    public String buttonArama = "//button[@class=\"primary-btn block\"]//span[text()=\"Ucuz bilet bul\"]";
    public String buttonNextMonth = "//div[contains(@aria-label, 'next month')]";
    public String fovoriEkleText = "//button[@data-testid=\"favorite-search-add-button\"]";


    public void callHomePage() {
        if (driver.getCurrentUrl().equals("https://www.enuygun.com/")) {
            return;
        } else {
            driver.get("https://www.enuygun.com/");
        }
    }


    public void clickNereden() {
        clickByXpath(neredenRota);
    }

    public void setNereden(String rota) {
        sendByXpath(neredenRota, rota);
    }

    public void clickNereye() {
        clickByXpath(nereyeRota);
    }

    public void clickTekYon() {
        clickByXpath(checkTekYon);
    }

    public void setNereye(String rota) {
        sendByXpath(nereyeRota, rota);
    }

    public void clickRota() {
        Actions action = new Actions(driver);
        action.moveToElement(driver.findElement(By.xpath(rotatikla))).build().perform();
        //action.moveByOffset(2, 2).build().perform();
        clickByXpath(rotatikla);
    }

    public void setGidisTarihi(String tarih) {
        clickByXpath(gidisTarih);
        String path="(//div[@class='CalendarMonth CalendarMonth_1']//td[contains(@aria-label,'" + tarih + "')])[1]";

        while (!findElementByXpath(path)){
            // daha ileri tarihlerin görünmesi için next month butonuna tıklanır
            clickByXpath(buttonNextMonth);
        }
         clickByXpath(path);

    }

    public void setDonusTarihi(String tarih) {

        String path="(//div[@class='CalendarMonth CalendarMonth_1']//td[contains(@aria-label,'" + tarih + "')])[1]";

        while (!findElementByXpath(path)){
            // daha ileri tarihlerin görünmesi için next month butonuna tıklanır
            clickByXpath(buttonNextMonth);
        }
        clickByXpath(path);


    }

    public void clickAktarmasız() {
        clickByXpath(chechAktarmasız);
    }

    public void clickYetişkinYolcu(int yolcu) {
        clickByXpath(yolcuButton);
        for (int i = 1; i < yolcu; i++) {
            clickByXpath(yetiskinYolcuArttir);
            System.out.println("yolcu arttirilir");
        }
        Assert.assertEquals(yolcu, Integer.parseInt(getTextByXpath(yetiskinYolcuSayi)));
    }

    public void clickBebekYolcu(int yolcu) {
        for (int i = 0; i < yolcu; i++) {
            clickByXpath(bebekYolcuArttir);
            System.out.println("yolcu arttirilir");
        }
        Assert.assertEquals(yolcu, Integer.parseInt(getTextByXpath(bebekYolcuSayi)));
    }

    public void clickCocukYolcu(int key) {
        for (int i = 0; i < key; i++) {
            clickByXpath(cocukYolcuArttir);
            System.out.println("yolcu arttirilir");
        }
        Assert.assertEquals(key, Integer.parseInt(getTextByXpath(cocukYolcuSayi)));
    }

    public void clickOgrenciYolcu(int yolcuArttir, int yolcuAzalt) {
        int yolcu=0;
        for (int i = 0; i < yolcuArttir; i++) {
            yolcu++;
            clickByXpath(ogrenciYolcuArttir);
            System.out.println("yolcu arttirilir");
        }

        if (yolcuArttir > yolcuAzalt) {

            for (int i = 0; i < yolcuAzalt; i++) {
                yolcu--;
                clickByXpath(ogrenciYolcuAzalt);
                System.out.println("yolcu azaltilir");
            }
        } else {
            for (int i = 0; i < (yolcuArttir); i++) {
                yolcu--;
                clickByXpath(ogrenciYolcuAzalt);
                System.out.println("ogrenci else");
            }

        }

        Assert.assertEquals(yolcu, Integer.parseInt(getTextByXpath(ogrenciYolcuSayi)));

    }

    public void clickAltmisBesYolcu(int yolcuArttir, int yolcuAzalt) {
        int yolcu=0;
        for (int i = 1; i < yolcuArttir; i++) {
            yolcu++;
            clickByXpath(altmisbesYolcuArttir);
            System.out.println("yolcu arttirilir");
        }

        if (yolcuArttir > yolcuAzalt) {

            for (int i = 1; i < yolcuAzalt; i++) {
                yolcu--;
                clickByXpath(altmisbesYolcuAzalt);
                System.out.println("yolcu azaltilir");
            }
        } else {
            for (int i = 1; i < (yolcuArttir); i++) {
                yolcu--;
                clickByXpath(altmisbesYolcuAzalt);
                System.out.println("yolcu azaltilir");
            }
        }

        Assert.assertEquals(yolcu, Integer.parseInt(getTextByXpath(ogrenciYolcuSayi)));
    }

    public void selectSinif(String sinif) {
        String LowerSinif = sinif.toLowerCase();

        if (LowerSinif.equals("ekonomi")) {
            System.out.println("Ekonomi sinifi secilir");
            clickByXpath(buttonEkonomi);
        } else if (LowerSinif.equals("business")) {

            System.out.println("Business sinifi secilir");
            clickByXpath(buttonBusiness);
        } else if (LowerSinif.equals("premium economy")) {
            System.out.println("Premium Economy sinifi secilir");
            clickByXpath(buttonPremiumEconomy);
        } else {
            System.out.println("Lütfen Ekonomi veya Business sinif seciniz.");
        }

    }

    public void clickAramaButton() {
        clickByXpath(buttonArama);
    }

    public void controlSonrakiSayfa() {
        String favoriEkle = "Aramayı Favorilere Ekle";


        if (favoriEkle.equals(getTextByXpath(fovoriEkleText))) {

            System.out.println("Sonraki sayfaya gecilmis ve favori ekle yazisi basarili sekilde yuklenmistir.");

        } else {

            //Test failed olması için assertionlar kullanıldı.
            System.out.println("Yuklenmeyen bir seyler var. Kontrol etmelisin");
            Assert.assertEquals(favoriEkle, getTextByXpath(fovoriEkleText));
        }
    }

}








