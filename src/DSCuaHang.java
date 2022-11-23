import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

import Function.Check;

public class DSCuaHang {
	static private CuaHang[] dsch = new CuaHang[0];
	private int sttLast;
	static Scanner sc = new Scanner(System.in);

	public DSCuaHang() {
	}

	public void Tao() {
		System.out.println("Nhap so luong cua hang can them: ");
		int sl = 0;
		for (;;) {
			if (sl > 0) {
				break;
			}
			sl = Check.checkInputDigit();
		}
		int arrLength = dsch.length;
		dsch = Arrays.copyOf(dsch, dsch.length + sl);
		for (int i = arrLength; i < arrLength + sl; i++) {
			dsch[i] = new CuaHang();
			System.out.println("Nhap thong tin cua hang");
			dsch[i].setId(sttLast++);
			dsch[i].nhap();
		}
		GhiFile();
	}

	public void Xuat() {
		System.out.println("+--------------------------   DANH SACH CUA HANG   ---------------------------+");
		System.out.println("|  ID        TEN CUA HANG             DIA CHI                  SDT            |");
		System.out.println("+-----------------------------------------------------------------------------+");
		for (int i = 0; i < dsch.length; i++) {
			dsch[i].xuat();
		}
		System.out.println("+-----------------------------------------------------------------------------+");
	}

	public void XuatMenu() {
		DocFile();
		int select = 0;
		String luaChon = null;
		do {
			System.out.println("+-------------- Chon thao tac --------------+");
			System.out.println("|1. Them cua hang                           |");
			System.out.println("|2. Xuat danh sach cua hang                 |");
			System.out.println("|3. Xoa cua hang                            |");
			System.out.println("|4. Sua cua hang                            |");
			System.out.println("|5. Tim cua hang                            |");
			System.out.println("|0. Quay lai                                |");
			System.out.println("+-------------------------------------------+");
			System.out.print("Nhap thao tac: ");
			select = Check.checkInput(luaChon);
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

	public void Sua() {
		DocFile();
		String id = "";
		System.out.println("Nhap ID CUA HANG ban muon sua?");
		System.out.println("0. Quay lai");
		System.out.print("Moi ban nhap: ");
		sc.nextLine();
		int pos = 0;
		id = sc.nextLine();
		boolean timThay = false;
		for (;;) {
			for (int i = 0; i < dsch.length; i++) {
				if (dsch[i].getId().equalsIgnoreCase(id)) {
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
			dsch[pos].xuat();
			System.out.println("+------------- Chon thao tac ban muon sua ------------+");
			System.out.println("|1. Sua ten cua hang                                  |");
			System.out.println("|2. Sua dia chi cua hang                              |");
			System.out.println("|3. Sua so dien thoai cua hang                        |");
			System.out.println("|4. Sua tat ca                                        |");
			System.out.println("|0. Quay lai                                          |");
			System.out.println("+-----------------------------------------------------+");
			System.out.print("Nhap thao tac : ");
			try {

				int select = Integer.parseInt(sc.nextLine());

				switch (select) {

				case 1: {
					System.out.print("Nhap ho va ten nhan vien moi : ");
					String tenMoi = sc.nextLine();
					dsch[pos].setTenCh(tenMoi);
					System.out.println("Da sua thanh cong!");
					dsch[pos].xuat();
					GhiFile();
					break;
				}
				case 2: {
					System.out.print("Nhap gioi tinh nhan vien moi: ");
					String tenMoi = sc.nextLine();
					dsch[pos].setDiachi(tenMoi);
					System.out.println("Da sua thanh cong!");
					dsch[pos].xuat();
					GhiFile();
					break;
				}
				case 3: {
					System.out.print("Nhap dia chi nhan vien moi : ");
					String tenMoi = sc.nextLine();
					dsch[pos].setSdt(tenMoi);
					System.out.println("Da sua thanh cong!");
					dsch[pos].xuat();
					GhiFile();
					break;
				}
				case 4: {
					System.out.print("Nhap dia chi nhan vien moi : ");
					dsch[pos].nhap();
					System.out.println("Da sua thanh cong!");
					dsch[pos].xuat();
					GhiFile();
					break;
				}
				case 0:
					break;
				default:
					System.out.println("Nhap sai thao tac, xin nhap lai !!!");

				}
			} catch (Exception e) {
				System.out.println("Error...\nMoi ban nhap lai...");
			}
		}
	}

	public void Xoa() {
		System.out.print("Nhap ID cua hang can xoa : ");
		String id = sc.nextLine();
		boolean flag = false;
		System.out.println(dsch.length);
		for (int i = 0; i < dsch.length; i++) {
			if (id.equalsIgnoreCase(dsch[i].getId())) {

				if (i != dsch.length - 1) {
					for (int j = i; j < dsch.length - 1; j++) {
						dsch[j] = dsch[j + 1];
					}

				} else {
					dsch[i] = null;
				}
				dsch = Arrays.copyOf(dsch, dsch.length - 1);
				flag = true;
				System.out.println("Da xoa thanh cong!");

			}
		}
		GhiFile();

		if (flag == false) {
			System.out.println("Khong co cua hang de xoa");
		}

	}

	public void TimKiem() {
		System.out.println("+--------------- Chon thao tac tim kiem ---------------+");
		System.out.println("|1. Tim cua hang theo ID                               |");
		System.out.println("|2. Tim cua  hang theo ten                             |");
		System.out.println("|0. Quay lai                                           |");
		System.out.println("+------------------------------------------------------+");
		System.out.print("Nhap thao tac : ");
		int select = sc.nextInt();
		switch (select) {
		case 1: {
			System.out.print("Nhap ID cua hang can tim: ");
			sc.nextLine();
			String id = sc.nextLine();
			boolean flag = false;
			for (int i = 0; i < dsch.length; i++) {
				if (id.equalsIgnoreCase(dsch[i].getId())) {
					dsch[i].xuat();
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
			for (int i = 0; i < dsch.length; i++) {
				if ((dsch[i].getTenCh().toLowerCase().contains(input.toLowerCase()))) {
					dsch[i].xuat();
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

	public void DocFile() {
		int i = 0;
		try {
			FileReader fr = new FileReader(".\\database\\DSCuaHang.txt");
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
					String ten = txt[1];
					String diachi = txt[2];
					String sdt = txt[3];

					String idTam = id.replaceAll("\\D+", "");
					sttLast = Integer.parseInt(idTam);
					dsch = Arrays.copyOf(dsch, dsch.length + 1);
					dsch[i] = new CuaHang(id, ten, diachi, sdt);
					i++;
				}
			} finally {
				fr.close();
				br.close();
			}

		} catch (Exception e) {
			System.out.println("Loi khong doc dc file");
		}

	}

	public void GhiFile() {

		try {
			FileWriter fw = new FileWriter(".\\database\\DSCuaHang.txt", false);
			BufferedWriter bw = new BufferedWriter(fw);
			PrintWriter pw = new PrintWriter(bw);
			try {
				for (int i = 0; i < dsch.length; i++) {
					pw.println(dsch[i].getId() + "|" + dsch[i].getTenCh() + "|" + dsch[i].getDiachi() + "|"
							+ dsch[i].getSdt());
				}
			} finally {
				fw.close();
				bw.close();
				pw.close();
			}

		} catch (IOException e) {
			System.out.println("Loi khong ghi dc file");
		}
	}

	public boolean checkTonTai(String id) {
		DocFile();
		for (int i = 0; i < dsch.length; i++) {
			if (dsch[i].getId().equalsIgnoreCase(id)) {
				return true;
			}
		}
		return false;

	}

	public CuaHang timCuaHang(String id) {
		DocFile();
		for (int i = 0; i < dsch.length; i++) {
			if (dsch[i].getId().equalsIgnoreCase(id)) {
				CuaHang ch = new CuaHang();
				ch = dsch[i];
				return ch;
			}
		}

		return null;
	}
}