package dao;

import java.util.Stack;

import model.KhachHang;
import model.Order;
import model.Product;

public class UndoDAO {
		public static Stack<KhachHang> undoCustomer = new Stack<>();
		public static Stack<Product> undoProduct = new Stack<>();
		public static Stack<Order> undoOrder = new Stack<>();
		
		public boolean restoreDeletedCustomer(){
			if(!undoCustomer.isEmpty()){
				KhachHang kh = undoCustomer.pop();
				System.out.println(kh);
				if(kh!=null){
					KhachHangDAO.mapKhachHang.put(kh.getMaKH(), kh);
				}
				return true;
			}else{
				return false;
			}
		}
		public boolean restoreDeletedProduct(){
			if(!undoProduct.isEmpty()){
				Product sp = undoProduct.pop();
				if(sp!=null){
					ProductDAO.mapProduct.put(sp.getProductID(), sp);
				}
				return true;
			}else{
				return false;
			}
		}
		public boolean restoreDeletedOrder(){
			if(!undoOrder.isEmpty()){
				Order o = undoOrder.pop();
				if(o!=null){
					OrderDAO.mapOrder.put(o.getOrderID(), o);
				}
				return true;
			}else{
				return false;
			}
		}
}
