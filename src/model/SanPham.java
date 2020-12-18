package model;

public class SanPham {
	String maSanPham;
	String tenSanPham;
	String giaTien;
	String soLuong;
	String maNhaCungCap;
	String maLoaiSanPham;
	String hinhAnh;
	String soLuongNhap;
	String soLuongBan;
	String giaGiam;
	public SanPham(String maSanPham, String tenSanPham, String giaTien, String soLuong, String maNhaCungCap,
			String maLoaiSanPham, String hinhAnh, String soLuongNhap, String soLuongBan, String giaGiam) {
		super();
		this.maSanPham = maSanPham;
		this.tenSanPham = tenSanPham;
		this.giaTien = giaTien;
		this.soLuong = soLuong;
		this.maNhaCungCap = maNhaCungCap;
		this.maLoaiSanPham = maLoaiSanPham;
		this.hinhAnh = hinhAnh;
		this.soLuongNhap = soLuongNhap;
		this.soLuongBan = soLuongBan;
		this.giaGiam = giaGiam;
	}
	public String getMaSanPham() {
		return maSanPham;
	}
	public void setMaSanPham(String maSanPham) {
		this.maSanPham = maSanPham;
	}
	public String getTenSanPham() {
		return tenSanPham;
	}
	public void setTenSanPham(String tenSanPham) {
		this.tenSanPham = tenSanPham;
	}
	public String getGiaTien() {
		return giaTien;
	}
	public void setGiaTien(String giaTien) {
		this.giaTien = giaTien;
	}
	public String getSoLuong() {
		return soLuong;
	}
	public void setSoLuong(String soLuong) {
		this.soLuong = soLuong;
	}
	public String getMaNhaCungCap() {
		return maNhaCungCap;
	}
	public void setMaNhaCungCap(String maNhaCungCap) {
		this.maNhaCungCap = maNhaCungCap;
	}
	public String getMaLoaiSanPham() {
		return maLoaiSanPham;
	}
	public void setMaLoaiSanPham(String maLoaiSanPham) {
		this.maLoaiSanPham = maLoaiSanPham;
	}
	public String getHinhAnh() {
		return hinhAnh;
	}
	public void setHinhAnh(String hinhAnh) {
		this.hinhAnh = hinhAnh;
	}
	public String getSoLuongNhap() {
		return soLuongNhap;
	}
	public void setSoLuongNhap(String soLuongNhap) {
		this.soLuongNhap = soLuongNhap;
	}
	public String getSoLuongBan() {
		return soLuongBan;
	}
	public void setSoLuongBan(String soLuongBan) {
		this.soLuongBan = soLuongBan;
	}
	public String getGiaGiam() {
		return giaGiam;
	}
	public void setGiaGiam(String giaGiam) {
		this.giaGiam = giaGiam;
	}
	@Override
	public String toString() {
		return "SanPham [maSanPham=" + maSanPham + ", tenSanPham=" + tenSanPham + ", giaTien=" + giaTien + ", soLuong="
				+ soLuong + ", maNhaCungCap=" + maNhaCungCap + ", maLoaiSanPham=" + maLoaiSanPham + ", hinhAnh="
				+ hinhAnh + ", soLuongNhap=" + soLuongNhap + ", soLuongBan=" + soLuongBan + ", giaGiam=" + giaGiam
				+ "]";
	}
	
	
}
