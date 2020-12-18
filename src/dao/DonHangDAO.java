package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;


import model.*;


public class DonHangDAO implements ObjectDAO {
	//Map chứa dữ liệu ở DTB load lên
	public static Map<String, DonHang> mapDonHang = layDuLieuTuDatabase();

	public DonHangDAO() {
	}


	@Override
	public boolean add(Object obj) {
		DonHang dh = (DonHang) obj;
		mapDonHang.put(dh.getId(), dh);
		try {
			String sql = "insert into DonHang values (?,?,?,?,?,?,?,?,?,?,?)";
			Connection connect = ConnectToDatabase.getConnect();
			PreparedStatement ppstm = connect.prepareStatement(sql);
			ppstm.setString(1, dh.getId());
			ppstm.setString(2, dh.getTenKhachHang());
			ppstm.setString(3, dh.getDanhSachMaSanPham());
			ppstm.setString(4, dh.getDanhSachTenSanPham());
			ppstm.setString(5, dh.getTongSoLuong());
			ppstm.setString(6, dh.getTongTien());
			ppstm.setString(7, dh.getNgayMua());
			ppstm.setString(8, dh.getDiaChi());
			ppstm.setString(9, dh.getSoDienThoai());
			ppstm.setString(10, dh.getEmail());
			ppstm.setString(11, dh.getTingTrangDonHang());
			ppstm.executeUpdate();
		} catch (Exception e) {
			System.out.println("Hệ thống gặp lỗi " + e.getMessage());
			return false;
		}
		return true;
	}

	@Override
	public boolean edit(String id,Object obj) {
		DonHang dh = (DonHang) obj;
		mapDonHang.replace(dh.getId(), dh);
		String sql = "update DonHang set Tenkhachhang=?,Danhsachmasanpham=?,Danhsachtensanpham=?,Tongsoluong=?,Tongtien=?,Ngaymua=?,Diachi=?,Sodienthoai=?,Email=?,Tinhtrangdonhang=? where Madonhang=?";
		Connection connect;
		try {
			connect = ConnectToDatabase.getConnect();
			PreparedStatement ppstm = connect.prepareStatement(sql);
			ppstm.setString(1, dh.getTenKhachHang());
			ppstm.setString(2, dh.getDanhSachMaSanPham());
			ppstm.setString(3, dh.getDanhSachTenSanPham());
			ppstm.setString(4, dh.getTongSoLuong());
			ppstm.setString(5, dh.getTongTien());
			ppstm.setString(6, dh.getNgayMua());
			ppstm.setString(7, dh.getDiaChi());
			ppstm.setString(8, dh.getSoDienThoai());
			ppstm.setString(9, dh.getEmail());
			ppstm.setString(10, dh.getTingTrangDonHang());
			ppstm.setString(11,id);

			ppstm.executeUpdate();
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	@Override
	public boolean del(String id) {
		mapDonHang.remove(id);
		String sql = "delete from DonHang where Madonhang='" + id + "'";
		try {
			new ConnectToDatabase().excuteSql(sql);
		} catch (Exception e) {
			System.out.println("Hệ thống lỗi vì:" + e.getMessage());
			return false;
		}
		return true;
	}

	
	//Phương thức load dữ liệu từ database
	public static Map<String, DonHang> layDuLieuTuDatabase() {
		Map<String, DonHang> map = new HashMap<>();
		try {
			ResultSet rs = new ConnectToDatabase().selectData("select * from  DonHang");
			while (rs.next()) {
				String id = rs.getString(1);
				String tenKhachHang = rs.getString(2);
				String danhSachMaSanPham = rs.getString(3);
				String danhSachTenSanPham = rs.getString(4);
				String tongSoLuong = rs.getString(5);
				String tongTien = rs.getString(6);
				String ngayMua = rs.getString(7);
				String diaChi = rs.getString(8);
				String soDienThoai = rs.getString(9);
				String email = rs.getString(10);
				String tinnTrangDonHang = rs.getString(11);
				DonHang dh = new DonHang(id, tenKhachHang, danhSachMaSanPham, danhSachTenSanPham, tongSoLuong, tongTien,
						ngayMua, diaChi, soDienThoai, email, tinnTrangDonHang);
				map.put(dh.getId(), dh);
			}

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

		return map;
	}

	

}
