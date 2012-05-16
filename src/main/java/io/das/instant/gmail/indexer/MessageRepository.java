package io.das.instant.gmail.indexer;

import javax.mail.Message;
import java.util.concurrent.Future;

public abstract class MessageRepository {

    public abstract Iterable<Message> GetStream();

}
