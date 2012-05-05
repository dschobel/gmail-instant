package io.das.instant.gmail.imap;


public abstract class Message {
    public abstract void setContent(String content);
    public abstract String getContent();
    public abstract void setSubject(String subject);
    public abstract String getSubject();
}
