
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



	@Override
	public void XuatMenu() {
		setSize();
		dsdh= new DonHang[getSize()];
		DocFile();
		int select = 0;
		do {
			System.out.println("+-------------- Chon thao tac --------------+");
			System.out.println("|1. Them don hang moi                       |");
			System.out.println("|2. Xuat danh sach don hang                 |");
			System.out.println("|3. Xoa don hang                            |");
			System.out.println("|4. Sua don hang                            |");
			System.out.println("|5. Tim don hang                            |");
			System.out.println("|6. xuat hoa don                            |");
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
		System.out.println("+------------------ Chon thao tac tim kiem ------------------|");
        System.out.println("|1. Tim kiem theo ID don hang                                |");
        //System.out.println("|2. Tim nhan vien theo ten khach hang                        |");
        System.out.println("|0. Quay lai                                                 |");
        System.out.println("+------------------------------------------------------------|");
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
		int index = 0;
        System.out.println("Nhap ID DON HANG ban muon sua?");
        System.out.println("0. Quay lai");
        System.out.print("Moi ban nhap: ");
        sc.nextLine();
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
            System.out.println("ID KHONG TON TAI moi ban nhap lai!!!");
            System.out.println("0. Quay lai");
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
            try {

                int select = Integer.parseInt(sc.nextLine());

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
	
	public void xuatHoaDon() {
		DocFile();
		System.out.println("Nhap id don hang : ");
		sc.nextLine();
		String id = sc.nextLine();
		for(int i = 0; i < size; i++) {
			if(id.equalsIgnoreCase(dsdh[i].getId())) { 
				System.out.println("----------------- PHIEU THANH TOAN -----------------+");
				System.out.println("ID : " + dsdh[i].getId());
				System.out.println("Ngay tao don : " + dsdh[i].getDate());
				System.out.println("Nhan vien thu ngan : " + dsdh[i].getthuNgan_id());
				System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - - -");
				System.out.println("Ten SP     So Luong       Gia ban     Thanh Tien");
				DSChiTietDonHang ds = new DSChiTietDonHang();
				ds.XuatTronGHoaDon(dsdh[i].getId());
				dsdh[i].setTongTien();
				System.out.println("Tong tien : " + dsdh[i].getTongTien());
			}
			
		}
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
				//System.out.println(size);
				br.close();
				fr.close();
			}
		}

		catch (Exception e) {
			System.out.println("Loi khong doc dc file danh sach don hang");
		}

	}
}
