package com.core.service.impl.user;

import com.core.dao.user.LoginLogDao;
import com.core.entity.user.LoginLog;
import com.core.service.user.LoginLogService;

/**
 * @ClassName LoginLogServiceImpl
 * @package com.core.service.impl.user
 * @description 用户登陆日志
 * @author liuqinggang
 * @Create Date: 2013-3-8 下午04:31:54
 * 
 */
public class LoginLogServiceImpl implements LoginLogService {

    private LoginLogDao loginLogDao;
    /** 添加登陆日志 */
    @Override
    public void addLoginLog(LoginLog loginLog) {
        loginLogDao.addLoginLog(loginLog);
    }
    
    public LoginLogDao getLoginLogDao() {
        return loginLogDao;
    }
    public void setLoginLogDao(LoginLogDao loginLogDao) {
        this.loginLogDao = loginLogDao;
    }

}
