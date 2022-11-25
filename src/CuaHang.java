import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
		for(;;) {
			if(tenCh.length() != 0) {
				break;
			}
			System.out.println("Khong duoc bo trong");
			tenCh = sc.nextLine();
		}
        this.TenCh = tenCh;
    }
    public String getTenCh() {
        return TenCh;
    }
    public void setDiachi(String diachi) {
    	for(;;) {
			if(diachi.length() != 0) {
				break;
			}
			System.out.println("Khong duoc bo trong");
			diachi = sc.nextLine();
		}
        this.diachi = diachi;
    }
    public String getDiachi() {
        return diachi;
    }
    public void setSdt(String sdt) {
    	Pattern p = Pattern.compile("^\\d{10}$");
		for (;;) {
			Matcher m = p.matcher(sdt);
			if (m.find() == true) {
				break;
			}
			System.out.println("khong phai dinh dang cua so dien thoai");
			System.out.println("Moi nhap lai so dien thoai:");
			sdt = sc.nextLine();
		}
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