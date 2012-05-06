package io.das.instant.gmail.indexer;

import com.google.inject.AbstractModule;
import com.sun.mail.imap.IMAPMessage;

import javax.mail.Message;

public class IndexModule extends AbstractModule {

    @Override
    public void configure() {
        //install(new Sl4jModule());
        //install(new com.google.sitebricks.slf4j.Slf4jModule());
        bind(Message.class).to(IMAPMessage.class);
    }
}
