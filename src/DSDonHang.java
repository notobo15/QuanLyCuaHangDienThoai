
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

import Function.Check;

public class DSDonHang implements ThaoTac {
	private DonHang[] dsdh = new DonHang[0];
	private static int stt;
	private static int size = 0;
	static Scanner sc = new Scanner(System.in);

	public DSDonHang() {
	}

	@Override
	public void XuatMenu() {
		DocFile();
		int select = 0;
		do {
			System.out.println("+-------------- Chon thao tac --------------+");
			System.out.println("|1. Them don hang moi                       |");
			System.out.println("|2. Xuat danh sach don hang                 |");
			System.out.println("|3. Xoa don hang                            |");
			System.out.println("|4. Sua don hang                            |");
			System.out.println("|5. Tim don hang                            |");
			System.out.println("|6. Xuat hoa don                            |");
			System.out.println("|0. Quay lai                                |");
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
			case 6:
				xuatHoaDon();
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

		System.out.println("Nhap so luong don hang can them: ");
		int sl = 0;
		for (;;) {
			if (sl > 0) {
				break;
			}
			sl = Check.checkInputDigit();
		}
		int arrLength = dsdh.length;
		dsdh = Arrays.copyOf(dsdh, dsdh.length + sl);

		for (int i = arrLength; i < arrLength + sl; i++) {
			dsdh[i] = new DonHang();
			System.out.println("--------- Nhap thong tin -----------");
			dsdh[i].setId(stt++);
			dsdh[i].nhap();
			System.out.println("Them don hang thanh cong");
		}
		size += sl;
		GhiFile();

	}

	@Override
	public void TimKiem() {
		System.out.println("+------------------ Chon thao tac tim kiem ------------------+");
		System.out.println("|1. Tim kiem theo ID don hang                                |");
		System.out.println("|0. Quay lai                                                 |");
		System.out.println("+------------------------------------------------------------+");
		System.out.print("Nhap thao tac : ");
		int select = Check.checkInputDigit();
		switch (select) {
		case 1: {
			sc = new Scanner(System.in);
			System.out.print("Nhap ID don hang can tim: ");
			String id = sc.nextLine();
			boolean flag = false;
			for (int i = 0; i < size; i++) {
				if (id.equalsIgnoreCase(dsdh[i].getId())) {
					dsdh[i].xuat();
					flag = true;

				}
			}
			if (flag == false) {
				System.out.println("Khong tim thay :(");
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
	public void Sua() {
		String id = "";
		int index = 0;
		System.out.println("Nhap ID DON HANG ban muon sua?");
		System.out.println("0. Quay lai");
		System.out.print("Moi ban nhap: ");
		id = sc.nextLine();
		boolean timThay = false;
		for (;;) {
			for (int i = 0; i < size; i++) {
				if (dsdh[i].getId().equalsIgnoreCase(id)) {
					index = i;
					timThay = true;
					break;
				}
			}
			if (timThay == true || id.equalsIgnoreCase("0"))
				break;
			System.out.println("ID KHONG TON TAI !!!");
			System.out.println("0. Quay lai");
			System.out.print("Moi ban nhap lai : ");
			id = sc.nextLine();
		}
		;
		if (timThay == true) {

			dsdh[index].xuat();
			System.out.println("+------------- Chon thao tac ban muon sua ------------+");
			System.out.println("|1. Sua/Thay doi id khach hang                        |");
			System.out.println("|2. Sua/Thay doi id thu ngan                          |");
			System.out.println("|3. Sua/Thay doi id cua hang                          |");
			System.out.println("|4. Sua/Thay doi hinh thuc thanh toan                 |");
			System.out.println("|0. Quay lai                                          |");
			System.out.println("+-----------------------------------------------------+");
			System.out.print("Nhap thao tac : ");

				int select = Check.checkInputDigit();

				switch (select) {

				case 1: {
					System.out.print("Nhap id khach hang moi : ");
					String tenMoi = sc.nextLine();
					dsdh[index].setKhachHang_id(tenMoi);
					System.out.println("Da sua thanh cong!");
					dsdh[index].xuat();
					GhiFile();
					break;
				}
				case 2: {
					System.out.print("Nhap id thu ngan moi : ");
					String tenMoi = sc.nextLine();
					dsdh[index].setthuNgan_id(tenMoi);
					System.out.println("Da sua thanh cong!");
					dsdh[index].xuat();
					GhiFile();
					break;
				}
				case 3: {
					System.out.print("Nhap id cua hang moi : ");
					String tenMoi = sc.nextLine();
					dsdh[index].setCuaHang_id(tenMoi);
					System.out.println("Da sua thanh cong!");
					dsdh[index].xuat();
					GhiFile();
					break;
				}
				case 4: {
					System.out.print("Nhap hinh thuc thanh toan moi : ");
					String tenMoi = sc.nextLine();
					dsdh[index].setHinhThucThanhToan(tenMoi);
					System.out.println("Da sua thanh cong!");
					dsdh[index].xuat();
					GhiFile();
					break;
				}

				case 0:
					break;
				default:
					System.out.println("Nhap sai thao tac, xin nhap lai !!!");

				}
			
		}

	}

	@Override
	public void Xuat() {
		System.out.println(
				"+---------------------------------------------------   DANH SACH DON HANG   ----------------------------------------------------+");
		System.out.println(
				"|  ID        TEN KHACH HANG      TEN THU NGAN        CUA HANG ID         HTTT           NGAY MUA HANG            TONG TIEN      |");
		System.out.println(
				"+-------------------------------------------------------------------------------------------------------------------------------+");
		for (int i = 0; i < size; i++) {
			dsdh[i].xuat();
		}
		// System.out
		// .println(
		// "+-------------------------------------------------------------------------------------------------------------------------------+");
	}

	public void xuatHoaDon() {
		System.out.println("Nhap id don hang : ");
		String id = sc.nextLine();
		for (int i = 0; i < size; i++) {
			if (id.equalsIgnoreCase(dsdh[i].getId())) {
				DSCuaHang dsch = new DSCuaHang();
				CuaHang ch = dsch.timCuaHang(dsdh[i].getCuaHang_id());
				
				
				DSNhanVien dsnv = new DSNhanVien();
				NVThuNgan nv = dsnv.timNVThuNgan(dsdh[i].getthuNgan_id());
				if(nv == null) {
					System.out.println("Nhan vien khong ton tai ! Hay kiem tra lai ...");
				}
				if(ch ==  null ) {
					System.out.println("Cua hang khong ton tai ! Hay kiem tra lai ...");
				}
				System.out.printf("+----------------- PHIEU THANH TOAN -----------------+%n");
				if(ch !=  null ) {
					System.out.printf("| Ten cua hang  : %-35s|%n", ch.getTenCh().toUpperCase());
					System.out.printf("| Dia chi       : %-35s|%n", ch.getDiachi());
					System.out.printf("| SDT           : %-35s|%n", ch.getSdt());
					
				}
				System.out.printf("| ID            : %-35s|%n", dsdh[i].getId());
				System.out.printf("| Ngay tao don  : %-35s|%n", dsdh[i].getDate());
				if(nv != null) {
					System.out.printf("| NV thu ngan   : %-35s|%n", nv.getHoVaTen());
					
				}
				System.out.printf("+- - - - - - - - - - - - - - - - - - - - - - - - - - +%n");
				System.out.printf("| Ten SP          So Luong   Gia ban     Thanh Tien  |%n");
				System.out.printf("+- - - - - - - - - - - - - - - - - - - - - - - - - - +%n");
				DSChiTietDonHang ds = new DSChiTietDonHang();
				ChiTietDonHang dsctdh[];
				dsctdh = ds.dsChiTietDonHang(dsdh[i].getId());

				for (ChiTietDonHang x : dsctdh) {
					DSSanPham dssp = new DSSanPham();
					SanPham sp = dssp.timSanPham(x.getSanPham_id());
					System.out.printf("| %-16s",sp.getTen());
					System.out.printf("%-,11.1f", x.getSoLuong());
					System.out.printf("%-,12.0f", x.getThanhTien() / x.getSoLuong());
					System.out.printf("%-,12.0f|%n", x.getThanhTien());
				}
				System.out.printf("+- - - - - - - - - - - - - - - - - - - - - - - - - - +%n");
				dsdh[i].setTongTien();

				// ds.XuatTronGHoaDon(dsdh[i].getId());
				// dsdh[i].setTongTien();
				System.out.printf("| TONG TIEN :%,36.2f    |%n", dsdh[i].getTongTien());
				System.out.printf("+----------------------------------------------------+%n");
				}

		}
	}

	@Override
	public void Xoa() {
		System.out.print("Nhap ID don hang can xoa : ");
		String id = sc.nextLine();
		boolean flag = false;

		for (int i = 0; i < size; i++) {
			if (id.equalsIgnoreCase(dsdh[i].getId())) {
				DonHang[] tam = new DonHang[size - 1];
				for (int j = 0, k = 0; j < size; j++) { 
					if (id.equalsIgnoreCase(dsdh[j].getId())) {
						continue;
					}
					tam[k++] = dsdh[j];
				}
				dsdh = Arrays.copyOf(tam, tam.length);
				flag = true;
				DSChiTietDonHang dsctdh = new DSChiTietDonHang();
				dsctdh.xoaChiTietDonHang(id);
				System.out.println("Da xoa thanh cong!");
				size--;
				break;
			}
 
        }
		if (flag == false) {
			System.out.println("Khong co don hang de xoa");
		}
		GhiFile();

	}

	@Override
	public void GhiFile() {
		try {
			FileWriter fw = new FileWriter(".\\database\\DSDonHang.txt", false);
			BufferedWriter bw = new BufferedWriter(fw);
			try (PrintWriter pw = new PrintWriter(bw)) {
				for (int i = 0; i < size; i++) {
					pw.println(dsdh[i].getId() + "|" + dsdh[i].getKhachHang_id() + "|" + dsdh[i].getthuNgan_id() + "|"
							+ dsdh[i].getCuaHang_id() + "|" + dsdh[i].getDate() + "|" + dsdh[i].getHinhThucThanhToan()
							+ "|" + dsdh[i].getTongTien());
				}
				pw.close();
			} finally {
				fw.close();
				bw.close();
			}

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

				String catID = id.replaceAll("\\D+", "");
				stt = Integer.parseInt(catID);

				dsdh = Arrays.copyOf(dsdh, dsdh.length + 1);
				dsdh[i] = new DonHang(id, khachHang_id, thuNgan_id, cuaHang_id, date, hinhThucThanhToan, thanhTien);
				i++;
			}
			size = i;
			br.close();
			fr.close();
		}

		catch (Exception e) {
			System.out.println("Loi khong doc dc file danh sach don hang");
		}

	}
}
