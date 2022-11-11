import java.util.Scanner;

public class Nha_Cung_Cap {
    static Scanner sc = new Scanner(System.in);
    private String id;
    private String TenNcc;
    private String diachi;
    private String sdt;
    public static int stt= 1;
    public Nha_Cung_Cap(){

    }
    public Nha_Cung_Cap(String id , String tenNcc , String diachi,String sdt ){
        this.id= id;
        this.TenNcc= tenNcc;
        this.diachi= diachi;
        this.sdt= sdt;
       
    }
    public void setId(String id) {
        this.id = "NV"+ ++stt;
    }
    public String getId() {
        return id;
    }
    public void setTenNcc(String tenNcc){
        this.TenNcc = tenNcc;
    }
    public String getTenNcc() {
        return TenNcc;
    }
    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }
    public String getDiachi() {
        return diachi;
    }
    public void setSdt(String sdt) {
        this.sdt = sdt;
    }
    public String getSdt() {
        return sdt;
    }
    @Override
    public String toString() {
        return TenNcc.toString();
    }
    public void xuat() {

		System.out.print("\t" + stt +"\t\t" + id +"\t\t" +TenNcc+"\t\t\t" +diachi+"\t\t\t" +sdt+"\n");
	}
    public void nhap()
    {
        setId(id);
        System.out.println("Nhap ten nha cung cap vao :");
        TenNcc= sc.nextLine();
        System.out.println("Nhap dia chi nha cung cap :");
        diachi= sc.nextLine();
        System.out.println("Nhap so dien thoai nha cung cao:");
        sdt= sc.nextLine();
    }


}