package base;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.powermock.api.mockito.PowerMockito;

public class MyServiceTest {
	
	@Test
	public void getEmailTest() {
		
		UserDao userDaoMock = PowerMockito.mock(UserDao.class);
		PowerMockito.when(userDaoMock.getEmailById(123)).thenReturn("XYZABC");
		when(userDaoMock.getEmailById(111)).thenReturn("AAAAA");
		
		MyService myserv=new MyService(userDaoMock);
		
		String email = myserv.getEmail(111);
		assertEquals("AAAAA", email);
		
	}

}
