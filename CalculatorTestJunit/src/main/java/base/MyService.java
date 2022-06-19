package base;

public class MyService {

	private UserDao dao;

	public MyService() {
		super();
	}

	public MyService(UserDao dao) {
		super();
		this.dao = dao;
	}

	public String getEmail(Integer id) {
		dao = new UserDao();
		String email = dao.getEmailById(id);

		return email.toUpperCase();

	}

}
