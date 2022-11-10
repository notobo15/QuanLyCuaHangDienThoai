import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class DSDonHang implements ThaoTac {
	private static int size = 0;
	public DonHang[] dsdh = new DonHang[1000];
	static Scanner sc = new Scanner(System.in);
	
	public DSDonHang() {
	}
	@Override
	public void XuatMenu() {
		int select = 0;
       	DocFile();
        do {
            System.out.println("||============ Chon thao tac ===============||");
            System.out.println("||1. Them don hang moi                     ||");
            System.out.println("||2. Xuat danh sach don hang              ||");
            System.out.println("||3. Xoa don hang                          ||");
            System.out.println("||4. Sua don hang                          ||");
            System.out.println("||5. Tim don hang                         ||");
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
	public void Xuat() {
		for (int i = 0; i < size; i++) {
            dsdh[i].xuat();
        }
		
	}
	@Override
	public void Xoa() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void Tao() {
		System.out.println("Nhap so luong don hang can them: ");
        int slnv = sc.nextInt();
        for (int i = size; i < size + slnv; i++) {
        	dsdh[i] = new DonHang();
            System.out.println("---------Nhap thong tin-----------");
            dsdh[i].nhap();
            System.out.println("Them nhan vien thanh cong");
        }
        size += slnv;
        GhiFile();
		
	}
	@Override
	public void TimKiem() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void DocFile() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void GhiFile() {
	
		try {
            FileWriter fw = new FileWriter("database\\DSDonHang.txt", false);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);
            for (int i = 0; i < size; i++) {
                pw.println(dsdh[i].getId() + "|"
                        + dsdh[i].getthuNgan_id() + "|"
                        + dsdh[i].getCuaHang_id() + "|"
                        + dsdh[i].getKhachHang_id() + "|"
                        + dsdh[i].getDate()+ "|"
                        + dsdh[i].getGia() + "|"
                        + dsdh[i].getHinhThucThanhToan());
            }
            bw.close();
        } catch (IOException e) {
        	System.out.println("Loi khong ghi dc file");
        }
		
	}
	@Override
	public void Sua() {
		// TODO Auto-generated method stub
		
	}
}
