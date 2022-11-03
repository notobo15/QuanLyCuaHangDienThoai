import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class DSSanPham implements ThaoTac {
	private static int size = 0;
	public SanPham[] sp = new SanPham[100];
	static Scanner sc = new Scanner(System.in);
	@Override
	public void Tao() {
		System.out.println("Nhap so luong san pham can them: ");
        int sl = sc.nextInt();
        for (int i = size; i < size + sl; i++) {
        	sp[i] = new SanPham();
            System.out.println("Nhap thong tin nhan vien: ");
            sp[i].Tao();
            System.out.println("Them nhan vien thanh cong");
        }
        size += sl;
        GhiFile();
	}

	@Override
	public void Xuat() {
		for (int i = 0; i < size; i++) {
            sp[i].Xuat();
        }
		
	}
	//@Override
    public void XuatMenu() {
        int select = 0;
        do {
            System.out.println("||============ Chon thao tac ===============||");
            System.out.println("||1. Them nhan vien moi                     ||");
            System.out.println("||2. Xuat danh sach nhan vien               ||");
            System.out.println("||3. Xoa nhan vien                          ||");
            System.out.println("||4. Sua nhan vien                          ||");
            System.out.println("||5. Tim nhan vien                          ||");
            System.out.println("||0. Quay lai                               ||");
            System.out.println("||==========================================||");
            System.out.print("Nhap thao tac: ");
            select = sc.nextInt();
            switch (select) {
                case 1: {
                    Tao();
                    break;
                }

                case 2:
                	DocFile();
                    Xuat();
                    break;
                case 3:
                    //Xoa();
                    break;
                case 4:
                    //Sua();
                    break;
                case 5:
                    //TimKiem();
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
            FileWriter fw = new FileWriter("database/DSSanPham.txt", false);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);
            for (int i = 0; i < size; i++) {
                pw.println(sp[i].getId() + "|"
                        + sp[i].getTen() + "|"
                        + sp[i].getMau() + "|"
                        + sp[i].getKichCo());
            }

            bw.close();
        } catch (IOException e) {
        }
    }
    
    public void DocFile() {
        int i = 0;
        try {
            FileReader fr = new FileReader("database/DSSanPham.txt");
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
                    String fullName = txt[1];
                    String gender = txt[2];
                    int age = Integer.parseInt(txt[3]);
                    String phongBan = "Phong Dev";
                    String chucVu = "Coder";
                    double luongcoban = 1500000;
                    double heSoLuong = Double.parseDouble(txt[4]);
                    double gioLamThem = Double.parseDouble(txt[5]);
                    //sp[i] = new SanPham(id, fullName, gender);
                    i++;
                }
            } finally {
                size = i;
                br.close();
            }

        } catch (Exception e) {
        }

    }

	@Override
	public void Xoa() {
		// TODO Auto-generated method stub
		
	}
	
}
