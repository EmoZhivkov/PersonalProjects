package org.networking;

import java.io.IOException;
import java.net.*;

public class Ping {
    public static boolean checkConnectivity(String hostName, int port) throws IOException{
        /*Socket socket = new Socket();
        Exception exception = null;

        long startTime = System.currentTimeMillis();

        try {
            socket.connect(new InetSocketAddress(hostName, port), 2000);
            System.out.println(System.currentTimeMillis() - startTime);
            socket.close();
            return true;
        } catch (IOException e) {
            exception = e;
            return false;
        }*/
        SocketAddress socketAddress = new InetSocketAddress(hostName, port);
        Socket socket = new Socket();

        long startTime = System.currentTimeMillis();

        try {
            socket.connect(socketAddress, 1000);
            socket.getOutputStream().write(4);
            while (socket.getInputStream().read() == -1) {}
            socket.close();
            System.out.println(System.currentTimeMillis() - startTime);
            return true;
        } catch (IOException e) {
            System.out.println("Err");
            System.out.println("Didn't connect to the port");
            return false;
        }
    }
    static boolean checkConnectivity(String hostName) {

        try {
            InetAddress inetAddress = InetAddress.getByName(hostName);

            long startTime = System.currentTimeMillis();

            boolean connectivity = inetAddress.isReachable(1000);
            if (connectivity) System.out.println(System.currentTimeMillis() - startTime);

            return connectivity;

        } catch (UnknownHostException e) {
            System.out.println("Err");
            return false;
        } catch (IOException e) {
            System.out.println("Err");
            return false;
        }
    }

}
