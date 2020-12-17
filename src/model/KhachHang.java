package model;

public class KhachHang {
		String ten;
		String taiKhoan;
		String matKhau;
		String gioiTinh;
		String soDienThoai;
		String email;
		String ngaySinh;
		String diaChi;
		String soLuongMua;
		String role;
		public KhachHang(String ten, String taiKhoan, String matKhau, String gioiTinh, String soDienThoai, String email,
				String ngaySinh, String diaChi, String soLuongMua, String role) {
			super();
			this.ten = ten;
			this.taiKhoan = taiKhoan;
			this.matKhau = matKhau;
			this.gioiTinh = gioiTinh;
			this.soDienThoai = soDienThoai;
			this.email = email;
			this.ngaySinh = ngaySinh;
			this.diaChi = diaChi;
			this.soLuongMua = soLuongMua;
			this.role = role;
		}
		public String getTen() {
			return ten;
		}
		public void setTen(String ten) {
			this.ten = ten;
		}
		public String getTaiKhoan() {
			return taiKhoan;
		}
		public void setTaiKhoan(String taiKhoan) {
			this.taiKhoan = taiKhoan;
		}
		public String getMatKhau() {
			return matKhau;
		}
		public void setMatKhau(String matKhau) {
			this.matKhau = matKhau;
		}
		public String getGioiTinh() {
			return gioiTinh;
		}
		public void setGioiTinh(String gioiTinh) {
			this.gioiTinh = gioiTinh;
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
		public String getNgaySinh() {
			return ngaySinh;
		}
		public void setNgaySinh(String ngaySinh) {
			this.ngaySinh = ngaySinh;
		}
		public String getDiaChi() {
			return diaChi;
		}
		public void setDiaChi(String diaChi) {
			this.diaChi = diaChi;
		}
		public String getSoLuongMua() {
			return soLuongMua;
		}
		public void setSoLuongMua(String soLuongMua) {
			this.soLuongMua = soLuongMua;
		}
		public String getRole() {
			return role;
		}
		public void setRole(String role) {
			this.role = role;
		}
		@Override
		public String toString() {
			return "KhachHang [ten=" + ten + ", taiKhoan=" + taiKhoan + ", matKhau=" + matKhau + ", gioiTinh="
					+ gioiTinh + ", soDienThoai=" + soDienThoai + ", email=" + email + ", ngaySinh=" + ngaySinh
					+ ", diaChi=" + diaChi + ", soLuongMua=" + soLuongMua + ", role=" + role + "]";
		}
		
		
}
