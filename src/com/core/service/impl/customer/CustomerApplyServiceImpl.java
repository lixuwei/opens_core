package com.core.service.impl.customer;

import java.util.List;

import com.core.common.entity.PageEntity;
import com.core.dao.customer.CustomerApplyDao;
import com.core.entity.customer.CustomerApply;
import com.core.service.customer.CustomerApplyService;

/**
 * @ClassName  CustomerApplyServiceImpl
 * @package com.core.service.impl.customer
 * @description
 * @author  liuqinggang
 * @Create Date: 2013-3-5 下午04:43:24
 * 
 */
public class CustomerApplyServiceImpl implements CustomerApplyService {
    
    private CustomerApplyDao customerApplyDao;

    /* (non-Javadoc)
     * @see com.core.service.customer.CustomerApplyService#addCustomerApply(com.core.entity.customer.CustomerApply)
     */
    @Override
    public void addCustomerApply(CustomerApply apply) {
        customerApplyDao.addCustomerApply(apply);
        
    }

    /* (non-Javadoc)
     * @see com.core.service.customer.CustomerApplyService#getCustomerApplyList(com.core.common.entity.PageEntity)
     */
    @Override
    public List<CustomerApply> getCustomerApplyList(PageEntity pageEntity) {
        return customerApplyDao.getCustomerApplyList(pageEntity);
    }

    public CustomerApplyDao getCustomerApplyDao() {
        return customerApplyDao;
    }

    public void setCustomerApplyDao(CustomerApplyDao customerApplyDao) {
        this.customerApplyDao = customerApplyDao;
    }
    
    

}
