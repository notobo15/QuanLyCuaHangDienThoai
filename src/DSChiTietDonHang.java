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
                        + dsctdh[i].getId() + "|"
                        + dsctdh[i].getDonHang_id() + "|"
                        + dsctdh[i].getSanPham_id() + "|"
                        + dsctdh[i].getSoLuong() + "|"
                        + dsctdh[i].getDateBaoHanh() + "|"
                        + dsctdh[i].getThanhTien());
            }
            bw.close();
        } catch (IOException e) {
        	System.out.println("Loi khong ghi dc file");
        }

	}

	@Override
	public void DocFile() {
//		int i = 0;
//        try {
//            FileReader fr = new FileReader("database\\DSNhanVien.txt");
//            BufferedReader br = new BufferedReader(fr);
//            try {
//                String line = "";
//                while (true) {
//                    line = br.readLine();
//                    if (line == null) {
//                        break;
//                    }
//                    String txt[] = line.split("\\|");
//                    String id = txt[0];
//                    String ten = txt[1];
//                    String gioiTinh = txt[2];
//                    String diachi = txt[3];
//                    String date = txt[4];
//                    String tam[] = date.split("\\/");
//                    int ngay = Integer.parseInt(tam[0]);
//                    int thang = Integer.parseInt(tam[1]);
//                    int nam = Integer.parseInt(tam[2]);
//                    Date ngaySinh = new Date(ngay, thang, nam); 
//                    String e = txt[5];
//                    String sdt = txt[6];
//                    double luong = Double.parseDouble(txt[7]);
//                    String chucVu = txt[8];
//                    dsctdh[i] = new NhanVien(id, ten,diachi, gioiTinh, ngaySinh , luong, chucVu, e, sdt);
//                    i++;
//                }
//            } finally {
//                size = i;
//                br.close();
//            }
//
//        } catch (Exception e) {
//        	System.out.println("Loi khong doc dc file");
//        }

	}

	@Override
	public void Sua() {
		// TODO Auto-generated metho d stub

	}

}
