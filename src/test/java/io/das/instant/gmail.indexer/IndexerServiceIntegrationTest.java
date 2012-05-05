package io.das.instant.gmail.indexer;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class IndexerServiceIntegrationTest {

    //Injector injector;
    IndexerService service;

    @BeforeMethod
    public void setUp() {
        /*injector = Guice.createInjector(new AbstractModule() {
        @Override
        protected void configure() {
            install(new IndexModule());
            bind(IndexerService.class);
            }
        });*/
        service = new IndexerService();// injector.getInstance(IndexerService.class);
    }

    @Test
    public void startUp() {
       // service.startUp();
    }

    @Test
    public void shutDown() {
       // service.startUp();
       // service.triggerShutdown();
    }

    @Test
    public void full_lifecycle() throws InterruptedException {
       // service.start();
        //service.run();
       // service.triggerShutdown();
    }
}
