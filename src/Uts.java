import javax.print.attribute.standard.PrinterInfo;
import java.util.Random;
import java.util.Scanner;

public class Uts {

    int jumvaksin=3;
    static int totaljumlahpenerimavaksin=12;
    public static String[] Pfizer = new String[4];
    public static String[] Sinopharm = new String[4];
    public static String[] moderna = new String[4];

    public static void infopenerimavaksin(){
        int totalpfizer=0;
        int totalsisakuota=0;
        for (int i=0; i<Pfizer.length; i++){
            if (Pfizer[i] !=null){
                totalpfizer++;
            }
        }
        int totalsinopharm=0;
        for (int i=0; i<Sinopharm.length;i++){
            if(Sinopharm[i] !=null){
                totalsinopharm++;
            }
        }
        int totalmoderna=0;
        for(int i=0;i<moderna.length;i++){
            if (moderna[i] !=null){
                totalmoderna++;
            }
        }
        totalsisakuota=totaljumlahpenerimavaksin-totalpfizer-totalsinopharm-totalmoderna;
        System.out.println("total pasian pfizer: " + totalpfizer + " | total pasian sinopharm: " + totalsinopharm + " | total pasien moderna: " + totalmoderna);
        System.out.println("jumlah seluruh pasien: " + totaljumlahpenerimavaksin + "| sisa kuota vaksin: "+ totalsisakuota);

    }
    public static void CheckIndexArray(String[] myArray,String pasien) {
        int IndexNow = 0;
        for (int i = 0; i< myArray.length;i++){
            if (myArray[i] !=null){
                IndexNow = i+1;
            }
        }
        if (IndexNow<myArray.length){
            myArray[IndexNow]=pasien;
        }
    }
    public static void simpenpasien (int angkaRandom, String pasien){
        switch (angkaRandom){
            case 1:
                CheckIndexArray(Pfizer,pasien);
                System.out.println("Anda mendapat vaksin pfizer");
                infopenerimavaksin();
                break;
            case 2:
                CheckIndexArray(Sinopharm,pasien);
                System.out.println("Anda mendapat vaksin sinopherm");
                infopenerimavaksin();
                break;
            case 3 :
                CheckIndexArray(moderna,pasien);
                System.out.println("Anda mendapatkan vaksin moderna");
                infopenerimavaksin();
                break;
        }
    }
    public static void InputPasien(){
        Scanner udin = new Scanner(System.in);
        while (true){
            System.out.println("Masukan Nama pasien");
            String NamaPasien = udin.nextLine();
            if(NamaPasien.isBlank()){
                System.out.println("Nama wajib diisi!");
                InputPasien();
            }else{
                Random hasilRandom= new Random();
                int JenisRandom = hasilRandom.nextInt(3)+1;
                simpenpasien(JenisRandom,NamaPasien);
            }
        }
    }

    public static void main(String[] args) {
        InputPasien();
    }
}
