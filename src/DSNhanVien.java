import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
public class DSNhanVien implements ThaoTac{
	private static int size = 0;
	public NhanVien[] nv = new NhanVien[1000];
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
	        GhiFile();
	}

	@Override
	public void Xuat() {
		System.out.println("ID\tHO VA TEN\t\t\tGIOI TINH\tDIA CHI\t\tNGAY SINH\tCHUC VU\t\tLUONG");
		System.out.println("-------------------------------------------------------------------------------------------------------------");
		for (int i = 0; i < size; i++) {
            nv[i].xuat();
        }
		
	}
	
	@Override
    public void Xoa() {
        sc = new Scanner(System.in);
        System.out.println("||============ Xoa nhan vien ===============||");

        System.out.print("Nhap ID coder can xoa : ");
        String id = sc.nextLine();
        id.toLowerCase();
        boolean flag = false;
        
        for (int i = 0; i < size; i++) {
            if ( id.equals(nv[i].getId())) {
            	nv[i] = null;
                for (int j = i; j < size; j++) {
                	
                	nv[j] = nv[j + 1];
                }
                flag = true;
                size--;
                GhiFile();
                System.out.println("Da xoa thanh cong!");
            }
        }

        if (flag == false) {
            System.out.println("Khong co nhan vien de xoa");
        }

    }
	
	

	@Override
	public void XuatMenu() {
		 int select = 0;
	       	DocFile();
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
	public void Sua() {
		sc.nextLine();
		System.out.print("Nhap ID nhan vien can sua: ");
        String id = sc.nextLine();
        id.toLowerCase();
        //NhanVien nvm ;
        int i;
        for (i = 0; i< size; i++) {
            if (id.equals(nv[i].getId().toLowerCase())) {
            	break;
            }else {
            	System.out.println("nhan vien khong ton tai");
            	id = sc.nextLine();
            	id.toLowerCase();
            	break;
            }
        }
        System.out.println("||============ Chon muc ban muon sua ===============||");
        System.out.println("||1. Sua ho va ten nhan vien                        ||");
        System.out.println("||2. Sua dia chi                         ||");
        System.out.println("||3. Sua gioi tinh                     ||");
        System.out.println("||4. Sua email                  ||");
        System.out.println("||5. Sua so dien thoai                      ||");
        System.out.println("||6. Sua ngay sinh                      ||");
        System.out.println("||7. Sua chuc vu                     ||");
        System.out.println("||8. Sua luong                     ||");
        System.out.println("||9. Sua tat ca                     ||");
        System.out.println("||0. Quay lai                                       ||");
        System.out.println("||==================================================||");
        System.out.print("Nhap thao tac : ");
	   int select = sc.nextInt();
	        
	        switch (select) {
		       
	            case 1: {
	                
	                System.out.print("Nhap ho va ten nhan vien moi : ");
	                
	                //nvm.setHoVaTen(newFullName);
	                    System.out.println("Khong co nhan vien de sua");
	                //GhiFileJava();
	                break;

	            }
	            case 2: {
	                
	            }
	            case 3: {
	                
	            }
	            case 0:
	                break;
	            default:
	                System.out.println("Nhap sai thao tac, xin nhap lai !!!");

	        }
		
	}

	@Override
	public void TimKiem() {
		 System.out.println("||============ Chon thao tac tim kiem ===============||");
	        System.out.println("||1. Tim nhan vien theo ID                           ||");
	        System.out.println("||2. Tim nhan vien theo ten                          ||");
	        System.out.println("||0. Quay lai                                        ||");
	        System.out.println("||===================================================||");
	        System.out.print("Nhap thao tac : ");
	        int select = sc.nextInt();
	        switch (select) {
	            case 1: {
	                sc = new Scanner(System.in);
	                System.out.print("Nhap ID nhan vien can tim: ");
	                String id = sc.nextLine();
	                id.toLowerCase();
	                boolean flag = false;
	                for (int i = 0; i < size; i++) {
	                    if (id.equals(nv[i].getId().toLowerCase())) {
	                    	nv[i].xuat();
	                        flag = true;
	                       
	                    }
	                }
	                if (flag == false) {
	                    System.out.println("Khong tim thay nhan vien");
	                }
	                break;
	            }
	            case 2: {
	                sc = new Scanner(System.in);
	                System.out.print("Nhap ho va ten nhan vien can tim: ");
	                String fullName = sc.nextLine();
	                String toLowerCase = fullName.toLowerCase();
	                boolean flag = false;
	                for (int i = 0; i < size; i++) {
	                    if ((nv[i].getHoVaTen().toLowerCase().contains(toLowerCase))) {
	                    	nv[i].xuat();
	                        flag = true;
	                        
	                    }
	                }
	                if (flag == false) {
	                    System.out.println("Khong tim thay nhan vien");
	                }
	            }
	            case 0:
	                break;
	            default:
	                System.out.println("Nhap sai thao tac, xin nhap lai !!!");

	        }
		
	}
	public void DocFile() {
        int i = 0;
        try {
            FileReader fr = new FileReader("database\\DSNhanVien.txt");
            BufferedReader br = new BufferedReader(fr);
            try {
                String line = " ";
                while (true) {
                    line = br.readLine();
                    if (line == null) {
                        break;
                    }
                    String txt[] = line.split("\\|");
                    String id = txt[0];
                    String ten = txt[1];
                    String gioiTinh = txt[2];
                    String diachi = txt[3];
                    String date = txt[4];
                    String tam[] = date.split("\\/");
                    int ngay = Integer.parseInt(tam[0]);
                    int thang = Integer.parseInt(tam[1]);
                    int nam = Integer.parseInt(tam[2]);
                    Date ngaySinh = new Date(ngay, thang, nam); 
                    
                    double luong = Double.parseDouble(txt[5]);
                    String chucVu = txt[6];
                    nv[i] = new NhanVien(id, ten,diachi, gioiTinh, ngaySinh , luong, chucVu);
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
	public void GhiFile() {
		 try {
	            FileWriter fw = new FileWriter("database\\DSNhanVien.txt", false);
	            BufferedWriter bw = new BufferedWriter(fw);
	            PrintWriter pw = new PrintWriter(bw);
	            for (int i = 0; i < size; i++) {
	                pw.println(nv[i].getId() + "|"
	                        + nv[i].getHoVaTen() + "|"
	                        + nv[i].getGioiTinh() + "|"
	                        + nv[i].getDiaChi() + "|"
	                        + nv[i].ngaySinh.toString() + "|"
	                        + nv[i].getLuong() + "|"
	                        + nv[i].getChucVu());
	                
	            }

	            bw.close();
	        } catch (IOException e) {
	        }
		
	}
	
}
