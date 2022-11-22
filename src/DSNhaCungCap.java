import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import Function.Check;

public class DSNhaCungCap {
	private static int size = 0;
	private int sttLast;
	public NhaCungCap[] dsncc = new NhaCungCap[1000];
	static Scanner sc = new Scanner(System.in);

	public DSNhaCungCap() {
	}

	public static int getSize() {
		return size;
	}

	public static void setSize() {
		int n = 0;
		try {
			FileReader fr = new FileReader(".\\database\\DSNhaCungCap.txt");
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
				size = n;
				br.close();
				fr.close();

			}
		} catch (Exception e) {
			System.out.println("loi");
		}
	}

	public int getSttLast() {
		return sttLast;
	}

	public void setSttLast(int sttLast) {
		this.sttLast = sttLast;
	}

	public void Tao() {
		DocFile();
		System.out.println("Nhap so luong nha cung cap can them: ");
		int sldsncc = sc.nextInt();

		NhaCungCap[] tam = new NhaCungCap[size];
		for (int i = 0; i < size; i++) {
			tam[i] = dsncc[i];
		}

		dsncc = new NhaCungCap[size + sldsncc];

		for (int i = 0; i < size; i++) {
			dsncc[i] = tam[i];
		}

		for (int i = size; i < size + sldsncc; i++) {
			dsncc[i] = new NhaCungCap();
			System.out.println("Nhap thong tin nha cung cap");
			dsncc[i].setId(++sttLast);
			dsncc[i].nhap();

		}
		size += sldsncc;
		GhiFile();
	}

	public void Xuat() {
		DocFile();
		System.out.println("+---------------------------- DANH SACH NHA CUNG CAP ----------------------------+");
		System.out.println("|ID             TEN                      DIA CHI                 SDT             |");
		System.out.println("+--------------------------------------------------------------------------------+");
		for (int i = 0; i < size; i++) {
			dsncc[i].xuat();
		}
		System.out.println("+--------------------------------------------------------------------------------+");
	}

	public void XuatMenu() {
		setSize();
		dsncc = new NhaCungCap[getSize()];
		DocFile();
		int select = 0;
		String luaChon = null;
		do {
			System.out.println("+----------------- Chon thao tac ----------+");
			System.out.println("|1. Them nha cung cap moi                  |");
			System.out.println("|2. Xuat danh sach nha cung cap            |");
			System.out.println("|3. Xoa nha cung cap                       |");
			System.out.println("|4. Sua nha cung cap                       |");
			System.out.println("|5. Tim nha cung cap                       |");
			System.out.println("|0. Quay lai                               |");
			System.out.println("+------------------------------------------+");
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
		System.out.println("Nhap ID NHA CUNG CAP ban muon sua?");
		System.out.println("0. Quay lai");
		System.out.print("Moi ban nhap: ");
		sc.nextLine();
		int pos = 0;
		id = sc.nextLine();
		boolean timThay = false;
		for (;;) {
			for (int i = 0; i < size; i++) {
				if (dsncc[i].getId().equalsIgnoreCase(id)) {
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
			dsncc[pos].xuat();
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
					dsncc[pos].setTenNcc(tenMoi);
					System.out.println("Da sua thanh cong!");
					dsncc[pos].xuat();
					GhiFile();
					break;
				}
				case 2: {
					System.out.print("Nhap gioi tinh nhan vien moi: ");
					String tenMoi = sc.nextLine();
					dsncc[pos].setDiachi(tenMoi);
					System.out.println("Da sua thanh cong!");
					dsncc[pos].xuat();
					GhiFile();
					break;
				}
				case 3: {
					System.out.print("Nhap dia chi nhan vien moi : ");
					String tenMoi = sc.nextLine();
					dsncc[pos].setSdt(tenMoi);
					System.out.println("Da sua thanh cong!");
					dsncc[pos].xuat();
					GhiFile();
					break;
				}
				case 4: {
					System.out.print("Nhap dia chi nhan vien moi : ");
					dsncc[pos].nhap();
					System.out.println("Da sua thanh cong!");
					dsncc[pos].xuat();
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
		DocFile();
		System.out.print("Nhap ID cua hang can xoa : ");
		sc.nextLine();
		String id = sc.nextLine();

		boolean flag = false;

		for (int i = 0; i < size; i++) {
			if (id.equalsIgnoreCase(dsncc[i].getId())) {

				if (i != size - 1) {
					for (int j = i; j < size - 1; j++) {
						dsncc[j] = dsncc[j + 1];
					}

				} else {
					dsncc[i] = null;
				}
				flag = true;
				size--;
				System.out.println("Da xoa thanh cong!");
				GhiFile();
				DocFile();
			}
		}

		if (flag == false) {
			System.out.println("Khong co cua hang de xoa");
		}

	}

	public void TimKiem() {
		DocFile();
		int select;
//			try {
			System.out.println("+------------- Chon thao tac tim kiem -------------+");
			System.out.println("|1. Tim cua hang theo ID                           |");
			System.out.println("|2. Tim cua  hang theo ten                         |");
			System.out.println("|0. Quay lai                                       |");
			System.out.println("+--------------------------------------------------+");
			System.out.print("Nhap thao tac : ");

			select = sc.nextInt();

			switch (select) {
			case 1: {
				System.out.print("Nhap ID cua hang can tim: ");
				sc.nextLine();
				String id = sc.nextLine();
				boolean flag = false;
				for (int i = 0; i < size; i++) {
					if (id.equalsIgnoreCase(dsncc[i].getId())) {
						dsncc[i].xuat();
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
					if ((dsncc[i].getTenNcc().toLowerCase().contains(input.toLowerCase()))) {
						dsncc[i].xuat();
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
//		} catch (Exception e) {
//				System.out.println("loi");
//			}
	}

	public void DocFile() {
		int i = 0;
		try {
			FileReader fr = new FileReader(".\\database\\DSNhaCungCap.txt");
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

					dsncc[i] = new NhaCungCap(id, ten, diachi, sdt);
					i++;
				}
			} finally {
				// size = i;
				br.close();
			}

		} catch (Exception e) {
			System.out.println("Loi khong doc dc file");
		}

	}

	public void GhiFile() {
		try {
			FileWriter fw = new FileWriter(".\\database\\DSNhaCungCap.txt", false);
			BufferedWriter bw = new BufferedWriter(fw);
			PrintWriter pw = new PrintWriter(bw);
			for (int i = 0; i < size; i++) {
				pw.println(dsncc[i].getId() + "|" + dsncc[i].getTenNcc() + "|" + dsncc[i].getDiachi() + "|"
						+ dsncc[i].getSdt());
			}
			bw.close();
		} catch (IOException e) {
			System.out.println("Loi khong ghi dc file");
		}

	}

}
