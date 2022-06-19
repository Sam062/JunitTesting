package base;

import static org.junit.Assert.assertEquals;

import org.junit.Assert;
import org.junit.Test;
import org.powermock.api.mockito.PowerMockito;

public class UserDaoTest {

	@Test
	public void testAdd() {
		Integer a = 10;
		Integer b = 20;

		assertEquals(30, a + b);
	}

	@Test
	public void testFindEmailById() {
		UserDao mockDao = PowerMockito.mock(UserDao.class);
		PowerMockito.when(mockDao.findEmailById(222)).thenReturn("MMMM");

		UserService serv = new UserService(mockDao);
		String email = serv.getEmailById(222);

		assertEquals("MMMM", email);
	}

	@Test
	public void testUserDao() {
		UserDao userDao = new UserDao();

		assertEquals("abc@xyz", userDao.findEmailById(12));
	}
	
//	@Test
//	public void testDoWork() throws Exception {
//		String message = "Hello PowerMockito";
//        String expectation = "Expectation";
// 
//        UserService mock = PowerMockito.spy(new UserService());
//        PowerMockito.doReturn(expectation).when(mock, expectation, message);
// 
//        String actual = mock.doWork(message);
//        Assert.assertEquals(expectation, actual);
//	}

}
