package com.nt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.dao.IPatientDAO;
import com.nt.model.Patient;

@Service("patientService")
public class PatientServiceImpl implements IPatientService {

	@Autowired
	private IPatientDAO patientDAO;
	@Override
	public String registerPatient(Patient pnt) throws Exception {
        //use DAO
		int count=patientDAO.insertPatient(pnt);
		
		return count==0?"Patient not registered ":" Patient registered successfully\n"+pnt;
	}

}
