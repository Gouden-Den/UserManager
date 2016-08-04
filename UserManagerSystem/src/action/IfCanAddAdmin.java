package action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import domain.User;

public class IfCanAddAdmin extends ActionSupport {
	private String tip;

	@Override
	public String execute() throws Exception {
		User user = (User) ActionContext.getContext().getSession().get("user");
		if(user.getRoleId()==0){
			this.setTip("权限不够i，赶紧滚！！");
			return "failure";
		}else if(user.getRoleId()==1){
			this.setTip("权限不够，赶紧滚！！");
			return "failure";
		}
		return "success";
	}

	public String getTip() {
		return tip;
	}

	public void setTip(String tip) {
		this.tip = tip;
	}
	
}
