package interceptor;

import java.util.List;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

import dao.UserDao;

public class GetAllUserInterceptor extends AbstractInterceptor {

	@Override
	public String intercept(ActionInvocation arg0) throws Exception {
		UserDao dao = new UserDao();
		List alluserList = dao.findAllUsers();
		List addadminList = dao.findAllAdmins();
		arg0.getInvocationContext().getSession().put("alladminList", addadminList);
		arg0.getInvocationContext().getSession().put("alluserList", alluserList);
		
		return arg0.invoke();	
	}

}
