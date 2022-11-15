import java.util.Scanner;

public class Menu {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		DSSanPham dssp = new DSSanPham();
		DSNhanVien dsnv = new DSNhanVien();
		DSKhachHang dskh = new DSKhachHang();
		DSDonHang dsdh = new DSDonHang();
		DSNhaCungCap dsncc = new DSNhaCungCap();
		DSCuaHang dsch = new DSCuaHang();
		// DSChiTietDonHang dsctdh = new DSChiTietDonHang();

		int select = 0;
		try {

			do {
				System.out.format("+---+--------------- MENU -----------------+%n");
				System.out.format("| 1 | Chon cac thao tac nhan vien          |%n");
				// System.out.format("+---+--------------------------------------+%n");
				System.out.format("| 2 | Chon cac thao tac nhan vien          |%n");
				// System.out.format("+---+--------------------------------------+%n");
				System.out.format("| 3 | Chon cac thao tac khach hang         |%n");
				// System.out.format("+---+--------------------------------------+%n");
				System.out.format("| 4 | Chon cac thao tac nha cung cap       |%n");
				// System.out.format("+---+--------------------------------------+%n");
				System.out.format("| 5 | Chon cac thao tac san pham           |%n");
				// System.out.format("+---+--------------------------------------+%n");
				System.out.format("| 6 | Chon cac thao tac don hang           |%n");
				// System.out.format("+---+--------------------------------------+%n");
				System.out.format("| 7 | Chon cac thao tac cua hang           |%n");
				// System.out.format("+---+--------------------------------------+%n");
				System.out.format("| 8 | Thong ke                             |%n");
				System.out.format("+---+--------------------------------------+%n");
				System.out.format("| 0 | Thoat chuong trinh                   |%n");
				System.out.format("+---+--------------------------------------+%n");
				System.out.print("Vui long chon: ");

				select = sc.nextInt();
				switch (select) {
					case 1:
						dsnv.XuatMenu();
						break;
					case 2:
						break;
					case 3:
						dskh.XuatMenu();
						break;
					case 4:
						dsncc.XuatMenu();
						break;

					case 5:
						dssp.XuatMenu();
						break;
					case 6:
						dsdh.XuatMenu();
						break;
					case 7:
						dsch.XuatMenu();
						break;
					case 8:
						break;
					case 0:
						break;

					default:
						System.out.println("Ban da nhap sai thao tac !!!\nXIN VUI LONG NHAP LAI");
				}
			} while (select != 0);
		} catch (Exception e) {
			System.out.println("BAN CHI DUOC NHAP SO!!!\nXIN VUI LONG NHAP LAI");

		}
	}

}
