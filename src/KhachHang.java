
public class KhachHang extends ConNguoi {
	private String thuocNhom;
	public KhachHang() {
	}
	
	public KhachHang(String id, String hoVaTen,  String gioiTinh,String diaChi,Date ngaySinh, String thuocNhom,String e,String sdt) {
		super(id, hoVaTen, gioiTinh, diaChi, ngaySinh, e, sdt);
		this.thuocNhom = thuocNhom;
	}
	public void setId(int stt) 	{
		super.id = "KH"+ ++stt;
	}
	public String getId() {
		return this.id;
	}
	public String getthuocNhom() {
		return thuocNhom;
	}
	public void setthuocNhom(String thuocNhom) {
		for(;;){
            if(thuocNhom.equalsIgnoreCase("Vip") 
            || thuocNhom.equalsIgnoreCase("Si")
            || thuocNhom.equalsIgnoreCase("Le")
              )
                break;
            System.out.println("Moi nhap lai (Vip/ Si/Le):");
            thuocNhom=sc.nextLine();
        }
		this.thuocNhom = thuocNhom;
	}



	@Override
    public String toString() {
        return super.toString();
    }
	public void xuat() {
		
		System.out.printf("|  %-10s", getId());
		System.out.printf("%-25s", getHoVaTen());
		System.out.printf("%-15s", getGioiTinh());
		System.out.printf("%-15s", getDiaChi());
		System.out.printf("%-15s", getNgaySinh());
		System.out.printf("%-15s", getEmail());
		System.out.printf("%-15s", getSdt());
		System.out.printf("%-13s|%n", getthuocNhom());
	}
    public void nhap() {
    	System.out.println("Moi nhap ho ten:");
		setHoVaTen(sc.nextLine());
		System.out.println("Moi nhap gioi tinh:");
		setGioiTinh(sc.nextLine());
		System.out.println("Moi nhap dia chi:");
		setDiaChi(sc.nextLine());
		System.out.println("Moi nhap ngay sinh:");
		ngaySinh.setTime();
		System.out.println("Moi nhap email:");
		setEmail(sc.nextLine());
		System.out.println("Moi nhap sdt:");
		setSdt(sc.nextLine());
    	setId();
        System.out.println("Moi nhap Nhom:");
        setthuocNhom(sc.nextLine());
    }

}

