package dao;

import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;

import model.ConnectDTB;
import model.Producer;

public class ProducerDAO {
	public static Map<String, Producer> mapProducer = getLoadProducerDTB();

	public ProducerDAO(){
		
	}
	
	public String getProducerName(String id){
		return mapProducer.get(id).getName();
	}
	
	private static Map<String, Producer> getLoadProducerDTB() {
		Map<String, Producer> listProducer = new HashMap<String, Producer>();
		try {
			ResultSet rs = new ConnectDTB().chonDuLieu("select * from Producer");
			while (rs.next()) {
				String producerID = rs.getString(1);
				String producerName = rs.getString(2);
				String address = rs.getString(3);
				listProducer.put(producerID, new Producer(producerID,producerName,address));
			}
		} catch (Exception e) {
			System.out.println("Lỗi ở load danh sách database " + e.getMessage());
			e.printStackTrace();
			return null;
		}
		return listProducer;

	}
	public static void main(String[] args) {
//		System.out.println(mapProducer);
	}
}
