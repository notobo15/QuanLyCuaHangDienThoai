
public class KhachHang extends ConNguoi {
	private String diaChiGiaohang;
	private String thuocNhom;
	private static int stt = 0;
	public KhachHang() {
	}
	
	public KhachHang(String id, String hoVaTen,  String gioiTinh,String diaChi,Date ngaySinh, String thuocNhom, String diaChiGiaohang,String e,String sdt) {
		super(id, hoVaTen, gioiTinh, diaChi, ngaySinh, e, sdt);
		this.diaChiGiaohang = diaChiGiaohang;
		this.thuocNhom = thuocNhom;
	}
	public void setId() {
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
	public String getdiaChiGiaohang() {
		return diaChiGiaohang;
	}
	public void setdiaChiGiaohang(String diaChiGiaohang) {
		this.diaChiGiaohang = diaChiGiaohang;
	}


	@Override
    public String toString() {
        return super.toString();
    }
	public void xuat() {
		
		super.xuat();
		System.out.print("\t" + thuocNhom +"\t\t" + diaChiGiaohang+"\n");
	}
    public void nhap() {
    	super.nhap();
    	setId();
        System.out.println("Moi nhap Nhom:");
        setthuocNhom(sc.nextLine());
        System.out.println("Moi nhap diaChiGiaohang:");
        setdiaChiGiaohang(sc.nextLine());
    }
	
}

