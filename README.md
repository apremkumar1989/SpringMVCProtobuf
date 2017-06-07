# SpringMVCProtobuf
A sample app to test protobuf serialization. This uses Spring Boot, Spring MVC, Protobuf.

## Steps
1. There is a proto file named **contacts.proto** with in **src/main/proto/** folder. This file contains message structures.
2. We need to generate java classes for the proto definitions. Run following cmd from project root folder:  
  * protoc -I=src/main/proto --java_out=src/main/java src/main/proto/contacts.proto
3. Run **com.premkumar.springmvcprotobuf.App** for starting the http server.
4. Now to test you can run **com.premkumar.springmvcprotobuf.ProtoHttpClientTest** which will make a http api call, parse the response and display the output in console.
