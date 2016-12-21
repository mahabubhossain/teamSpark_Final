package edu.mum.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.mum.dao.MemberDao;
import edu.mum.domain.Member;
import edu.mum.rest.service.MemberRestService;
import edu.mum.service.UserCredentialsService;

@Service
public class MemberServiceImpl implements edu.mum.service.MemberService {
	
 	@Autowired
	//private MemberRestService memberRestService;
 	private MemberDao memberDao;
 	
 	@Autowired
 	private UserCredentialsService credentialsService;

     public void save( Member member) {  		
    	//memberRestService.save(member);
    	 memberDao.save(member);
	}
		
    @Override
   	public void saveFull( Member member) {  		
  		credentialsService.save(member.getUserCredentials());
  		//memberRestService.save(member);
  		memberDao.save(member);
	}
  	

	public List<Member> findAll() {
		//return (List<Member>)memberRestService.findAll();
		return (List<Member>)memberDao.findAll();
	}

 
	public Member findOne(Long id) {
		//return memberRestService.findOne(id);
		return memberDao.findOne(id);
	}
	
 
	
 }
