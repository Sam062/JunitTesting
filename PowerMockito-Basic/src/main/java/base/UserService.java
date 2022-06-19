package base;

public class UserService {
	private UserDao userDao;

	public UserService() {
		super();
	}

	public UserService(UserDao userDao) {
		super();
		this.userDao = userDao;
	}

	public String getEmailById(Integer id) {
		return userDao.findEmailById(id);
	}
	
	public String doWork(String msg) {
		return formatName(msg);
	}

	private String formatName(String name) {
		return name.toLowerCase();
	}

}
