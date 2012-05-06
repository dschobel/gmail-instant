package io.das.instant.gmail.indexer;


import javax.mail.Message;

public class CountingMessageProcessor implements IMessageProcessor {

    private int _count;
    public CountingMessageProcessor(){
        _count = 0;
    }
    public void Process(Message msg) {
        _count++;
    }

    public int getCount() {
        return _count;
    }
}
