package com.mimu;

import org.vertx.java.core.Handler;
import org.vertx.java.core.http.HttpServer;
import org.vertx.java.core.http.HttpServerRequest;
import org.vertx.java.platform.Verticle;

import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by miloszmuszynski on 10/11/2014.
 */
public class CalleeVerticle extends Verticle {

    AtomicLong counter = new AtomicLong(0L);

    public void start() {

        HttpServer server = vertx.createHttpServer();

        server.requestHandler(new Handler<HttpServerRequest>() {
            @Override
            public void handle(HttpServerRequest req) {
                req.response().setChunked(true);
                req.response().setStatusCode(200);
                req.response().write("counter=" + counter.incrementAndGet());
                req.response().end();
            }
        });

        server.listen(9199);

    }

}
