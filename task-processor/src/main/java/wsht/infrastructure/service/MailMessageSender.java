package wsht.infrastructure.service;

import javax.annotation.Resource;

import org.springframework.mail.MailException;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

import wsht.messages.NotificationMessage;

@Service("mailMessageSender")
public class MailMessageSender implements IMessageSender {

	@Resource(name="mailSender")
	private MailSender mailSender;

	public void setMailSender(MailSender mailSender) {
		this.mailSender = mailSender;
	}
	
	 public void sendNotification(NotificationMessage message) {

	        SimpleMailMessage msg = new SimpleMailMessage();
	        msg.setTo(message.emailAddress());
	        msg.setText(
	            "Dear "
	                + message.message().getName()
	                + ", thank you for placing order. Your order number is "
	                + message.message().getPriority().getExpressionLanguage());
	        try{
	            mailSender.send(msg);
	        }
	        catch(MailException ex) {
	            //log it and go on
	            System.err.println(ex.getMessage());            
	        }
	    }
}
