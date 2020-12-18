package model;

public class publisher {
    String id;
	String name;
	
	
	public publisher(String id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "publisher [id=" + id + ", name=" + name + "]";
	}
	
	
}
