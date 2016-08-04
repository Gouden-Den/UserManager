package action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import dao.UserDao;
import domain.User;

public class UserScanAction extends ActionSupport {
	private int id;
	private User userinfo;
	
	@Override
	public String execute() throws Exception {
		UserDao dao = new UserDao();
		User user = (User) ActionContext.getContext().getSession().get("user");
		if(id != 0){
			this.setUserinfo(dao.selectUserInfo(id));
		}else{
			this.setUserinfo(user);
		}
		
		return SUCCESS;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public User getUserinfo() {
		return userinfo;
	}
	public void setUserinfo(User userinfo) {
		this.userinfo = userinfo;
	}
	
}
