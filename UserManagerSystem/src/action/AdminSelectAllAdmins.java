package action;

import java.util.List;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import dao.UserDao;
import domain.User;

public class AdminSelectAllAdmins extends ActionSupport {
	private String tip;
	@Override
	public String execute() throws Exception {
		User user = (User) ActionContext.getContext().getSession().get("user");
		if(user.getRoleId()==0){
			this.setTip("当前用户为普通用户，没权限，赶紧滚！！");
			return "failure";
		}else{
			UserDao dao = new UserDao();
			List alladmin = dao.findAllAdmins();
			ActionContext.getContext().getSession().put("alladmin", alladmin);
		}
		if(user.getRoleId()==1){
			return "smalladmin";
		}else{
			return "bigadmin";
		}
		
	}
	public String getTip() {
		return tip;
	}
	public void setTip(String tip) {
		this.tip = tip;
	}
	
}
