package com.core.dao.user;

import com.core.entity.user.LoginLog;

/**
 * @ClassName  LoginLogDao
 * @package com.core.dao.user
 * @description
 * @author  liuqinggang
 * @Create Date: 2013-3-8 下午04:33:46
 * 
 */
public interface LoginLogDao {
    /** 添加登陆日志 */
    public void addLoginLog(LoginLog loginLog);
}
