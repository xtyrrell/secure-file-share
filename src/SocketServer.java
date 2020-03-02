import java.io.*;
import java.net.*;
import java.util.*;

/**
 * This is the chat server program.
 * Press Ctrl + C to terminate the program.
 *
 * @author www.codejava.net
 */
public class SocketServer {
    private int port;
    private Set<RequestThread> threads = new HashSet<>();
 
    public SocketServer(int port) {
        this.port = port;
    }
 
    public void execute(Arguments arguments) {
        try (ServerSocket serverSocket = new ServerSocket(port)) {
 
            System.out.println("File server is listening on port " + port);
 
            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("New client connected");
 
                RequestThread newUser = new RequestThread(socket, this);
                threads.add(newUser);
                newUser.start();
            }
 
        } catch (IOException ex) {
            System.out.println("Error in the server: " + ex.getMessage());
            ex.printStackTrace();
        }
    }
 
    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("Syntax: java SocketServer <port-number>");
            System.exit(0);
        }
 
        int port = Integer.parseInt(args[0]);
 
        SocketServer server = new SocketServer(port);
        server.execute(null);
    }
 
 
    /**
     * When a client is disconneted, removes the associated username and RequestThread
     */
<<<<<<< Updated upstream:SocketServer.java
    public void removeUser(RequestThread aUser) {
      userThreads.remove(aUser);
=======
    void removeUser(RequestThread aUser) {
      threads.remove(aUser);
>>>>>>> Stashed changes:src/SocketServer.java
      System.out.println("A user disconnected");
    }
    
    public void print(PrintStream stream) {
      System.out.println(stream);
    }

}