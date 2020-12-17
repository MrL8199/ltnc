package  model;

public class ChiTietSanPham {
	private String masp;
	private String moTa1;
	private String moTa2;
	private String moTa3;
	private String moTa4;
	private String moTa5;
	private String hinhAnhChiTiet;
	public ChiTietSanPham(String masp, String moTa1, String moTa2, String moTa3, String moTa4, String moTa5,
			String hinhAnhChiTiet) {
		super();
		this.masp = masp;
		this.moTa1 = moTa1;
		this.moTa2 = moTa2;
		this.moTa3 = moTa3;
		this.moTa4 = moTa4;
		this.moTa5 = moTa5;
		this.hinhAnhChiTiet = hinhAnhChiTiet;
	}
	public String getMasp() {
		return masp;
	}
	public void setMasp(String masp) {
		this.masp = masp;
	}
	public String getMoTa1() {
		return moTa1;
	}
	public void setMoTa1(String moTa1) {
		this.moTa1 = moTa1;
	}
	public String getMoTa2() {
		return moTa2;
	}
	public void setMoTa2(String moTa2) {
		this.moTa2 = moTa2;
	}
	public String getMoTa3() {
		return moTa3;
	}
	public void setMoTa3(String moTa3) {
		this.moTa3 = moTa3;
	}
	public String getMoTa4() {
		return moTa4;
	}
	public void setMoTa4(String moTa4) {
		this.moTa4 = moTa4;
	}
	public String getMoTa5() {
		return moTa5;
	}
	public void setMoTa5(String moTa5) {
		this.moTa5 = moTa5;
	}
	public String getHinhAnhChiTiet() {
		return hinhAnhChiTiet;
	}
	public void setHinhAnhChiTiet(String hinhAnhChiTiet) {
		this.hinhAnhChiTiet = hinhAnhChiTiet;
	}
	@Override
	public String toString() {
		return "ChiTietSanPham [masp=" + masp + ", moTa1=" + moTa1 + ", moTa2=" + moTa2 + ", moTa3=" + moTa3
				+ ", moTa4=" + moTa4 + ", moTa5=" + moTa5 + ", hinhAnhChiTiet=" + hinhAnhChiTiet + "]";
	}
	
}