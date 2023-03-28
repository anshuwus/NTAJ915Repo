package in.nit.hc.service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.nit.hc.entity.UserType;
import in.nit.hc.repository.IUserTypeRepository;

@Service
public class UserTypeImpl implements IUserTypeService{
	@Autowired
	private IUserTypeRepository repo;
	
	@Override
	public Long saveUserType(UserType userType) {
		return repo.save(userType).getTypeCode();
	}

	@Override
	public Map<Long, String> getTypeCodeAndUserType() {
		List<Object[]> list=repo.getTypeCodeAndUserType();
		Map<Long, String> map=list.stream().collect(Collectors.toMap(
				                                     ob -> Long.valueOf(
				                                    		 ob[0].toString()),
				                                     ob -> ob[1].toString()));
		return map;
	}

}
