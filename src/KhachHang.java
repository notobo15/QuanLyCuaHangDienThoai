
public class KhachHang extends ConNguoi {
	private String thuocNhom;
	public KhachHang() {
	}
	
	public KhachHang(String id, String hoVaTen,  String gioiTinh,String diaChi,Date ngaySinh, String thuocNhom,String e,String sdt) {
		super(id, hoVaTen, gioiTinh, diaChi, ngaySinh, e, sdt);
		this.thuocNhom = thuocNhom;
	}
	public void setId(int stt) 	{
		super.id = "KH"+ stt;
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
		
		super.xuat();
		System.out.print("\t" + thuocNhom +"\t\t");
	}
    public void nhap() {
    	super.nhap();
    	setId();
        System.out.println("Moi nhap Nhom:");
        setthuocNhom(sc.nextLine());
    }
	
}

