package action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import domain.User;

public class IfCanAddUser extends ActionSupport {
	private String tip;
	
	@Override
	public String execute() throws Exception {
		User user = (User) ActionContext.getContext().getSession().get("user");
		if(user.getRoleId()==0){
			this.setTip("È¨ÏÞ²»¹»£¡£¡");
			return "failure";
		}else{
			return "success";
		}
	}

	public String getTip() {
		return tip;
	}

	public void setTip(String tip) {
		this.tip = tip;
	}
	
}
