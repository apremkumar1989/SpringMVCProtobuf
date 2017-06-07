# SpringMVCProtobuf
A sample app to test protobuf serialization. This uses Spring Boot, Spring MVC, Protobuf.

## Steps
1. There is a proto file named **contacts.proto** with in **src/main/proto/** folder. This file contains message structures.
2. We need to generate java classes for the proto definitions. Run following cmd from project root folder:  
  * protoc -I=src/main/proto --java_out=src/main/java src/main/proto/contacts.proto
3. Run **com.premkumar.springmvcprotobuf.App** for starting the http server.
4. Now to test you can run **com.premkumar.springmvcprotobuf.ProtoHttpClientTest** which will make a http api call, parse the response and display the output in console.


## using curl
#### without accept header
curl -i 'http://localhost:8080/contacts'
```
HTTP/1.1 200 
X-Protobuf-Schema: contacts.proto
X-Protobuf-Message: src.main.java.AddressBook
Content-Type: application/x-protobuf;charset=UTF-8
Content-Length: 114
Date: Wed, 07 Jun 2017 17:14:08 GMT


John
    john@xyz.com"
9902XXXXXX(
John
    john@xyz.com"
9902XXXXXX(
John
    john@xyz.com"
```
