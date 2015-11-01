package com.pallelli.mvcpract;

public interface EmailSender {

	boolean sendEmail(String toAddress, String toName, String subject, String message);
}
