import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
public class DSNhaCungCap {
    private static int size = 0;
	public Nha_Cung_Cap[] Ncc = new Nha_Cung_Cap[1000];
	static Scanner sc = new Scanner(System.in);
	
	public DSNhaCungCap() {
	}

	public Nha_Cung_Cap[] getNcc() {
		return Ncc;
	}

	public void setNcc(Nha_Cung_Cap[] Ncc) {
		this.Ncc = Ncc;
	}

	public void Tao() {
		 	System.out.println("Nhap so luong nha cung cap can them: ");
	        int slNcc = sc.nextInt();
	        for (int i = size; i < size + slNcc; i++) {
	            Ncc[i] = new Nha_Cung_Cap();
	            System.out.println("Nhap thong tin nha cung cap");
	            Ncc[i].nhap();
	            System.out.println("Them nha cung cap");
	        }
	        size += slNcc;
			GhiFile();    
		}
	public void Xuat() {
		System.out.println("\tSTT\t\tID\t\tHO VA TEN\t\tDIA CHI\t\t\tSDT\t\t");
//		System.out.println("-------------------------------------------"
//				+ "----------------------------------------------------"
//				+ "------------------------------------------------------");
		for(int i = 0; i <= 140; i++) {
			System.out.print("-");
		}
		System.out.println();
		
		for (int i = 0; i < size; i++) {
            Ncc[i].xuat();
        }
	}
    
	public void XuatMenu() {
		 int select = 0;
	        do {
	            System.out.println("||============ Chon thao tac ===============||");
	            System.out.println("||1. Them nha cung cap moi                     ||");
	            System.out.println("||2. Xuat danh sach nha cung cap               ||");
	            System.out.println("||3. Xoa nha cung cap                          ||");
	            System.out.println("||4. Sua nha cung cap                          ||");
	            System.out.println("||5. Tim nha cung cap                          ||");
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
        System.out.println("|1. Sua ho va ten nha cung cap                         |");
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
            System.out.println("Nhap ID nha cung cap can sua: ");

            String ID = sc.nextLine();
            
            String toLowerCase = ID.toLowerCase();

            System.out.print("Nhap ho va ten nha cung cap moi : ");
            String newFullName = sc.nextLine();
            
            boolean flag = false;
            for (int i = 0; i < size; i++) {
                if (toLowerCase.equals(Ncc[i].getId().toLowerCase())) {
                	Ncc[i].setTenNcc(newFullName);
                    System.out.println("Da sua thanh cong!");
                    flag = true;
                }
            }
            if (flag == false) {
                System.out.println("Khong co nha cung cap de sua");
            }
            GhiFile();
            break;
        }
        case 2: {
			sc = new Scanner(System.in);
            System.out.print("Nhap ID nha cung cap can sua: ");
            String ID = sc.nextLine();
            ID = ID.toLowerCase();
            System.out.print("Nhap dia chi moi : ");
            String input = sc.nextLine();
            boolean flag = false;
            for (int i = 0; i < size; i++) {
                if (ID.equals(Ncc[i].getId().toLowerCase())) {
                	Ncc[i].setDiachi(input);
                    System.out.println("Da sua thanh cong!");
                    flag = true;
                }
            }
            if (flag == false) {
                System.out.println("Khong co nha cung cap de sua");
            }
            GhiFile();
            break;
        }
        
        case 4: {
            sc = new Scanner(System.in);
            System.out.print("Nhap ID nha cung cap can sua: ");
            String ID = sc.nextLine();
            String toLowerCase = ID.toLowerCase();

            boolean flag = false;
            for (int i = 0; i < size; i++) {
                if (toLowerCase.equals(Ncc[i].getId().toLowerCase())) {
                	Ncc[i].nhap();
                    System.out.println("Da sua thanh cong!");
                    flag = true;
                }
            }
            if (flag == false) {
                System.out.println("Khong co nha cung cap de sua");
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
        System.out.println(" Xoa nha cung cap ");

        System.out.print("Nhap ID coder can xoa : ");
        String id = sc.nextLine();
        id = id.toLowerCase();
        boolean flag = false;
        
        for (int i = 0; i < size; i++) {
            if ( id.equals(Ncc[i].getId().toLowerCase())) {
            	Ncc[i] = null;
                for (int j = i; j < size; j++) {
                	
                	Ncc[j] = Ncc[j + 1];
                }
                flag = true;
                size--;
                GhiFile();
                System.out.println("Da xoa thanh cong!");
            }
        }

        if (flag == false) {
            System.out.println("Khong co nha cung cap de xoa");
        }

    }
	public void TimKiem() {
		System.out.println("||============ Chon thao tac tim kiem ===============||");
		   System.out.println("||1. Tim nha cung cap theo ID                           ||");
		   System.out.println("||2. Tim nha cung cap theo ten                          ||");
		   System.out.println("||0. Quay lai                                        ||");
		   System.out.println("||===================================================||");
		   System.out.print("Nhap thao tac : ");
		   int select = sc.nextInt();
		   switch (select) {
			   case 1: {
				   sc = new Scanner(System.in);
				   System.out.print("Nhap ID nha cung cap can tim: ");
				   String id = sc.nextLine();
				   id.toLowerCase();
				   boolean flag = false;
				   for (int i = 0; i < size; i++) {
					   if (id.equals(Ncc[i].getId().toLowerCase())) {
						   Ncc[i].xuat();
						   flag = true;
						  
					   }
				   }
				   if (flag == false) {
					   System.out.println("Khong tim thay nha cung cap");
				   }
				   break;
			   }
			   case 2: {
				   sc = new Scanner(System.in);
				   System.out.print("Nhap ho va ten nha cung cap can tim: ");
				   String fullName = sc.nextLine();
				   String toLowerCase = fullName.toLowerCase();
				   boolean flag = false;
				   for (int i = 0; i < size; i++) {
					   if ((Ncc[i].getTenNcc().toLowerCase().contains(toLowerCase))) {
						   Ncc[i].xuat();
						   flag = true;
						   
					   }
				   }
				   if (flag == false) {
					   System.out.println("Khong tim thay nha cung cap");
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
                    Ncc[i] = new Nha_Cung_Cap(id,ten,diachi,sdt);
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
	            FileWriter fw = new FileWriter("D:\\DoAnJava\\NhaCungCap.java\\src\\DSNhaCungCap.txt", false);
	            BufferedWriter bw = new BufferedWriter(fw);
	            PrintWriter pw = new PrintWriter(bw);
	            for (int i = 0; i < size; i++) {
	                pw.println(Ncc[i].getId() + "|"
	                        + Ncc[i].getTenNcc() + "|"
	                        + Ncc[i].getDiachi() + "|"
	                        + Ncc[i].getSdt() + "|");
	            }
	            bw.close();
	        } catch (IOException e) {
	        	System.out.println("Loi khong ghi dc file");
	        }
		
	}
	
}
