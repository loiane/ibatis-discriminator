package com.loiane.data;

import java.util.List;

import org.apache.ibatis.annotations.Case;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.TypeDiscriminator;

import com.loiane.model.Developer;
import com.loiane.model.Employee;
import com.loiane.model.Manager;

/**
 * Employee Mapper contains all the myBatis/iBatis annotations
 * 
 * @author Loiane Groner
 * http://loianegroner.com (English)
 * http://loiane.com (Portuguese)
 */
public interface EmployeeMapper {

	final String SELECT_EMPLOYEE = "SELECT id, name, employee_type, manager_id, info, developer_id, product " +
			"FROM employee E left join manager M on M.employee_id = E.id " +
			"left join developer D on D.employee_id = E.id ";
	
	/**
	 * Returns the list of all Employee instances from the database.
	 * @return the list of all Employee instances from the database.
	 */
	@Select(SELECT_EMPLOYEE)
	@TypeDiscriminator(column = "employee_type", 
		cases = { 
			@Case (value="1", type = Manager.class,
				results={
					@Result(property="managerId", column="manager_id"),
					@Result(property="info"),
			}),
			@Case (value="2", type = Developer.class,
				results={
					@Result(property="developerId", column="developer_id"),
					@Result(property="project", column="product"),
			})
	})
	List<Employee> getAllEmployeesAnnotation();
}
