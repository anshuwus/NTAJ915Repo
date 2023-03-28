package in.nit.hc.service;

import java.util.Map;

import in.nit.hc.entity.UserType;

public interface IUserTypeService {
	Long saveUserType(UserType userType);
	Map<Long,String> getTypeCodeAndUserType();
}
