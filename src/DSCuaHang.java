import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
public class DSCuaHang {
    private static int size = 0;
	public Cua_Hang[] Ch = new Cua_Hang[1000];
	static Scanner sc = new Scanner(System.in);
	
	public DSCuaHang() {
	}

	public Cua_Hang[] getCh() {
		return Ch;
	}

	public void setCh(Cua_Hang[] Ch) {
		this.Ch = Ch;
	}

	public void Tao() {
		 	System.out.println("Nhap so luong cua hang can them: ");
	        int slCh = sc.nextInt();
	        for (int i = size; i < size + slCh; i++) {
	            Ch[i] = new Cua_Hang();
	            System.out.println("Nhap thong tin cua hang");
	            Ch[i].nhap();
	            System.out.println("Them cua hang");
	        }
	        size += slCh;
			GhiFile();    
		}
	public void Xuat() {
		System.out.println("\tSTT\t\tID\t\tTEN CUA HANG\t\tDIA CHI\t\t\tSDT\t\t");
//		System.out.println("-------------------------------------------"
//				+ "----------------------------------------------------"
//				+ "------------------------------------------------------");
		for(int i = 0; i <= 140; i++) {
			System.out.print("-");
		}
		System.out.println();
		
		for (int i = 0; i < size; i++) {
            Ch[i].xuat();
        }
	}
    
	public void XuatMenu() {
		 int select = 0;
	        do {
	            System.out.println("||============ Chon thao tac ===============||");
	            System.out.println("||1. Them cua hang                          ||");
	            System.out.println("||2. Xuat danh sach cua hang                ||");
	            System.out.println("||3. Xoa cua hang                           ||");
	            System.out.println("||4. Sua cua hang                           ||");
	            System.out.println("||5. Tim cua hang                           ||");
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


	public void Sua() {
        System.out.println("+--------------- Chon muc ban muon sua ---------------+");
System.out.println("|1. Sua ten cua hang                                  |");
        System.out.println("|2. Sua dia chi                                       |");
        System.out.println("|3. Sua so dien thoai                                 |");
        System.out.println("|4. Sua tat ca                                        |");
        System.out.println("|0. Quay lai                                          |");
        System.out.println("+-----------------------------------------------------+");
        System.out.print("Nhap thao tac : ");
        int select = sc.nextInt();
        switch (select) {
        case 1: {
            sc = new Scanner(System.in);
            System.out.println("Nhap ID ten cua hang can sua: ");

            String ID = sc.nextLine();
            
            String toLowerCase = ID.toLowerCase();

            System.out.print("Nhap ten cua hang cap moi : ");
            String newFullName = sc.nextLine();
            
            boolean flag = false;
            for (int i = 0; i < size; i++) {
                if (toLowerCase.equals(Ch[i].getId().toLowerCase())) {
                	Ch[i].setTenCh(newFullName);
                    System.out.println("Da sua thanh cong!");
                    flag = true;
                }
            }
            if (flag == false) {
                System.out.println("Khong co cua hang de sua");
            }
            GhiFile();
            break;
        }
        case 2: {
			sc = new Scanner(System.in);
            System.out.print("Nhap ID cua hang can sua: ");
            String ID = sc.nextLine();
            ID = ID.toLowerCase();
            System.out.print("Nhap dia chi moi : ");
            String input = sc.nextLine();
            boolean flag = false;
            for (int i = 0; i < size; i++) {
                if (ID.equals(Ch[i].getId().toLowerCase())) {
                	Ch[i].setDiachi(input);
                    System.out.println("Da sua thanh cong!");
                    flag = true;
                }
            }
            if (flag == false) {
                System.out.println("Khong co cua hang de sua");
            }
            GhiFile();
            break;
        }
        
        case 4: {
            sc = new Scanner(System.in);
            System.out.print("Nhap ID cua hang can sua: ");
            String ID = sc.nextLine();
            String toLowerCase = ID.toLowerCase();

            boolean flag = false;
            for (int i = 0; i < size; i++) {
                if (toLowerCase.equals(Ch[i].getId().toLowerCase())) {
                	Ch[i].nhap();
                    System.out.println("Da sua thanh cong!");
                    flag = true;
                }
            }
            if (flag == false) {
                System.out.println("Khong co cua hang de sua");
            }
            GhiFile();
            break;
        }
        case 0:
            break;
        default:
System.out.println("Nhap sai thao tac, xin nhap lai !!!");

    
        }
	}

	public void Xoa() {
        sc = new Scanner(System.in);
        System.out.println(" Xoa cua hang ");

        System.out.print("Nhap ID coder can xoa : ");
        String id = sc.nextLine();
        id = id.toLowerCase();
        boolean flag = false;
        
        for (int i = 0; i < size; i++) {
            if ( id.equals(Ch[i].getId().toLowerCase())) {
            	Ch[i] = null;
                for (int j = i; j < size; j++) {
                	
                	Ch[j] = Ch[j + 1];
                }
                flag = true;
                size--;
                GhiFile();
                System.out.println("Da xoa thanh cong!");
            }
        }

        if (flag == false) {
            System.out.println("Khong co cua hang de xoa");
        }

    }
	public void TimKiem() {
		System.out.println("||============ Chon thao tac tim kiem ===============||");
		   System.out.println("||1. Tim cua hang theo ID                           ||");
		   System.out.println("||2. Tim cua  hang theo ten                          ||");
		   System.out.println("||0. Quay lai                                        ||");
		   System.out.println("||===================================================||");
		   System.out.print("Nhap thao tac : ");
		   int select = sc.nextInt();
		   switch (select) {
			   case 1: {
				   sc = new Scanner(System.in);
				   System.out.print("Nhap ID cua hang can tim: ");
				   String id = sc.nextLine();
				   id.toLowerCase();
				   boolean flag = false;
				   for (int i = 0; i < size; i++) {
					   if (id.equals(Ch[i].getId().toLowerCase())) {
						   Ch[i].xuat();
						   flag = true;
						  
					   }
				   }
				   if (flag == false) {
					   System.out.println("Khong tim thay cua hang");
				   }
				   break;
			   }
			   case 2: {
				   sc = new Scanner(System.in);
				   System.out.print("Nhap ten cua hang can tim: ");
				   String fullName = sc.nextLine();
				   String toLowerCase = fullName.toLowerCase();
				   boolean flag = false;
				   for (int i = 0; i < size; i++) {
					   if ((Ch[i].getTenCh().toLowerCase().contains(toLowerCase))) {
						   Ch[i].xuat();
						   flag = true;
						   
					   }
				   }
				   if (flag == false) {
					   System.out.println("Khong tim thay cua hang");
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
            FileReader fr = new FileReader("D:\\DoAnJava\\NhaCungCap.java\\src\\DSNhaCungCap.txt");
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
                    String ten = txt[1];
                    String diachi = txt[2];
                    String sdt = txt[3];
                    Ch[i] = new Cua_Hang(id,ten,diachi,sdt);
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


	public void GhiFile() {
		 try {
	            FileWriter fw = new FileWriter("D:\\DoAnJava\\CuaHang.java\\src\\DSCuaHang.txt", false);
	            BufferedWriter bw = new BufferedWriter(fw);
	            PrintWriter pw = new PrintWriter(bw);
	            for (int i = 0; i < size; i++) {
	                pw.println(Ch[i].getId() + "|"
	                        + Ch[i].getTenCh() + "|"
	                        + Ch[i].getDiachi() + "|"
	                        + Ch[i].getSdt() + "|");
	            }
	            bw.close();
	        } catch (IOException e) {
	        	System.out.println("Loi khong ghi dc file");
	        }
		
	}
	public static void main(String[] args) {
        DSCuaHang b=new DSCuaHang();
		b.XuatMenu();
        
    }
	
}