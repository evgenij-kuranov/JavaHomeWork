package com.pb.kuranov.hw14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {
    public static void main(String[] args) {

        int port = 1234;

        try {
            Socket socket = new Socket("127.0.0.1", port);
            System.out.println("Клиент подключился к серверу");

            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader inConsole = new BufferedReader(new InputStreamReader(System.in));

            String user, server;
            while ((user = inConsole.readLine()) != null) {
                out.println(user);
                server = in.readLine();
                System.out.println(server);
                if ("выход".equalsIgnoreCase(user)) {
                    System.out.println("Клиент отключился от сервера");
                    break;
                }
            }
            in.close();
            out.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
