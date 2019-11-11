package app;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("CZ3006 Lab 2 UDP Client");

        // Need to initialise server in another terminal
        // Rfc865UdpServer.main(null);

        //String params[] = { "localhost", "17" };
        String params[] = { "djxmmx.net", "17" };
        //String params[] = { "Swl2-c2-v0102", "17" };
        Rfc865UdpClient.main(params);
    }
}