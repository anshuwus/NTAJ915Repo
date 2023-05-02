package com.nt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.nt.model.Patient;
import com.nt.service.IPatientService;

@Controller("patientController")
public class PatientController {
    
	@Autowired
	private IPatientService patientService;
	
	public String processPatient(Patient pnt)throws Exception {
	
		//use service
		String result=patientService.registerPatient(pnt);
		return result;
	}
}
