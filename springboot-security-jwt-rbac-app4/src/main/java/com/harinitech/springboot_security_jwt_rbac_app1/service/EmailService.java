package com.harinitech.springboot_security_jwt_rbac_app1.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.sendgrid.Method;
import com.sendgrid.Request;
import com.sendgrid.Response;
import com.sendgrid.SendGrid;
import com.sendgrid.helpers.mail.Mail;
import com.sendgrid.helpers.mail.objects.Content;
import com.sendgrid.helpers.mail.objects.Email;

@Service
public class EmailService {

	@Value("${sendgrid.api.key}")
	private String apiKey;

	@Value("${sendgrid.sender.email}")
	private String senderEmail;

	@Value("${sendgrid.sender.name}")
	private String senderName;

	public void sendOtp(String toEmail, String otp) {

		Email from = new Email(senderEmail, senderName);
		Email to = new Email(toEmail);
		String subject = "🔐 Password Reset OTP - Secure Access";

		// ✅ HTML TEMPLATE
		Content content = new Content("text/html", buildOtpTemplate(otp));

		Mail mail = new Mail(from, subject, to, content);

		SendGrid sg = new SendGrid(apiKey);
		Request request = new Request();

		try {
			request.setMethod(Method.POST);
			request.setEndpoint("mail/send");
			request.setBody(mail.build());

			Response response = sg.api(request);

			System.out.println("Status Code: " + response.getStatusCode());

			if (response.getStatusCode() >= 400) {
				throw new RuntimeException("SendGrid Error: " + response.getBody());
			}

		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("Error sending email via SendGrid", e);
		}
	}

	// 🔥 SAME HTML TEMPLATE (unchanged)
	private String buildOtpTemplate(String otp) {
		return "<!DOCTYPE html>" + "<html>"
				+ "<body style='font-family: Arial, sans-serif; background-color:#f4f4f4; padding:20px;'>"

				+ "<div style='max-width:600px; margin:auto; background:white; padding:20px; border-radius:10px;'>"

				+ "<div style='text-align:center;'>" + "<h2 style='color:#333;'>Security Verification</h2>" + "</div>"

				+ "<p>Hello User,</p>"

				+ "<p>Your One-Time Password (OTP) for password reset is:</p>"

				+ "<div style='text-align:center; margin:20px;'>"
				+ "<span style='font-size:28px; font-weight:bold; color:#4CAF50; letter-spacing:5px;'>" + otp
				+ "</span>" + "</div>"

				+ "<p>This OTP is valid for <b>5 minutes</b>.</p>"

				+ "<p>If you did not request this, please ignore this email.</p>"

				+ "<hr/>"

				+ "<p style='font-size:12px; color:gray;'>© 2026 Secure Auth System</p>"

				+ "</div>"

				+ "</body></html>";
	}
}