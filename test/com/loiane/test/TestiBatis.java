package com.loiane.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.loiane.dao.EmployeeDAO;
import com.loiane.model.Employee;

/**
 * Test Case
 * 
 * @author Loiane Groner
 * http://loianegroner.com (English)
 * http://loiane.com (Portuguese)
 */
public class TestiBatis {
	
	private static EmployeeDAO employeeDAO;

	@BeforeClass
	public static  void runBeforeClass() {
		employeeDAO = new EmployeeDAO();
	}

	@AfterClass
	public static void runAfterClass() {
		employeeDAO = null;
	}

	/**
	 * Test method for {@link com.loiane.dao.EmployeeDAO#selectAll()}.
	 */
	@Test
	public void testSelectAll() {
		
		List<Employee> list = employeeDAO.selectAll();
		
		for (Employee employee : list){
			System.out.println(employee.toString());
		}
		
		assertNotNull(list);
		assertEquals(5, list.size());
	}

}
