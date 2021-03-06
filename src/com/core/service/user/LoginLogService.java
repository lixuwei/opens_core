/**
 * @ClassName  LoginLogService
 * @package com.core.service.user
 * @description
 * @author  liuqinggang
 * @Create Date: 2013-3-1 下午10:19:18
 * 
 */
package com.core.service.user;

import com.core.entity.user.LoginLog;

/**
 * @ClassName  LoginLogService
 * @package com.core.service.user
 * @description
 * @author  liuqinggang
 * @Create Date: 2013-3-1 下午10:19:18
 * 
 */
public interface LoginLogService {
    
    /**添加登陆日志*/
    public void addLoginLog(LoginLog loginLog);
    
}
