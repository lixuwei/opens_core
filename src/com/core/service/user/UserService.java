package com.core.service.user;

import java.util.List;

import com.core.common.entity.PageEntity;
import com.core.entity.user.Function;
import com.core.entity.user.QueryUserCondition;
import com.core.entity.user.Role;
import com.core.entity.user.User;

/**
 * @ClassName UserService
 * @package com.core.service.user
 * @description
 * @author liuqinggang
 * @Create Date: 2013-3-1 下午10:18:56
 * 
 */
public interface UserService {
    /** 根据登录名查询用户 */
    public User getUserByLoginName(String name);

    /** 根据id查询用户 */
    public User getUserById(int id);
    
    /** 拼凑用户权限*/
    public List<Function> getUserFunctionMap(List<Role> roleList);
    
    /** 查询 用户权限 */
    public List<Function> getUserFunction(List<Role> roleList);

    /**
     * 查询所有用户,分页
     */
    public List<User> getAllUserList(QueryUserCondition queryUserCondition,
            PageEntity pageEntity);

    /** 修改用户信息 */
    public void updateUser(User user);

    /** 修改密码 */
    public void updateUserPwd(User user);
    
    /**
     * 新增用户
     */
    public void addUser(User user);
    
}
