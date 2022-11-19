import java.util.Scanner;

public class CuaHang {
    static Scanner sc = new Scanner(System.in);
    private String id;
    private String TenCh;
    private String diachi;
    private String sdt;
    public CuaHang(){

    }
    public CuaHang(String id , String tenCh , String diachi,String sdt ){
        this.id= id;
        this.TenCh= tenCh;
        this.diachi= diachi;
        this.sdt= sdt;
       
    }

    public String getId() {
		return id;
	}
	public void setId(int stt) {
		this.id = "CH" + ++stt;
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
    	System.out.printf("|  %-10s", getId());
		System.out.printf("%-25s", getTenCh());
		System.out.printf("%-25s", getDiachi());
		System.out.printf("%-15s|%n", getSdt());
		//System.out.print(id +"\t\t" +TenCh+"\t\t\t" +diachi+"\t\t\t" +sdt+"\n");
	}
    
    public void nhap()
    {
        System.out.println("Nhap ten cua hang :");
        setTenCh(sc.nextLine());
        System.out.println("Nhap dia chi cua hang :");
        setDiachi(sc.nextLine());
        System.out.println("Nhap so dien thoai cua hang:");
        setSdt(sc.nextLine());
    }

}