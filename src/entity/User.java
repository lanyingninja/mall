package entity;

public class User {
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(String username, String password, String cellphone, String email, double money) {
		super();
		this.username = username;
		this.password = password;
		this.cellphone = cellphone;
		this.email = email;
		this.money = money;
	}
	private String username;
	private String password;
	private String cellphone;
	private String email;
	private double money;
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public double getMoney() {
		return money;
	}
	public void setMoney(double money) {
		this.money = money;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getCellphone() {
		return cellphone;
	}
	public void setCellphone(String cellphone) {
		this.cellphone = cellphone;
	}
	
	

}
