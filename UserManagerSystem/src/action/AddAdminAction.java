package action;

import java.util.List;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import dao.UserDao;
import domain.User;

public class AddAdminAction extends ActionSupport {
	private User admin;
	UserDao dao = new UserDao();
	
	@Override
	public String execute() throws Exception {
		dao.addAdmin(admin);
		List alladmin = dao.findAllAdmins();
		if(ActionContext.getContext().getSession().containsKey("alladmin")){
			ActionContext.getContext().getSession().remove("alladmin");
		}
		ActionContext.getContext().getSession().put("alladmin", alladmin);
		return "success";
	}

	public User getAdmin() {
		return admin;
	}

	public void setAdmin(User admin) {
		this.admin = admin;
	}
	
}
