package day02_dataTurleri_Scanner;

import java.util.Scanner;

public class C05_ScannerIlkGorev {

    public static void main(String[] args) {
        // kullanicidan bir sayi alin
        // ve sayinin karesini yazdirin

      //  Scanner scan= new Scanner(System.in);
      //  System.out.println("Lutfen bir sayi girin");

      //  int girilenSayi= scan.nextInt();

      //  System.out.println("Girilen sayinin karesi : " + girilenSayi*girilenSayi);
      //
      //
      //  // Kullanıcdan bir isim ve yaş al sonra bu yaş ve adı ayzdır

        Scanner isim = new Scanner(System.in);

        System.out.println("Lütfen isminizi girin");

        String ad = isim.next();

        System.out.println("Yaşınızı girin");

        Scanner yas= new Scanner(System.in);

        int yil = yas.nextInt();


        System.out.println("Girilen yaş ve yıl : " + ad+" "+yil);







    }
}
