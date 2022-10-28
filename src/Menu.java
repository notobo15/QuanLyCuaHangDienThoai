import java.util.Scanner;


public class Menu {
	 public static void main(String[] args) {
	       
	        Scanner sc = new Scanner(System.in);
	        
	        
	        DSSanPham dssp = new DSSanPham();
	       
	        int select = 0;
	        do {
	            System.out.println("||================== Menu ===================||");
	            System.out.println("||1. Chon cac thao tac nhan vien quan ly       ||");
	            System.out.println("||2. Chon cac thao tac nhan vien thu ngan      ||");
	            System.out.println("||3. Chon cac thao tac nhan vien ban hang      ||");
	            System.out.println("||4. Chon cac thao tac khach hang   			||");
	            System.out.println("||5. Chon cac thao tac nha cung cap        		||");
	            System.out.println("||6. Chon cac thao tac san pham     		||");
	            System.out.println("||7. Chon cac thao tac don hang    			||");
	            System.out.println("||8. Thong ke   			||");
	            System.out.println("||0. Thoat chuong trinh                      ||");
	            System.out.println("||===========================================||");
	            System.out.print("Nhap lua chon: ");
	            select = sc.nextInt();
	            switch (select) {
	                case 1: {
	                	
	                    break;
	                }
	                case 2: {
	                    break;
	                }
	                case 3: {
	                    break;
	                }
	                case 4: {
	                    break;
	                }
	                case 5:
	                    break;
	                case 6:
	                	dssp.Tao();
	                	dssp.Xuat();
	                    break;
	                case 0:
	                    break;

	                default:
	                    System.out.println("Nhap sai lua chon, xin nhap lai !!!");

	            }
	        } while (select != 0);

	    }
}
