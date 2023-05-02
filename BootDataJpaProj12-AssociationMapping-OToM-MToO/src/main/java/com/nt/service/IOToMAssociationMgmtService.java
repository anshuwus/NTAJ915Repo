package com.nt.service;

public interface IOToMAssociationMgmtService {
	public void saveDataUsingParent();
	public void saveDataUsingChild();
	public void loadDataUsingParent();
	
	//delete operation in association mapping
	public String deleteByPerson(int personId);
	//deleting only childs of Parent in OneToMany association
	public String deleteAllPhoneNumbersOfAPerson(int personId);
	//adding new child to exting childs of a Parent
	public void addNewChildToAParentById(int id);
}
