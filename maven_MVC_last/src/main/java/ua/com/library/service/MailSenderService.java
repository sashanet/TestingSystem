package ua.com.library.service;

public interface MailSenderService {

	void sendMail(String content, String mailBody, String email);
	
}
