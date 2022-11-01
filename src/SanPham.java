
import java.util.Scanner;

public class SanPham {
	static Scanner sc = new Scanner(System.in);
	private String id;
	private static int stt = 1000;
	private String ten, moTa, mau, kichCo;
	private float gia;
	private String ncc_id; 
	private Date ngayRaMat = new Date(); 
	private String donViTinh;
	private static float soLuong = 0 ;
	public SanPham() {
		
	}
	public SanPham(String id, String ten, String moTa, String mau, String kichCo, float gia, String ncc_id) {
		this.id = id;
		this.ten = ten;
		this.moTa = moTa;
		this.mau = mau;
		this.kichCo = kichCo;
		this.gia = gia;
		this.ncc_id = ncc_id;
	}
	public String getId() {
		return id;
	}
	public void setId() {
		
		this.id = "SP" + ++stt;
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
	public float getGia() {
		return gia;
	}
	public void setGia(float gia) {
		this.gia = gia;
	}
	public int getNhaCC_id() {
		return nhaCC_id;
	}
	public void setNhaCC_id(int nhaCC_id) {
		this.nhaCC_id = nhaCC_id;
	}
	
	
	public Date getNgayRaMat() {
		return ngayRaMat;
	}
	public void setNgayRaMat() {
		this.ngayRaMat.setTime();
	}
	public void Tao() {
		setId();
		System.out.println("Moi nhap ten san pham:");
        setTen(sc.nextLine());
        System.out.println("Moi nhap mau:");
        setMau(sc.nextLine());
        System.out.println("Moi nhap kich co:");
        setKichCo(sc.nextLine());
        System.out.println("Moi nhap mo ta:");
        setMoTa(sc.nextLine());
        setNgayRaMat();
	}
	
	
	
	@Override
	public String toString() {
		return "SanPham [id=" + id + ", ten=" + ten + ", moTa=" + moTa + ", mau=" + mau + ", kichCo=" + kichCo
				+ ", gia=" + gia + ", nhaCC_id=" + nhaCC_id + ", ngayRaMat=" + ngayRaMat + "]";
	}
	public void Xuat() {
		System.out.println(toString());
	}
	
}
