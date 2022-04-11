package tests;

import com.thoughtworks.gauge.Step;
import models.HomeModel;
import org.junit.Assert;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.HashSet;


public class HomeTest {

    HomeModel homeModel = new HomeModel();


    @Step("Nereden input alanına <key> yazılması")
    public void rotaNereden(String key) {
        System.out.println("Nereden rotasinin yazilmasi");
        homeModel.clickNereden();
        homeModel.setNereden(key);
    }

    @Step("Nereye input alanına <key> yazılması")
    public void rotaNereye(String key) {
        System.out.println("Nereye rotasinin yazilmasi");
        homeModel.clickNereye();
        homeModel.setNereye(key);
    }

    @Step("Listedeki ilk rotanın seçilmesi")
    public void rotaSec() {
        System.out.println("Listedeki ilk rotanin secilmesi");
        homeModel.clickRota();
    }

    @Step("Tek yön checkboxına tıklanır")
    public void tekYon() {
        System.out.println("Tek yon checkboxina tiklnir");
        homeModel.clickTekYon();
    }

    @Step("Gidiş tarihi <key> olarak yazılır")
    public void gidisTarihi(String key) {
        System.out.println("Gidis tarihinin girilmesi");
        homeModel.setGidisTarihi(key);
    }

    @Step("Dönüş tarihi <key> olarak yazılır")
    public void donusTarihi(String key) {
        System.out.println("Donus tarihinin girilmesi");
        homeModel.setDonusTarihi(key);
    }

    @Step("Aktarmasız uçuş seçilmesi")
    public void checkAktarma() {
        System.out.println("Aktarmasiz ucus checkboxi tiklanir");
        homeModel.clickAktarmasız();
    }

    @Step("Yetişkin yolcu sayısının <key> olarak arttırılması")
    public void setYolcuYetiskin(int key) {
        System.out.println("Yolcu sayisi arttırılır");
        homeModel.clickYetişkinYolcu(key);
    }

    @Step("Bebek yolcu sayısının <key> olarak arttırılması")
    public void setYolcuBebek(int key) {
        System.out.println("Yolcu sayisi arttirilir");
        homeModel.clickBebekYolcu(key);
    }

    @Step("Çocuk yolcu sayısının <key> olarak arttırılması")
    public void clickYolcuCocuk(int key) {
        System.out.println("Yolcu sayisi arttırılması");
        homeModel.clickCocukYolcu(key);
    }

    @Step("Altmış beş yolcu sayısının <key> kadar arttırılması ve <key> kadar azaltılması")
    public void setYolcuAltmisBes(int key1, int key2) {
        System.out.println("Yolcu sayisi yazilmasi");
        homeModel.clickAltmisBesYolcu(key1, key2);
    }

    @Step("Öğrenci yolcu sayısının <key> kadar arttırılması ve <key> kadar azaltılması")
    public void setYolcuOgrenci(int key1, int key2) {
        System.out.println("Yolcu sayisi yazılması");
        homeModel.clickOgrenciYolcu(key1, key2);
    }

    @Step("Bilet sınıfının <key> olarak seçilmesi")
    public void selectBiletSinif(String key) {
        System.out.println("Bilet sinifi secilir");
        homeModel.selectSinif(key);
    }

    @Step("Arama butonuna tıklanması")
    public void clickButtonArama() {
        System.out.println("Arama butonunun tiklanmasi");
        homeModel.clickAramaButton();
    }

    @Step("Sonraki sayfaya geçtiğinin kontrolünün yapılması")
    public void controlNextPage() {
        System.out.println("Anasayfa kontrolu yapilir");
        homeModel.controlSonrakiSayfa();
    }
    @Step("Anasayfanın geldiğinin kontrol edilmesi")
    public void controlAnasayfa() {
        System.out.println("Anasayfa kontrolu yapilir");
        homeModel.callHomePage();
    }
}
