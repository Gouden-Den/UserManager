package action;

import com.opensymphony.xwork2.ActionSupport;

import dao.UserDao;
import domain.User;

public class UserModifyAction extends ActionSupport {
	private User userinfo;
	@Override
	public String execute() throws Exception {
		UserDao dao = new UserDao();
		int id = dao.getUserid(userinfo.getUsername(), userinfo.getPassword());
		int roleid = dao.getUserroleId(id);
		userinfo.setId(id);
		userinfo.setRoleId(roleid);
		int count = dao.modifyUserInfo(userinfo);
		
		if(count>0){
			return SUCCESS;
		}else{
			return "error";
		}
	}
	
	public User getUserinfo() {
		return userinfo;
	}
	public void setUserinfo(User userinfo) {
		this.userinfo = userinfo;
	}
	
}
