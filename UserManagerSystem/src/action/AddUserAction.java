package action;

import com.opensymphony.xwork2.ActionSupport;

import dao.UserDao;
import domain.User;

public class AddUserAction extends ActionSupport 
{

	private User user;//����User�������ڽ��ձ�����
	UserDao interUser=new UserDao();
	public String execute()
	{
		
		user.setRoleId(0);//����Ȩ��roleId����0
		int count=interUser.addUser(user);//�����ݿ����������
		if(count>0){
	    	return "success";
		}
		return "input";
	}
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	@Override
	public void validate()
	{
		boolean flag=interUser.isExistUsername(user.getUsername());
		if(flag)
		{
			this.addFieldError("addusererr", "�����ͨ�û�ʧ�ܣ��û����Ѵ���");
		}
	}

}
