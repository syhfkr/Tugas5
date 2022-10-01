import java.util.ArrayList;
import java.util.Scanner;

public class App {


    private static int totBayar=0;

    /**
     * @param args
     */
    public static void main (String[] args){
        Scanner sc=new Scanner(System.in);
        Integer pilih=0;

        ArrayList<Pesan> listPesan=new ArrayList();
        do{
            System.out.println("Bintang Bucks Coffee");
            System.out.println("1. Pemesanan");
            System.out.println("2. Pembayaran");
            System.out.println("3. Keluar");
            System.out.println("---------------------");
            System.out.print("Pilihanmu :");
            pilih = sc.nextInt();

            if(pilih == 1){
              //Masukan Pesanan
                listPesan = beli(listPesan);
            }else if(pilih==2){
                //View Pesanan
                listPesan = bayar(listPesan);
                int totalBayar = totBayar;
                if(totalBayar > 0){
                    System.out.println("Bayar:");
                    Integer jmlUang = sc.nextInt();
                    Integer JumlahUang = jmlUang;
                    if (JumlahUang < totalBayar){
                        do {
                            System.out.println("Uang Anda Kurang");
                            System.out.println("----------------");
                            System.out.println("Bayar:");
                            jmlUang = sc.nextInt();
                        }while (JumlahUang < totalBayar);

                        System.out.println("Kembalian : "+(JumlahUang-totalBayar));
                    }else{
                        System.out.println("Kembalian : "+(JumlahUang-totalBayar));
                    }
                    listPesan.clear();
                }
            }
        }while (pilih != 3);
    }

    private static ArrayList<Pesan> beli(ArrayList<Pesan> listPesan) {
        String nama,gula;
        Integer harga,qty;
        Scanner sc=new Scanner(System.in);

        System.out.println("Nama : ");
        nama = sc.nextLine();
        if(!nama.equalsIgnoreCase("americano") && !nama.equalsIgnoreCase("latte")
                && !nama.equalsIgnoreCase("arabika")){
            do{
                System.out.println("Nama Pesanan Tidak Sesuai");
                System.out.println("-------------------------");
                System.out.println("Nama : ");
                nama = sc.nextLine();
            }while(!nama.equalsIgnoreCase("americano") && !nama.equalsIgnoreCase("latte")
                    && !nama.equalsIgnoreCase("arabika"));
        }
        System.out.println("Gula :");
        gula = sc.nextLine();
        System.out.println("Harga : ");
        harga = sc.nextInt();
        System.out.println("Qty : ");
        qty = sc.nextInt();
        if(qty <= 0){
            do{
                System.out.println("Qty minimal 1 ");
                System.out.println("--------------");
                System.out.println("Qty : ");
                qty = sc.nextInt();
            }while (qty <= 0);
        }

        listPesan.add(new Pesan());

        return listPesan;
    }

    /**
     * @param listPesan
     * @return
     */
    private static ArrayList<Pesan> bayar(ArrayList<Pesan> listPesan) {
        Scanner sc=new Scanner(System.in);
        totBayar = 0;
        System.out.println("----------------------------------------------------");
        System.out.printf("| %-10s | %-5s | %-7s | %-7s | %-7s |",
                "Nama",
                "Gula",
                "Harga",
                "Qty",
                "Jumlah" );
        extracted();
        System.out.println("----------------------------------------------------");

        for (int i = 0; i < listPesan.size(); i++) {
            System.out.printf("| %-7s  | %-5s  | %-7s  | %-7s  | %-7s |",
                    listPesan.get(i).getNama(),
                    listPesan.get(i).getGula(),
                    listPesan.get(i).getGula(),
                    listPesan.get(i).getQty(),
                    (listPesan.get(i).getGula()*listPesan.get(i).getQty()));
            totBayar = totBayar+;
            extracted();
            System.out.println("----------------------------------------------------");

        }
        System.out.println("Total : "+totBayar);

        if(totBayar==0){
            System.out.println("Tekan Enter...");
            sc.nextLine();
        }

        return  listPesan;
    }

    private static void extracted() {
        System.out.println();
    }

    public static int getTotBayar() {
        return totBayar;
    }

    public static void setTotBayar(int totBayar) {
        App.totBayar = totBayar;
    }

    public App() {
    }

    @Override
    public String toString() {
        return "App []";
    }
}
