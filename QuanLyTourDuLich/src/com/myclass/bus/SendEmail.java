package com.myclass.bus;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.*;
import javax.mail.internet.*;

import javax.swing.JDialog;
import javax.swing.JOptionPane;

public class SendEmail implements Runnable{
    private String recepient = null;
    private String titleEmail = null;
    private String contentEmail = null;
    
    public SendEmail(String recepient,String titleEmail,String contentEmail) {
        this.recepient = recepient;
        this.titleEmail = titleEmail;
        this.contentEmail = contentEmail;
    }
    
    
    
    public static boolean sendMail(String recepient,String titleEmail,String contentEmail) throws Exception{
        System.out.println("Prepare send email");
        Properties properties = new Properties();
        
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");
        
        String myAccountEmail = "lytheminh2506@gmail.com";
        String myPassword = "LYTHEMINHLHT113";
        
        JOptionPane pane = new JOptionPane("Ä�ang gá»­i mÃ£ xÃ¡c nháº­n Ä‘áº¿n Email...", JOptionPane.INFORMATION_MESSAGE);
        JDialog dialog = pane.createDialog(null, "Vui lÃ²ng chá»� ...");
        dialog.setModal(false);
        dialog.setVisible(true);
        
        Session session = Session.getInstance(properties,new Authenticator() {
            @Override
            protected  PasswordAuthentication getPasswordAuthentication(){
                return new PasswordAuthentication(myAccountEmail, myPassword);
            }
        });
        
        Message message = null;
        message = prepareMessage(session,myAccountEmail,recepient,titleEmail,contentEmail);
        if(message == null){
            return false;        
        }
        try {
            Transport.send(message);
        } catch (Exception e) {
            return false;
        }
        
        JOptionPane.showMessageDialog(null, "Send Email Successfully");
        //Tá»± dá»™ng máº¥t khung thÃ´ng bÃ¡o
        new javax.swing.Timer(1, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dialog.setVisible(false);
            }
        }).start();
        return true;
    }

    protected static Message prepareMessage(Session session, String myAccountEmail, String recepient, String titleEmail, String htmlCode) {
        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(myAccountEmail));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(recepient));
            message.setSubject(titleEmail);
            message.setContent(htmlCode,"text/html");
            return message;
        } catch (Exception e) {
            System.out.println("Can't send Email !!! Error : " + e);
        }
        return null;
    }

    @Override
    public void run() {
        try {
            SendEmail.sendMail(recepient, titleEmail, contentEmail);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Láº¥y mÃ£ xÃ¡c nháº­n khÃ´ng thÃ nh cÃ´ng .Vui lÃ²ng kiá»ƒm tra láº¡i káº¿t ná»‘i");
        }
    }   
}
