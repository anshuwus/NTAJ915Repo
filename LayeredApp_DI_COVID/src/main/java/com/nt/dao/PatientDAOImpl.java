package com.nt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.nt.model.Patient;

@Repository("patientDAO")
public class PatientDAOImpl implements IPatientDAO {

	private static final String INSERT_PATIENT="INSERT INTO COVIDPATIENT_TAB VALUES(COVIDPATIENTNO_SEQ.NEXTVAL,?,?,?,?)";
	//private static final String RETREIVE_PATIENTNO="SELECT PATIENT_NO FROM COVIDPATIENT_TAB";
	@Autowired
	private DataSource ds;
	@Override
	public int insertPatient(Patient pnt) throws Exception {
        
		int count=0;
        try(
        		Connection con=ds.getConnection();
        		PreparedStatement ps=con.prepareStatement(INSERT_PATIENT);
        	//	Statement stmt=con.createStatement();
        		){
        	
					
					/*ResultSet rs=stmt.executeQuery(RETREIVE_PATIENTNO); 
					while(rs.next()) {
					
					pnt.setPno(rs.getInt(1)); }*/
					 
        	 ps.setString(1, pnt.getPname());
        	 ps.setString(2, pnt.getPaddrs());
        	 ps.setString(3, pnt.getSex());
        	 ps.setByte(4, pnt.getAge());
        	 
        	 count=ps.executeUpdate();
        	 
        	
        }
        catch(SQLException e) {
        	e.printStackTrace();
        	throw e;
        }
		catch(Exception e) {
			e.printStackTrace();
			throw e;
		}
		return count;
	}

}
