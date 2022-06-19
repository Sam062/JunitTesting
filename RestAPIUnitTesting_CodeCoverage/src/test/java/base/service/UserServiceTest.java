package base.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;

import base.conroller.UserService;
import base.model.UserModel;

@WebMvcTest(value = UserService.class)
public class UserServiceTest {
	private UserService userService = new UserService();

	@Test
	public void getWelcomeMsgTest() {
		String welcomeMsg = userService.getWelcomeMsg();
		assertEquals("Good Morning", welcomeMsg);

	}

	@Test
	public void saveUserTestSuccess() {
		boolean status = userService.saveUser(new UserModel("SAM", "25", "LKO"));
		assertEquals(true, status);
	}

	@Test
	public void saveUserTestFailure() {
		boolean status = userService.saveUser(null);

		assertEquals(false, status);

	}

}
