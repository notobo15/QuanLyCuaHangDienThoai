import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class DSChiTietDonHang implements ThaoTac {
	private static int size = 0;
	public ChiTietDonHang[] dsctdh = new ChiTietDonHang[1000];
	static Scanner sc = new Scanner(System.in);
	private String donHang_id;

	public DSChiTietDonHang() {
	}

	public DSChiTietDonHang(String donHang_id) {
		this.donHang_id = donHang_id;
	}

	@Override
	public void XuatMenu() {
		int select = 0;
		do {
			System.out.println("+-------------- Chon thao tac --------------+");
			System.out.println("|1. Them san pham vao gio                   |");
			System.out.println("|2. Xuat danh sach san pham trong gio hang  |");
			System.out.println("|3. Xoa don hang                            |");
			System.out.println("|4. Sua so luong san pham                   |");
			System.out.println("|5. Tim san pham                            |");
			System.out.println("|0. Quay lai                                |");
			System.out.println("+-------------------------------------------+");
			System.out.print("Nhap thao tac: ");
			select = sc.nextInt();
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
		for (int i = 0; i < size; i++) {
			dsctdh[i].xuat();
		}

	}

	public void XuatTronGDonHang(String id) {
		DocFile();
		for (int i = 0; i < size; i++) {
			if (dsctdh[i].getDonHang_id().equalsIgnoreCase(id))
				dsctdh[i].xuat();
		}

	}

	@Override
	public void Xoa() {
		// TODO Auto-generated method stub

	}

	// public void nhap(String id) {
	// System.out.println("Nhap so luong san pham: ");
	// int slnv = sc.nextInt();
	// for (int i = size; i < size + slnv; i++) {
	// dsctdh[i] = new ChiTietDonHang(id);
	// System.out.println("---------Nhap thong tin-----------");
	// dsctdh[i].nhap(donHang_id);
	// System.out.println("Them nhan vien thanh cong");
	// }
	// size += slnv;
	// GhiFile();

	// }

	@Override
	public void Tao() {
		System.out.println("Nhap so luong san pham: ");
		int slnv = sc.nextInt();
		for (int i = size; i < size + slnv; i++) {
			dsctdh[i] = new ChiTietDonHang();
			System.out.println("---------Nhap thong tin-----------");
			dsctdh[i].nhap(donHang_id);
			System.out.println("Them nhan vien thanh cong");
		}
		size += slnv;
		GhiFile();

	}

	@Override
	public void TimKiem() {
		// TODO Auto-generated method stub

	}

	@Override
	public void GhiFile() {
		try {
			FileWriter fw = new FileWriter(".\\database\\DSChiTietDonHang.txt", false);
			BufferedWriter bw = new BufferedWriter(fw);
			PrintWriter pw = new PrintWriter(bw);
			for (int i = 0; i < size; i++) {
				pw.println(dsctdh[i].getId() + "|"
						+ dsctdh[i].getDonHang_id() + "|"
						+ dsctdh[i].getSanPham_id() + "|"
						+ dsctdh[i].getSoLuong() + "|"
						+ dsctdh[i].getThanhTien());
			}
			bw.close();
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
			try {
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
					dsctdh[i] = new ChiTietDonHang(id, donHang_id, sanPham_id, soLuong, thanhTien);
					i++;
				}
			} finally {
				size = i;
				br.close();
			}

		} catch (Exception e) {
			System.out.println("Loi khong doc dc file");
		}

	}

	@Override
	public void Sua() {
		// TODO Auto-generated metho d stub

	}

	public double thanhTien(String id) {
		double s = 0;
		for (int i = 0; i < size; i++) {
			if (id.equalsIgnoreCase(dsctdh[i].getDonHang_id())) {
				s += dsctdh[i].getThanhTien();
			}
		}
		return s;
	}

	public double tongTien(String id) {
		DocFile();
		double s = 0;
		for (int i = 0; i < size; i++) {
			if (id.equalsIgnoreCase(dsctdh[i].getDonHang_id())) {
				s += dsctdh[i].getThanhTien();
			}
		}
		return s;
	}
}
