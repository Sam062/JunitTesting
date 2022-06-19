package base.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;

import base.conroller.UserController;
import base.conroller.UserService;
import base.model.UserModel;

@WebMvcTest(value = UserController.class)
public class UserControllerTest {

	@MockBean
	private UserService userService;

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void testWelcomeMsg() throws Exception {
		when(userService.getWelcomeMsg()).thenReturn("Hi, Good Morning");

		MockHttpServletRequestBuilder reqBuilder = MockMvcRequestBuilders.get("/test");

		ResultActions perform = mockMvc.perform(reqBuilder);
		MvcResult result = perform.andReturn();

		MockHttpServletResponse response = result.getResponse();
		int status = response.getStatus();

		assertEquals(200, status);
	}

	@Test
	public void testSaveUserSuccess() throws Exception {
		when(userService.saveUser(ArgumentMatchers.any())).thenReturn(true);

		UserModel userModel = new UserModel("SAM", "24", "LKO");
		String userJson = new ObjectMapper().writeValueAsString(userModel);

		MockHttpServletRequestBuilder reqBuilder = MockMvcRequestBuilders.post("/saveUser")
				.contentType(MediaType.APPLICATION_JSON).content(userJson);

		ResultActions perform = mockMvc.perform(reqBuilder);
		MvcResult result = perform.andReturn();

		MockHttpServletResponse response = result.getResponse();
		int status = response.getStatus();

		assertEquals(201, status);
	}
	@Test
	public void testSaveUserFailure() throws Exception {
		when(userService.saveUser(null)).thenReturn(false);
		
		UserModel userModel = new UserModel("XYZ", null, "AAA");
		String userJson = new ObjectMapper().writeValueAsString(userModel);
		
		MockHttpServletRequestBuilder reqBuilder = MockMvcRequestBuilders.post("/saveUser")
				.contentType(MediaType.APPLICATION_JSON).content(userJson);
		
		ResultActions perform = mockMvc.perform(reqBuilder);
		MvcResult result = perform.andReturn();
		
		MockHttpServletResponse response = result.getResponse();
		int status = response.getStatus();
		
		assertEquals(400, status);
	}

}
