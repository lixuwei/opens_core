package com.core.dao.impl.customer;

import java.util.List;

import com.core.common.dao.GenericDaoImpl;
import com.core.common.entity.PageEntity;
import com.core.dao.customer.CustomerApplyDao;
import com.core.entity.customer.CustomerApply;

/**
 * @ClassName  CustomerApplyDaoImpl
 * @package com.core.dao.impl.customer
 * @description
 * @author  liuqinggang
 * @Create Date: 2013-3-5 下午04:42:41
 * 
 */
public class CustomerApplyDaoImpl extends GenericDaoImpl implements CustomerApplyDao {

    /* (non-Javadoc)
     * @see com.core.dao.customer.CustomerApplyDao#addCustomerApply(com.core.entity.customer.CustomerApply)
     */
    @Override
    public void addCustomerApply(CustomerApply apply) {
        this.getMyBatisDao().insert("CustomerApplyMapper.addOneCustomerApply", apply);
    }

    /* (non-Javadoc)
     * @see com.core.dao.customer.CustomerApplyDao#getCustomerApplyList(com.core.common.entity.PageEntity)
     */
    @Override
    public List<CustomerApply> getCustomerApplyList(PageEntity pageEntity) {
       return this.queryForListPage("CustomerApplyMapper.getCustomerApplylit", null, pageEntity);
    }

}
