package BEAN;

public class TacGia {
	private String id;
	private String email;
	private String hoTen;
	private String password;
	public TacGia(String id, String email, String hoTen, String password) {
		super();
		this.id = id;
		this.email = email;
		this.hoTen = hoTen;
		this.password = password;
	}
	public TacGia(String id) {
		super();
		this.id = id;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getHoTen() {
		return hoTen;
	}
	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
