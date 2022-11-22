import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

import Function.Check;

public class DSSanPham implements ThaoTac {
    private static int size;
    private SanPham[] sp = new SanPham[0];
    private static int stt = 0;
    static Scanner sc = new Scanner(System.in);
    
    
    public DSSanPham() {
		super();
	}

	public static int getSize() {
		return size;
	}

	public static void setSize() {
		int n = 0;
		try {
			FileReader fr = new FileReader(".\\database\\DSSanPham.txt");
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
    public void Tao() {
		System.out.println("Nhap so luong cua hang can them: ");
		int sl = sc.nextInt();
		SanPham[] tam = new SanPham[size];
		for (int i = 0; i < size; i++) {
			tam[i] = sp[i];
		}

		sp = new SanPham[size + sl];

		for (int i = 0; i < size; i++) {
			sp[i] = tam[i];
		}
		for (int i = size; i < size + sl; i++) {
			sp[i] = new SanPham();
			System.out.println("Nhap thong tin cua hang");
			sp[i].setId(stt++);
			sp[i].nhap();
		}
		size += sl;
		GhiFile();
    }

    @Override
    public void Xuat() {

        for (int i = 0; i < sp.length; i++) {
            sp[i].Xuat();
        }

    }
    public String getTenKhachHang(String id) {
    	DocFile();
    	for(int i = 0; i <size; i++) {
    		if(sp[i].getId().equalsIgnoreCase(id)) {
    			return sp[i].getTen();
    		}
    	}
    	return "";
    }
    // @Override
    public void XuatMenu() {
        int select = 0;
        String luaChon = null;
        DocFile();
        do {
            System.out.println("+------------- Chon thao tac -------------+");
            System.out.println("|1. Them san pham                         |");
            System.out.println("|2. Xuat danh sach san pham               |");
            System.out.println("|3. Xoa san pham                          |");
            System.out.println("|4. Sua san pham                          |");
            System.out.println("|5. Tim san pham                          |");
            System.out.println("|0. Quay lai                              |");
            System.out.println("+-----------------------------------------+");
            System.out.print("Nhap thao tac: ");
            select = Check.checkInput(luaChon);
            switch (select) {
                case 1: {
                    Tao();
                    break;
                }

                case 2:
                    System.out.println("ID\tTEN\t\t\tMO TA\t\tMAU\t\tKICH CO\t\tGIA\t\tID NHA CUNG CAP\t\tNGAY RA MAT");
                    for (int i = 0; i <= 140; i++) {
                        System.out.print("-");
                    }
                    System.out.println();
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

    public void GhiFile() {
        try {
            FileWriter fw = new FileWriter(".\\database\\DSSanPham.txt", false);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);
            for (int i = 0; i < size; i++) {
                pw.println(sp[i].getId() + "|"
                        + sp[i].getTen() + "|"
                        + sp[i].getMoTa() + "|"
                        + sp[i].getMau() + "|"
                        + sp[i].getKichCo() + "|"
                        + sp[i].getGia() + "|"
                        + sp[i].getNCC_ID() + "|"
                        + sp[i].getNgayRaMat());
            }

            bw.close();
        } catch (IOException e) {

        }

    }

    public void DocFile() {
        int i = 0;
        try {
            FileReader fr = new FileReader(".\\database\\DSSanPham.txt");
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
                    String Ten = txt[1];
                    String moTa = txt[2];
                    String Mau = txt[3];
                    String kichCo = txt[4];
                    int Gia = Integer.parseInt(txt[5]);
                    String NCC_ID = txt[6];
                    String date = txt[7];
                    String temp[] = date.split("\\/");
                    int ngay = Integer.parseInt(temp[0]);
                    int thang = Integer.parseInt(temp[1]);
                    int nam = Integer.parseInt(temp[2]);
                    Date ngayRaMat = new Date(ngay, thang, nam);
                    
                    String idTam = id.replaceAll("\\D+", "");
					stt = Integer.parseInt(idTam);
                   
                    sp = Arrays.copyOf(sp, sp.length + 1);
                    sp[i] = new SanPham(id, Ten, moTa, Mau, kichCo, Gia, NCC_ID, ngayRaMat);
                    i++;
                }
            } finally {
                br.close();
            }

        } catch (Exception e) {
            System.out.println("Loi khong doc dc file");

        }

    }

    @Override
    public void Xoa() {
		System.out.print("Nhap ID cua hang can xoa : ");
		String id = sc.nextLine();

		boolean flag = false;

		for (int i = 0; i < size; i++) {
			if (id.equalsIgnoreCase(sp[i].getId())) {

				if (i != size - 1) {
					for (int j = i; j < size - 1; j++) {
						sp[j] = sp[j + 1];
					}

				} else {
					sp[i] = null;
				}
				flag = true;
				size--;
				System.out.println("Da xoa thanh cong!");
				GhiFile();
			}
		}

		if (flag == false) {
			System.out.println("Khong co cua hang de xoa");
		}

    }

    @Override
    public void Sua() {
        
            String id = "";
    
            System.out.println("Nhap ID cua san pham ban muon sua?");
            System.out.println("0. Quay lai");
            System.out.print("Moi ban nhap: ");
            sc.nextLine();
            SanPham tam = null;
            id = sc.nextLine();
            boolean timThay = false;
            for (;;) {
                for (int i = 0; i < size; i++) {
                    if (sp[i].getId().equalsIgnoreCase(id)) {
                        tam = sp[i];
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
                System.out.println(
                        "ID\tTEN\t\t\tMO TA\tMAU\t\tKICH CO\tGIA\t\tID NHA CUNG CAP\t\tNGAY RA MAT");
                for (int i = 0; i <= 140; i++) {
                    System.out.print("-");
                }
                System.out.println();
                tam.Xuat();
                System.out.println("+------------- Chon thao tac ban muon sua ------------+");
                System.out.println("|1. Sua ten san pham                                  |");
                System.out.println("|2. Sua mo ta                                         |");
                System.out.println("|3. Sua mau                                           |");
                System.out.println("|4. Sua kich co                                       |");
                System.out.println("|5. Sua gia                                           |");
                System.out.println("|6. Sua ngay ra mat                                   |");
                System.out.print("Nhap thao tac : ");
                try {
    
                    int select = Integer.parseInt(sc.nextLine());
    
                    switch (select) {
    
                        case 1: {
                            System.out.print("Nhap ten san pham moi : ");
                            String tenMoi = sc.nextLine();
                            tam.setTen(tenMoi);
                            System.out.println("Da sua thanh cong!");
                            tam.Xuat();
                            GhiFile();
                            break;
                        }
                        case 2: {
                            System.out.print("Nhap mo ta moi: ");
                            String tenMoi = sc.nextLine();
                            tam.setMoTa(tenMoi);
                            System.out.println("Da sua thanh cong!");
                            tam.Xuat();
                            GhiFile();
                            break;
                        }
                        case 3: {
                            System.out.print("Nhap mau moi : ");
                            String tenMoi = sc.nextLine();
                            tam.setMau(tenMoi);
                            System.out.println("Da sua thanh cong!");
                            tam.Xuat();
                            GhiFile();
                            break;
                        }
                        case 4: {
                            System.out.print("Nhap kich co moi : ");
                             String tenMoi = sc.nextLine();
                             tam.setKichCo(tenMoi);
                            System.out.println("Da sua thanh cong!");
                            tam.Xuat();
                            GhiFile();
                            break;
                        }
                        case 5: {
                            System.out.print("Nhap gia moi : ");
                            int giaMoi = sc.nextInt();
                            tam.setGia(giaMoi);
                            System.out.println("Da sua thanh cong!");
                            tam.Xuat();
                            GhiFile();
                            break;
                        }
                        case 6: {
                            System.out.print("Nhap ngay ra mat moi : ");
                            tam.setNgayRaMat();
                            System.out.println("Da sua thanh cong!");
                            tam.Xuat();
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
        // TODO Auto-generated method stub
        sc = new Scanner(System.in);
        System.out.print("Nhap ID san pham can tim: ");
        String id = sc.nextLine();
        String ID = id.toLowerCase();
        boolean flag = false;
        for (int i = 0; i < size; i++) {
            if (ID.equals(sp[i].getId().toLowerCase())) {
                sp[i].Xuat();
                flag = true;

            }
        }
        if (flag == false) {
            System.out.println("Khong tim thay san pham!!!");
        }

    }

    public int xuatGia(String id) {
        DocFile();
        for (int i = 0; i < size; i++) {
            if (id.equalsIgnoreCase(sp[i].getId())) {
                return sp[i].getGia();
            }
        }
        return 0;
    }
}
