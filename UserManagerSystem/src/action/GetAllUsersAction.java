package action;

import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import dao.UserDao;
import domain.User;

public class GetAllUsersAction extends ActionSupport {

	@Override
	public String execute() throws Exception {
		UserDao dao = new UserDao();
		List alluser = new ArrayList();
		alluser = dao.findAllUsers();
		if(ActionContext.getContext().getSession().containsKey("alluser")){
			ActionContext.getContext().getSession().remove("alluser");
		}
		
		ActionContext.getContext().getSession().put("alluser", alluser);
		User user = (User) ActionContext.getContext().getSession().get("user");
		if(user.getRoleId() == 0){
			return "userselect";
		}
		
		return "adminselect";
	}
	
}
