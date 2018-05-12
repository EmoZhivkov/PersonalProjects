package org.networking;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String hostName = scanner.nextLine();
        String portString = scanner.nextLine();

        int port = Integer.parseInt(portString);

        boolean b = false;
        try {
            b = Ping.checkConnectivity(hostName, port);
        } catch (IOException e) {
           e.printStackTrace();
        }
        if (b == false) {
            Ping.checkConnectivity(hostName);
        }
        System.out.println(b);
        /*String hostName = "77.85.251.184";
        int port = 345;


        try {
            InetAddress inetAddress = InetAddress.getByName(hostName);
            boolean b = inetAddress.isReachable(5000);
            System.out.println(b);
        } catch (IOException e) {
            System.out.println("Err");
        }*/
    }

}
