import java.util.Scanner;

public class DSChiTietDonHang implements ThaoTac {
	private static int size = 0;
	public ChiTietDonHang[] dsctdh = new ChiTietDonHang[1000];
	static Scanner sc = new Scanner(System.in);

	@Override
	public void XuatMenu() {
		// TODO Auto-generated method stub

	}

	@Override
	public void Xuat() {
		for (int i = 0; i < size; i++) {
			dsctdh[i].xuat();
        }
		

	}

	@Override
	public void Xoa() {
		// TODO Auto-generated method stub

	}

	@Override
	public void Tao() {
		System.out.println("Nhap so luong san pham: ");
        int slnv = sc.nextInt();
        for (int i = size; i < size + slnv; i++) {
        	dsctdh[i] = new ChiTietDonHang();
            System.out.println("---------Nhap thong tin-----------");
            dsctdh[i].nhap();
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
		// TODO Auto-generated method stub

	}

	@Override
	public void Sua() {
		// TODO Auto-generated metho d stub

	}

}
