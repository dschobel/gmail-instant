package io.das.instant.gmail.imap;

import com.sun.mail.imap.IMAPMessage;
import com.sun.xml.internal.messaging.saaj.packaging.mime.MessagingException;

import java.io.*;


public class SunImapMessageWrapper extends Message {

    private final String CharSet = "US-ASCII";
    private final IMAPMessage _message;

    public SunImapMessageWrapper(IMAPMessage message) {
        _message = message;
    }

    @Override
    public void setContent(String content) {
    }

    @Override
    public String getContent() {

        ByteArrayOutputStream os = new ByteArrayOutputStream();
        try {
            _message.writeTo(os);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (javax.mail.MessagingException e) {
            e.printStackTrace();
        }
        try {
            return os.toString(CharSet);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void setSubject(String subject) {

        try {
            _message.setSubject(subject, CharSet);
        } catch (javax.mail.MessagingException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String getSubject() {
        try {
            return _message.getSubject();
        } catch (javax.mail.MessagingException e) {
            e.printStackTrace();
        }
        return null;

    }
}
