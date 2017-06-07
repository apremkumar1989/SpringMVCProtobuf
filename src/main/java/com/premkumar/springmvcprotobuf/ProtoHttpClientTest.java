package com.premkumar.springmvcprotobuf;

import java.net.HttpURLConnection;
import java.net.URL;

import com.premkumar.springmvcprotobuf.proto.ContactsProtos.AddressBook;
import com.premkumar.springmvcprotobuf.proto.ContactsProtos.AddressBook.Builder;

public class ProtoHttpClientTest {

	public static void main(String[] args) throws Exception {
		sendGet();

	}

	// HTTP GET request
	private static void sendGet() throws Exception {

		String url = "http://localhost:8080/contacts/";

		URL obj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();

		// optional default is GET
		con.setRequestMethod("GET");

		int responseCode = con.getResponseCode();
		System.out.println("\nSending 'GET' request to URL : " + url);
		System.out.println("Response Code : " + responseCode);

		// print result
		Builder addressBook = AddressBook.newBuilder().mergeFrom(
				con.getInputStream());
		System.out.println(addressBook);

	}

}
