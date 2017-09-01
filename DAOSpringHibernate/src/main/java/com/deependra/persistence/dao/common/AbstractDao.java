package com.deependra.persistence.dao.common;

import java.io.Serializable;

import com.google.common.base.Preconditions;

public abstract class AbstractDao<T extends Serializable> implements IOperations<T> {

	protected Class<T> clazz;

	protected final void setClazz(final Class<T> clazzToSet) {
		this.clazz = Preconditions.checkNotNull(clazzToSet);
	}
	
	

}
