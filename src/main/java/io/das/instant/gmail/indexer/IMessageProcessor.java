package io.das.instant.gmail.indexer;

import javax.mail.Message;


public interface IMessageProcessor {
    void Process(Message msg);
}
