package com.example.grpcclient;

import java.io.IOException;

import com.example.grpcserver.CalculaTabuadaServiceGrpc;
import com.example.grpcserver.CalculaTabuadaServiceGrpc.CalculaTabuadaServiceStub;
import com.example.grpcserver.TabuadaRequest;
import com.example.grpcserver.TabuadaResponse;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;

@SpringBootApplication
public class GrpcClientApplication {

	public static void main(String[] args) throws IOException, InterruptedException {
		SpringApplication.run(GrpcClientApplication.class, args);

		ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 8099)
		.usePlaintext()
		.build();	
		

		StreamObserver<TabuadaResponse> responseObserver = new StreamObserver<TabuadaResponse>(){

			@Override
			public void onCompleted() {
				System.out.println("acabou");
				channel.shutdown();
			}

			@Override
			public void onError(Throwable arg0) {
				System.out.println("deu erro "+arg0.getMessage());
				channel.shutdown();
			}

			@Override
			public void onNext(TabuadaResponse arg0) {
				System.out.println("aqui  "+arg0.getText());
				
			} 

		};

		CalculaTabuadaServiceStub nonBlockStub =  CalculaTabuadaServiceGrpc.newStub(channel);
		TabuadaRequest request =  TabuadaRequest
			.newBuilder()
			.setNumero(5)
			.build();
		nonBlockStub.calculaTabuada(request, responseObserver);
		
		//  nonBlockStub.calculaTabuada(TabuadaRequest
		// 	.newBuilder()
		// 	.setNumero(5)
		// 	.build(), responseObserver);

		//  para pegar apenas um resultado 
		// CalculaTabuadaServiceGrpc.CalculaTabuadaServiceBlockingStub stub = 
		// CalculaTabuadaServiceGrpc.newBlockingStub(channel);

		// TabuadaResponse tabuadaResponse = stub.calculaTabuada(TabuadaRequest
		// 	.newBuilder()
		// 	.setNumero(5)
		// 	.build());
		
		

	

	}

}
