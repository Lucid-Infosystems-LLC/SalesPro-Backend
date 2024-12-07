package com.lucidinfosystems.SalesPro.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;
import org.springframework.mail.javamail.JavaMailSender;

@Service
@RequiredArgsConstructor
public class EmailService {
	private final JavaMailSender mailSender;
	
	@Value("${spring.mail.username}")
	private String fromEmail;
	
	public void sendCandidateId(String toEmail, String candidateId) {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom(fromEmail);
		message.setTo(toEmail);
		message.setSubject("Your SalesPro Candidate ID");
		message.setText("Your unique candidate ID is: " + candidateId);
		mailSender.send(message);
	}
}
