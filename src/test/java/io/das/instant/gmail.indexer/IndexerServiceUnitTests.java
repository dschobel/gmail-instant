package io.das.instant.gmail.indexer;

import com.google.common.base.Service;
import junit.framework.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import javax.activation.DataHandler;
import javax.mail.*;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Date;
import java.util.Enumeration;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class IndexerServiceUnitTests {

    //Injector injector;
    IndexerService service;

    @BeforeMethod
    public void setUp() {
        CountingMessageProcessor counter = new CountingMessageProcessor();
        service = new IndexerService(null,counter);

        Assert.assertEquals(0,counter.getCount());
    }

    //@Test
    //public void startUp() {
        // service.startUp();
    //}

    //@Test
    //public void shutDown() {
        // service.startUp();
        // service.triggerShutdown();
   // }

    @Test
    public void all_messsages_are_received(){
        service.start();
    }
    @Test
    public void full_lifecycle() throws InterruptedException, ExecutionException {
        service.start();
        service.run();
        service.stopAndWait();
        Future<Service.State> fs =  service.stop();
        Assert.assertEquals(Service.State.TERMINATED, fs.get());
    }

    private class StubMessage extends Message
    {

        @Override
        public Address[] getFrom() throws MessagingException {
            return new Address[0];  //To change body of implemented methods use File | Settings | File Templates.
        }

        @Override
        public void setFrom() throws MessagingException {
            //To change body of implemented methods use File | Settings | File Templates.
        }

        @Override
        public void setFrom(Address address) throws MessagingException {
            //To change body of implemented methods use File | Settings | File Templates.
        }

        @Override
        public void addFrom(Address[] addresses) throws MessagingException {
            //To change body of implemented methods use File | Settings | File Templates.
        }

        @Override
        public Address[] getRecipients(RecipientType recipientType) throws MessagingException {
            return new Address[0];  //To change body of implemented methods use File | Settings | File Templates.
        }

        @Override
        public void setRecipients(RecipientType recipientType, Address[] addresses) throws MessagingException {
            //To change body of implemented methods use File | Settings | File Templates.
        }

        @Override
        public void addRecipients(RecipientType recipientType, Address[] addresses) throws MessagingException {
            //To change body of implemented methods use File | Settings | File Templates.
        }

        @Override
        public String getSubject() throws MessagingException {
            return null;  //To change body of implemented methods use File | Settings | File Templates.
        }

        @Override
        public void setSubject(String s) throws MessagingException {
            //To change body of implemented methods use File | Settings | File Templates.
        }

        @Override
        public Date getSentDate() throws MessagingException {
            return null;  //To change body of implemented methods use File | Settings | File Templates.
        }

        @Override
        public void setSentDate(Date date) throws MessagingException {
            //To change body of implemented methods use File | Settings | File Templates.
        }

        @Override
        public Date getReceivedDate() throws MessagingException {
            return null;  //To change body of implemented methods use File | Settings | File Templates.
        }

        @Override
        public Flags getFlags() throws MessagingException {
            return null;  //To change body of implemented methods use File | Settings | File Templates.
        }

        @Override
        public void setFlags(Flags flags, boolean b) throws MessagingException {
            //To change body of implemented methods use File | Settings | File Templates.
        }

        @Override
        public Message reply(boolean b) throws MessagingException {
            return null;  //To change body of implemented methods use File | Settings | File Templates.
        }

        @Override
        public void saveChanges() throws MessagingException {
            //To change body of implemented methods use File | Settings | File Templates.
        }

        public int getSize() throws MessagingException {
            return 0;  //To change body of implemented methods use File | Settings | File Templates.
        }

        public int getLineCount() throws MessagingException {
            return 0;  //To change body of implemented methods use File | Settings | File Templates.
        }

        public String getContentType() throws MessagingException {
            return null;  //To change body of implemented methods use File | Settings | File Templates.
        }

        public boolean isMimeType(String s) throws MessagingException {
            return false;  //To change body of implemented methods use File | Settings | File Templates.
        }

        public String getDisposition() throws MessagingException {
            return null;  //To change body of implemented methods use File | Settings | File Templates.
        }

        public void setDisposition(String s) throws MessagingException {
            //To change body of implemented methods use File | Settings | File Templates.
        }

        public String getDescription() throws MessagingException {
            return null;  //To change body of implemented methods use File | Settings | File Templates.
        }

        public void setDescription(String s) throws MessagingException {
            //To change body of implemented methods use File | Settings | File Templates.
        }

        public String getFileName() throws MessagingException {
            return null;  //To change body of implemented methods use File | Settings | File Templates.
        }

        public void setFileName(String s) throws MessagingException {
            //To change body of implemented methods use File | Settings | File Templates.
        }

        public InputStream getInputStream() throws IOException, MessagingException {
            return null;  //To change body of implemented methods use File | Settings | File Templates.
        }

        public DataHandler getDataHandler() throws MessagingException {
            return null;  //To change body of implemented methods use File | Settings | File Templates.
        }

        public Object getContent() throws IOException, MessagingException {
            return null;  //To change body of implemented methods use File | Settings | File Templates.
        }

        public void setDataHandler(DataHandler dataHandler) throws MessagingException {
            //To change body of implemented methods use File | Settings | File Templates.
        }

        public void setContent(Object o, String s) throws MessagingException {
            //To change body of implemented methods use File | Settings | File Templates.
        }

        public void setText(String s) throws MessagingException {
            //To change body of implemented methods use File | Settings | File Templates.
        }

        public void setContent(Multipart multipart) throws MessagingException {
            //To change body of implemented methods use File | Settings | File Templates.
        }

        public void writeTo(OutputStream outputStream) throws IOException, MessagingException {
            //To change body of implemented methods use File | Settings | File Templates.
        }

        public String[] getHeader(String s) throws MessagingException {
            return new String[0];  //To change body of implemented methods use File | Settings | File Templates.
        }

        public void setHeader(String s, String s1) throws MessagingException {
            //To change body of implemented methods use File | Settings | File Templates.
        }

        public void addHeader(String s, String s1) throws MessagingException {
            //To change body of implemented methods use File | Settings | File Templates.
        }

        public void removeHeader(String s) throws MessagingException {
            //To change body of implemented methods use File | Settings | File Templates.
        }

        public Enumeration getAllHeaders() throws MessagingException {
            return null;  //To change body of implemented methods use File | Settings | File Templates.
        }

        public Enumeration getMatchingHeaders(String[] strings) throws MessagingException {
            return null;  //To change body of implemented methods use File | Settings | File Templates.
        }

        public Enumeration getNonMatchingHeaders(String[] strings) throws MessagingException {
            return null;  //To change body of implemented methods use File | Settings | File Templates.
        }
    }
}
