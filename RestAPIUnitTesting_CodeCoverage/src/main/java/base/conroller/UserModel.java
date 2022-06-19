package base.conroller;

public class UserModel {

	private String userName;
	private String age;
	private String addr;
	
	public UserModel(String userName, String age, String addr) {
		super();
		this.userName = userName;
		this.age = age;
		this.addr = addr;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	@Override
	public String toString() {
		return "UserModel [userName=" + userName + ", age=" + age + ", addr=" + addr + "]";
	}

}
