package edu.mum.dao.impl;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import edu.mum.dao.CredentialsDao;
import edu.mum.domain.UserCredentials;

@Repository
public class CredentialsDaoImpl extends GenericDaoImpl<UserCredentials> implements CredentialsDao {

	public CredentialsDaoImpl() {
		super.setDaoType(UserCredentials.class);
	}

	public UserCredentials findByUserName(String userName) {

		Query query = entityManager.createQuery("select m from CREDENTIALS m  where m.username =:userName");
		return (UserCredentials) query.setParameter("userName", userName).getSingleResult();

	}

	public String findAuthority(String userName) {
		// TODO Auto-generated method stub
		Query query = entityManager.createQuery("select authority from authority a  where a.username =:userName");
		return (String) query.setParameter("userName", userName).getSingleResult();
	}
}