package action;

import java.util.List;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import dao.UserDao;

public class AdminDeleteAdminAction extends ActionSupport {
	private String tip;
	private int id;
	@Override
	public String execute() throws Exception {
		UserDao dao = new UserDao();
		dao.deleteUser(id);
		List alladmin = dao.findAllAdmins();
		ActionContext.getContext().getSession().remove("alladmin");
		ActionContext.getContext().getSession().put("alladmin", alladmin);
		this.setTip("É¾³ý³É¹¦£¡£¡");
		return SUCCESS;
	}

	public String getTip() {
		return tip;
	}

	public void setTip(String tip) {
		this.tip = tip;
	}
	
}
