import java.util.Scanner;

public class NhapHang {
	private String id;
	private String cuaHang_id;
	private String hinhThucTT;
	private float gia;
	private static int stt = 0;
	Scanner sc = new Scanner(System.in);
	public NhapHang() {
		super();
	}
	public String getId() {
		return id;
	}
	public void setId() {
		this.id = "DH" + ++stt;
	}
	public String getCuaHang_id() {
		return cuaHang_id;
	}
	public void setCuaHang_id(String cuaHang_id) {
		this.cuaHang_id = cuaHang_id;
	}
	public String getHinhThucTT() {
		return hinhThucTT;
	}
	public void setHinhThucTT(String hinhThucTT) {
		this.hinhThucTT = hinhThucTT;
	}
	public float getGia() {
		return gia;
	}
	public void setGia(float gia) {
		this.gia = gia;
	}
	public static int getStt() {
		return stt;
	}
	public static void setStt(int stt) {
		NhapHang.stt = stt;
	}
	public void Tao() {
		setId();
		System.out.println("");
	}
	
}
