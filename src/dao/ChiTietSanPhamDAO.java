package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;
import model.*;



public class ChiTietSanPhamDAO implements ObjectDAO{

	public static Map<String, ChiTietSanPham> mapChiTietSanPham = layDuLieuTuDatabase();

	//kiểm tra thông tin sản phẩm này đã có trong database chưa
	public boolean checkProductIDDuplicate(String maSanPham){
		ChiTietSanPham ctsp = mapChiTietSanPham.get(maSanPham);
		return (ctsp != null) ? true:false;
	}
	
	@Override
	public boolean add(Object obj) {
		ChiTietSanPham ncc = (ChiTietSanPham) obj;
		mapChiTietSanPham.put(ncc.getMasp(), ncc);
		try {
			String sql = "insert into Thongtinsanpham values (?,?,?,?,?,?,?)";
			Connection getConnect = ConnectToDatabase.getConnect();
			PreparedStatement ppstm = getConnect.prepareStatement(sql);
			ppstm.setString(1, ncc.getMasp());
			ppstm.setString(2, ncc.getMoTa1());
			ppstm.setString(3, ncc.getMoTa2());
			ppstm.setString(4, ncc.getMoTa3());
			ppstm.setString(5, ncc.getMoTa4());
			ppstm.setString(6, ncc.getMoTa5());
			ppstm.setString(7, ncc.getHinhAnhChiTiet());
			ppstm.executeUpdate();
		} catch (Exception e) {
			System.out.println("Hệ thống gặp lỗi " + e.getMessage());
			return false;
		}
		return true;
	}
//Phương thức lấy dữ liệu từ database lên sử dụng
	public static Map<String, ChiTietSanPham> layDuLieuTuDatabase() {
		Map<String, ChiTietSanPham> map = new HashMap<>();
		try {
			ResultSet rs = new ConnectToDatabase().selectData("select * from  Thongtinsanpham");
			while (rs.next()) {
				String maSanPham = rs.getString(1);
				String moTa1 = rs.getString(2);
				String moTa2 = rs.getString(3);
				String moTa3 = rs.getString(4);
				String moTa4 = rs.getString(5);
				String moTa5 = rs.getString(6);
				String hinhAnhChiTiet = rs.getString(7);
				ChiTietSanPham ncc = new ChiTietSanPham(maSanPham, moTa1, moTa2, moTa3, moTa4, moTa5, hinhAnhChiTiet);
				map.put(ncc.getMasp(), ncc);
			}

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

		return map;
	}

	@Override
	public boolean edit(String id,Object obj) {
		ChiTietSanPham ncc = (ChiTietSanPham) obj;
		mapChiTietSanPham.replace(ncc.getMasp(), ncc);
		String sql = "update Thongtinsanpham set mota1=?,mota2=?,mota3=?,mota4=?,mota5=?,hinhanhchitiet=? where Masanpham=?";
		Connection getConnect;
		try {
			getConnect = ConnectToDatabase.getConnect();
			PreparedStatement ppstm = getConnect.prepareStatement(sql);
			ppstm.setString(1, ncc.getMoTa1());
			ppstm.setString(2, ncc.getMoTa2());
			ppstm.setString(3, ncc.getMoTa3());
			ppstm.setString(4, ncc.getMoTa4());
			ppstm.setString(5, ncc.getMoTa5());
			ppstm.setString(6, ncc.getHinhAnhChiTiet());
			ppstm.setString(7, id);
			ppstm.executeUpdate();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
		return true;
	}

	@Override
	public boolean del(String id) {
		mapChiTietSanPham.remove(id);
		String sql = "delete from Thongtinsanpham where Masanpham='" + id + "'";
		try {
			new ConnectToDatabase().excuteSql(sql);
		} catch (Exception e) {
			System.out.println("Hệ thống lỗi vì:" + e.getMessage());
			return false;
		}
		return true;
	}

}
