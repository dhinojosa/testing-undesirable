package com.evolutionnext.sproutclass;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

public class InterestService {
    private float balance;

    @SuppressWarnings("Duplicates")
    protected Float lookupLatestInterestRate() throws IOException {
        String host = "123.40.5.101";
        try (Socket socket = new Socket(InetAddress.getByName(host), 80);
             InputStream is = socket.getInputStream();
             OutputStream os = socket.getOutputStream();
             InputStreamReader reader = new InputStreamReader(is);
             OutputStreamWriter writer = new OutputStreamWriter(os);
             BufferedReader bufferedReader = new BufferedReader(reader);
             BufferedWriter bufferedWriter = new BufferedWriter(writer)) {

            System.out.println(host + " connected?: " + socket.isConnected());

            //Somewhere here I want to make
            //Make Raw HTTP Request
            bufferedWriter.write("GET /account/interest HTTP/1.1");
            bufferedWriter.newLine();
            bufferedWriter.write("Host: " + host);
            bufferedWriter.newLine();
            bufferedWriter.write("Cache-Control: no-cache");
            bufferedWriter.newLine();
            bufferedWriter.newLine();
            bufferedWriter.flush();

            System.out.println("Sent info");

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                return Float.parseFloat(line);
            }

            throw new RuntimeException("Interest Rate Not Found");
        }
    }

    public synchronized void addToAccount(int amount) throws IOException {
        this.balance += (this.lookupLatestInterestRate() * amount) + amount;
    }

    public synchronized float getBalance() {
        return balance;
    }
}
