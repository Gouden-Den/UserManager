package action;

import com.opensymphony.xwork2.ActionSupport;

import dao.UserDao;
import domain.User;

public class AdminModifyAction extends ActionSupport {
	private User userinfo;

	@Override
	public String execute() throws Exception {
		UserDao dao = new UserDao();
		int id = dao.getUserid(userinfo.getUsername(), userinfo.getPassword());
		userinfo.setId(id);
		userinfo.setRoleId(1);
		dao.modifyUserInfo(userinfo);
		return SUCCESS;
	}

	public User getUserinfo() {
		return userinfo;
	}

	public void setUserinfo(User userinfo) {
		this.userinfo = userinfo;
	}
	
}
