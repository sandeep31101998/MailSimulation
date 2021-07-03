package com.te.mailwebapp.dao;

import java.util.List;

import com.te.mailwebapp.beans.User_info;
import com.te.mailwebapp.beans.mail_info;

public interface MailDAO {

	public User_info authenticate(String email, String pwd);

	public boolean deleteMailData(String uid,String from_id);
	
	public boolean deleteMailData1(String uid,String from_id);

	public boolean sendMail(String mid ,String email,String email1,String subject,String message,String status,String id1);

	public List<mail_info> getAllMails(String from_id);
	
	public List<mail_info> getAllSent(String from_id);
	
	
	
}
