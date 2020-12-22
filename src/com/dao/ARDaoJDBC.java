package com.dao;

import java.util.List;

import com.alumnirecords.ARBean;
import com.mysql.MysqlUtil;

public class ARDaoJDBC implements ARDao {
	
	public static void main(String[] args) {
		ARDaoJDBC dao = new ARDaoJDBC();
		dao.getAR(1);
	}
	
	
	private static final String SELECT_ARS_SQL="select * from alumni_records order by id desc";
	private static final String SELECT_AR_SQL="select * from alumni_records where id=?";
	private static final String SAVE_AR_SQL="insert into alumni_records(user_id, invited_code, image, name, sex, birthday, mobile, email, address, interests, yearning_city, image_to_inviter, leave_message) values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
	private static final String UPDATE_AR_SQL="update alumni_records set user_id=?, invited_code=?, image=?, name=?, sex=?, birthday=?, mobile=?, email=?, address=?, interests=?, yearning_city=?, image_to_inviter=?, leave_message=? where id=?";
	private static final String DELETE_AR_SQL="delete from alumni_records where id=?";
	MysqlUtil m;
	int i;
	
	
	public ARDaoJDBC() {
		m = new MysqlUtil();
		m.init("java:comp/env/jdbc/mysql");
	}
	
	@Override
	public ARBean getAR(Integer id) {
		Object[] parameters={id};
		ARBean ar = (ARBean) m.query(SELECT_AR_SQL);
		return ar;
	}

	@Override
	public List getARS() {
		List list = m.query(SELECT_ARS_SQL);
		return list;
	}

	@Override
	public boolean save(ARBean ar) {
		Object[] parameters={ar.getObjectsArray()};
		int i =m.insert(SAVE_AR_SQL,parameters);
		return i>0?true:false;
	}

	@Override
	public boolean update(ARBean ar) {
		Object[] parameters={ar.getObjectsArray()};
		int i =m.update(SAVE_AR_SQL,parameters);
		return i>0?true:false;
	}

	@Override
	public boolean delete(Integer id) {
		Object[] parameters={id};
		i = m.delete(DELETE_AR_SQL,parameters);
		return i>0?true:false;
	}

}
