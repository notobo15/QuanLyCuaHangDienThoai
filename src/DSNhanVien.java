import java.util.Scanner;


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
	
}
