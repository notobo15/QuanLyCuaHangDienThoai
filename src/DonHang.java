import java.time.LocalDateTime;
import java.util.Scanner;
import java.time.format.DateTimeFormatter;

public class DonHang {
	Scanner sc = new Scanner(System.in);
	private static int stt = 0;
	private String id, hinhThucThanhToan;
	private String thuNgan_id;
	private String khachHang_id;
	private String cuaHang_id;
	private static float gia = 0;
	private String date;

	public DonHang() {
	}

	public DonHang(String id, String hinhThucThanhToan, String thuNgan_id, String khachHang_id, String cuaHang_id,
			float gia, String date) {
		this.id = id;
		this.hinhThucThanhToan = hinhThucThanhToan;
		this.thuNgan_id = thuNgan_id;
		this.khachHang_id = khachHang_id;
		this.cuaHang_id = cuaHang_id;
		this.gia = gia;
		this.date = date;
	}

	public String getId() {
		return id;
	}

	public void setId() {

		this.id = "DH" + ++stt;
	}

	public String getHinhThucThanhToan() {
		return hinhThucThanhToan;
	}

	public void setHinhThucThanhToan(String hinhThucThanhToan) {
		this.hinhThucThanhToan = hinhThucThanhToan;
	}

	public String getthuNgan_id() {
		return thuNgan_id;
	}

	public void setthuNgan_id(String thuNgan_id) {
		this.thuNgan_id = thuNgan_id;
	}

	public String getKhachHang_id() {
		return khachHang_id;
	}

	public void setKhachHang_id(String khachHang_id) {
		this.khachHang_id = khachHang_id;
	}

	public String getCuaHang_id() {
		return cuaHang_id;
	}

	public void setCuaHang_id(String cuaHang_id) {
		this.cuaHang_id = cuaHang_id;
	}

	public float getGia() {
		return gia;
	}

	public static void setGia(double d) {
		
		gia += d;
	}

	public void setDate() {
		LocalDateTime myDateObj = LocalDateTime.now();
		DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
		String formattedDate = myDateObj.format(myFormatObj);
		this.date = formattedDate;
	}

	public String getDate() {
		return date;
	}

	public void nhap() {
		setId();
		System.out.println("Nhap id cua khach hang: ");
		setKhachHang_id(sc.nextLine());
		System.out.println("Nhap id cua thu ngan: ");
		setthuNgan_id(sc.nextLine());
		System.out.println("Nhap id cua cua hang: ");
		setCuaHang_id(sc.nextLine());
		System.out.println("Nhap hanh thuc thanh toan: ");
		setHinhThucThanhToan(sc.nextLine());
		setDate();
		
		ChiTietDonHang dsctdh[] = new ChiTietDonHang[1000];
		int n = 1;
		System.out.println(getId());
		for(int i = 0; i < n; i++) {
			dsctdh[i] = new ChiTietDonHang(getId());
			dsctdh[i].nhap();
			dsctdh[i].xuat();
			setGia(dsctdh[i].getThanhTien());
		}
//		System.out.println("Nhap so luong san pham: ");
//        int slnv = sc.nextInt();
//        for (int i = size; i < size + slnv; i++) {
//        	dsctdh[i] = new ChiTietDonHang();
//            System.out.println("---------Nhap thong tin-----------");
//            dsctdh[i].nhap();
//            System.out.println("Them nhan vien thanh cong");
//        }
//        size += slnv;
	}
	
	@Override
	public String toString() {
		return id + ", hinhThucThanhToan=" + hinhThucThanhToan + ", thuNgan_id=" + thuNgan_id + ", khachHang_id="
				+ khachHang_id + ", cuaHang_id=" + cuaHang_id + ", gia=" + gia + ", date=" + date;
	}
	public void xuat() {
		System.out.println(toString());
	}
	public static void main(String[] args) {
		DonHang dh = new DonHang();
		dh.nhap();
		dh.xuat();
	}
}
