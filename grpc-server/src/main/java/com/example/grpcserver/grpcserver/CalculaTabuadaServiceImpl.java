package com.example.grpcserver.grpcserver;

import com.example.grpcserver.CalculaTabuadaServiceGrpc.CalculaTabuadaServiceImplBase;
import com.example.grpcserver.TabuadaRequest;
import com.example.grpcserver.TabuadaResponse;

import io.grpc.stub.StreamObserver;

public class CalculaTabuadaServiceImpl extends CalculaTabuadaServiceImplBase {
 
    @Override
    public void calculaTabuada(TabuadaRequest request,StreamObserver<TabuadaResponse> responseObserver ) {
        TabuadaResponse response; 
        for (int i = 0; i <= 10; i++) {
            response = TabuadaResponse.newBuilder()
                .setText(String.format("%d x %d = %d", i, request.getNumero(), request.getNumero()*i))
                .build();

            
            try {
                Thread.sleep(2000); // simula um processo demorado 
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

            responseObserver.onNext(response);
        }

 
        responseObserver.onCompleted();
    }
}
