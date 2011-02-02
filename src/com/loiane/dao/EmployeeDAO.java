package com.loiane.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.loiane.model.Employee;

/**
 * Employee DAO
 * 
 * @author Loiane Groner
 * http://loianegroner.com (English)
 * http://loiane.com (Portuguese)
 */
public class EmployeeDAO {

	/**
	 * Returns the list of all Employee instances from the database.
	 * @return the list of all Employee instances from the database.
	 */
	@SuppressWarnings("unchecked")
	public List<Employee> selectAll(){

		SqlSessionFactory sqlSessionFactory = MyBatisConnectionFactory.getSqlSessionFactory();
		SqlSession session = sqlSessionFactory.openSession();
		
		try {
			List<Employee> list = session.selectList("Employee.getAllEmployees");
			return list;
		} finally {
			session.close();
		}
	}

}
