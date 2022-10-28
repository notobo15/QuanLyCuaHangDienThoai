import java.util.Scanner;

public class ConNguoi {
	private int id;
	private String hoVaTen;
	private String diaChi;
	private String gioiTinh;
	static Scanner sc = new Scanner(System.in);
	private  Date ngaySinh = new Date();
	public ConNguoi() {
	}
	public ConNguoi(int id, String hoVaTen, String diaChi, String gioiTinh) {
		this.id = id;
		this.hoVaTen = hoVaTen;
		this.diaChi = diaChi;
		this.gioiTinh = gioiTinh;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getHoVaTen() {
		return hoVaTen;
	}
	public void setHoVaTen(String hoVaTen) {
		this.hoVaTen = hoVaTen;
	}
	public String getDiaChi() {
		return diaChi;
	}
	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}
	public String getGioiTinh() {
		return gioiTinh;
	}
	public void setGioiTinh(String gioiTinh) {
        for(;;){
            if(gioiTinh.equalsIgnoreCase("Nam")|| gioiTinh.equalsIgnoreCase("Nu"))
                break;
            System.out.println("Moi nhap lai gioi tinh:");
            gioiTinh=sc.nextLine();
        }
        this.gioiTinh = gioiTinh;
    }
	
  
	
	public Date getNgaySinh() {
		return ngaySinh;
	}
	public void setNgaySinh(Date ngaySinh) {
		this.ngaySinh = ngaySinh;
	}
	@Override
    public String toString() { 
        return  "hoTen=" + hoVaTen + ", gioiTinh=" + gioiTinh + ", diaChi=" + diaChi  + ngaySinh.toString();
    }
     public void nhap(){
         System.out.println("Moi nhap ho ten:");
         setHoVaTen(sc.nextLine());
         System.out.println("Moi nhap gioi tinh:");
         setGioiTinh(sc.nextLine());
         System.out.println("Moi nhap dia chi:");
         diaChi=sc.nextLine();
         System.out.println("Moi nhap ngay sinh:");
         ngaySinh.setTime();
     }
     public void xuat(){
         System.out.println(toString());
     }
	
}
