package dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import model.KhachHang;
import model.ObjExcel;
import model.Order;
import model.Product;

public class FileDAO {
	String text;

	public FileDAO(String text) {
		super();
		this.text = text;
	}

	public String getStringArray() {
		String res = "";
		String[] str = this.text.split("[\n]");
		for (String string : str) {
			res += string.trim();
		}

		String sf = "";
		int batDau = 0;
		int ketThuc = 0;
		for (int i = 0; i < res.length(); i++) {
			if (res.charAt(i) != ' ') {
				sf += res.charAt(i) + "";
			}
		}
		for (int i = 0; i < sf.length(); i++) {
			if (sf.charAt(i) == '[') {
				batDau = i;
				break;
			}
		}
		for (int i = 0; i < sf.length(); i++) {
			if (sf.charAt(i) == ']') {
				ketThuc = i;
				break;
			}
		}
		res = sf.substring(batDau, ketThuc);
		res = res.substring(1, res.length());

		return res;
	}

	public Map<String, KhachHang> getCustomer(String s) {
		ArrayList<String> listBig = new ArrayList<>();
		ArrayList<String> list = new ArrayList<>();
		Map<String, KhachHang> mapOBJ = new HashMap<String, KhachHang>();
		//lấy ra từng hàng của file excel
		s = s.substring(1, s.length() - 1);
		String[] arr = s.split("}");
		for (int i = 0; i < arr.length; i++) {
			if (i == 0) {
				arr[i] = arr[i].substring(0, arr[i].length());
			} else {
				arr[i] = arr[i].substring(2, arr[i].length());
			}
			listBig.add(arr[i]);
		}
		//Kiểm tra xem danh sách nhận từ excel có hợp lệ hay không,nếu có thì import,ngược lại là return null
		if (listBig.size() < 5 || listBig.size() > 5) {
			return null;
		} else {
			//Lấy ra từng giá trị của hàng,tạo ra object tương ứng,truyền giá trị của hàng vào thuộc tính
			for (int j = 0; j < listBig.size(); j++) {
				list = getStringDoubleDot(listBig.get(j));
				mapOBJ.put(list.get(0), new KhachHang(list.get(0), list.get(1), list.get(2), list.get(3), list.get(4)));
			}
		}
		return mapOBJ;
	}

	public Map<String, Product> getProduct(String s) {
		ArrayList<String> listBig = new ArrayList<>();
		ArrayList<String> list = new ArrayList<>();
		Map<String, Product> mapProduct = new HashMap<>();
		s = s.substring(1, s.length() - 1);
		String[] arr = s.split("}");
		for (int i = 0; i < arr.length; i++) {
			if (i == 0) {
				arr[i] = arr[i].substring(0, arr[i].length());
			} else {
				arr[i] = arr[i].substring(2, arr[i].length());
			}
			listBig.add(arr[i]);
		}
		if (listBig.size() < 5 || listBig.size() > 5) {
			return null;
		} else {
			for (int j = 0; j < listBig.size(); j++) {
				list = getStringDoubleDot(listBig.get(j));
				mapProduct.put(list.get(0),
						new Product(list.get(0), list.get(1), list.get(2), list.get(3), list.get(4)));
			}
		}
		return mapProduct;
	}

	public Map<String, Order> getOrder(String s) {
		ArrayList<String> listBig = new ArrayList<>();
		ArrayList<String> list = new ArrayList<>();
		Map<String, Order> mapOrder = new HashMap<>();
		s = s.substring(1, s.length() - 1);
		String[] arr = s.split("}");
		for (int i = 0; i < arr.length; i++) {
			if (i == 0) {
				arr[i] = arr[i].substring(0, arr[i].length());
			} else {
				arr[i] = arr[i].substring(2, arr[i].length());
			}
			listBig.add(arr[i]);
		}
		if (listBig.size() < 5 || listBig.size() > 5) {
			return null;
		} else {
			for (int j = 0; j < listBig.size(); j++) {
				list = getStringDoubleDot(listBig.get(j));
				mapOrder.put(list.get(0), new Order(list.get(0), list.get(1), list.get(2), list.get(3), list.get(4)));
			}
		}
		return mapOrder;
	}

	public ArrayList<String> getStringDoubleDot(String s) {
		ArrayList<String> list = new ArrayList<>();
		String[] arr = s.split(",");
		for (int i = 0; i < arr.length; i++) {
			list.add(arr[i].split(":")[1]);
		}
		return list;
	}

	public static void main(String[] args) {
		String st = "{  ok.xlsx: {    Sheet1: [      {        Tên:  Phong ,         Lớp :  B ,         Khoa :  CNTT       },      {         Tên :  Hậu , Lớp :  C ,         Khoa :  CNTT       },{         Tên :  Hòa ,         Lớp :  C ,         Khoa :  Thú Y       }], Sheet2 :[], Sheet3 :[]}} ;";
		String ok = "Tên:Phong,Lớp:B,Khoa:CNTT";
		FileDAO test = new FileDAO(st);
		// System.out.println(test.getStringArray());
		// System.out.println(test.getStringDoubleDot(ok));
		System.out.println(test.getCustomer(test.getStringArray()));
	}
}
