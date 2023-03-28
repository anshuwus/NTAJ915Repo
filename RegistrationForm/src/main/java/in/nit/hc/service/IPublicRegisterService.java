package in.nit.hc.service;

import in.nit.hc.entity.PublicRegister;

public interface IPublicRegisterService {
	Long savePublicCredentials(PublicRegister user);
}
