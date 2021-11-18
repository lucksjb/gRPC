package com.example.grpcserver;

import java.io.IOException;

import com.example.grpcserver.grpcserver.CalculaTabuadaServiceImpl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.protobuf.services.ProtoReflectionService;

@SpringBootApplication
public class GrpcServerApplication {

	public static void main(String[] args) throws IOException, InterruptedException {
		SpringApplication.run(GrpcServerApplication.class, args);
		
		Server server = ServerBuilder
		.forPort(8099)
		.addService(new CalculaTabuadaServiceImpl())
		.addService(ProtoReflectionService.newInstance()) // para conseguir acessar com o evans 
		.build();

		
		

	  server.start();
	  server.awaitTermination();		
	}

}
