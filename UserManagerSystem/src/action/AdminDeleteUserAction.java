package action;

import java.util.List;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import dao.UserDao;

public class AdminDeleteUserAction extends ActionSupport {
	private int id;
	private String tip;
	UserDao dao = new UserDao();
	List alluser = dao.findAllUsers();
	@Override
	public String execute() throws Exception {
		int count = dao.deleteUser(id);
		if(count!=0){
			if(ActionContext.getContext().getSession().containsKey("alluser")){
				ActionContext.getContext().getSession().remove("alluser");
			}
			ActionContext.getContext().getSession().put("alluser", alluser);
			this.setTip("É¾³ý³É¹¦£¡£¡");
			return SUCCESS;
		}
		this.setTip("É¾³ýÊ§°Ü£¡£¡");
		return "failure";
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public String getTip() {
		return tip;
	}

	public void setTip(String tip) {
		this.tip = tip;
	}
	
}
