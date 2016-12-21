package edu.mum.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.mum.dao.CredentialsDao;
import edu.mum.domain.UserCredentials;
import edu.mum.rest.service.UserCredentialsRestService;

@Service
public class UserCredentialsServiceImpl implements edu.mum.service.UserCredentialsService {
	
 	@Autowired
	//private UserCredentialsRestService userCredentialsRestService;
 	private CredentialsDao credentialsDao;

 	
    public void save( UserCredentials userCredentials) {  		
 		//userCredentialsRestService.save(userCredentials);
    	credentialsDao.save(userCredentials);
	}
 	
   	
	public List<UserCredentials> findAll() {
		//return (List<UserCredentials>)userCredentialsRestService.findAll();
		return (List<UserCredentials>)credentialsDao.findAll();
	}
	
	public UserCredentials findOne(String id){
		//return userCredentialsRestService.findOne(id);
		return credentialsDao.findByUserName(id);
	}

 

 
 
}
