/**
 * 
 * faizhesabi
 * Created by Oktay KUZU
 * 
 */
import java.text.DecimalFormat;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class faizhesabi {

    public static void main(String[] args) {
        try (Scanner girislBilgi = new Scanner(System.in)) {
            System.out.print("Lütfen \"Ana Para\" miktarınız giriniz:");
            float anaPara = girislBilgi.nextFloat();
            // float anaPara = 10000f;
            System.out.print("Lütfen \"Yıllık Vade\" oranını giriniz:");
            float faizOrani = girislBilgi.nextFloat();
            // float faizOrani = 25f;
            System.out.print("Paranızı kaç ay vadede tutacaksınız? : ");
            int toplamAy = girislBilgi.nextInt();
            // int toplamAy = 12;
            System.out.print("Hesaplanıyor");
            for (int x = 0; x < 3; x++) { 
                TimeUnit.SECONDS.sleep(1); // Son kullanıcı bir iş yaptığımıza inandırmak lazım :)
                System.out.print(".");
            }
            System.out.println("\nSonuçlar:");
            
            float ilkAnaPara = anaPara;
            for (int i = 0; i < toplamAy; i++) {
                try {
                    int ay = i + 1;
                    String mesaj = "";
                    float aylikCarpan = (faizOrani / 12) / 100;
                    float kazanc = anaPara * aylikCarpan;
                    anaPara = anaPara + kazanc;
                    if (ay == toplamAy) {
                        mesaj = "Son Ayda elde edeceğiniz faiz " + yuvarlaTLGetir(kazanc) + "; Toplam Ana Paranız: "
                                + yuvarlaTLGetir(anaPara);
                    } else {
                        mesaj = ay + ". Ayda elde edeceğiniz faiz " + yuvarlaTLGetir(kazanc)
                                + "; Bu elinizdeki ana para: " + yuvarlaTLGetir(anaPara);
                    }
                    if (mesaj.isEmpty() == false) {
                        System.out.println(mesaj);
                    }
                } catch (Exception e) {
                    System.out.println("Bir Hata Oluştu: " + e.getMessage());
                }
            }
            float toplamGelir = anaPara - ilkAnaPara;
            System.out.println("Başlangıçta yatırdığınız miktar:" + yuvarlaTLGetir(ilkAnaPara));
            System.out.println("%" + faizOrani + " faiz oranı ile " + toplamAy + " ayda toplam kazancınız: "
                    + yuvarlaTLGetir(toplamGelir));
            System.out.println("Vade sonu elinizdeki toplam miktar: " + yuvarlaTLGetir(anaPara));
            System.out.println(
                    "Not: Hesaplamalar Standart \"360 gün vade hesabı\" sistemi ile her ayı 30 gün kabul ederek yapılmıştır.");
        } catch (Exception e) {
            System.out.println("Veri girişlerinizden birinde hata oluştu, lütfen kontrol ediniz: " + e.toString());
        }
    }

    public static String yuvarlaTLGetir(float deger) {
        String yeniDeger = new DecimalFormat("##.##").format(Math.round(deger));
        return yeniDeger + " TL";
    }

}
