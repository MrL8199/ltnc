package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;

import model.*;

public class NhaCungCapDAO implements ObjectDAO {
	public static Map<String, NhaCungCap> mapNhaCungCap = layDuLieuTuDatabase();
	

	@Override
	public boolean add(Object obj) {
		NhaCungCap ncc = (NhaCungCap) obj;
		mapNhaCungCap.put(ncc.getMaNhaCungCap(), ncc);
		try {
			String sql = "insert into [dbo].[NhaCungCap] values (?,?,?,?,?)";
			Connection connect = ConnectToDatabase.getConnect();
			PreparedStatement ppstm = connect.prepareStatement(sql);
			ppstm.setString(1, ncc.getMaNhaCungCap());
			ppstm.setString(2, ncc.getTenNhaCungCap());
			ppstm.setString(3, ncc.getDiaChi());
			ppstm.setString(4, ncc.getSoDienThoai());
			ppstm.setString(5, ncc.getLogo());
			ppstm.executeUpdate();
		} catch (Exception e) {
			System.out.println("Hệ thống gặp lỗi " + e.getMessage());
			return false;
		}
		return true;
	}
//Phương thức lấy dữ liệu từ database lên sử dụng
	public static Map<String, NhaCungCap> layDuLieuTuDatabase() {
		Map<String, NhaCungCap> map = new HashMap<>();
		try {
			ResultSet rs = new ConnectToDatabase().selectData("select * from  NhaCungCap");
			while (rs.next()) {
				String maNhaCungCap = rs.getString(1);
				String tenNhaCungCap = rs.getString(2);
				String diaChi = rs.getString(3);
				String soDienThoai = rs.getString(4);
				String logo = rs.getString(5);
				NhaCungCap ncc = new NhaCungCap(maNhaCungCap, tenNhaCungCap, diaChi, soDienThoai, logo);
				map.put(ncc.getMaNhaCungCap(), ncc);
			}

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

		return map;
	}

	@Override
	public boolean edit(String id,Object obj) {
		NhaCungCap ncc = (NhaCungCap) obj;
		mapNhaCungCap.replace(ncc.getMaNhaCungCap(), ncc);
		String sql = "update NhaCungCap set Tennhacungcap=?,Diachi=?,Sodienthoai=?,Logo=? where Manhacungcap=?";
		Connection connect;
		try {
			connect = ConnectToDatabase.getConnect();
			PreparedStatement ppstm = connect.prepareStatement(sql);
			ppstm.setString(1, ncc.getTenNhaCungCap());
			ppstm.setString(2, ncc.getDiaChi());
			ppstm.setString(3, ncc.getSoDienThoai());
			ppstm.setString(4, ncc.getLogo());
			ppstm.setString(5, id);
			ppstm.executeUpdate();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
		return true;
	}

	@Override
	public boolean del(String id) {
		mapNhaCungCap.remove(id);
		String sql = "delete from NhaCungCap where Manhacungcap='" + id + "'";
		try {
			new ConnectToDatabase().excuteSql(sql);
		} catch (Exception e) {
			System.out.println("Hệ thống lỗi vì:" + e.getMessage());
			return false;
		}
		return true;
	}
}
