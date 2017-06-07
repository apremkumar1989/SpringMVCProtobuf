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
---
#### with accept header in json format
curl -i -H 'Accept: application/json' 'http://localhost:8080/contacts'
```
HTTP/1.1 200 
Content-Type: application/json
Transfer-Encoding: chunked
Date: Wed, 07 Jun 2017 17:18:33 GMT

{"contacts": [{"id": 1,"name": "John","email": "john@xyz.com","mobile": "9902XXXXXX","contactType": "WORK"},{"id": 1,"name": "John","email": "john@xyz.com","mobile": "9902XXXXXX","contactType": "WORK"},{"id": 1,"name": "John","email": "john@xyz.com","mobile": "9902XXXXXX","contactType": "WORK"}]}
```
---
#### with accept header in xml format
curl -i -H 'Accept: application/xml' 'http://localhost:8080/contacts'
```
HTTP/1.1 200 
Content-Type: application/xml
Transfer-Encoding: chunked
Date: Wed, 07 Jun 2017 17:20:15 GMT

<AddressBook><contacts><id>1</id><name>John</name><email>john@xyz.com</email><mobile>9902XXXXXX</mobile><contactType>WORK</contactType></contacts><contacts><id>1</id><name>John</name><email>john@xyz.com</email><mobile>9902XXXXXX</mobile><contactType>WORK</contactType></contacts><contacts><id>1</id><name>John</name><email>john@xyz.com</email><mobile>9902XXXXXX</mobile><contactType>WORK</contactType></contacts></AddressBook>
```
---
#### with accept header in protobuf format
curl -i -H 'Accept: application/x-protobuf' 'http://localhost:8080/contacts'
```
HTTP/1.1 200 
X-Protobuf-Schema: contacts.proto
X-Protobuf-Message: src.main.java.AddressBook
Content-Type: application/x-protobuf;charset=UTF-8
Content-Length: 114
Date: Wed, 07 Jun 2017 17:32:42 GMT


John
    john@xyz.com"
9902XXXXXX(
John
    john@xyz.com"
9902XXXXXX(
John
    john@xyz.com"
9902XXXXXX(
```
