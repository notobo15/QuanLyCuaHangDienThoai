import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
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

	public void nhap(String id) {
		System.out.println("Nhap so luong san pham: ");
        int slnv = sc.nextInt();
        for (int i = size; i < size + slnv; i++) {
        	dsctdh[i] = new ChiTietDonHang(id);
            System.out.println("---------Nhap thong tin-----------");
            dsctdh[i].nhap();
            System.out.println("Them nhan vien thanh cong");
        }
        size += slnv;
        GhiFile();

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
	public void GhiFile() {
		try {
            FileWriter fw = new FileWriter("database\\DSChiTietDonHang.txt", false);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);
            for (int i = 0; i < size; i++) {
                pw.println(dsctdh[i].getId() + "|"
                        + dsctdh[i].getDonHang_id() + "|"
                        + dsctdh[i].getSanPham_id() + "|"
                        + dsctdh[i].getSoLuong() + "|"
                        + dsctdh[i].getThanhTien());
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
            FileReader fr = new FileReader("database\\DSChiTietDonHang.txt");
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
                    String donHang_id = txt[1];
                    String sanPham_id = txt[2];
                    float soLuong = Float.parseFloat(txt[3]);
                    double thanhTien = Double.parseDouble(txt[4]);
                    dsctdh[i] = new ChiTietDonHang(id, donHang_id, sanPham_id, soLuong, thanhTien);
                    i++;
                }
            } finally {
                size = i;
                br.close();
            }

        } catch (Exception e) {
        	System.out.println("Loi khong doc dc file");
        }

	}

	@Override
	public void Sua() {
		// TODO Auto-generated metho d stub

	}
	
	
	public double thanhTien(String id) {
		double s = 0;
		for(int i = 0; i < size; i++) {
			if(id.equalsIgnoreCase(dsctdh[i].getDonHang_id())) {
				s += dsctdh[i].getThanhTien();
			}
		}
		return s;
	}
	public double tongTien(String id) {
		DocFile();
		double s = 0;
		for(int i = 0; i < size; i++) {
			if(id.equalsIgnoreCase(dsctdh[i].getDonHang_id())) {
				s += dsctdh[i].getThanhTien();
			}
		}
		return s;
	}
}
