package com.core.common.filter;

import java.io.IOException;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.core.common.util.Constant;
import com.core.entity.user.Function;
import com.core.entity.user.QueryFunctionCondition;
import com.core.entity.user.User;
import com.core.service.user.FunctionService;
import com.core.service.user.RoleService;
import com.core.service.user.UserService;

/**
 * @ClassName  LoginFilter
 * @package com.core.common.filter
 * @description 登录用拦截器
 * @author  liuqinggang
 * @Create Date: 2013-3-8 下午11:24:41
 * 
 */
public class LoginFilter implements Filter{

    private FunctionService functionService;
    private UserService userService;
    private User loginedUser;
    private RoleService roleService;
    private static final Logger logger = Logger.getLogger(LoginFilter.class);
    @Override
    public void destroy() {
        
    }

    
    @Override
    public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) arg0;
        HttpServletResponse response = (HttpServletResponse) arg1;
        
        boolean flag = false;
        HttpSession session = request.getSession();
        //判断是否有此功能
        
        String invokeUrl = request.getRequestURL().toString();
        logger.info("+++ LoginFilter invokeUrl:"+invokeUrl);
        List<Function> functionList = functionService.getFunctionList(new QueryFunctionCondition());
        boolean hasFunction = false;
        for (Function function : functionList) {
            if (function.getFunctionUrl() != null && function.getFunctionUrl().indexOf(invokeUrl) != -1){
                hasFunction = true;
            }
        }
        //cookie
        /*
        ActionContext actionContext = actionInvocation.getInvocationContext();   
        HttpServletRequest request= (HttpServletRequest) actionContext.get(StrutsStatics.HTTP_REQUEST);
        //HttpServletResponse response= (HttpServletResponse)actionContext.get(StrutsStatics.HTTP_RESPONSE);
        
        String userId= CookieUtils.getCookie(request, Constant.SYS_USER_SESSION_NAME);
        if(StringUtils.isNotEmpty(userId)){
            userId=DESCoder.decrypt(userId);
            //session中用户信息存在无需查询
            User user = (User) session.get(Constant.SYS_USER_SESSION_NAME);
            if(user!=null){
                return actionInvocation.invoke();
            }
            
            user= userService.getUserById(Integer.valueOf(userId));
            List<Role> roleList =  roleService.getRoleListByUserId(user.getUserId());
            functionList = this.userService.getUserFunctionMap(roleList);
            
            
            // 用户所属功能权限，用于权限树生成
            List<Function> curUserFunctionList = this.userService.getUserFunction(roleList);
            
            List<List<Function>> tabUserFunctionList = processTabUserFunctionList(new ArrayList<Function>(
                    curUserFunctionList));
            
            ActionContext.getContext().getSession().clear();
            session.put("userfunctionList", functionList);
            session.put("curUserFunctionList", curUserFunctionList);
            session.put("tabUserFunctionList", tabUserFunctionList);
            
            session.put(Constant.SYS_USER_SESSION_NAME,user);
            
            return actionInvocation.invoke();
        }*/
        
        //session
        User user = (User) session.getAttribute(Constant.SYS_USER_SESSION_NAME);
        if(user==null){
            logger.info("++ user should login in invokeUrl:"+invokeUrl);
            // return "reLogin";
        }
        if(user.getUserId()==1){
            logger.info("++ user action pass  userName:"+user.getLoginName()+",invokeUrl:"+invokeUrl);
            //return actionInvocation.invoke();
        }
        
        //访问路径在权限管理中时再做验证
        if (hasFunction) {
            List<String>  userfunctionList = (List<String>)session.getAttribute("userfunctionList");
            if(userfunctionList!=null){
                for (String function : userfunctionList) {
                    if (function!= null && function.indexOf(invokeUrl) != -1){
                        flag = true;
                    }
                }
            }
        }
        setLoginedUser(user);
        if(!flag&&hasFunction){
            logger.info("++ user want access limit url userName:"+user.getLoginName()+",invokeUrl:"+invokeUrl);
            //return LoginAction.ERROR_LIMIT_VERIFY;
        }else{
            logger.info("++ user action pass  userName:"+user.getLoginName()+",invokeUrl:"+invokeUrl);
            //return actionInvocation.invoke();
        }
        
        chain.doFilter(request, response);
        
    }

    
    @Override
    public void init(FilterConfig arg0) throws ServletException {
    }


    public FunctionService getFunctionService() {
        return functionService;
    }


    public void setFunctionService(FunctionService functionService) {
        this.functionService = functionService;
    }


    public UserService getUserService() {
        return userService;
    }


    public void setUserService(UserService userService) {
        this.userService = userService;
    }


    public User getLoginedUser() {
        return loginedUser;
    }


    public void setLoginedUser(User loginedUser) {
        this.loginedUser = loginedUser;
    }


    public RoleService getRoleService() {
        return roleService;
    }


    public void setRoleService(RoleService roleService) {
        this.roleService = roleService;
    }

}
