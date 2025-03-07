package com.pranit.util;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import jakarta.mail.internet.MimeMessage;

@Component
public class EmailUtils {

	@Autowired
	private JavaMailSender mailSender;

	public boolean sendMail(String subject, String body, String to,File f) {

		try {
			MimeMessage miMsg = mailSender.createMimeMessage();
			MimeMessageHelper helper = new MimeMessageHelper(miMsg, true);
			

			helper.setSubject(subject);
			helper.setText(body, true);
			helper.setTo(to);
			helper.addAttachment("Plans-Info", f);
			
			 mailSender.send(miMsg);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return true;
	}

}
