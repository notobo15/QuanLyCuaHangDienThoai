import java.util.Scanner;

public abstract class ConNguoi {
	static Scanner sc = new Scanner(System.in);

	protected String id;
	protected String hoVaTen;

	protected String diaChi;

	protected String gioiTinh;

	protected String email;

	protected String sdt;
	protected  Date ngaySinh = new Date();
	public ConNguoi() {
	}
	public ConNguoi(String id, String hoVaTen, String diaChi, String gioiTinh) {
		this.id = id;
		this.hoVaTen = hoVaTen;
		this.diaChi = diaChi;
		this.gioiTinh = gioiTinh;
	}
	public String getId() {
		return id;
	}
	public void setId() {
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
        return "id: "+ id + "; hoTen: " + hoVaTen + "; gioiTinh: " + gioiTinh + "; diaChi: " +diaChi+"; "  + ngaySinh.toString();
    }
     public abstract void nhap();
     public void xuat(){
         System.out.print(toString());
     }
	
}
