package action;

import com.opensymphony.xwork2.ActionSupport;

import dao.UserDao;
import domain.User;

public class AdminGetDataAction extends ActionSupport {
	private int id;
	private User userinfo;
	
	@Override
	public String execute() throws Exception {
		UserDao dao = new UserDao();
		this.setUserinfo(dao.selectUserInfo(id));
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
