package com.core.common.service;

import com.core.common.dao.MyBatisDao;

public abstract class BaseServiceRead {

	private MyBatisDao myBatisDaoRead;

	public MyBatisDao getMyBatisDaoRead() {
		return myBatisDaoRead;
	}

	public void setMyBatisDaoRead(MyBatisDao myBatisDaoRead) {
		this.myBatisDaoRead = myBatisDaoRead;
	}

}
