package action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import dao.UserDao;
import domain.User;

public class UserLoginAction extends ActionSupport {
	private User user;
	private String loginerror;
	@Override
	public String execute() throws Exception {
		UserDao dao = new UserDao();
		boolean flag = dao.login(user);
		if(flag){
			ActionContext.getContext().getSession().put("user", user);
			return SUCCESS;
		}
		this.setLoginerror("用户名或密码输入错误");
		return INPUT;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	public String getLoginerror() {
		return loginerror;
	}
	public void setLoginerror(String loginerror) {
		this.loginerror = loginerror;
	}
}
