package com.mbakara.service;

import com.mbakara.dto.EmailDetails;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class EmailService {

    @Autowired
    private JavaMailSender javaMailSender;

    @Value("${spring.mail.username}")// this property will give access to email sender
    private String emailSender;

    public void sendEmail(EmailDetails emailDetails){ // This method is not meant to return anything Just to send a message, taking in a parameter, so an emailDetails DTO created.
// Building an Obj of simple Mail message
        try{ // This try and catch is used for easily tracking errors that might comeUp later.
         SimpleMailMessage mailMessage = new SimpleMailMessage();// Creating an Obj of simple mailMessage, with this, one can easily deliver emails via text. So no styling like Company logo and so on.
            mailMessage.setFrom(emailSender);// Manipulating the Obj here using the principle of ENCAPSULATION. Setting the msg from the person who sent the msg being the emailSender.
            mailMessage.setTo(emailDetails.getRecipient());//emailSetTo happens to be the recipient, This is gotten from emailDetails.
            mailMessage.setText(emailDetails.getMessageBody());//Message to be Sent, you get it from the DTO.
            mailMessage.setSubject(emailDetails.getSubject()); //
            javaMailSender.send(mailMessage);//Calling the send message method from the above method(JavaMailSender)., taking in the mailMessage obj.
            // this annotation @Slf4j is used for logging, So logging is away of doing rough work, that when sending a msg, one can get the exact details.
            log.info("Message sent to: {}", emailDetails.getRecipient());
            log.info("Message sender: {}", emailSender);//

        } catch (MailException e) {
            throw new RuntimeException(e);
        }
    }

    // To Test the above method, you create an Obj of emailService.
    public static void main(String[] args){
        EmailService emailService = new EmailService();
        emailService.sendEmail(EmailDetails.builder()
                        .messageBody("Just testing")
                        .recipient("gloryanwana4gmail.com")
                        .subject("Testing")
                .build());

    }



}
