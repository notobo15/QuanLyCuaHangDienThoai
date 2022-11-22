import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

import Function.Check;

public class DSChiTietDonHang implements ThaoTac {
	private ChiTietDonHang[] dsctdh = new ChiTietDonHang[0];
	private static int stt = 0;
	static Scanner sc = new Scanner(System.in);
	private String donHang_id;

	public DSChiTietDonHang() {
	}

	public DSChiTietDonHang(String donHang_id) {
		this.donHang_id = donHang_id;
	}

	@Override
	public void XuatMenu() {
		DocFile();
		int select = 0;
		do {
			System.out.println("+-------------- Chon thao tac --------------+");
			System.out.println("|1. Them san pham vao gio                   |");
			System.out.println("|2. Xuat danh sach san pham trong gio hang  |");
			System.out.println("|3. Xoa san pham vao gio                    |");
			System.out.println("|4. Sua so luong san pham                   |");
			System.out.println("|5. Tim san pham                            |");
			System.out.println("|0. Hoan Tat                                |");
			System.out.println("+-------------------------------------------+");
			System.out.print("Nhap thao tac: ");
			select = Check.checkInputDigit();
			switch (select) {
				case 1: {
					Tao();
					break;
				}
				case 2:
					Xuat();
					break;
				case 3:
					Xoa();
					break;
				case 4:
					Sua();
					break;
				case 5:
					TimKiem();
					break;
				case 0:
					break;
				default:
					System.out.println("Nhap sai thao tac, xin nhap lai !!!");

			}

		} while (select != 0);

	}

	@Override
	public void Xuat() {
		for (int i = 0; i < dsctdh.length; i++) {
			dsctdh[i].xuat();
		}

	}

	public void XuatTronGDonHang(String id) {
		DocFile();
		for (int i = 0; i < dsctdh.length; i++) {
			if (dsctdh[i].getDonHang_id().equalsIgnoreCase(id))
				dsctdh[i].xuat();
		}
		System.out.printf(
				"+- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -+%n");

	}

	public void XuatTronGHoaDon(String id) {
		DocFile();
		for (int i = 0; i < dsctdh.length; i++) {
			if (dsctdh[i].getDonHang_id().equalsIgnoreCase(id)) {
				System.out.print(dsctdh[i].getSanPham_id() + "\t");
				System.out.print(dsctdh[i].getSoLuong() + "\t");

				System.out.println(dsctdh[i].getThanhTien());
			}
		}

	}

	public ChiTietDonHang[] dsChiTietDonHang(String id) {
		DocFile();
		int n = 0;
		for (int k = 0; k < dsctdh.length; k++) {
			if (dsctdh[k].getDonHang_id().equalsIgnoreCase(id)) {
				n++;
			}
		}
		ChiTietDonHang ds[] = new ChiTietDonHang[n];
		int j = 0;
		for (int i = 0; i < dsctdh.length; i++) {
			if (dsctdh[i].getDonHang_id().equalsIgnoreCase(id)) {
				ChiTietDonHang tem = new ChiTietDonHang();
				tem = dsctdh[i];
				ds[j++] = tem;
			}
		}
		return ds;
	}

	@Override
	public void Xoa() {
		System.out.print("Nhap ID chi tiet don hang can xoa : ");
		String id = sc.nextLine();
		boolean flag = false;

		for (int i = 0; i < dsctdh.length; i++) {
			if (id.equalsIgnoreCase(dsctdh[i].getId())) {
				for (int j = i; j < dsctdh.length; j++) {
					dsctdh[j] = dsctdh[j + 1];
				}
				flag = true;
				dsctdh = Arrays.copyOf(dsctdh, dsctdh.length - 1);
				System.out.println("Da xoa thanh cong!");
			}
		}

		if (flag == false) {
			System.out.println("Khong co don hang de xoa");
		}
		GhiFile();
	}

	@Override
	public void Tao() {
		System.out.println("Nhap so luong san pham: ");
		int sl = 0;
		for (;;) {
			if (sl > 0) {
				break;
			}
			sl = Check.checkInputDigit();
		}
		int arrLength = dsctdh.length;
		dsctdh = Arrays.copyOf(dsctdh, dsctdh.length + sl);

		for (int i = arrLength; i < arrLength + sl; i++) {
			dsctdh[i] = new ChiTietDonHang();
			System.out.println("---------Nhap thong tin-----------");
			dsctdh[i].setId(stt++);
			dsctdh[i].nhap();
			System.out.println("Them don hang thanh cong");
		}
		GhiFile();

	}

	public double tong(String id) {
		DocFile();
		double s = 0;
		for (int i = 0; i < dsctdh.length; i++) {
			// System.out.println(dsctdh[i].getThanhTien());
			if (id.equalsIgnoreCase(dsctdh[i].getDonHang_id())) {
				s += dsctdh[i].getThanhTien();
			}
		}
		return s;
	}

	@Override
	public void TimKiem() {
		System.out.print("Nhap ID chi tiet don hang can tim: ");
		sc.nextLine();
		String id = sc.nextLine();
		boolean flag = false;
		for (int i = 0; i < dsctdh.length; i++) {
			if (id.equalsIgnoreCase(dsctdh[i].getId())) {
				dsctdh[i].xuat();
				flag = true;

			}
		}
		if (flag == false) {
			System.out.println("Khong tim thay nhan vien");
		}

	}

	@Override
	public void GhiFile() {
		try {
			FileWriter fw = new FileWriter(".\\database\\DSChiTietDonHang.txt", false);
			BufferedWriter bw = new BufferedWriter(fw);
			PrintWriter pw = new PrintWriter(bw);
			for (int i = 0; i < dsctdh.length; i++) {
				pw.println(dsctdh[i].getId() + "|" + dsctdh[i].getDonHang_id() + "|" + dsctdh[i].getSanPham_id() + "|"
						+ dsctdh[i].getSoLuong() + "|" + dsctdh[i].getThanhTien());
			}
			bw.close();
			fw.close();
			pw.close();
		} catch (IOException e) {
			System.out.println("Loi khong ghi dc file");
		}

	}

	@Override
	public void DocFile() {
		int i = 0;
		try {
			FileReader fr = new FileReader(".\\database\\DSChiTietDonHang.txt");
			BufferedReader br = new BufferedReader(fr);
			String line = "";
			while (true) {
				line = br.readLine();
				if (line == null) {
					break;
				}
				String txt[] = line.split("\\|");
				String id = txt[0];
				String donHang_id = txt[1];
				String sanPham_id = txt[2];
				float soLuong = Float.parseFloat(txt[3]);
				double thanhTien = Double.parseDouble(txt[4]);
				dsctdh = Arrays.copyOf(dsctdh, dsctdh.length + 1);

				dsctdh[i] = new ChiTietDonHang(id, donHang_id, sanPham_id, soLuong, thanhTien);
				i++;
			}
			br.close();
			fr.close();

		} catch (Exception e) {
			System.out.println("Loi khong doc dc file");
		}

	}

	@Override
	public void Sua() {
		System.out.println("nhap id chi tiet don hang can sua : ");
		sc.nextLine();
		String id = sc.nextLine();
		boolean flag = false;
		for (int i = 0; i < dsctdh.length; i++) {
			if (id.equalsIgnoreCase(dsctdh[i].getId())) {
				System.out.println("nhap so luong can sua : ");
				int soLuongMoi = Integer.parseInt(sc.nextLine());
				dsctdh[i].setSoLuong(soLuongMoi);
				dsctdh[i].setThanhTien();
				flag = true;
				System.out.println("Thay doi thanh cong");
			}
		}
		if (flag == false) {
			System.out.println("sua khong thanh cong");
		}

		GhiFile();
	}

	public double thanhTien(String id) {
		double s = 0;
		for (int i = 0; i < dsctdh.length; i++) {
			if (id.equalsIgnoreCase(dsctdh[i].getDonHang_id())) {
				s += dsctdh[i].getThanhTien();
			}
		}
		return s;
	}
}
