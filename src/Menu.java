import java.util.Scanner;

import Function.Check;

public class Menu {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		DSNhanVien dsnv = new DSNhanVien();
		DSSanPham dssp = new DSSanPham();
		DSKhachHang dskh = new DSKhachHang();
		DSDonHang dsdh = new DSDonHang();
		DSNhaCungCap dsncc = new DSNhaCungCap();
		DSCuaHang dsch = new DSCuaHang();
		// DSChiTietDonHang dsctdh = new DSChiTietDonHang();

		int luaChon = 0;

		do {
			System.out.format("+---+--------------- MENU -----------------+%n");
			System.out.format("| 1 | Chon cac thao tac nhan vien          |%n");
			// System.out.format("+---+--------------------------------------+%n");
//			System.out.format("| 2 | Chon cac thao tac nhan vien thu ngan |%n");
			// System.out.format("+---+--------------------------------------+%n");
			System.out.format("| 2 | Chon cac thao tac khach hang         |%n");
			// System.out.format("+---+--------------------------------------+%n");
			System.out.format("| 3 | Chon cac thao tac nha cung cap       |%n");
			// System.out.format("+---+--------------------------------------+%n");
			System.out.format("| 4 | Chon cac thao tac san pham           |%n");
			// System.out.format("+---+--------------------------------------+%n");
			System.out.format("| 5 | Chon cac thao tac don hang           |%n");
			// System.out.format("+---+--------------------------------------+%n");
			System.out.format("| 6 | Chon cac thao tac cua hang           |%n");
			// System.out.format("+---+--------------------------------------+%n");
			System.out.format("| 7 | Thong ke                             |%n");
			System.out.format("+---+--------------------------------------+%n");
			System.out.format("| 0 | Thoat chuong trinh                   |%n");
			System.out.format("+---+--------------------------------------+%n");
			System.out.print("Vui long chon: ");

			luaChon = Check.checkInputDigit();
			switch (luaChon) {
				case 1:
					dsnv.XuatMenu();
					break;
				
				case 2:
					dskh.XuatMenu();
					break;
				case 3:
					dsncc.XuatMenu();
					break;
				case 4:
					dssp.XuatMenu();
					break;
				case 5:
					dsdh.XuatMenu();
					break;
				case 6:
					dsch.XuatMenu();
					break;
				case 0:
					break;

				default:
					System.out.println("Ban da nhap sai thao tac !!!\nMoi ban nhap lai : ");
			}
		} while (luaChon != 0);

	}

}
