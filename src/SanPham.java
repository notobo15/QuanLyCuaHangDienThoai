import java.util.Scanner;
//import java.util.Random;
// import javax.print.Doc;
// import java.io.BufferedReader;
// // import java.io.BufferedWriter;
// import java.io.FileReadaaer;
// import java.io.FileWriter;
// import java.io.IOException;
// import java.io.PrintWriter;


public class SanPham {
	static Scanner sc = new Scanner(System.in);
	private String id;
	private String ten, moTa, mau, kichCo;
	private int gia;
	private String ncc_id; 
	private Date ngayRaMat = new Date(); 
	// private int soLuongSanPham;
	 private static int stt=0;
	private static int stt_ncc=0;
	// // public void DocFile() {
    //     int i = 0;
    //     try {
    //         FileReader fr = new FileReader("database/DSSanPham.txt");
    //         BufferedReader br = new BufferedReader(fr);
    //         try {
    //             String line = "";
    //             while (true) {
    //                 line = br.readLine();
    //                 if (line == null) {
    //                     break;
    //                 }
    //                 String txt[] = line.split("\\|");
    //                 String id=txt[0];
    //                 String Ten=txt[1];
    //                 String moTa=txt[2];
    //                 String Mau=txt[3];
    //                 String kichCo=txt[4];
    //                 int Gia= Integer.parseInt(txt[5]);
    //                 String NCC_ID=txt[6];
    //                 String date=txt[7];
    //                 String temp[]= date.split("\\/");
    //                 int ngay = Integer.parseInt(temp[0]);
    //                 int thang = Integer.parseInt(temp[1]);
    //                 int nam = Integer.parseInt(temp[2]);
    //                 Date ngayRaMat=new Date(ngay,thang,nam);
    //                 sp[i] = new SanPham(id, Ten,moTa,Mau,kichCo,Gia,NCC_ID,ngayRaMat);
    //                 i++;
    //             }
    //         } finally {
    //             soLuongSanPham = i;
    //             br.close();
    //         }

    //     } catch (Exception e) {
    //         System.out.println("KHONG DOC DUOC DU LIEU!!!");
    //     }

    // }
	public SanPham() {
		
	}
	
	public SanPham(String id, String ten, String moTa, String mau, String kichCo, int gia, String ncc_id,Date ngayRaMat) {
		this.id = id;
		this.ten = ten;
		this.moTa = moTa;
		this.mau = mau;
		this.kichCo = kichCo;
		this.gia = gia;
		this.ncc_id = ncc_id;
		this.ngayRaMat=ngayRaMat;
	}
	public String getId() {
		return id;
	}
	public void setId(int stt) {
		//DSSanPham.DocFile();
		
		this.id = "SP" + ++stt ;
	}
	public String getTen() {
		return ten;
	}
	public void setTen(String ten) {
		this.ten = ten;
	}
	public String getMoTa() {
		return moTa;
	}
	public void setMoTa(String moTa) {
		this.moTa = moTa;
	}
	public String getMau() {
		return mau;
	}
	public void setMau(String mau) {
		this.mau = mau;
	}
	public String getKichCo() {
		return kichCo;
	}
	public void setKichCo(String kichCo) {
		this.kichCo = kichCo;
	}
	public int getGia() {
		return gia;
	}
	public void setGia(int gia) {
		this.gia = gia;
	}
	public String getNCC_ID(){
		return ncc_id;
	}
	public void setNCC_ID(){
		// DocFile();
		this.ncc_id="NCC" + ++stt_ncc ;
	}
	
	public Date getNgayRaMat() {
		return ngayRaMat;
	}
	public void setNgayRaMat() {
		this.ngayRaMat.setTime();
	}
	public void nhap() {
		
		//setId();
		System.out.print("Moi nhap ten san pham:");
        setTen(sc.nextLine());
        System.out.print("Moi nhap mau:");
        setMau(sc.nextLine());
        System.out.print("Moi nhap kich co:");
        setKichCo(sc.nextLine());
        System.out.println("Moi nhap loai hang:");
		System.out.println("||============ Chon thao tac ===============||");
		System.out.println("||1. Hang New                         	   ||");
		System.out.println("||2. Hang Likenew                		   ||");
		System.out.println("||2. Hang Old                			   ||");
		System.out.println("||==========================================||");
		System.out.print("Nhap mo ta: ");
		int select = sc.nextInt();
		switch (select) {
			case 1: {
				setMoTa("New");
				break;
			}
			case 2:
				setMoTa("Likenew");
				break;
			case 3:
				setMoTa("Old");
				break;
			default:
				System.out.println("Nhap sai thao tac, xin nhap lai !!!");
		}
		System.out.print("Nhap gia ban:");
		setGia(sc.nextInt());		
		setNCC_ID();
        setNgayRaMat();
	}

	
	
	@Override
	public String toString() {
		return id+"\t"+ ten+"\t\t\t"+moTa+"\t\t"+mau+"\t\t"+kichCo+"\t\t"+gia+"\t\t"+ncc_id+"\t\t\t"+ngayRaMat;
	}
	public void Xuat() {
		System.out.println(toString());
	}
	
}
