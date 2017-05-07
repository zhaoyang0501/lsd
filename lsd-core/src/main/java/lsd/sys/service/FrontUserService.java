package lsd.sys.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lsd.common.service.SimpleCurdService;
import lsd.sys.entity.FrontUser;
import lsd.sys.repository.FrontUserRepository;

@Service
public class FrontUserService extends SimpleCurdService<FrontUser, Long> {
	
	@Autowired
	private  FrontUserRepository frontUserRepository;
	
	public FrontUser login(String username,String password){
		return  this.frontUserRepository.findByUsernameAndPassword(username, password);
	}
	
	public FrontUser findByUserName(String username){
		return frontUserRepository.findByUsername(username);
	}
}
