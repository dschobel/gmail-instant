package io.das.instant.gmail.indexer;

import javax.mail.Message;

public abstract class MessageRepository {

    public abstract Iterable<Message> GetMessages();

}
