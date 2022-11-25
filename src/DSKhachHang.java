
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

import javax.print.Doc;

import Function.Check;

public class DSKhachHang implements ThaoTac {
	private int sttLast = 0;
	private static int size = 0;
	private KhachHang[] dskh = new KhachHang[0];
	static Scanner sc = new Scanner(System.in);

	public DSKhachHang() {
	}

	public KhachHang[] getKh() {
		return dskh;
	}

	public void setKh(KhachHang[] Kh) {
		this.dskh = Kh;
	}

	@Override
	public void Tao() {
		System.out.println("Nhap so luong khach hang can them: ");
		int sl = 0;
		for (;;) {
			if (sl > 0) {
				break;
			}
			sl = Check.checkInputDigit();
		}
		int arrLength = dskh.length;
		dskh = Arrays.copyOf(dskh, dskh.length + sl);

		for (int i = arrLength; i < arrLength + sl; i++) {
			dskh[i] = new KhachHang();
			System.out.println("---------Nhap thong tin-----------");
			dskh[i].setId(sttLast++);
			dskh[i].nhap();
			System.out.println("Them khach hang thanh cong");
		}
		size += sl;
		GhiFile();
	}

	@Override
	public void Xuat() {
		System.out.println(
				"+----------------------------------------------------------   DANH SACH KHACH HANG  --------------------------------------------+");
		System.out.println(
				"|  ID        HO VA TEN                GIOI TINH      DIA CHI        NGAY SINH      EMAIL          SDT            LOAI           |");
		System.out.println(
				"+-------------------------------------------------------------------------------------------------------------------------------+");
		for (int i = 0; i < size; i++) {
			dskh[i].xuat();
		}
		System.out.println(
				"+-------------------------------------------------------------------------------------------------------------------------------+");
	}

	@Override
	public void Xoa() {
		System.out.print("Nhap ID nhan vien can xoa : ");
		String id = sc.nextLine();
		boolean flag = false;
		for (int i = 0; i < size; i++) {
			if (id.equalsIgnoreCase(dskh[i].getId())) {
				KhachHang[] tam = new KhachHang[size - 1];
				for (int j = 0, k = 0; j < size; j++) { 
					if (id.equalsIgnoreCase(dskh[j].getId())) {
						continue;
					}
					tam[k++] = dskh[j];
				}
				dskh = Arrays.copyOf(tam, tam.length);
				flag = true;
				System.out.println("Da xoa thanh cong!");
				size--;
				break;
			}
		}

		if (flag == false) {
			System.out.println("Khong co nhan vien de xoa");
		}
		DocFile();

	}

	@Override
	public void XuatMenu() {
		DocFile();
		int select = 0;
		do {
			System.out.println("+------------ Chon thao tac -------------+");
			System.out.println("|1. Them khach hang moi                  |");
			System.out.println("|2. Xuat danh sach khach hang            |");
			System.out.println("|3. Xoa khach hang                       |");
			System.out.println("|4. Sua khach hang                       |");
			System.out.println("|5. Tim khach hang                       |");
			System.out.println("|0. Quay lai                             |");
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
			case 0:
				break;
			default:
				System.out.println("Nhap sai thao tac, xin nhap lai !!!");

			}

		} while (select != 0);

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
			for (int i = 0; i < size; i++) {
				if (dskh[i].getId().equalsIgnoreCase(id)) {
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
			System.out.println("|7. Sua chuc vu                                       |");
			System.out.println("|8. Sua luong                                         |");
			System.out.println("|9. Sua tat ca                                        |");
			System.out.println("|0. Quay lai                                          |");
			System.out.println("+-----------------------------------------------------+");
			System.out.print("Nhap thao tac : ");
			try {

				int select = Integer.parseInt(sc.nextLine());

				switch (select) {

				case 1: {
					System.out.print("Nhap ho va ten nhan vien moi : ");
					String tenMoi = sc.nextLine();
					dskh[pos].setHoVaTen(tenMoi);
					System.out.println("Da sua thanh cong!");
					// tam.xuat();
					dskh[pos].xuat();
					GhiFile();
					break;
				}
				case 2: {
					System.out.print("Nhap gioi tinh nhan vien moi: ");
					String tenMoi = sc.nextLine();
					dskh[pos].setGioiTinh(tenMoi);
					System.out.println("Da sua thanh cong!");
					dskh[pos].xuat();
					GhiFile();
					break;
				}
				case 3: {
					System.out.print("Nhap dia chi nhan vien moi : ");
					String tenMoi = sc.nextLine();
					dskh[pos].setDiaChi(tenMoi);
					System.out.println("Da sua thanh cong!");
					dskh[pos].xuat();
					GhiFile();
					break;
				}
				case 4: {
					System.out.print("Nhap ngay sinh nhan vien moi : ");
					// String tenMoi = sc.nextLine();
					// tam.setNgaySinh(tenMoi);
					System.out.println("Da sua thanh cong!");
					dskh[pos].xuat();
					GhiFile();
					break;
				}
				case 5: {
					System.out.print("Nhap Email nhan vien moi : ");
					String tenMoi = sc.nextLine();
					dskh[pos].setEmail(tenMoi);
					System.out.println("Da sua thanh cong!");
					dskh[pos].xuat();
					GhiFile();
					break;
				}
				case 6: {
					System.out.print("Nhap so dien thoai nhan vien moi : ");
					String tenMoi = sc.nextLine();
					dskh[pos].setSdt(tenMoi);
					System.out.println("Da sua thanh cong!");
					dskh[pos].xuat();
					GhiFile();
					break;
				}
				case 7: {
					System.out.print("Nhap chuc vu nhan vien moi : ");
					String tenMoi = sc.nextLine();
					((KhachHang) dskh[pos]).setthuocNhom(tenMoi);
					System.out.println("Da sua thanh cong!");
					dskh[pos].xuat();
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
		System.out.println("+-------------- Chon thao tac tim kiem --------------+");
		System.out.println("|1. Tim cua hang theo ID                             |");
		System.out.println("|2. Tim cua  hang theo ten                           |");
		System.out.println("|0. Quay lai                                         |");
		System.out.println("+----------------------------------------------------+");
		System.out.print("Nhap thao tac : ");
		int select = sc.nextInt();
		switch (select) {
		case 1: {
			System.out.print("Nhap ID cua hang can tim: ");
			sc.nextLine();
			String id = sc.nextLine();
			boolean flag = false;
			for (int i = 0; i < size; i++) {
				if (id.equalsIgnoreCase(dskh[i].getId())) {
					dskh[i].xuat();
					flag = true;

				}
			}
			if (flag == false) {
				System.out.println("Khong tim thay cua hang");
			}
			break;
		}
		case 2: {
			System.out.print("Nhap ten cua hang can tim: ");
			sc.nextLine();
			String input = sc.nextLine();
			boolean flag = false;
			for (int i = 0; i < size; i++) {
				if ((dskh[i].getHoVaTen().toLowerCase().contains(input.toLowerCase()))) {
					dskh[i].xuat();
					flag = true;

				}
			}
			if (flag == false) {
				System.out.println("Khong tim thay cua hang");
			}
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
			FileReader fr = new FileReader(".\\database\\DSKhachHang.txt");
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
				String thuocNhom = txt[7];

				String idTam = id.replaceAll("\\D+", "");
				sttLast = Integer.parseInt(idTam);
				dskh = Arrays.copyOf(dskh, dskh.length + 1);
				dskh[i] = new KhachHang(id, ten, diachi, gioiTinh, ngaySinh, thuocNhom, e, sdt);
				i++;
			}
			size = i;
			br.close();
			fr.close();
		} catch (Exception e) {
			System.out.println("Loi khong doc dc file");
		}

	}

	@Override
	public void GhiFile() {
		try {
			FileWriter fw = new FileWriter(".\\database\\DSKhachHang.txt", false);
			BufferedWriter bw = new BufferedWriter(fw);
			try(PrintWriter pw = new PrintWriter(bw)) {
				for (int i = 0; i < size; i++) {
					pw.println(dskh[i].getId() + "|" + dskh[i].getHoVaTen() + "|" + dskh[i].getGioiTinh() + "|"
							+ dskh[i].getDiaChi() + "|" + dskh[i].ngaySinh.toString() + "|" + dskh[i].getEmail() + "|"
							+ dskh[i].getSdt() + "|" + dskh[i].getthuocNhom());
				}
				pw.close();
			} finally {
				
				fw.close();
				bw.close();
			}

		} catch (IOException e) {
			System.out.println("Loi khong ghi dc file khach hang");
		}

	}

	public boolean checkKhachHangTonTai(String id) {
		DocFile();
		for (int i = 0; i < size; i++) {
			System.out.println((dskh[i].getId()));
			if (id.equalsIgnoreCase(dskh[i].getId())) {
				return true;
			}
		}
		return false;
	}
	public KhachHang timKhachHang(String id) {
		DocFile();
		for(int i =0; i < size;  i++) {
			if( dskh[i].getId().equalsIgnoreCase(id)) {
				return dskh[i];
			}
		}
		return null;
	}
}
