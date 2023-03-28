package in.nit.hc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import in.nit.hc.entity.PublicRegister;

public interface IPublicRegisterRepo extends JpaRepository<PublicRegister, Long> {

}
