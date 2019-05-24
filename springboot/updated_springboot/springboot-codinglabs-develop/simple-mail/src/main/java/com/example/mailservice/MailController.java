package com.example.mailservice;

import java.util.Date;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MailController {

	@Autowired
	EmailService emailService;
	
	@RequestMapping("/sendmail/{username}")
	public void sendmailController(@PathVariable String username) throws Exception {

		DateTime dateTime = new DateTime();
		dateTime = dateTime.minusHours(1);
		Date modifiedDate = dateTime.toDate();
		
		System.out.println("+++++++++++++++++++++++  "+ modifiedDate +"\n"+" ************ "+dateTime);
		
		Mail mail = new Mail();
		mail.setFrom("darshanj@wavelabs.in");
		mail.setTo(username);
		mail.setSubject("subject");
		mail.setContent("content");

		emailService.sendSimpleMessage(mail);
	}

}
