package action;

import com.opensymphony.xwork2.ActionSupport;

import dao.UserDao;
import domain.User;

public class AdminScanAction extends ActionSupport 
{
	private int id;//用于接收从页面传来的id参数
	private User userinfo;//从页面直接传递数据
	
	public String execute()
	{
		
		UserDao interUser=new UserDao();
		this.setUserinfo(interUser.selectUserInfo(id));
	  	return "success";
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
