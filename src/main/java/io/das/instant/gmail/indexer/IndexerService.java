package io.das.instant.gmail.indexer;

import com.google.common.util.concurrent.AbstractExecutionThreadService;

import javax.activation.DataHandler;
import javax.mail.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Date;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class IndexerService extends AbstractExecutionThreadService{

    private final IMessageProcessor _processor;
    private final MessageRepository _repository;
    private BlockingQueue<Message> queue;

    public IndexerService(MessageRepository repository, IMessageProcessor processor)
    {
        _processor = processor;
        _repository = repository;
    }
    public void startUp(){
        logger.info("starting up");
        Iterator m = _repository.GetMessages().iterator();
        new LinkedBlockingQueue<Message>();
        queue = new LinkedBlockingQueue<Message>();
    }

    public void run() throws InterruptedException {
        Message toProcess;
        while((toProcess = queue.take()) != SENTINEL)
        {
            _processor.Process(toProcess);
        }
        logger.info("stopped");
    }

    public void triggerShutdown() {
        logger.info("shutting down...");
        try {
            queue.put(SENTINEL);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    private final SentinelMessage SENTINEL = new SentinelMessage();
    private final Logger logger = LoggerFactory.getLogger(IndexerService.class);

    private class SentinelMessage extends Message{

        @Override
        public Address[] getFrom() throws MessagingException {
            throw new UnsupportedOperationException();
        }

        @Override
        public void setFrom() throws MessagingException {
            throw new UnsupportedOperationException();

        }

        @Override
        public void setFrom(Address address) throws MessagingException {
            throw new UnsupportedOperationException();

        }

        @Override
        public void addFrom(Address[] addresses) throws MessagingException {
            throw new UnsupportedOperationException();

        }

        @Override
        public Address[] getRecipients(RecipientType recipientType) throws MessagingException {
            throw new UnsupportedOperationException();

        }

        @Override
        public void setRecipients(RecipientType recipientType, Address[] addresses) throws MessagingException {
            throw new UnsupportedOperationException();

        }

        @Override
        public void addRecipients(RecipientType recipientType, Address[] addresses) throws MessagingException {
            throw new UnsupportedOperationException();

        }

        @Override
        public String getSubject() throws MessagingException {
            throw new UnsupportedOperationException();
        }

        @Override
        public void setSubject(String s) throws MessagingException {
            throw new UnsupportedOperationException();
        }

        @Override
        public Date getSentDate() throws MessagingException {
            throw new UnsupportedOperationException();
        }

        @Override
        public void setSentDate(Date date) throws MessagingException {
            throw new UnsupportedOperationException();
        }

        @Override
        public Date getReceivedDate() throws MessagingException {
            throw new UnsupportedOperationException();
        }

        @Override
        public Flags getFlags() throws MessagingException {
            throw new UnsupportedOperationException();
        }

        @Override
        public void setFlags(Flags flags, boolean b) throws MessagingException {
            throw new UnsupportedOperationException();
        }

        @Override
        public Message reply(boolean b) throws MessagingException {
            throw new UnsupportedOperationException();
        }

        @Override
        public void saveChanges() throws MessagingException {
            throw new UnsupportedOperationException();

        }

        public int getSize() throws MessagingException {
            throw new UnsupportedOperationException();
        }

        public int getLineCount() throws MessagingException {
            throw new UnsupportedOperationException();
        }

        public String getContentType() throws MessagingException {
            throw new UnsupportedOperationException();
        }

        public boolean isMimeType(String s) throws MessagingException {
            throw new UnsupportedOperationException();
        }

        public String getDisposition() throws MessagingException {
            throw new UnsupportedOperationException();
        }

        public void setDisposition(String s) throws MessagingException {
            throw new UnsupportedOperationException();
        }

        public String getDescription() throws MessagingException {
            throw new UnsupportedOperationException();
        }

        public void setDescription(String s) throws MessagingException {
            throw new UnsupportedOperationException();
        }

        public String getFileName() throws MessagingException {
            throw new UnsupportedOperationException();
        }

        public void setFileName(String s) throws MessagingException {
            throw new UnsupportedOperationException();
        }

        public InputStream getInputStream() throws IOException, MessagingException {
            throw new UnsupportedOperationException();
        }

        public DataHandler getDataHandler() throws MessagingException {
            throw new UnsupportedOperationException();
        }

        public Object getContent() throws IOException, MessagingException {
            throw new UnsupportedOperationException();
        }

        public void setDataHandler(DataHandler dataHandler) throws MessagingException {
            throw new UnsupportedOperationException();

        }

        public void setContent(Object o, String s) throws MessagingException {
            throw new UnsupportedOperationException();

        }

        public void setText(String s) throws MessagingException {
            throw new UnsupportedOperationException();

        }

        public void setContent(Multipart multipart) throws MessagingException {
            throw new UnsupportedOperationException();

        }

        public void writeTo(OutputStream outputStream) throws IOException, MessagingException {
            throw new UnsupportedOperationException();

        }

        public String[] getHeader(String s) throws MessagingException {
            throw new UnsupportedOperationException();

        }

        public void setHeader(String s, String s1) throws MessagingException {
            throw new UnsupportedOperationException();

        }

        public void addHeader(String s, String s1) throws MessagingException {
            throw new UnsupportedOperationException();

        }

        public void removeHeader(String s) throws MessagingException {
            throw new UnsupportedOperationException();

        }

        public Enumeration getAllHeaders() throws MessagingException {
            throw new UnsupportedOperationException();
        }

        public Enumeration getMatchingHeaders(String[] strings) throws MessagingException {
            throw new UnsupportedOperationException();
        }

        public Enumeration getNonMatchingHeaders(String[] strings) throws MessagingException {
            throw new UnsupportedOperationException();
        }
    }
}
