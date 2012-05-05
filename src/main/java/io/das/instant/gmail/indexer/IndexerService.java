package io.das.instant.gmail.indexer;

import com.google.common.util.concurrent.AbstractExecutionThreadService;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class IndexerService extends AbstractExecutionThreadService{

    BlockingQueue<Integer> queue;
    public void startUp(){

        queue = new LinkedBlockingQueue<Integer>();
    }

    public void run() throws InterruptedException {
        Integer toProcess;
        while(false == (toProcess = queue.take()).equals(SENTINEL))
        {
            doStuff(toProcess);
        }
    }

    public void doStuff(Integer x)
    {

    }

    private final Integer SENTINEL = Integer.MAX_VALUE;

    public void triggerShutdown() {
        try {
            queue.put(SENTINEL);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
