package com.dao;

import java.util.List;

import com.alumnirecords.ARBean;

public interface ARDao {
	public ARBean getAR(Integer id);
	public List getARS();
	public boolean save(ARBean ar);
	public boolean update(ARBean ar);
	public boolean delete(Integer id);
}
