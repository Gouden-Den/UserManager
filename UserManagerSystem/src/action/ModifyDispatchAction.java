package action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import dao.UserDao;
import domain.User;

public class ModifyDispatchAction extends ActionSupport {
	private User userinfo;
	private int id;
	@Override
	public String execute() throws Exception {
		UserDao dao = new UserDao();
		User user = (User) ActionContext.getContext().getSession().get("user");
		if(id == 0){
			this.setUserinfo(user);
			return "usermodify";
		}else{
			this.setUserinfo(dao.selectUserInfo(id));
			return "othersmodify";
		}
	}
	
	public User getUserinfo() {
		return userinfo;
	}
	public void setUserinfo(User userinfo) {
		this.userinfo = userinfo;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
}
