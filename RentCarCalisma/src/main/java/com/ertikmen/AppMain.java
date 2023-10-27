package com.ertikmen;

import com.ertikmen.controller.AracController;
import com.ertikmen.controller.KiralamaController;
import com.ertikmen.controller.KisiController;
import com.ertikmen.model.Arac;
import com.ertikmen.model.Kiralama;
import com.ertikmen.model.Kisi;
import com.ertikmen.model.enums.EAracStatus;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class AppMain {
    static Scanner scanner = new Scanner(System.in);
    static AracController aracController;
    static KiralamaController kiralamaController;
    static KisiController kisiController;

    public AppMain() {
        this.aracController = new AracController();
        this.kiralamaController = new KiralamaController();
        this.kisiController = new KisiController();
    }

    public static void main(String[] args) {

        AppMain appMain = new AppMain();
        appMain.anaMenu();

    }

    private void anaMenu() {

        int secim =0;

        do {
            System.out.println("***************************");
            System.out.println("******** LOLO EMLAK *******");
            System.out.println("******** ANA MENU *********");
            System.out.println("***************************");

            System.out.println("1- Arac Ekle");
            System.out.println("2- Arac Ara");
            System.out.println("3- Kişi Ekle");
            System.out.println("4- Arac Kirala");
            System.out.println("5- Rapor");
            System.out.println("0- Çıkış");

            secim= scanner.nextInt();

            switch (secim) {
                case 1:
                    System.out.println("Arac ekle seçildi..");
                    aracEkle();
                    break;

                case 2:
                    System.out.println("Arac ara seçildi..");
                    aracAra();
                    break;

                case 3:
                    System.out.println("Kisi ekle seçildi..");
                    kisiEkle();
                    break;

                case 4:
                    System.out.println("Arac kirala seçildi..");
                    aracKirala();
                    break;

                case 5:
                    System.out.println("Rapor seçildi..");
                    rapor();
                    break;

                case 0:
                    System.out.println("Çıkış yapılıyor...");
                    break;

                default:
                    break;
            }

        }while (secim!=0);
    }




    private static void aracEkle() {

        System.out.println("Lütfen üretim yılını giriniz");
        int uretim = scanner.nextInt();

        scanner.nextLine();

        System.out.println("Lütfen marka giriniz");
        String tur = scanner.nextLine();



        Arac arac = Arac.builder()
                .uretimYili(LocalDate.of(uretim,1,1))
                .marka(tur)
                .build();

        aracController.aracOlustur(arac);
    }
    private static void aracAra() {

        System.out.println("Lütfen arac id sini giriniz");
        Long id = scanner.nextLong();

        Arac arac = aracController.aracAraById(id);
        System.out.println(arac);
    }
    private static void aracKirala() {

        System.out.println("Lütfen arac id sini giriniz");
        Long id = scanner.nextLong();

        Arac arac = aracController.aracAraById(id);
        arac.setDurum(EAracStatus.KIRADA);
        System.out.println("ARAC BİLGİSİ: " + arac);


        System.out.println("Lütfen kiralamak isteyen kisi id sini giriniz");
        Long kisiId = scanner.nextLong();

        Kisi kisi = kisiController.kisiAraById(kisiId);
        System.out.println("KİSİ BİLGİSİ:" + kisi);


        Kiralama kiralama = Kiralama.builder()
                .arac(arac)
                .kisi(kisi)
                .build();

        kiralamaController.kiralamaOlustur(kiralama);
    }

    private static void kisiEkle() {
        scanner.nextLine();

        System.out.println("Lütfen isminizi giriniz: ");
        String ad = scanner.nextLine();

        System.out.println("Lütfen soyisminizi giriniz");
        String soyad = scanner.nextLine();

        System.out.println("Lütfen tc nizi giriniz");
        String tc = scanner.nextLine();


        Kisi kisi = Kisi.builder()
                .ad(ad)
                .soyad(soyad)
                .tcNo(tc)
                .build();

        kisiController.kisiOlustur(kisi);
    }
    private static void rapor() {

        int secim =0;

        do {

            System.out.println("**************************");
            System.out.println("******** RAPORLAR ********");
            System.out.println("**************************");

            System.out.println("1- Suan Kirada olan Araclar");
            System.out.println("2- Boşta müsait olan Araclar");
            System.out.println("3- Herhangi bir müşterinin kiraladığı Araclar");
            System.out.println("0- Üst Menü");

            secim= scanner.nextInt();

            switch (secim) {
                case 1:
                    System.out.println("Su an kirada olan araclar aranıyor. ");
                    kiradakiAraclar();
                    break;

                case 2:
                    System.out.println("Boşta müsait olan araclar aranıyor.");
                    musaitAraclar();
                    break;

                case 3:
                    System.out.println("Herhangi bir müşterinin kiraladığı araclar aranıyor.");
                    herhangiBirMusterininKiraladigiAraclar();
                    break;


                case 0:
                    System.out.println("Çıkış yapılıyor...");
                    break;

                default:
                    break;
            }

        }while (secim!=0);
    }

    private static void kiradakiAraclar() {

        List<Arac> araclarListesi = aracController.kiradakiAraclar();
        for (Arac arac : araclarListesi) {
            System.out.println("Durumu: " + arac.getDurum() + "\t Id: " + arac.getId() +
                    "\t Markasi: " + arac.getMarka() + "\t Modeli: " + arac.getModel() + "\t Yılı: "+ arac.getUretimYili());
        }
    }

    private static void musaitAraclar() {

        List<Arac> araclarListesi = aracController.musaitAraclar();
        for (Arac arac : araclarListesi) {
            System.out.println("Durumu: " + arac.getDurum() + "\t Id: " + arac.getId()+
                    "\t Markası: " + arac.getMarka() + "\t Modeli: " + arac.getModel() + "\t Yılı: "+ arac.getUretimYili());
        }
    }

    private static void herhangiBirMusterininKiraladigiAraclar() {
    }


}