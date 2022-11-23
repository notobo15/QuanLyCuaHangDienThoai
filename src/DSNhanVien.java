import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

import Function.Check;

public class DSNhanVien implements ThaoTac {
	private static int stt = 0;
	// public NhanVien[] nv = new NhanVien[1000];
	public NhanVien[] nv = new NhanVien[0];
	static Scanner sc = new Scanner(System.in);

	public DSNhanVien() {
	}

	public double getGia(String id) {
		for (int i = 0; i < nv.length; i++) {
			if (id.equalsIgnoreCase(nv[i].getId())) {
				return ((NhanVien) nv[i]).getluongCB();
			}
		}
		return 0;
	}

	public String getTenNhanVien(String id) {
		DocFile();
		for (int i = 0; i < nv.length; i++) {
			if (id.equalsIgnoreCase(nv[i].getId())) {
				return nv[i].getHoVaTen();
			}
		}
		return "err";
	}

	@Override
	public void Tao() {
		System.out.println("Nhap so luong nhan vien can them: ");
		int sl = 0;
		sl = Check.checkInputDigitDuong();
		int arrLength = nv.length;
		nv = Arrays.copyOf(nv, nv.length + sl);
		for (int i = arrLength; i < arrLength + sl; i++) {
			boolean isCheck = false;
			do {
				System.out.println("1. Tao nhan vien thu nhan");
				System.out.println("2. Tao nhan vien ban hang");
				int chon = Check.checkInputDigitDuong();
				switch (chon) {
				case 1: {
					nv[i] = new NVThuNgan();
					isCheck = true;
					break;
				}
				case 2: {
					nv[i] = new NVBanHang();
					isCheck = true;
					break;
				}
				default: {
					System.out.println("Nhap sai thao tac");
				}
				}
			} while (isCheck != true);
			System.out.println("Nhap thong tin cua hang");
			nv[i].setId(stt++);
			nv[i].nhap();
		}
		GhiFile();
	}

	@Override
	public void Xuat() {

		System.out.println(
				"+----------------------------------------------------------   DANH SACH NHAN VIEN   -----------------------------------------------------------+");
		System.out.println(
				"|  ID        HO VA TEN                GIOI TINH      DIA CHI        NGAY SINH      EMAIL          SDT            CHUC VU        LUONG          |");
		System.out.println(
				"+----------------------------------------------------------------------------------------------------------------------------------------------+");
		for (int i = 0; i < nv.length; i++) {
			if (nv[i] instanceof NVBanHang) {
				((NVBanHang) nv[i]).xuat();

			} else {
				((NVThuNgan) nv[i]).xuat();
			}
		}
		System.out.println(
				"+----------------------------------------------------------------------------------------------------------------------------------------------+");

	}

	@Override
	public void Xoa() {
		System.out.print("Nhap ID nhan vien can xoa : ");
		String id = sc.nextLine();
		boolean flag = false;
		System.out.println(nv.length);
		for (int i = 0; i < nv.length; i++) {
			if (id.equalsIgnoreCase(nv[i].getId())) {

				if (i != nv.length - 1) {
					for (int j = i; j < nv.length - 1; j++) {
						nv[j] = nv[j + 1];
					}

				} else {
					nv[i] = null;
				}
				nv = Arrays.copyOf(nv, nv.length - 1);
				flag = true;
				System.out.println("Da xoa thanh cong!");

			}
		}
		GhiFile();

		if (flag == false) {
			System.out.println("Khong co cua hang de xoa");
		}


	}

	@Override
	public void XuatMenu() {
		DocFile();
		int select;
			do {
				System.out.println("+------------ Chon thao tac -------------+");
				System.out.println("1. Them nhan vien moi                    |");
				System.out.println("2. Xuat danh sach nhan vien              |");
				System.out.println("3. Xoa nhan vien                         |");
				System.out.println("4. Sua nhan vien                         |");
				System.out.println("5. Tim nhan vien                         |");
				System.out.println("0. Quay lai                              |");
				System.out.println("+----------------------------------------+");
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
					System.out.println("Ban da nhap sai thao tac!!!\nXIN VUI LONG NHAP LAI");
				}
			} while (select != 0);

	}

	@Override
	public void Sua() {
		String id = "";
		System.out.println("Nhap ID cua NHAN VIEN ban muon sua?");
		System.out.println("0. Quay lai");
		System.out.print("Moi ban nhap: ");
		int pos = 0;
		sc.nextLine();
		id = sc.nextLine();
		boolean timThay = false;
		for (;;) {
			for (int i = 0; i < nv.length; i++) {
				System.out.println(nv[i].getId().equalsIgnoreCase(id));
				if (nv[i].getId().equalsIgnoreCase(id)) {
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
			nv[pos].xuat();
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
			System.out.println("|9. Sua so gio lam                                    |");
			System.out.println("|10. Sua phu cap                                      |");
			System.out.println("|11. Sua tat ca                                       |");
			System.out.println("|0. Quay lai                                          |");
			System.out.println("+-----------------------------------------------------+");
			System.out.print("Nhap thao tac : ");
			try {

				int select = Integer.parseInt(sc.nextLine());

				switch (select) {

				case 1: {
					System.out.print("Nhap ho va ten nhan vien moi : ");
					String tenMoi = sc.nextLine();
					nv[pos].setHoVaTen(tenMoi);
					System.out.println("Da sua thanh cong!");
					// tam.xuat();
					nv[pos].xuat();
					GhiFile();
					break;
				}
				case 2: {
					System.out.print("Nhap gioi tinh nhan vien moi: ");
					String tenMoi = sc.nextLine();
					nv[pos].setGioiTinh(tenMoi);
					System.out.println("Da sua thanh cong!");
					nv[pos].xuat();
					GhiFile();
					break;
				}
				case 3: {
					System.out.print("Nhap dia chi nhan vien moi : ");
					String tenMoi = sc.nextLine();
					nv[pos].setDiaChi(tenMoi);
					System.out.println("Da sua thanh cong!");
					nv[pos].xuat();
					GhiFile();
					break;
				}
				case 4: {
					System.out.print("Nhap ngay sinh nhan vien moi : ");
					// String tenMoi = sc.nextLine();
					// tam.setNgaySinh(tenMoi);
					System.out.println("Da sua thanh cong!");
					nv[pos].xuat();
					GhiFile();
					break;
				}
				case 5: {
					System.out.print("Nhap Email nhan vien moi : ");
					String tenMoi = sc.nextLine();
					nv[pos].setEmail(tenMoi);
					System.out.println("Da sua thanh cong!");
					nv[pos].xuat();
					GhiFile();
					break;
				}
				case 6: {
					System.out.print("Nhap so dien thoai nhan vien moi : ");
					String tenMoi = sc.nextLine();
					nv[pos].setSdt(tenMoi);
					System.out.println("Da sua thanh cong!");
					nv[pos].xuat();
					GhiFile();
					break;
				}
				case 7: {
					System.out.print("Nhap chuc vu nhan vien moi : ");
					Double input = Double.parseDouble(sc.nextLine());
					((NhanVien) nv[pos]).setluongCB(input);
					System.out.println("Da sua thanh cong!");
					nv[pos].xuat();
					GhiFile();
					break;
				}
				case 8: {
					System.out.print("Nhap luong nhan vien moi : ");
					Float input = Float.parseFloat(sc.nextLine());
					if(nv[pos] instanceof NVThuNgan) {
						((NVThuNgan)nv[pos]).setSoNgayLam(input);
						System.out.println("Da sua thanh cong!");
						nv[pos].xuat();
						GhiFile();
						break;
						
					} else {
						System.out.println("Khong phai la nhan vien thu ngan");
					}
				}
				case 9: {
					System.out.print("Nhap luong nhan vien moi : ");
					Float input = Float.parseFloat(sc.nextLine());
					if(nv[pos] instanceof NVBanHang) {
						((NVBanHang)nv[pos]).setSoGioLam(input);
						System.out.println("Da sua thanh cong!");
						nv[pos].xuat();
						GhiFile();
						break;
						
					} else {
						System.out.println("Khong phai la nhan vien thu ngan");
						break;
					}
				}
				case 10: {
					System.out.print("Nhap luong nhan vien moi : ");
					Double input = Double.parseDouble(sc.nextLine());
					if(nv[pos] instanceof NVBanHang) {
						((NVBanHang)nv[pos]).setPhuCap(input);
						System.out.println("Da sua thanh cong!");
						nv[pos].xuat();
						GhiFile();
						break;
						
					} else {
						System.out.println("Khong phai la nhan vien thu ngan");
						break;
					}
				}
				case 11: {
					nv[pos].nhap();
					System.out.println("Da sua thanh cong!");
					System.out.println(
							"ID\tHO VA TEN\t\t\tGIOI TINH\tDIA CHI\t\tNGAY SINH\tEMAIL\t\tSDT\t\tNhom\t\tLuong");
					for (int i = 0; i <= 140; i++) {
						System.out.print("-");
					}
					System.out.println();
					nv[pos].xuat();
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

	@Override
	public void TimKiem() {
		System.out.println("+-------------- Chon thao tac tim kiem -------------+");
		System.out.println("|1. Tim nhan vien theo ID                           |");
		System.out.println("|2. Tim nhan vien theo ten                          |");
		System.out.println("|0. Quay lai                                        |");
		System.out.println("+---------------------------------------------------+");
		System.out.print("Nhap thao tac : ");
		try {

			int select = sc.nextInt();
			switch (select) {
			case 1: {
				sc = new Scanner(System.in);
				System.out.print("Nhap ID nhan vien can tim: ");
				String id = sc.nextLine();
				id.toLowerCase();
				boolean flag = false;
				System.out.println(
						"ID\tHO VA TEN\t\t\tGIOI TINH\tDIA CHI\t\tNGAY SINH\tEMAIL\t\tSDT\t\tCHUC VU\t\tLUONG");
				for (int j = 0; j <= 140; j++)
					System.out.print("-");
				System.out.println();
				for (int i = 0; i < nv.length; i++) {
					if (id.equals(nv[i].getId().toLowerCase())) {

						nv[i].xuat();
						flag = true;

					}
				}
				if (flag == false) {
					System.out.println("Khong tim thay nhan vien");
				}
				break;
			}
			case 2: {
				sc = new Scanner(System.in);
				System.out.print("Nhap ho va ten nhan vien can tim: ");
				String fullName = sc.nextLine();
				String toLowerCase = fullName.toLowerCase();
				boolean flag = false;
				System.out.println(
						"ID\tHO VA TEN\t\t\tGIOI TINH\tDIA CHI\t\tNGAY SINH\tEMAIL\t\tSDT\t\tCHUC VU\t\tLUONG");
				for (int j = 0; j <= 140; j++)
					System.out.print("-");
				System.out.println();
				for (int i = 0; i < nv.length; i++) {
					if ((nv[i].getHoVaTen().toLowerCase().contains(toLowerCase))) {

						nv[i].xuat();
						flag = true;

					}
				}
				if (flag == false) {
					System.out.println("Khong tim thay nhan vien");
				}
			}
			case 0:
				break;
			default:
				System.out.println("Nhap sai thao tac, xin nhap lai !!!");

			}
		} catch (Exception e) {
			System.out.println("BAN CHI DUOC NHAP SO!!!\nXIN VUI LONG NHAP LAI");
		}

	}

	

	@Override
	public void DocFile() {
		int i = 0;
		try {
			FileReader fr2 = new FileReader(".\\database\\DSNhanVien.txt");
			BufferedReader br2 = new BufferedReader(fr2);
			try {
				String line = "";
				while (true) {
					line = br2.readLine();
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
					String tenCV = txt[7];
					double luong = Double.parseDouble(txt[8]);
					String catID = id.replaceAll("\\D+", "");
					stt = Integer.parseInt(catID);
					if (tenCV.contains("Thu Ngan")) {
						float soNgayLam = Float.parseFloat(txt[9]);
						nv = Arrays.copyOf(nv, nv.length + 1);
						nv[i] = new NVThuNgan(id, ten, diachi, gioiTinh, ngaySinh,e,sdt,tenCV, luong,   soNgayLam);
					} else {
						float soGioLam = Float.parseFloat(txt[9]);
						double phuCap = Double.parseDouble(txt[10]);
						nv = Arrays.copyOf(nv, nv.length + 1);
						nv[i] = new NVBanHang(id, ten,gioiTinh, diachi, ngaySinh, e, sdt, tenCV, luong, soGioLam,  phuCap);
					}
					i++;
				}
			} finally {
				br2.close();

			}

		} catch (

		Exception e) {
			System.out.println("Loi khong doc dc file");
		}

	}

	// public static NhanVien[] add(int n, NhanVien myarray[], NhanVien ele) {
	// int i;
	// NhanVien newArray[] = new NhanVien[n + 1];
	// // copy original array into new array
	// for (i = 0; i < n; i++)
	// newArray[i] = myarray[i];

	// // add element to the new array
	// newArray[n] = ele;

	// return newArray;
	// }

	@Override
	public void GhiFile() {
		try {
			FileWriter fw = new FileWriter(".\\database\\DSNhanVien.txt", false);
			BufferedWriter bw = new BufferedWriter(fw);
			PrintWriter pw = new PrintWriter(bw);

			for (int i = 0; i < nv.length; i++) {
				if (nv[i].getTenChucVu().contains("Thu Ngan")) {
					pw.println((nv[i]).getId() + "|" 
				+ (nv[i]).getHoVaTen() + "|" 
				+ (nv[i]).getGioiTinh() + "|"
				+ (nv[i]).getDiaChi() + "|" 
				+ (nv[i]).ngaySinh.toString() + "|" 
				+ (nv[i]).getEmail() + "|"
				+ (nv[i]).getSdt() + "|" 
				+(nv[i]).getTenChucVu() + "|" 
				+ (nv[i]).getluongCB() + "|" 
				+ ((NVThuNgan) nv[i]).getSoNgayLam());
				} else {
					pw.println((nv[i]).getId() + "|" 
				+ (nv[i]).getHoVaTen() + "|" 
				+ (nv[i]).getGioiTinh() + "|"
				+ (nv[i]).getDiaChi() + "|" 
				+ (nv[i]).ngaySinh.toString() + "|"
				+ (nv[i]).getEmail() + "|"
				+ (nv[i]).getSdt() + "|"
				+(nv[i]).getTenChucVu() + "|" 
				+ (nv[i]).getluongCB() + "|" 
				+ ((NVBanHang) nv[i]).getSoGioLam()+ "|" 
				+ ((NVBanHang) nv[i]).getPhuCap());
				}
			}
			bw.close();
		} catch (IOException e) {
			System.out.println("Loi khong ghi dc file");
		}

	}


}
