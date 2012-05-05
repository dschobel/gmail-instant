package io.das.instant.gmail.indexer;

import com.google.common.util.concurrent.AbstractExecutionThreadService;
import io.das.instant.gmail.imap.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class IndexerService extends AbstractExecutionThreadService{


    BlockingQueue<Message> queue;
    public void startUp(){
        logger.info("starting up");
        queue = new LinkedBlockingQueue<Message>();
    }

    public void run() throws InterruptedException {
        Message toProcess;
        while(!(toProcess = queue.take()).equals(SENTINEL))
        {
            process(toProcess);
        }
        logger.info("stopped");
    }

    public void process(Message x)
    {
        logger.debug("processing item", x);
    }


    public void triggerShutdown() {
        logger.info("shutting down...");
        try {
            queue.put(SENTINEL);
        } catch (InterruptedException e) {
            logger.error(e.toString());
            e.printStackTrace();
        }
    }
    private final Logger logger = LoggerFactory.getLogger(IndexerService.class);
    private static final Message SENTINEL = null;
}
