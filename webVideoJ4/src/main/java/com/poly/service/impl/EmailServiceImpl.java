package com.poly.service.impl;

import javax.servlet.ServletContext;

import com.poly.entity.User;
import com.poly.service.Emailservice;
import com.poly.util.SendEmailUtil;

public class EmailServiceImpl implements Emailservice{
	
	private static final String EMAIL_WELLCOME_SUBJECT = "Welcome to Web Video Online";
	private static final String EMAIL_FORGOT_PASSWORD = "Web Video Online - New password";

	@Override
	public void sendEmail(ServletContext context, User recipient, String type) {
		String host = context.getInitParameter("host");
        String port = context.getInitParameter("port");
        String user = context.getInitParameter("user");
        String pass = context.getInitParameter("pass");
        
        try {
			String content = null;
			String subject = null;
			switch (type) {
			case "welcome":
				subject = EMAIL_WELLCOME_SUBJECT;
				content = "Dear "+recipient.getUsername()+" ,hope you have a good time!";
				break;
			case "forgot":
				subject = EMAIL_FORGOT_PASSWORD;
				content = "Dear "+recipient.getUsername()+" ,your new password is: " + recipient.getPassword();
				break;
			default:
				subject = "Web Video Online";
				content = "Maybe this email is wrong ^^!";
			}
			SendEmailUtil.sendEmail(host, port, user, pass, recipient.getEmail(), subject, content);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
