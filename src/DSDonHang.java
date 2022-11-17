
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class DSDonHang implements ThaoTac {
	private static int size = 0;
	public DonHang[] dsdh;
	static Scanner sc = new Scanner(System.in);

	public DSDonHang() {
	}

	public void timDodaiMang() {
		int n = 0;
		try {
			FileReader fr = new FileReader(".\\database\\DSNhanVien.txt");
			BufferedReader br = new BufferedReader(fr);
			try {
				String l = "";
				while (true) {
					l = br.readLine();
					if (l == null) {
						break;
					}
					n++;
				}

			} finally {
				this.dsdh = new DonHang[n];
				br.close();

			}
		} catch (Exception e) {
			System.out.println("loi");
		}
		size = n;
	}

	@Override
	public void XuatMenu() {
		timDodaiMang();
		DocFile();
		int select = 0;
		do {
			System.out.println("+-------------- Chon thao tac --------------+");
			System.out.println("|1. Them don hang moi                       |");
			System.out.println("|2. Xuat danh sach don hang                 |");
			System.out.println("|3. Xoa don hang                            |");
			System.out.println("|4. Sua don hang                            |");
			System.out.println("|5. Tim don hang                            |");
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
	public void Tao() {
		DonHang[] tam = new DonHang[size];
		for (int i = 0; i < size; i++) {
			tam[i] = dsdh[i];
		}
		System.out.println("Nhap so luong don hang can them: ");
		int slnv = sc.nextInt();
		dsdh = new DonHang[size + slnv];
		for (int i = 0; i < size; i++) {
			dsdh[i] = tam[i];
		}

		for (int i = size; i < size + slnv; i++) {
			dsdh[i] = new DonHang();
			System.out.println("---------Nhap thong tin-----------");
			dsdh[i].nhap();
			System.out.println("Them don hang thanh cong");
		}
		size += slnv;
		GhiFile();

	}

	@Override
	public void TimKiem() {
		// TODO Auto-generated method stub

	}

	@Override
	public void Sua() {
		// TODO Auto-generated method stub

	}

	@Override
	public void Xuat() {
		System.out
				.println(
						"+---------------------------------------------------   DANH SACH DON HANG   ----------------------------------------------------+");
		System.out.println(
				"|  ID        TEN KHACH HANG      TEN THU NGAN        CUA HANG ID         HTTT           NGAY MUA HANG            TONG TIEN      |");
		System.out
				.println(
						"+-------------------------------------------------------------------------------------------------------------------------------+");
		for (int i = 0; i < size; i++) {
			dsdh[i].xuat();
		}
		// System.out
		// .println(
		// "+-------------------------------------------------------------------------------------------------------------------------------+");
	}

	@Override
	public void Xoa() {
		// TODO Auto-generated method stub

	}

	@Override
	public void GhiFile() {
		try {
			FileWriter fw = new FileWriter(".\\database\\DSDonHang.txt", false);
			BufferedWriter bw = new BufferedWriter(fw);
			PrintWriter pw = new PrintWriter(bw);
			for (int i = 0; i < size; i++) {
				pw.println(dsdh[i].getId() + "|"
						+ dsdh[i].getKhachHang_id() + "|"
						+ dsdh[i].getthuNgan_id() + "|"
						+ dsdh[i].getCuaHang_id() + "|"
						+ dsdh[i].getDate() + "|"
						+ dsdh[i].getHinhThucThanhToan() + "|"
						+ dsdh[i].getTongTien());
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
			FileReader fr = new FileReader(".\\database\\DSDonHang.txt");
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
					String khachHang_id = txt[1];
					String thuNgan_id = txt[2];
					String cuaHang_id = txt[3];
					String date = txt[4];
					String hinhThucThanhToan = txt[5];
					double thanhTien = Double.parseDouble(txt[6]);
					dsdh[i] = new DonHang(id, khachHang_id, thuNgan_id, cuaHang_id, date, hinhThucThanhToan, thanhTien);
					i++;
				}
			} finally {
				size = i;
				br.close();
			}
		}

		catch (Exception e) {
			System.out.println("Loi khong doc dc file danh sach don hang");
		}

	}
}
