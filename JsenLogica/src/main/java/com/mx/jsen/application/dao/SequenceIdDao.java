package com.mx.jsen.application.dao;

import com.mx.jsen.application.exception.SequenceException;

public interface SequenceIdDao {
	public Long getNextSequenceId(String key) throws SequenceException;
}
