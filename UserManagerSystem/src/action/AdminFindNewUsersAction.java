package action;

import java.util.List;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import dao.UserDao;
import domain.User;

public class AdminFindNewUsersAction extends ActionSupport {
	private String tip;

	@Override
	public String execute() throws Exception {
		User user = (User) ActionContext.getContext().getSession().get("user");
		if(user.getRoleId()==0){
			this.setTip("È¨ÏÞ²»¹»£¬¸Ï½ô¹ö£¡£¡");
			return "failure";
		}else{
			UserDao dao = new UserDao();
			List newuser = dao.findNewUsers();
			if(ActionContext.getContext().getSession().containsKey("newuser")){
				ActionContext.getContext().getSession().remove("newuser");
			}
			ActionContext.getContext().getSession().put("newuser", newuser);
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
