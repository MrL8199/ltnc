package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ConnectDTB {
	public static String sqlDB;
	public static String sqlDBOffline;
	
	public ConnectDTB() {
		super();
		sqlDB = "jdbc:sqlserver://localhost:1433;database=JAVA_BanSach;user=sa;password=1234567890";		
	}
	
	public static  Connection connect(){
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection connect = DriverManager.getConnection(sqlDB);
			return connect;
		} catch (SQLException | ClassNotFoundException e ) {
			System.out.println(e.getMessage());
		}
		return null;
	}
	public boolean createTableIntoDatabase(String tableName,ArrayList<String> column){
		String sql="CREATE TABLE "+tableName+" ( ";
		for (int i = 0; i < column.size(); i++) {
			if(i!=column.size()-1){
				//náº¿u lÃ  cá»™t khÃ´ng pháº£i lÃ  cuá»‘i cÃ¹ng thÃ¬ cuá»‘i giÃ¡ gá»‹ dá»¯ liá»‡u sáº½ lÃ  dáº¥u ,
				sql+=column.get(i)+" nvarchar(255), ";
			}else{
				// nếu là cột cuối cùng thì đóng ngoặc và ;
				sql+=column.get(i)+" nvarchar(255) );";
			}
		}
		try {
			//truyá»�n vÃ o Ä‘á»‘i tÆ°á»£ng connect() láº¥y Ä‘Æ°á»£c vÃ o
			Connection connect =connect();
			Statement stmt = connect.createStatement();
			stmt.executeUpdate(sql);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			return false;
		}
		return true;
	}
	public  void thucThiSQL(String sql) throws Exception{
		Connection connect =connect();
		Statement stmt = connect.createStatement();
		stmt.executeUpdate(sql);
	}
	public ResultSet chonDuLieu(String sql) throws Exception{
		Connection connect =connect();
		Statement stmt = connect.createStatement();
		ResultSet rs=	stmt.executeQuery(sql);
		return rs;
	}
	public static void main(String[] args) {
//		ArrayList<String> list = new ArrayList<>();
//		list.add("colone");
//		list.add("coltwo");
//		list.add("colthree");
//		System.out.println(new ConnectDTB().createTableIntoDatabase("okokok", list));
	}
}
