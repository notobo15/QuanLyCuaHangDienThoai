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
    private double tongTien;
    private String date;	

    public DonHang() {
    }

    public DonHang(String id, String khachHang_id, String thuNgan_id, String cuaHang_id, String date,
            String hinhThucThanhToan, double tongTien) {
        this.id = id;
        this.hinhThucThanhToan = hinhThucThanhToan;
        this.thuNgan_id = thuNgan_id;
        this.khachHang_id = khachHang_id;
        this.cuaHang_id = cuaHang_id;
        this.tongTien = tongTien;
        this.date = date;
    }

    public String getId() {
        return id;
    }


    public void setId(int id) {

        this.id = "DH" + ++id;
    }

    public String getHinhThucThanhToan() {
        return hinhThucThanhToan;
    }

    public void setHinhThucThanhToan(String hinhThucThanhToan) {
        for (;;) {
            if (hinhThucThanhToan.equalsIgnoreCase("cash")
                    || hinhThucThanhToan.equalsIgnoreCase("card"))
                break;
            System.out.println("Moi nhap lai (cash / card):");
            hinhThucThanhToan = sc.nextLine();
        }
        this.hinhThucThanhToan = hinhThucThanhToan;
    }

    public String getthuNgan_id() {
        return thuNgan_id;
    }

    public void setthuNgan_id(String thuNgan_id) {
        DSNhanVien ds = new DSNhanVien();
        NVThuNgan found;
        for (;;) {
            found = ds.timNVThuNgan(thuNgan_id);
            
            if (found != null)
                break;
            System.out.println("Khach hang khong ton tai!\nMoi nhap lai:");
            thuNgan_id = sc.nextLine();
        }
        this.thuNgan_id = thuNgan_id;
    }

    public String getKhachHang_id() {
        return khachHang_id;
    }

    public void setKhachHang_id(String khachHang_id) {
        DSKhachHang ds = new DSKhachHang();
        for (;;) {
        	 KhachHang found = ds.timKhachHang(khachHang_id);
            if (found != null)
                break;
            System.out.println("Khach hang khong ton tai!\nMoi nhap lai:");
            khachHang_id = sc.nextLine();
        }
        this.khachHang_id = khachHang_id;
    }

    public String getCuaHang_id() {
        return cuaHang_id;
    }

    public void setCuaHang_id(String cuaHang_id) {
        DSCuaHang ds = new DSCuaHang();
        for (;;) {
            CuaHang check = ds.timCuaHang(cuaHang_id);
            if (check != null)
                break;
            System.out.println("cua hang khong ton tai!\nMoi nhap lai:");
            sc.nextLine();
            cuaHang_id = sc.nextLine();
        }
        this.cuaHang_id = cuaHang_id;
    }

    public double getTongTien() {
        return tongTien;
    }

    public void setTongTien() {
        DSChiTietDonHang ds = new DSChiTietDonHang();
        this.tongTien = ds.tong(id);
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
        System.out.println("Nhap id cua khach hang: ");
        setKhachHang_id(sc.nextLine());
        System.out.println("Nhap id cua thu ngan: ");
         setthuNgan_id(sc.nextLine());
        System.out.println("Nhap id cua cua hang: ");
        setCuaHang_id(sc.nextLine());
        System.out.println("Nhap hanh thuc thanh toan: ");
        setHinhThucThanhToan(sc.nextLine());
        setDate();
        DSChiTietDonHang ctdh = new DSChiTietDonHang(getId());
        ctdh.XuatMenu();
        tongTien = ctdh.tong(id);
    }

    @Override
    public String toString() {
        return id + ", hinhThucThanhToan=" + hinhThucThanhToan + ", thuNgan_id=" +
                thuNgan_id + ", khachHang_id="
                + khachHang_id + ", cuaHang_id=" + cuaHang_id + ", date=" + date + "tong tien" + tongTien;
    }

    public String InTenKhachHang() {
        DSSanPham ds = new DSSanPham();
        return ds.getTenKhachHang(getKhachHang_id());
    }

    public String InTenNhanVien() {
        DSNhanVien ds = new DSNhanVien();
        return ds.getTenNhanVien(getthuNgan_id());
    }

    public void xuat() {
        // System.out.println(toString());
        System.out.printf("| %-10s", getId());
        System.out.printf("%-20s", getKhachHang_id());
        System.out.printf("%-20s", getthuNgan_id());
        // System.out.printf("%-20s", InTenNhanVien());
        System.out.printf("%-20s", getCuaHang_id());
        System.out.printf("%-15s", getHinhThucThanhToan());
        System.out.printf("%-25s", getDate());
        setTongTien();
        System.out.printf("%-,15.2f |%n", getTongTien());

        DSChiTietDonHang ds = new DSChiTietDonHang();
        ds.XuatTronGDonHang(getId());

    }

}
