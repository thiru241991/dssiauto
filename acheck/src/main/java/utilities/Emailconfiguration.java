package utilities;

import java.util.Properties;

import javax.mail.Address;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.mail.Session;
import javax.mail.Store;

public class Emailconfiguration {
	
	 Properties properties = null;
	    private Session session = null;
	    private Store store = null;
	    private Folder inbox = null;
	    private String userName = "thiruvenkhadan1991@outlook.com";// provide user name
	    private String password = "Hari@291";// provide password
	    String link;
	  //  private String saveDirectory = System.getProperty("user.dir") + "\\SaveEmails";


	    public String readMails() {
	        properties = new Properties();
	        properties.setProperty("mail.store.protocol", "imaps");
	        try {
	            session = Session.getDefaultInstance(properties, null);
	            store = session.getStore("imaps");
	            store.connect("outlook.office365.com", userName, password);
	            inbox = store.getFolder("INBOX");

	            int unreadMailCount = inbox.getUnreadMessageCount();
	            System.out.println("No. of Unread Mails = " + unreadMailCount);

	            inbox.open(Folder.READ_WRITE);

	            Message messages[] = inbox.getMessages();
	            
	           // System.out.println("No. of Total Mails = " + messages.length);
	            for (int i = messages.length; i > (messages.length - unreadMailCount);) {
	                Message message = messages[i - 1];

	                Address[] from = message.getFrom();
	                

	                if(from[0].toString().trim().equalsIgnoreCase("A-Check Global <Acheckdirect@acheckglobal.com>".trim())) {
	                	
	                /*   System.out.println("====================================== Mail no.: " + i + " start ======================================");
	                       System.out.println("Date: " + message.getSentDate());
	                       System.out.println("From: " + from[0]);
	                       System.out.println("Subject: " + message.getSubject());
	                       System.out.println( message.getContent().toString()); */
	                   //    MimeMultipart mimeMultipart = (MimeMultipart)message.getContent();

	                     //    String result = getTextFromMimeMultipart(mimeMultipart);
	                       
	                       String result= message.getContent().toString();
	                       
	        
	          int startIndex = result.indexOf("href=");
	          int endIndex = result.indexOf("\">Activate your myA-CHECK account", startIndex);
	          if (endIndex == -1) {
	              endIndex = result.length();
	          }
	          
	          link = result.substring(startIndex+6, endIndex);
	          System.out.println(link);
	                }        break;              	
	                }

	            inbox.close(false);
	            store.close();
	        } catch (NoSuchProviderException ex) {
	            System.out.println("No provider for pop3.");
	            ex.printStackTrace();
	        } catch (MessagingException ex) {
	            System.out.println("Could not connect to the message store");
	            ex.printStackTrace();
	        }
	        
	        catch (Exception ex) {
	            ex.printStackTrace();
	        }
	        return  link;
	    }
}
