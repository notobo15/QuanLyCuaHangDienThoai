
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
	private int idCuoiCung;
	static Scanner sc = new Scanner(System.in);

	public DSDonHang() {
	}

	public void timDodaiMang() {
		int n = 1;
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
			dsdh[i].setId(idCuoiCung);
			dsdh[i].nhap();
			System.out.println("Them don hang thanh cong");
		}
		size += slnv;
		GhiFile();

	}

	@Override
	public void TimKiem() {
		System.out.println("|------------------ Chon thao tac tim kiem ------------------|");
        System.out.println("|1. Tim nhan vien theo ID                                    |");
        //System.out.println("|2. Tim nhan vien theo ten khach hang                        |");
        System.out.println("|0. Quay lai                                                 |");
        System.out.println("|------------------------------------------------------------|");
        System.out.print("Nhap thao tac : ");
        int select = sc.nextInt();
        switch (select) {
            case 1: {
                sc = new Scanner(System.in);
                System.out.print("Nhap ID nhan vien can tim: ");
                String id = sc.nextLine();
                boolean flag = false;
                for (int i = 0; i < size; i++) {
                    if (id.equalsIgnoreCase(dsdh[i].getId())) {
                    	dsdh[i].xuat();
                        flag = true;

                    }
                }
                if (flag == false) {
                    System.out.println("Khong tim thay nhan vien");
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

        System.out.println("Nhap ID DON HANG ban muon sua?");
        System.out.println("0. Quay lai");
        System.out.print("Moi ban nhap: ");
        sc.nextLine();
        DonHang tam = null;
        id = sc.nextLine();
        boolean timThay = false;
        for (;;) {
            for (int i = 0; i < size; i++) {
                if (dsdh[i].getId().equalsIgnoreCase(id)) {
                    tam = dsdh[i];
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
            
            tam.xuat();
            System.out.println("+------------- Chon thao tac ban muon sua ------------+");
            System.out.println("|1. Sua id khach hang                                 |");
            System.out.println("|2. Sua id thu ngan                                   |");
            System.out.println("|3. Sua id cua hang                                   |");
            System.out.println("|4. Sua hinh thuc thanh toan                          |");
            System.out.println("|0. Quay lai                                          |");
            System.out.println("+-----------------------------------------------------+");
            System.out.print("Nhap thao tac : ");
            try {

                int select = Integer.parseInt(sc.nextLine());

                switch (select) {

                    case 1: {
                        System.out.print("Nhap ho va ten nhan vien moi : ");
                        String tenMoi = sc.nextLine();
                        tam.setKhachHang_id(tenMoi);
                        System.out.println("Da sua thanh cong!");
                        tam.xuat();
                        GhiFile();
                        break;
                    }
                    case 2: {
                        System.out.print("Nhap gioi tinh nhan vien moi: ");
                        String tenMoi = sc.nextLine();
                        tam.setthuNgan_id(tenMoi);
                        System.out.println("Da sua thanh cong!");
                        tam.xuat();
                        GhiFile();
                        break;
                    }
                    case 3: {
                        System.out.print("Nhap dia chi nhan vien moi : ");
                        String tenMoi = sc.nextLine();
                        tam.setCuaHang_id(tenMoi);
                        System.out.println("Da sua thanh cong!");
                        tam.xuat();
                        GhiFile();
                        break;
                    }
                    case 4: {
                        System.out.print("Nhap ngay sinh nhan vien moi : ");
                        // String tenMoi = sc.nextLine();
                        // tam.setNgaySinh(tenMoi);
                        System.out.println("Da sua thanh cong!");
                        tam.xuat();
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

	@Override
	public void Xoa() {
        System.out.print("Nhap ID don hang can xoa : ");
        sc.nextLine();
        String id = sc.nextLine();
        boolean flag = false;

        for (int i = 0; i < size; i++) {
            if (id.equalsIgnoreCase(dsdh[i].getId())) {

                if (i != size - 1) {
                    for (int j = i; j < size - 1; j++) {
                    	dsdh[j] = dsdh[j + 1];
                    }

                } else {
                	dsdh[i] = null;
                }
                flag = true;
                size--;
                System.out.println("Da xoa thanh cong!");
                GhiFile();
                DocFile();
            }
        }

        if (flag == false) {
            System.out.println("Khong co don hang de xoa");
        }

	}

	@Override
	public void GhiFile() {
		try {
			FileWriter fw = new FileWriter(".\\database\\DSDonHang.txt", false);
			BufferedWriter bw = new BufferedWriter(fw);
			PrintWriter pw = new PrintWriter(bw);
			for (int i = 0; i < size; i++) {
				pw.println(dsdh[i].getId() + "|" + dsdh[i].getKhachHang_id() + "|" + dsdh[i].getthuNgan_id() + "|"
						+ dsdh[i].getCuaHang_id() + "|" + dsdh[i].getDate() + "|" + dsdh[i].getHinhThucThanhToan() + "|"
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
					
					String catID = id.replaceAll("\\D+", "");
                    idCuoiCung = Integer.parseInt(catID);
					dsdh[i] = new DonHang(id, khachHang_id, thuNgan_id, cuaHang_id, date, hinhThucThanhToan, thanhTien);
					i++;
				}
			} finally {
				//size = i;
				System.out.println(size);
				br.close();
				fr.close();
			}
		}

		catch (Exception e) {
			System.out.println("Loi khong doc dc file danh sach don hang");
		}

	}
}
