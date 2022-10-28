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
		
		
	}

	@Override
	public void Xuat() {
		for (int i = 0; i < size; i++) {
            sp[i].Xuat();
        }
		
	}
	
}
