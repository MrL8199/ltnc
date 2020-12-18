package controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.OrderDAO;
import dao.ProductDAO;
import model.Order;
import model.Product;


@WebServlet("/Dropdown")
public class DropdownController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public DropdownController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		String chucNang = request.getParameter("chucNang");
		OrderDAO.mapOrder=OrderDAO.getLoadOrderDTB();
		ProductDAO.mapProduct=ProductDAO.getLoadProductDTB();
		if(chucNang.equals("Order")){
			String date=request.getParameter("date");
			Map<String,Order> mapFilter = new OrderDAO().getSelectOrderDate(date);
			OrderDAO.mapOrder.clear();
			OrderDAO.mapOrder.putAll(mapFilter);
			response.sendRedirect("showorder.jsp");
		}else
			//chức năng hiển thị product đã lọc
			if(chucNang.equals("Product")){
			String id=request.getParameter("id");
			Map<String,Product> mapFilter = new ProductDAO().getSelectProducer(id);
			ProductDAO.mapProduct.clear();
			ProductDAO.mapProduct.putAll(mapFilter);
			response.sendRedirect("showproduct.jsp");
		}else
			//chức năng hiển thị tất cả đơn hàng
			if(chucNang.equals("AllOrder")){
			ProductDAO.mapProduct=ProductDAO.getLoadProductDTB();
			OrderDAO.mapOrder=OrderDAO.getLoadOrderDTB();
			response.sendRedirect("showorder.jsp");
		}else
			//chức năng hiển thị tất cả product
			if(chucNang.equals("AllProduct")){
			ProductDAO.mapProduct=ProductDAO.getLoadProductDTB();
			OrderDAO.mapOrder=OrderDAO.getLoadOrderDTB();
			response.sendRedirect("showproduct.jsp");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
