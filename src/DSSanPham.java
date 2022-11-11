import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class DSSanPham implements ThaoTac {
	private static int size ;
	public SanPham[] sp = new SanPham[100];
	static Scanner sc = new Scanner(System.in);
	@Override
	public void Tao() {
        DocFile();
		System.out.println("Nhap so luong san pham can them: ");
        int sl = sc.nextInt();
     
        for (int i = size; i < size + sl; i++) {
        	sp[i] = new SanPham();
            sp[i].Tao();
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
            System.out.println("||1. Them san pham                          ||");
            System.out.println("||2. Xuat danh sach san pham                ||");
            System.out.println("||3. Xoa san pham                           ||");
            System.out.println("||4. Sua san pham                           ||");
            System.out.println("||5. Tim san pham                           ||");
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
                    Xoa();
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
                pw.println(sp[i].getId()    +"|"
                        + sp[i].getTen()    +"|"
                        + sp[i].getMoTa()   +"|"
                        + sp[i].getMau()    +"|"
                        + sp[i].getKichCo() +"|"
                        + sp[i].getGia()    +"|"
                        + sp[i].getNCC_ID() +"|" 
                        + sp[i].getNgayRaMat());
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
                    String id=txt[0];
                    String Ten=txt[1];
                    String moTa=txt[2];
                    String Mau=txt[3];
                    String kichCo=txt[4];
                    int Gia= Integer.parseInt(txt[5]);
                    String NCC_ID=txt[6];
                    String date=txt[7];
                    String temp[]= date.split("\\/");
                    int ngay = Integer.parseInt(temp[0]);
                    int thang = Integer.parseInt(temp[1]);
                    int nam = Integer.parseInt(temp[2]);
                    Date ngayRaMat=new Date(ngay,thang,nam);
                    sp[i] = new SanPham(id, Ten,moTa,Mau,kichCo,Gia,NCC_ID,ngayRaMat);
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
		sc = new Scanner(System.in);
        System.out.println(" Xoa san pham ");

        System.out.print("Nhap ID san pham can xoa theo kieu SP1xxx : ");
        String id = sc.nextLine();
        id = id.toLowerCase();
        boolean flag = false;
        for (int i = 0; i < size; i++) {
            if ( id.equals(sp[i].getId().toLowerCase())) {
            	sp[i] = null;
                for (int j = i; j < size; j++) {
                	
                	sp[j] = sp[j + 1];
                }
                flag = true;
                size--;
                GhiFile();
                System.out.println("Da xoa thanh cong!");
            }
        }

        if (flag == false) {
            System.out.println("Khong co san pham de xoa");
        }

		
	}
	public int xuatGia(String id) {
		DocFile();
		for (int i = 0; i < size; i++) {
            if(id.equalsIgnoreCase(sp[i].getId())) {
            	return sp[i].getGia();
            }
        }
		return 0;
	}
	
	
    @Override
    public void Sua() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void TimKiem() {
        // TODO Auto-generated method stub
        
	}
   
}
