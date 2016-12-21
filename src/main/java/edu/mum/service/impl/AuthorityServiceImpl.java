package edu.mum.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.mum.dao.CredentialsDao;
import edu.mum.domain.UserCredentials;
import edu.mum.rest.service.UserCredentialsRestService;

@Service
public class AuthorityServiceImpl implements edu.mum.service.AuthorityService {
	
 	@Autowired
	//private UserCredentialsRestService userCredentialsRestService;
 	private CredentialsDao credentialsDao;

	@Override
	public String findAuthority(String id) {
		// TODO Auto-generated method stub
		return credentialsDao.findAuthority(id);
	}

 	
    
	 
 
}
