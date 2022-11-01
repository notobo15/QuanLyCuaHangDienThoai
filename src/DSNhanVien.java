import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;

import NhanSu.Coder;


public class DSNhanVien implements ThaoTac{
	private static int size = 0;
	public NhanVien[] nv = new NhanVien[100];
	static Scanner sc = new Scanner(System.in);
	
	public DSNhanVien() {
		super();
	}
	
	public static int getSize() {
		return size;
	}

	public static void setSize(int size) {
		DSNhanVien.size = size;
	}

	public NhanVien[] getNv() {
		return nv;
	}

	public void setNv(NhanVien[] nv) {
		this.nv = nv;
	}

	@Override
	public void Tao() {
		 System.out.println("Nhap so luong nhan vien can them: ");
	        int slnv = sc.nextInt();
	        for (int i = size; i < size + slnv; i++) {
	            nv[i] = new NhanVien();
	            System.out.println("Nhap thong tin nhan vien: ");
	            nv[i].nhap();
	            System.out.println("Them nhan vien thanh cong");
	        }
	        size += slnv;
		
	}

	@Override
	public void Xuat() {
		for (int i = 0; i < size; i++) {
            nv[i].xuat();
        }
		
	}
	public void DocFileJava() {
        int i = 0;
        try {
            FileReader fr = new FileReader("NhanVienCoder.txt");
            BufferedReader br = new BufferedReader(fr);
            try {
                String line = " ";
                while (true) {
                    line = br.readLine();
                    if (line == null) {
                        break;
                    }
                    String txt[] = line.split("\\|");
                    String ID = txt[0];
                    String fullName = txt[1];
                    String gender = txt[2];
                    int age = Integer.parseInt(txt[3]);
                    String phongBan = "Phong Dev";
                    String chucVu = "Coder";
                    double luongcoban = 1500000;
                    double heSoLuong = Double.parseDouble(txt[4]);
                    double gioLamThem = Double.parseDouble(txt[5]);
                    coder[i] = new Coder(ID, fullName, gender, age, phongBan, chucVu, luongcoban, heSoLuong, gioLamThem);
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
	public void XuatMenu() {
		// TODO Auto-generated method stub
		
	}
	
}
