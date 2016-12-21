package edu.mum.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.mum.dao.CredentialsDao;

@Service
public class AuthorityServiceImpl implements edu.mum.service.AuthorityService {

	@Autowired
	// private UserCredentialsRestService userCredentialsRestService;
	private CredentialsDao credentialsDao;

	@Override
	public String findAuthority(String id) {
		// TODO Auto-generated method stub
		return credentialsDao.findAuthority(id);
	}
}