import java.io.BufferedWriter;
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
		
        GhiFileJava();
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
    
    
    public void GhiFileJava() {
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
	
}
