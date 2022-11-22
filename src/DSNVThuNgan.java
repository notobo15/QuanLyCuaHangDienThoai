import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

import Function.Check;

public class DSNVThuNgan implements ThaoTac {
	private static int stt;
	public NVThuNgan[] dsnvtn = new NVThuNgan[0];
	static Scanner sc = new Scanner(System.in);

	public DSNVThuNgan() {
		super();
	}

	@Override
	public void XuatMenu() {
		DocFile();
		int select = 0;
		do {
			System.out.println("+------------ Chon thao tac -------------+");
			System.out.println("1. Them nhan vien moi                    |");
			System.out.println("2. Xuat danh sach nhan vien              |");
			System.out.println("3. Xoa nhan vien                         |");
			System.out.println("4. Sua nhan vien                         |");
			System.out.println("5. Tim nhan vien                         |");
			System.out.println("6. Tinh luong nhan vien                  |");
			System.out.println("0. Quay lai                              |");
			System.out.println("+----------------------------------------+");
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
				case 6:
					TinhLuong();
					break;
				case 0:
					break;
				default:
					System.out.println("Ban da nhap sai thao tac!!!\nXIN VUI LONG NHAP LAI");
			}
		} while (select != 0);

	}

	@Override
	public void Xuat() {
		System.out.println(
				"+----------------------------------------------------------   DANH SACH NHAN VIEN   -----------------------------------------------------------+");
		System.out.println(
				"|  ID        HO VA TEN                GIOI TINH      DIA CHI        NGAY SINH      EMAIL          SDT            LUONGCB        SO NGAY LAM    |");
		System.out.println(
				"+----------------------------------------------------------------------------------------------------------------------------------------------+");
		for (int i = 0; i < dsnvtn.length; i++) {
			dsnvtn[i].xuat();
		}
		System.out.println(
				"+----------------------------------------------------------------------------------------------------------------------------------------------+");

	}

	@Override
	public void Xoa() {
		System.out.print("Nhap ID nhan vien can xoa : ");
		String id = sc.nextLine();
		boolean flag = false;
		for (int i = 0; i < dsnvtn.length; i++) {
			if (id.equalsIgnoreCase(dsnvtn[i].getId())) {
				if (i != dsnvtn.length - 1) {
					for (int j = i; j < dsnvtn.length - 1; j++) {
						dsnvtn[j] = dsnvtn[j + 1];
					}
				} else {
					dsnvtn[i] = null;
				}
				flag = true;
				dsnvtn = Arrays.copyOf(dsnvtn, dsnvtn.length - 1);
				System.out.println("Da xoa thanh cong!");
			}
		}

		if (flag == false) {
			System.out.println("Khong khong tim thay nhan ");
		}
		System.out.println(dsnvtn.length);
		GhiFile();
	}

	@Override
	public void Tao() {
		System.out.println("Nhap so luong nhan vien can them: ");
		int sl = 0;
		for (;;) {
			if (sl > 0) {
				break;
			}
			sl = Check.checkInputDigit();
		}
		int arrLength = dsnvtn.length;
		dsnvtn = Arrays.copyOf(dsnvtn, dsnvtn.length + sl);

		for (int i = arrLength; i < arrLength + sl; i++) {
			dsnvtn[i] = new NVThuNgan();
			System.out.println("---------Nhap thong tin-----------");
			dsnvtn[i].setId(stt++);
			dsnvtn[i].nhap();
			System.out.println("Them don hang thanh cong");
		}
		GhiFile();

	}

	@Override
	public void TimKiem() {

		DocFile();
		int select;
		System.out.println("+------------- Chon thao tac tim kiem -------------+");
		System.out.println("|1. Tim cua hang theo ID                           |");
		System.out.println("|0. Quay lai                                       |");
		System.out.println("+--------------------------------------------------+");
		System.out.print("Nhap thao tac : ");

		select = sc.nextInt();

		switch (select) {
			case 1: {
				System.out.print("Nhap ID nhan vien can tim: ");
				sc.nextLine();
				String id = sc.nextLine();
				boolean flag = false;
				for (int i = 0; i < dsnvtn.length; i++) {
					if (id.equalsIgnoreCase(dsnvtn[i].getId())) {
						System.out.println(
								"+----------------------------------------------------------   DANH SACH NHAN VIEN   -----------------------------------------------------------+");
						System.out.println(
								"|  ID        HO VA TEN                GIOI TINH      DIA CHI        NGAY SINH      EMAIL          SDT            LUONGCB        SO NGAY LAM    |");
						System.out.println(
								"+----------------------------------------------------------------------------------------------------------------------------------------------+");
						dsnvtn[i].xuat();
						flag = true;

					}
				}
				if (flag == false) {
					System.out.println("Khong tim thay cua hang");
				}
				break;
			}

			case 0:
				break;
			default:
				System.out.println("Nhap sai thao tac, xin nhap lai !!!");
		}
	}

	@Override
	public void DocFile() {
		int i = 0;
		try {
			FileReader fr = new FileReader(".\\database\\DSNVThuNgan.txt");
			BufferedReader br = new BufferedReader(fr);
			String line = "";
			while (true) {
				line = br.readLine();
				if (line == null) {
					break;
				}
				String txt[] = line.split("\\|");
				String id = txt[0];
				String ten = txt[1];
				String gioiTinh = txt[2];
				String diachi = txt[3];
				String date = txt[4];
				String tam[] = date.split("\\/");
				int ngay = Integer.parseInt(tam[0]);
				int thang = Integer.parseInt(tam[1]);
				int nam = Integer.parseInt(tam[2]);
				Date ngaySinh = new Date(ngay, thang, nam);
				String e = txt[5];
				String sdt = txt[6];
				double luong = Double.parseDouble(txt[7]);
				Float soNgayLam = Float.parseFloat(txt[8]);
				String catID = id.replaceAll("\\D+", "");
				stt = Integer.parseInt(catID);

				dsnvtn = Arrays.copyOf(dsnvtn, dsnvtn.length + 1);
				dsnvtn[i] = new NVThuNgan(id, ten, diachi, gioiTinh, ngaySinh, luong, e, sdt, soNgayLam);
				i++;
			}
			br.close();
			fr.close();
		} catch (

		Exception e) {
			System.out.println("Loi khong doc dc file");
		}

	}

	@Override
	public void GhiFile() {
		try {
			FileWriter fw = new FileWriter(".\\database\\DSNVThuNgan.txt", false);
			BufferedWriter bw = new BufferedWriter(fw);
			PrintWriter pw = new PrintWriter(bw);
			for (int i = 0; i < dsnvtn.length; i++) {
				pw.println((dsnvtn[i]).getId() + "|"
						+ (dsnvtn[i]).getHoVaTen() + "|"
						+ (dsnvtn[i]).getGioiTinh() + "|"
						+ (dsnvtn[i]).getDiaChi() + "|"
						+ (dsnvtn[i]).ngaySinh.toString() + "|"
						+ (dsnvtn[i]).getEmail() + "|"
						+ (dsnvtn[i]).getSdt() + "|"
						+ (dsnvtn[i]).getluongCB() + "|"
						+ (dsnvtn[i]).getSoNgayLam());
			}
			fw.close();
			bw.close();
			pw.close();
		} catch (IOException e) {
			System.out.println("Loi khong ghi dc file");
		}

	}

	@Override
	public void Sua() {
		DocFile();
		String id = "";
		System.out.println("Nhap ID cua NHAN VIEN ban muon sua?");
		System.out.println("0. Quay lai");
		System.out.print("Moi ban nhap: ");
		sc.nextLine();
		int pos = 0;
		id = sc.nextLine();
		boolean timThay = false;
		for (;;) {
			for (int i = 0; i < dsnvtn.length; i++) {
				if (dsnvtn[i].getId().equalsIgnoreCase(id)) {
					// tam = nv[i];
					pos = i;
					timThay = true;
					break;
				}
			}
			if (timThay == true || id.equalsIgnoreCase("0"))
				break;
			System.out.println("ID KHONG TON TAI moi ban nhap lai!!!");
			System.out.println("0. Quay lai");
			id = sc.nextLine();
		}
		;
		if (timThay == true) {
			System.out.println("ID\tHO VA TEN\t\t\tGIOI TINH\tDIA CHI\t\tNGAY SINH\tEMAIL\t\tSDT\t\tNhom\t\tLuong");
			for (int i = 0; i <= 140; i++) {
				System.out.print("-");
			}
			System.out.println();
			// tam.xuat();
			System.out.println("+------------- Chon thao tac ban muon sua ------------+");
			System.out.println("|1. Sua ho va ten nhan vien                           |");
			System.out.println("|2. Sua gioi tinh                                     |");
			System.out.println("|3. Sua dia chi                                       |");
			System.out.println("|4. Sua ngay sinh                                     |");
			System.out.println("|5. Sua email                                         |");
			System.out.println("|6. Sua so dien thoai                                 |");
			System.out.println("|7. Sua luong co ban                                  |");
			System.out.println("|8. Sua so ngay lam                                   |");
			System.out.println("|9. Sua tat ca                                       |");
			System.out.println("|0. Quay lai                                          |");
			System.out.println("+-----------------------------------------------------+");
			System.out.print("Nhap thao tac : ");
			try {

				int select = Integer.parseInt(sc.nextLine());

				switch (select) {

					case 1: {
						System.out.print("Nhap ho va ten nhan vien moi : ");
						String tenMoi = sc.nextLine();
						dsnvtn[pos].setHoVaTen(tenMoi);
						System.out.println("Da sua thanh cong!");
						dsnvtn[pos].xuat();
						GhiFile();
						break;
					}
					case 2: {
						System.out.print("Nhap gioi tinh nhan vien moi: ");
						String tenMoi = sc.nextLine();
						dsnvtn[pos].setGioiTinh(tenMoi);
						System.out.println("Da sua thanh cong!");
						dsnvtn[pos].xuat();
						GhiFile();
						break;
					}
					case 3: {
						System.out.print("Nhap dia chi nhan vien moi : ");
						String tenMoi = sc.nextLine();
						dsnvtn[pos].setDiaChi(tenMoi);
						System.out.println("Da sua thanh cong!");
						dsnvtn[pos].xuat();
						GhiFile();
						break;
					}
					case 4: {
						System.out.print("Nhap ngay sinh nhan vien moi : ");
						// String tenMoi = sc.nextLine();
						// tam.setNgaySinh(tenMoi);
						System.out.println("Da sua thanh cong!");
						dsnvtn[pos].xuat();
						GhiFile();
						break;
					}
					case 5: {
						System.out.print("Nhap Email nhan vien moi : ");
						String tenMoi = sc.nextLine();
						dsnvtn[pos].setEmail(tenMoi);
						System.out.println("Da sua thanh cong!");
						dsnvtn[pos].xuat();
						GhiFile();
						break;
					}
					case 6: {
						System.out.print("Nhap so dien thoai nhan vien moi : ");
						String tenMoi = sc.nextLine();
						dsnvtn[pos].setSdt(tenMoi);
						System.out.println("Da sua thanh cong!");
						dsnvtn[pos].xuat();
						GhiFile();
						break;
					}
					case 7: {
						System.out.print("Nhap luong co ban nhan vien moi : ");
						String tenMoi = sc.nextLine();
						((NVThuNgan) dsnvtn[pos]).setluongCB(Double.parseDouble(tenMoi));
						System.out.println("Da sua thanh cong!");
						dsnvtn[pos].xuat();
						GhiFile();
						break;
					}
					case 8: {
						System.out.print("Nhap luong nhan vien moi : ");
						String input = sc.nextLine();
						((NVThuNgan) dsnvtn[pos]).setSoNgayLam(Float.parseFloat(input));
						System.out.println("Da sua thanh cong!");
						dsnvtn[pos].xuat();
						GhiFile();
						break;
					}
					case 9: {
						dsnvtn[pos].nhap();
						System.out.println("Da sua thanh cong!");
						GhiFile();
						break;
					}
					case 0:
						break;
					default:
						System.out.println("Nhap sai thao tac, xin nhap lai !!!");

				}
			} catch (Exception e) {
				System.out.println("BAN CHI DUOC NHAP SO.\nMoi ban nhap lai...");
			}
		}
	}

	public void TinhLuong() {
		DocFile();
		System.out.println("Nhap id nhan vien : ");
		sc.nextLine();
		String id = sc.nextLine();
		boolean flag = false;
		for (int i = 0; i < dsnvtn.length; i++) {
			if (dsnvtn[i].getId().equalsIgnoreCase(id)) {
				flag = true;
				System.out.println("Tien luong : " + ((NVThuNgan) dsnvtn[i]).tinhLuong());
				break;
			}
		}
		if (flag == false) {
			System.out.println("Khong tim thay");
		}

	}

	public boolean checkTonTai(String id) {
		DocFile();
		for (int i = 0; i < dsnvtn.length; i++) {
			if (id.equalsIgnoreCase(dsnvtn[i].getId())) {
				return true;
			}
		}
		return false;
	}

}
