package model;

public class DonHang {
	String id;
	String tenKhachHang;
	String danhSachMaSanPham ;
	String danhSachTenSanPham;
	String tongSoLuong;
	String tongTien;
	String ngayMua;
	String diaChi;
	String soDienThoai;
	String email;
	String tingTrangDonHang;
	public DonHang(String id, String tenKhachHang, String danhSachMaSanPham, String danhSachTenSanPham,
			String tongSoLuong, String tongTien, String ngayMua, String diaChi, String soDienThoai, String email,
			String tingTrangDonHang) {
		super();
		this.id = id;
		this.tenKhachHang = tenKhachHang;
		this.danhSachMaSanPham = danhSachMaSanPham;
		this.danhSachTenSanPham = danhSachTenSanPham;
		this.tongSoLuong = tongSoLuong;
		this.tongTien = tongTien;
		this.ngayMua = ngayMua;
		this.diaChi = diaChi;
		this.soDienThoai = soDienThoai;
		this.email = email;
		this.tingTrangDonHang = tingTrangDonHang;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTenKhachHang() {
		return tenKhachHang;
	}
	public void setTenKhachHang(String tenKhachHang) {
		this.tenKhachHang = tenKhachHang;
	}
	public String getDanhSachMaSanPham() {
		return danhSachMaSanPham;
	}
	public void setDanhSachMaSanPham(String danhSachMaSanPham) {
		this.danhSachMaSanPham = danhSachMaSanPham;
	}
	public String getDanhSachTenSanPham() {
		return danhSachTenSanPham;
	}
	public void setDanhSachTenSanPham(String danhSachTenSanPham) {
		this.danhSachTenSanPham = danhSachTenSanPham;
	}
	public String getTongSoLuong() {
		return tongSoLuong;
	}
	public void setTongSoLuong(String tongSoLuong) {
		this.tongSoLuong = tongSoLuong;
	}
	public String getTongTien() {
		return tongTien;
	}
	public void setTongTien(String tongTien) {
		this.tongTien = tongTien;
	}
	public String getNgayMua() {
		return ngayMua;
	}
	public void setNgayMua(String ngayMua) {
		this.ngayMua = ngayMua;
	}
	public String getDiaChi() {
		return diaChi;
	}
	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}
	public String getSoDienThoai() {
		return soDienThoai;
	}
	public void setSoDienThoai(String soDienThoai) {
		this.soDienThoai = soDienThoai;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTingTrangDonHang() {
		return tingTrangDonHang;
	}
	public void setTingTrangDonHang(String tingTrangDonHang) {
		this.tingTrangDonHang = tingTrangDonHang;
	}
	@Override
	public String toString() {
		return "DonHang [id=" + id + ", tenKhachHang=" + tenKhachHang + ", danhSachMaSanPham=" + danhSachMaSanPham
				+ ", danhSachTenSanPham=" + danhSachTenSanPham + ", tongSoLuong=" + tongSoLuong + ", tongTien="
				+ tongTien + ", ngayMua=" + ngayMua + ", diaChi=" + diaChi + ", soDienThoai=" + soDienThoai + ", email="
				+ email + ", tingTrangDonHang=" + tingTrangDonHang + "]";
	}
	
	
	
}
