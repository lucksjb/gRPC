# Dependecies    
to dependecies look to [pom.xml file]()
```
		<!-- gRPC -->
		<dependency>
			<groupId>io.grpc</groupId>
			<artifactId>grpc-netty</artifactId>
			<version>1.16.1</version>
		</dependency>
		<dependency>
			<groupId>io.grpc</groupId>
			<artifactId>grpc-protobuf</artifactId>
			<version>1.16.1</version>
		</dependency>
		<dependency>
			<groupId>io.grpc</groupId>
			<artifactId>grpc-stub</artifactId>
			<version>1.16.1</version>
		</dependency>

		<dependency>
			<groupId>com.google.protobuf</groupId>
			<artifactId>protobuf-java</artifactId>
			<version>${protobuf.version}</version>
		</dependency>

		<!-- https://mvnrepository.com/artifact/com.google.protobuf/protoc -->
		<dependency>
			<groupId>com.google.protobuf</groupId>
			<artifactId>protoc</artifactId>
			<version>4.0.0-rc-2</version>
			<type>pom</type>
		</dependency>

```

# Plugin to compile protobuffer
```
	<build>
		<extensions>
			<extension>
				<groupId>kr.motd.maven</groupId>
				<artifactId>os-maven-plugin</artifactId>
				<version>1.6.1</version>
			</extension>
		</extensions>
		<plugins>
			<plugin>
				<groupId>org.springframework.boot</groupId>
				<artifactId>spring-boot-maven-plugin</artifactId>
				<configuration>
					<excludes>
						<exclude>
							<groupId>org.projectlombok</groupId>
							<artifactId>lombok</artifactId>
						</exclude>
					</excludes>
				</configuration>
			</plugin>

			<plugin>
				<groupId>org.xolstice.maven.plugins</groupId>
				<artifactId>protobuf-maven-plugin</artifactId>
				<version>0.6.1</version>
				<configuration>
					<protocArtifact>
					com.google.protobuf:protoc:3.3.0:exe:${os.detected.classifier}
				  </protocArtifact>
					<pluginId>grpc-java</pluginId>
					<pluginArtifact>
					io.grpc:protoc-gen-grpc-java:1.4.0:exe:${os.detected.classifier}
				  </pluginArtifact>
				</configuration>
				<executions>
					<execution>
						<goals>
							<goal>compile</goal>
							<goal>compile-custom</goal>
						</goals>
					</execution>
				</executions>
			</plugin>
		</plugins>
	</build>
```

# Status Code in gRPC   
https://github.com/grpc/grpc/blob/master/doc/statuscodes.md   


# Documents  
https://grpc.io/docs/languages/java/basics/   
https://www.baeldung.com/grpc-introduction    
https://www.baeldung.com/google-protocol-buffer   
https://github.com/eugenp/tutorials/tree/master/grpc   
https://github.com/grpc/grpc-java/blob/master/examples/README.md   
https://www.baeldung.com/java-grpc-streaming   



# Para testar o server   
[Evans - Para testar o server](https://github.com/ktr0731/evans)
*evans -r repl --host localhost --port 8099*




# vscode-proto3
https://marketplace.visualstudio.com/items?itemName=zxh404.vscode-proto3
