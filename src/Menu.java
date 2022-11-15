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
		do {
			System.out.println("+---+--------------- MENU -----------------+");
			System.out.println("| 1 | Chon cac thao tac nhan vien          |");
			System.out.println("+---+--------------------------------------+");
			System.out.println("| 2 | Chon cac thao tac nhan vien          |");
			System.out.println("+---+--------------------------------------+");
			System.out.println("| 3 | Chon cac thao tac khach hang         |");
			System.out.println("+---+--------------------------------------+");
			System.out.println("| 4 | Chon cac thao tac nha cung cap       |");
			System.out.println("+---+--------------------------------------+");
			System.out.println("| 5 | Chon cac thao tac san pham           |");
			System.out.println("+---+--------------------------------------+");
			System.out.println("| 6 | Chon cac thao tac don hang           |");
			System.out.println("+---+--------------------------------------+");
			System.out.println("| 7 | Chon cac thao tac cua hang           |");
			System.out.println("+---+--------------------------------------+");
			System.out.println("| 8 | Thong ke                             |");
			System.out.println("+---+--------------------------------------+");
			System.out.println("| 0 | Thoat chuong trinh                   |");
			System.out.println("+---+--------------------------------------+");
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
					System.out.println("Nhap sai lua chon, xin nhap lai !!!");

			}
		} while (select != 0);

	}

}
