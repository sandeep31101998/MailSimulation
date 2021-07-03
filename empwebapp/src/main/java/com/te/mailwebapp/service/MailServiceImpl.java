package com.te.mailwebapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.te.mailwebapp.beans.User_info;
import com.te.mailwebapp.beans.mail_info;
import com.te.mailwebapp.dao.MailDAO;

@Service("serviceone")
public class MailServiceImpl implements MailService {

	@Autowired
	MailDAO dao;

	@Override
	public User_info authenticate(String email, String pwd) {
		System.out.println("Service layer one");
		
			return dao.authenticate(email, pwd);
		

	}

	@Override
	public boolean deleteMailData(String  mid,String from_id) {

		return dao.deleteMailData(mid,from_id);
	}
	
	@Override
	public boolean deleteMailData1(String  mid,String from_id) {

		return dao.deleteMailData1(mid,from_id);
	}

	@Override
	public boolean sendMail(String mid ,String email,String email1,String subject,String message,String status,String id1) {

		return dao.sendMail(mid,email,email1,subject,message,status,id1);
	}


	@Override
	public List<mail_info> getAllMails(String from_id) {
		// TODO Auto-generated method stub
		return dao.getAllMails(from_id);
	}

	@Override
	public List<mail_info> getAllSent(String from_id) {
		return dao.getAllSent(from_id);
	}


}
