package com.core.dao.user;

import java.util.List;

import com.core.entity.user.Function;
import com.core.entity.user.QueryFunctionCondition;

/**
 * @ClassName  FunctionDao
 * @package com.core.dao.user
 * @description
 * @author  liuqinggang
 * @Create Date: 2013-3-3 上午12:13:19
 * 
 */
public interface FunctionDao {
    
    public  List<Function>  getFunctionListByParentId(int parentId);
    
    public  List<Function> getFunctionListByRoleId(int roleId);

    /**
     * 添加功能
     * @param function 要添加的功能
     * @return id
     */
    public java.lang.Integer addFunction(Function function);

    /**
     * 根据id删除一个功能
     * @param functionId 要删除的id
     */
    public void delFunctionById(int functionId);

    /**
     * 修改功能
     * @param function 要修改的功能
     */
    public void updateFunction(Function function);

    /**
     * 根据id获取单个功能对象
     * @param functionId 要查询的id
     * @return 年级
     */
    public Function getFunctionById(int functionId);

    /**
     * 根据条件获取功能列表
     * @param queryFunctionCondition 查询条件
     * @return 查询结果
     */
    public List<Function> getFunctionList(QueryFunctionCondition queryFunctionCondition);

    /**
     * 根据功能适用范围id获取第一级功能列表
     * @param functionApplyScopeId 功能适用范围id，具体值范围参见Function中静态域
     * @return 第一级功能列表
     */
    public List<Function> getFirstLevelFunctionList();

    /**
     * 获取可以使用的功能权限
     * @return
     */
    public List<Function> getUsableFunctionList();

    /**
     * 获取第一级权限菜单列表
     * @param queryFunctionCondition
     * @return
     */
    public List<Function> getFirFunction(
            QueryFunctionCondition queryFunctionCondition);

    /**
     * 根据id获取子权限列表
     * @param parentFunctionId
     * @return
     */
    public List<Function> getChildFunctionById(int parentFunctionId);
    
    /**
     * 删除权限及子权限
     * @return
     */
    public void delFunctions(List<Integer> list);
    /**
     * 根据多个parentId 查询
     * @param parentList
     * @return
     */
    public  List<Function>  getFunctionListByParentIdSet(List<Integer> parentList);

}
