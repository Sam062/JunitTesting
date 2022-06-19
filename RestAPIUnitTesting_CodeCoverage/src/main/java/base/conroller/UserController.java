package base.conroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

	@Autowired
	private UserService userServ;

	@GetMapping(value = "/test")
	public ResponseEntity<?> testApi() {

		String welcomeMsg = userServ.getWelcomeMsg();
		return new ResponseEntity<>("App Up And Running, " + welcomeMsg, HttpStatus.OK);
	}

	@PostMapping(value = "/saveUser", consumes = { "application/json" })
	public ResponseEntity<?> testPostReq(@RequestBody UserModel model) {
		boolean status = userServ.saveUser(model);

		if (status)
			return new ResponseEntity<>("User Saved Successfully", HttpStatus.CREATED);
		else {
			System.out.println("---------------------------------------------ELSE EXECUTED");
			return new ResponseEntity<>("User Save failed.", HttpStatus.BAD_REQUEST);
		}
	}

}
