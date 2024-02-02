package com.valgaudeau.server;

import com.valgaudeau.grpc.ServiceOneGrpc;
import io.grpc.stub.StreamObserver;
import org.lognet.springboot.grpc.GRpcService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@GRpcService
public class ServiceOne extends ServiceOneGrpc.ServiceOneImplBase {

    private static final Logger logger = LoggerFactory.getLogger(ServiceOne.class);

    @Override
    public void sayHello(com.valgaudeau.grpc.ServiceOneRequest request, StreamObserver<com.valgaudeau.grpc.ServiceOneResponse> responseObserver) {
        logger.info("Received request: " + request.getName());

        // Create the response
        com.valgaudeau.grpc.ServiceOneResponse response = com.valgaudeau.grpc.ServiceOneResponse.newBuilder()
                .setGreeting("Hello from ServiceOne, " + request.getName() + "!")
                .build();

        // Send the response
        responseObserver.onNext(response);
        responseObserver.onCompleted();

        logger.info("Sent response");
    }

}
