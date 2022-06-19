package base.conroller;

import org.springframework.stereotype.Service;

import base.model.UserModel;

@Service
public class UserService {
	
	public String getWelcomeMsg() {
		return "Good Morning";
	}
	
	
	public boolean saveUser(UserModel model) {
		if(model!=null && model.getAge()!=null)
			return true;
		else
			return false;
	}

}
