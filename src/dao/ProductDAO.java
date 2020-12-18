package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;

import model.ConnectDTB;
import model.KhachHang;
import model.Order;
import model.Product;
import model.ProductOrder;

public class ProductDAO implements ObjectDAO {
	public static Map<String, Product> mapProduct = getLoadProductDTB();
	public static Map<String, Product> mapUndo = new HashMap<>();
	public static Map<String, Product> mapProductOrder = new HashMap<>();
	public static Set<String> setProducer = getSetProducer();

	public boolean delAll() {
		mapUndo.putAll(mapProduct);
		mapProduct.clear();

		return true;
	}

	public static Set<String> getSetProducer() {
		Set<String> producer = new HashSet<>();
		for (Product sp : mapProduct.values()) {
			producer.add(sp.getProducerID());
		}
		return producer;
	}

	public Map<String, Product> getSelectProducer(String producerName) {
		Map<String, Product> mapSelectProduct = new HashMap<>();
		for (Product sp : mapProduct.values()) {
			if (sp.getProducerID().equals(producerName)) {
				mapSelectProduct.put(sp.getProductID(), sp);
			}
		}
		return mapSelectProduct;
	}

	public String getNameProduct(String id) {
		boolean ok = false;
		char[] arrchar = id.toCharArray();
		for (int i = 0; i < arrchar.length; i++) {
			if (",".equals(arrchar[i] + "")) {
				ok = true;
			}
		}
		String name = "";
		if (ok) {
//			id=id.substring(0,id.length()-1);
			String[] arr = id.split(",");
			for (Product sp : mapProduct.values()) {
				for (int i = 0; i < arr.length; i++) {
					if (sp.getProductID().equals(arr[i])) {
						name += sp.getProductName() + ",";
					}
				}
			}
			return name;
		} else {
			for (Product sp : mapProduct.values()) {
				if (sp.getProductID().equals(id)) {
					name = sp.getProductName();
				}
			}
			return name;
		}
	}

	public Product findProductOrder(String id) {
		return mapProduct.get(id);
	}

	public boolean undo() {
		mapProduct.putAll(mapUndo);
		mapUndo.clear();
		return true;
	}

	public boolean delProductOrder(String id) {
		mapProductOrder.remove(id);
		return true;
	}

	public static String getTotalProductOrder() {
		String sp = "";
		for (Product od : mapProductOrder.values()) {
			sp += od.getProductID() + ",";
		}
		return sp;
	}

	public String tongGiaTienDatHang() {
		String gia = "0";
		for (Product od : mapProductOrder.values()) {
			gia = Integer.parseInt(od.getPrice()) + Integer.parseInt(gia) + "";
		}
		return gia;
	}
	public static String danhSachTen(){
		String s=getTotalProductOrder();
		String rs = "";
		// Danh sách mã truyền vào
		List<String> list= Arrays.asList(s.split(","));
		// Danh sách các tên trùng với mã truyền vào
		List<String> ten = list.stream().map(p->mapProductOrder.get(p).getProductName()).collect(Collectors.toList());
		// gép các tên thành 1 chuỗi
		for (String string : ten) {
			rs+=string+","; // kết quả đã có nhưng kẹt dấu phẩy ở cuối
		}
		return rs.substring(0, rs.length()-1); // trả về 1 chuỗi bỏ đi kí tự cuối vì kí tự cuối là dấu phẩy
	}
	
	public boolean addProductOrder(Product sp) {
		mapProductOrder.put(sp.getProductID(), sp);
		return true;
	}

	public int random(int limit) {
		Random rd = new Random();
		int res = rd.nextInt(limit);
		while (mapProduct.containsKey("Product" + res)) {
			res = rd.nextInt(limit);
		}
		return res;
	}

	public Map<String, Product> getListProductByProducerID(String producerid) {
		Map<String, Product> listProductByProducerID = new HashMap<>();
		for (Product sp : mapProduct.values()) {
			if (sp.getProducerID().equals(producerid)) {
				listProductByProducerID.put(sp.getProductID(), sp);
			}
		}
		return listProductByProducerID;
	}

	@Override
	public boolean add(Object obj) {
		Product sp = (Product) obj;
		mapProduct.put(sp.getProductID(), sp);
		try {
			Connection connection = ConnectDTB.connect();
			PreparedStatement statement = connection.prepareStatement("insert into Product values(?,?,?,?,?)");
			statement.setString(1, sp.getProductID());
			statement.setString(2, sp.getProductName());
			statement.setString(3, sp.getPrice());
			statement.setString(4, sp.getProducerID());
			statement.setString(5, sp.getImg());
			statement.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			return false;
		}
		return false;
	}

	public static Map<String, Product> getLoadProductDTB() {
		Map<String, Product> listProduct = new HashMap<String, Product>();
		try {
			ResultSet rs = new ConnectDTB().chonDuLieu("select * from Product");
			while (rs.next()) {
				String productID = rs.getString(1);
				String productName = rs.getString(2);
				String price = rs.getString(3);
				String producerID = rs.getString(4);
				String img = rs.getString(5);
				listProduct.put(productID, new Product(productID, productName, price, producerID, img));
			}
		} catch (Exception e) {
			System.out.println("Lỗi ở load danh sách database " + e.getMessage());
			e.printStackTrace();
			return null;
		}
		return listProduct;
	}

	@Override
	public boolean edit(Object obj) {
		Product sp = (Product) obj;
		mapProduct.replace(sp.getProductID(), sp);
		try {
			Connection connection = ConnectDTB.connect();
			String sql = "update Product set ProductID=?,ProductName=?,Price=?,ProducerID=?,Image=? where ProductID=?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, sp.getProductID());
			preparedStatement.setString(2, sp.getProductName());
			preparedStatement.setString(3, sp.getPrice());
			preparedStatement.setString(4, sp.getProducerID());
			preparedStatement.setString(5, sp.getImg());
			preparedStatement.setString(6, sp.getProductID());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			return false;
		}
		return true;
	}

	@Override
	public boolean del(String id) {
		mapProduct.remove(id);
		try {
			new ConnectDTB().thucThiSQL("delete from Product where ProductID='" + id + "'");
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
		return true;
	}

}
