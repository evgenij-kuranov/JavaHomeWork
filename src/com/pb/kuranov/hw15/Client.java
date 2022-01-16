package com.pb.kuranov.hw15;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.Socket;

public class Client {
    public static void main(String[] args) {

        int port = 1234;

        try {
            Socket socket = new Socket("127.0.0.1", port);

            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader inConsole = new BufferedReader(new InputStreamReader(System.in));

            JFrame frame = new JFrame("Клиент");
            frame.setBounds(0,0,600,600);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            JTextArea textArea = new JTextArea();
            frame.add(textArea, BorderLayout.CENTER);
            textArea.append("Клиент подключился к серверу\n");
            JTextField textField = new JTextField();
            frame.add(textField, BorderLayout.SOUTH);
            JButton button = new JButton("Отправить");
            frame.add(button, BorderLayout.EAST);
            frame.setVisible(true);
            button.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String user = textField.getText();
                        out.println(user);
                        textField.setText("");
                    }
                    });
            while (true) {
                String server = in.readLine();
                textArea.append(server + "\n");
                if (server.equals("выход")) {
                    textArea.append("Клиент отключился от сервера!\n");
                    break;
                }
            }
                    in.close();
                    out.close();
                    socket.close();
        } catch (IOException e2) {
            e2.printStackTrace();
        }
    }
}
