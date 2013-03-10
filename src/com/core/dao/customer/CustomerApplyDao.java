package com.core.dao.customer;

import java.util.List;

import com.core.common.entity.PageEntity;
import com.core.entity.customer.CustomerApply;

/**
 * @ClassName  CustomerApplyDao
 * @package com.core.dao.customer
 * @description
 * @author  liuqinggang
 * @Create Date: 2013-3-5 下午04:42:19
 * 
 */
public interface CustomerApplyDao {
    public void addCustomerApply(CustomerApply apply);
    public List<CustomerApply> getCustomerApplyList(PageEntity pageEntity);
}
