
public class NhanVien extends ConNguoi {
	private String chucVu;
	private double luong;
	private static String stt;
	private float soGioLamViec;
	public NhanVien() {
	}
	
	public NhanVien(int id, String hoVaTen, String diaChi, String gioiTinh, String chucVu, double luong, float soGioLamViec) {
		super(id, hoVaTen, diaChi, gioiTinh);
		this.chucVu = chucVu;
		this.luong = luong;
		this.soGioLamViec = soGioLamViec;
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
	public static String getStt() {
		return stt;
	}
	public static void setStt(String stt) {
		NhanVien.stt = stt;
	}
	public float getSoGioLamViec() {
		return soGioLamViec;
	}
	public void setSoGioLamViec(float soGioLamViec) {
		this.soGioLamViec = soGioLamViec;
	}
	@Override
    public String toString() {
        return super.toString();
    }
	public void xuat() {
		super.xuat();
		System.out.println("chuc vu:" + chucVu);
		System.out.println("luong:" + luong);
		System.out.println("so gio lam viec:" + soGioLamViec);
	}
    @Override
    public void nhap() {
        super.nhap(); 
        System.out.println("Moi nhap chuc vu:");
        chucVu=sc.nextLine();
        System.out.println("Moi nhap luong:");
        luong=Integer.parseInt(sc.nextLine());
        System.out.println("Moi nhap so gio lam viec:");
        soGioLamViec=Float.parseFloat(sc.nextLine());
    }
	
}
