
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class DSKhachHang implements ThaoTac {
    private static int size = 0;
    public KhachHang[] Kh = new KhachHang[1000];
    static Scanner sc = new Scanner(System.in);

    public DSKhachHang() {
    }

    public KhachHang[] getKh() {
        return Kh;
    }

    public void setKh(KhachHang[] Kh) {
        this.Kh = Kh;
    }

    @Override
    public void Tao() {
        System.out.println("Nhap so luong khach hang can them: ");
        int slKh = sc.nextInt();
        for (int i = size; i < size + slKh; i++) {
            Kh[i] = new KhachHang();
            System.out.println("Nhap thong tin khach hang");
            Kh[i].nhap();
            System.out.println("Them khach hang thanh cong");
        }
        size += slKh;
        GhiFile();
    }

    @Override
    public void Xuat() {
        System.out.println("ID\tHO VA TEN\t\t\tGIOI TINH\tDIA CHI\t\tNGAY SINH\tEMAIL\t\tSDT\t\tNhom\t\tDiaChiGiaHang");
        // System.out.println("-------------------------------------------"
        // + "----------------------------------------------------"
        // + "------------------------------------------------------");
        for (int i = 0; i <= 140; i++) {
            System.out.print("-");
        }
        System.out.println();

        for (int i = 0; i < size; i++) {
            Kh[i].xuat();
        }

    }

    @Override
    public void Xoa() {
        sc = new Scanner(System.in);
        System.out.println(" Xoa khach hang ");

        System.out.print("Nhap ID coder can xoa : ");
        String id = sc.nextLine();
        id = id.toLowerCase();
        boolean flag = false;

        for (int i = 0; i < size; i++) {
            if (id.equals(Kh[i].getId().toLowerCase())) {
                Kh[i] = null;
                for (int j = i; j < size; j++) {

                    Kh[j] = Kh[j + 1];
                }
                flag = true;
                size--;
                GhiFile();
                System.out.println("Da xoa thanh cong!");
            }
        }

        if (flag == false) {
            System.out.println("Khong co khach hang de xoa");
        }

    }

    @Override
    public void XuatMenu() {
        int select = 0;
        DocFile();
        do {
            System.out.println("||============ Chon thao tac ===============||");
            System.out.println("||1. Them khach hang moi                     ||");
            System.out.println("||2. Xuat danh sach khach hang               ||");
            System.out.println("||3. Xoa khach hang                          ||");
            System.out.println("||4. Sua khach hang                          ||");
            System.out.println("||5. Tim khach hang                          ||");
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

    // public String kiemTraInput(String str) {
    // do {
    // System.out.println("Nhap ID khach hang can sua: ");
    // System.out.println("0. thoat");
    // str = sc.nextLine();
    // }while(str != "0");
    // str = ID.toLowerCase();
    // return str;
    // }
    @Override
    public void Sua() {
        String id = "";
        System.out.println("nhap id cua khach hang ");
        System.out.println("0. thoat");
        id = sc.nextLine();
        for (;;) {
            for (int i = 0; i < size; i++) {
                if (Kh[i].getId().equalsIgnoreCase(id)) {
                    break;
                }
            }
            if (id.equalsIgnoreCase("0"))
                break;
            System.out.println("id khong ton tai moi ban nhap lai");
            System.out.println("0. thoat");
            id = sc.nextLine();
        }
        ;
        if (id.equals("0")) {

        }
        for (int i = 0; i <= 140; i++) {
            System.out.print("-");
        }
        System.out.println("+--------------- Chon muc ban muon sua ---------------+");
        System.out.println("|1. Sua ho va ten khach hang                           |");
        System.out.println("|2. Sua gioi tinh                                     |");
        System.out.println("|3. Sua dia chi                                       |");
        System.out.println("|4. Sua ngay sinh                                     |");
        System.out.println("|5. Sua email                                         |");
        System.out.println("|6. Sua so dien thoai                                 |");
        System.out.println("|7. Sua thuoc nhom                                    |");
        System.out.println("|8. Sua dia chi giao hang                             |");
        System.out.println("|9. Sua tat ca                                        |");
        System.out.println("|0. Quay lai                                          |");
        System.out.println("+-----------------------------------------------------+");
        System.out.print("Nhap thao tac : ");
        int select = sc.nextInt();
        switch (select) {
            case 1: {
                sc = new Scanner(System.in);
                System.out.println("Nhap ID khach hang can sua: ");

                String ID = sc.nextLine();

                String toLowerCase = ID.toLowerCase();

                System.out.print("Nhap ho va ten khach hang moi : ");
                String newFullName = sc.nextLine();

                boolean flag = false;
                for (int i = 0; i < size; i++) {
                    if (toLowerCase.equals(Kh[i].getId().toLowerCase())) {
                        Kh[i].setHoVaTen(newFullName);
                        System.out.println("Da sua thanh cong!");
                        flag = true;
                    }
                }
                if (flag == false) {
                    System.out.println("Khong co khach hang de sua");
                }
                GhiFile();
                break;
            }
            case 2: {
                sc = new Scanner(System.in);
                System.out.print("Nhap ID khach hang can sua: ");
                System.out.print("0. Quay lai ");
                String ID = sc.nextLine();
                ID = ID.toLowerCase();
                System.out.print("gioi tinh moi : ");
                String input = sc.nextLine();
                boolean flag = false;
                for (int i = 0; i < size; i++) {
                    if (ID.equals(Kh[i].getId().toLowerCase())) {
                        Kh[i].setGioiTinh(input);
                        System.out.println("Da sua thanh cong!");
                        flag = true;
                    }
                }
                if (flag == false) {
                    System.out.println("Khong co khach hang de sua");
                }
                GhiFile();
                break;
            }
            case 3: {
                sc = new Scanner(System.in);
                System.out.print("Nhap ID khach hang can sua: ");
                String ID = sc.nextLine();
                ID = ID.toLowerCase();
                System.out.print("Nhap dia chi moi : ");
                String input = sc.nextLine();
                boolean flag = false;
                for (int i = 0; i < size; i++) {
                    if (ID.equals(Kh[i].getId().toLowerCase())) {
                        Kh[i].setDiaChi(input);
                        System.out.println("Da sua thanh cong!");
                        flag = true;
                    }
                }
                if (flag == false) {
                    System.out.println("Khong co khach hang de sua");
                }
                GhiFile();
                break;
            }
            case 4: {
                sc = new Scanner(System.in);
                System.out.print("Nhap ID khach hang can sua: ");
                String ID = sc.nextLine();
                ID = ID.toLowerCase();
                boolean flag = false;
                for (int i = 0; i < size; i++) {
                    if (ID.equals(Kh[i].getId().toLowerCase())) {
                        Date ngaySinhMoi = new Date();
                        ngaySinhMoi.setTime();
                        Kh[i].setNgaySinh(ngaySinhMoi);
                        System.out.println("Da sua thanh cong!");
                        flag = true;
                    }
                }
                if (flag == false) {
                    System.out.println("Khong co khach hang de sua");
                }
                GhiFile();
                break;
            }
            case 5: {
                sc = new Scanner(System.in);
                System.out.print("Nhap ID khach hang can sua: ");
                String ID = sc.nextLine();
                ID = ID.toLowerCase();
                System.out.print("Nhap email moi : ");
                String input = sc.nextLine();
                boolean flag = false;
                for (int i = 0; i < size; i++) {
                    if (ID.equals(Kh[i].getId().toLowerCase())) {
                        Kh[i].setEmail(input);
                        System.out.println("Da sua thanh cong!");
                        flag = true;
                    }
                }
                if (flag == false) {
                    System.out.println("Khong co khach hang de sua");
                }
                GhiFile();
                break;
            }
            case 6: {
                sc = new Scanner(System.in);
                System.out.print("Nhap ID khach hang can sua: ");
                String ID = sc.nextLine();
                ID = ID.toLowerCase();
                System.out.print("Nhap so dien thoai moi : ");
                String input = sc.nextLine();
                boolean flag = false;
                for (int i = 0; i < size; i++) {
                    if (ID.equals(Kh[i].getId().toLowerCase())) {
                        Kh[i].setSdt(input);
                        System.out.println("Da sua thanh cong!");
                        flag = true;
                    }
                }
                if (flag == false) {
                    System.out.println("Khong co khach hang de sua");
                }
                GhiFile();
                break;
            }
            case 7: {
                sc = new Scanner(System.in);
                System.out.print("Nhap ID khach hang can sua: ");
                String ID = sc.nextLine();
                String toLowerCase = ID.toLowerCase();
                System.out.print("Nhap chuc vu moi : ");
                String newthuocNhom = sc.nextLine();
                boolean flag = false;
                for (int i = 0; i < size; i++) {
                    if (toLowerCase.equals(Kh[i].getId().toLowerCase())) {
                        Kh[i].setthuocNhom(newthuocNhom);
                        System.out.println("Da sua thanh cong!");
                        flag = true;
                    }
                }

                if (flag == false) {
                    System.out.println("Khong co khach hang de sua");
                }
                GhiFile();
                break;
            }
            case 8: {
                sc = new Scanner(System.in);
                System.out.print("Nhap ID khach hang can sua: ");
                String ID = sc.nextLine();
                String toLowerCase = ID.toLowerCase();
                System.out.print("Nhap dia chi gia hang moi : ");
                String newdiaChiGiaohang = sc.nextLine();
                boolean flag = false;
                for (int i = 0; i < size; i++) {
                    if (toLowerCase.equals(Kh[i].getId().toLowerCase())) {
                        Kh[i].setdiaChiGiaohang(newdiaChiGiaohang);
                        System.out.println("Da sua thanh cong!");
                        flag = true;
                    }
                }
                if (flag == false) {
                    System.out.println("Khong co khach hang de sua");
                }
                GhiFile();
                break;
            }
            case 9: {
                sc = new Scanner(System.in);
                System.out.print("Nhap ID khach hang can sua: ");
                String ID = sc.nextLine();
                String toLowerCase = ID.toLowerCase();

                boolean flag = false;
                for (int i = 0; i < size; i++) {
                    if (toLowerCase.equals(Kh[i].getId().toLowerCase())) {
                        Kh[i].nhap();
                        System.out.println("Da sua thanh cong!");
                        flag = true;
                    }
                }
                if (flag == false) {
                    System.out.println("Khong co khach hang de sua");
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

    @Override
    public void TimKiem() {
        System.out.println("||============ Chon thao tac tim kiem ===============||");
        System.out.println("||1. Tim khach hang theo ID                           ||");
        System.out.println("||2. Tim khach hang theo ten                          ||");
        System.out.println("||0. Quay lai                                        ||");
        System.out.println("||===================================================||");
        System.out.print("Nhap thao tac : ");
        try {
            int select = sc.nextInt();
            switch (select) {
                case 1: {
                    sc = new Scanner(System.in);
                    System.out.print("Nhap ID khach hang can tim: ");
                    String id = sc.nextLine();
                    id.toLowerCase();
                    boolean flag = false;
                    for (int i = 0; i < size; i++) {
                        if (id.equals(Kh[i].getId().toLowerCase())) {
                            Kh[i].xuat();
                            flag = true;

                        }
                    }
                    if (flag == false) {
                        System.out.println("Khong tim thay khach hang");
                    }
                    break;
                }
                case 2: {
                    sc = new Scanner(System.in);
                    System.out.print("Nhap ho va ten khach hang can tim: ");
                    String fullName = sc.nextLine();
                    String toLowerCase = fullName.toLowerCase();
                    boolean flag = false;
                    for (int i = 0; i < size; i++) {
                        if ((Kh[i].getHoVaTen().toLowerCase().contains(toLowerCase))) {
                            Kh[i].xuat();
                            flag = true;

                        }
                    }
                    if (flag == false) {
                        System.out.println("Khong tim thay khach hang");
                    }
                }
                case 0:
                    break;
                default:
                    System.out.println("Nhap sai thao tac, xin nhap lai !!!");

            }
        } catch (Exception e) {
            System.out.println("vui long nhap");
        }

    }

    @Override
    public void DocFile() {
        int i = 0;
        try {
            FileReader fr = new FileReader("D:\\QuanLyCuaHangDienThoai-dev\\src\\khachang.txt");
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
                    String gioiTinh = txt[2];
                    String diachi = txt[3];
                    String date = txt[4];
                    String tam[] = date.split("\\/");
                    int ngay = Integer.parseInt(tam[0]);
                    int thang = Integer.parseInt(tam[1]);
                    int nam = Integer.parseInt(tam[2]);
                    Date ngaySinh = new Date(ngay, thang, nam);
                    String e = txt[5];
                    String sdt = txt[6];
                    String diaChiGiaohang = txt[7];
                    String thuocNhom = txt[8];
                    Kh[i] = new KhachHang(id, ten, diachi, gioiTinh, ngaySinh, thuocNhom, diaChiGiaohang, e, sdt);
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
    public void GhiFile() {
        try {
            FileWriter fw = new FileWriter("..\\database\\DSKhachHang.txt", false);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);
            for (int i = 0; i < size; i++) {
                pw.println(Kh[i].getId() + "|"
                        + Kh[i].getHoVaTen() + "|"
                        + Kh[i].getGioiTinh() + "|"
                        + Kh[i].getDiaChi() + "|"
                        + Kh[i].ngaySinh.toString() + "|"
                        + Kh[i].getEmail() + "|"
                        + Kh[i].getSdt() + "|"
                        + Kh[i].getdiaChiGiaohang() + "|"
                        + Kh[i].getthuocNhom());
            }
            bw.close();
        } catch (IOException e) {
            System.out.println("Loi khong ghi dc file");
        }

    }

}
