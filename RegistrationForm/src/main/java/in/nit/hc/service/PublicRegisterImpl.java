package in.nit.hc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.nit.hc.entity.PublicRegister;
import in.nit.hc.repository.IPublicRegisterRepo;

@Service
public class PublicRegisterImpl implements IPublicRegisterService{
	@Autowired
	private IPublicRegisterRepo repo;

	@Override
	public Long savePublicCredentials(PublicRegister user) {
		return repo.save(user).getId();
	}

}
