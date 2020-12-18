package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;

import model.*;

public class SanPhamDAO implements ObjectDAO {
	public static Map<String, SanPham> mapSanPham = layDuLieuTuDatabase();

	@Override
	public boolean add(Object obj) {
		SanPham sp = (SanPham) obj;
		mapSanPham.put(sp.getMaSanPham(), sp);
		try {
			String sql = "insert into SanPham values (?,?,?,?,?,?,?,?,?,?)";
			Connection connect = ConnectToDatabase.getConnect();
			PreparedStatement ppstm = connect.prepareStatement(sql);
			ppstm.setString(1, sp.getMaSanPham());
			ppstm.setString(2, sp.getTenSanPham());
			ppstm.setString(3, sp.getGiaGiam());
			ppstm.setString(4, sp.getGiaTien());
			ppstm.setString(5, sp.getSoLuong());
			ppstm.setString(6, sp.getMaNhaCungCap());
			ppstm.setString(7, sp.getMaLoaiSanPham());
			ppstm.setString(8, sp.getHinhAnh());
			ppstm.setString(9, sp.getSoLuongNhap());
			ppstm.setString(10, sp.getSoLuongBan());
			ppstm.executeUpdate();
		} catch (Exception e) {
			System.out.println("Hệ thống gặp lỗi " + e.getMessage());
			return false;
		}
		return true;
	}

	public static Map<String, SanPham> layDuLieuTuDatabase() {
		Map<String, SanPham> map = new HashMap<>();
		try {
			ResultSet rs = new ConnectToDatabase().selectData("select * from  SanPham");
			while (rs.next()) {
				String maSanPham = rs.getString(1);
				String tenSanPham = rs.getString(2);
				String giaGiam = rs.getString(3);
				String giaTien = rs.getString(4);
				String soLuong = rs.getString(5);
				String maNhaCungCap = rs.getString(6);
				String maLoaiSanPham = rs.getString(7);
				String hinhAnh = rs.getString(8);
				String soLuongNhap = rs.getString(9);
				String soLuongBan = rs.getString(10);
				SanPham sp = new SanPham(maSanPham, tenSanPham, giaTien, soLuong, maNhaCungCap, maLoaiSanPham, hinhAnh,
						soLuongNhap, soLuongBan, giaGiam);
				map.put(sp.getMaSanPham(), sp);
			}

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

		return map;
	}

	@Override
	public boolean edit(String id,Object obj) {
		SanPham sp = (SanPham) obj;
		mapSanPham.replace(sp.getMaSanPham(), sp);
		String sql = "update SanPham set Ten=?,Giadagiam=?,Giaban=?,Soluong=?,Nhacungcap=?,Maloai=?,Hinhanh=?,Soluongnhap=?,Soluongban=? where Masanpham=?";
		Connection connect;
		try {
			connect = ConnectToDatabase.getConnect();
			PreparedStatement ppstm = connect.prepareStatement(sql);
			ppstm.setString(1, sp.getTenSanPham());
			ppstm.setString(2, sp.getGiaGiam());
			ppstm.setString(3, sp.getGiaTien());
			ppstm.setString(4, sp.getSoLuong());
			ppstm.setString(5, sp.getMaNhaCungCap());
			ppstm.setString(6, sp.getMaLoaiSanPham());
			ppstm.setString(7, sp.getHinhAnh());
			ppstm.setString(8, sp.getSoLuongNhap());
			ppstm.setString(9, sp.getSoLuongBan());
			ppstm.setString(10, id);
			ppstm.executeUpdate();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
		return true;
	}

	@Override
	public boolean del (String id) {
		mapSanPham.remove(id);
		String sql = "delete from SanPham where Masanpham='" + id + "'";
		try {
			new ConnectToDatabase().excuteSql(sql);
		} catch (Exception e) {
			System.out.println("Hệ thống lỗi vì:" + e.getMessage());
			return false;
		}
		return true;
	}

	

}
