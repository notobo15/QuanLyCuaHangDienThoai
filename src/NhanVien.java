
public class NhanVien extends ConNguoi {
	private String chucVu;
	private double luong;
	private static int stt = 0;
	public NhanVien() {
	}
	
	public NhanVien(String id, String hoVaTen,  String gioiTinh,String diaChi,Date ngaySinh, double luong, String chucVu) {
		super(id, hoVaTen, gioiTinh, diaChi, ngaySinh);
		this.chucVu = chucVu;
		this.luong = luong;
	}
	public void setId() {
		super.id = "NV"+ ++stt;
	}
	public String getId() {
		return this.id;
	}
	public String getChucVu() {
		return chucVu;
	}
	public void setChucVu(String chucVu) {
		this.chucVu = chucVu;
	}
	public double getLuong() {
		return luong;
	}
	public void setLuong(double luong) {
		this.luong = luong;
	}


	@Override
    public String toString() {
        return super.toString();
    }
	public void xuat() {
		
		super.xuat();
		System.out.print("\t" + chucVu);
		System.out.println("\t\t" + luong);
	}
    public void nhap() {
    	setId();
    	System.out.println("Moi nhap ho ten:");
	    setHoVaTen(sc.nextLine());
	    System.out.println("Moi nhap gioi tinh:");
	    setGioiTinh(sc.nextLine());
	    System.out.println("Moi nhap dia chi:");
	    diaChi=sc.nextLine();
	    System.out.println("Moi nhap ngay sinh:");
	    ngaySinh.setTime();
        System.out.println("Moi nhap chuc vu:");
        chucVu=sc.nextLine();
        System.out.println("Moi nhap luong:");
        luong=Integer.parseInt(sc.nextLine());
    }
	
}
