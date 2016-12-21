package edu.mum.dao.impl;

 

import org.springframework.stereotype.Repository;

import edu.mum.dao.AddressDao;
import edu.mum.domain.Address;


@SuppressWarnings("unchecked")
@Repository
public class AddressDaoImpl extends GenericDaoImpl<Address> implements AddressDao {

	public AddressDaoImpl() {
		super.setDaoType(Address.class );
		}

	@Override
	public Address findOne(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

 
 }