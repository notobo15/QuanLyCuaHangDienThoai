import java.util.Scanner;

public class Cua_Hang {
    static Scanner sc = new Scanner(System.in);
    private String id;
    private String TenCh;
    private String diachi;
    private String sdt;
    public static int stt= 1;
    public Cua_Hang(){

    }
    public Cua_Hang(String id , String tenCh , String diachi,String sdt ){
        this.id= id;
        this.TenCh= tenCh;
        this.diachi= diachi;
        this.sdt= sdt;
       
    }
    public void setId(String id) {
        this.id = "NV"+ ++stt;
    }
    public String getId() {
        return id;
    }
    public void setTenCh(String tenCh){
        this.TenCh = tenCh;
    }
    public String getTenCh() {
        return TenCh;
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
        return TenCh.toString();
    }
    public void xuat() {

		System.out.print("\t" + stt +"\t\t" + id +"\t\t" +TenCh+"\t\t\t" +diachi+"\t\t\t" +sdt+"\n");
	}
    public void nhap()
    {
        setId(id);
        System.out.println("Nhap ten cua hang :");
        TenCh= sc.nextLine();
        System.out.println("Nhap dia chi cua hang :");
        diachi= sc.nextLine();
        System.out.println("Nhap so dien thoai cua hang:");
        sdt= sc.nextLine();
    }

}