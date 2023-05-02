package com.nt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.nt.model.Employee;

@Repository("empDAO-mysql")
public class MYSQLEmployeeDAOImpl implements IEmployeeDAO {

	private static final String INSERT_EMPLOYEE_QUERY="INSERT INTO EMPLOYEE_INFO(ENAME,DESG,SALARY,GROSS_SALARY,NET_SALARY) VALUES(?,?,?,?,?)";
	
	@Autowired
	private DataSource ds;
	
	@Override
	public int insert(Employee emp) throws Exception {
		System.out.println("Data Source class name:: "+ds.getClass());
		int count=0;
		try(//get pooled jdbc con object
				Connection con=ds.getConnection();
				//create PreparedStatement object having pre-complied SQL Query
				PreparedStatement ps=con.prepareStatement(INSERT_EMPLOYEE_QUERY);
				){
			
			//set values to Query params
			ps.setString(1, emp.getEname());
			ps.setString(2, emp.getDesg());
			ps.setDouble(3, emp.getSalary());
			ps.setDouble(4, emp.getGrossSalary());
			ps.setDouble(5, emp.getNetSalary());
			
			//execute the Query
			count=ps.executeUpdate();
			
		}//try
		catch(SQLException se) {
			se.printStackTrace();
			throw se;
		}
		catch(Exception e) {
			e.printStackTrace();
			throw e;
		}
		return count;
	}//method close

}//class close
