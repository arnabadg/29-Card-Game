package projectserver;

import static com.sun.corba.se.impl.util.Utility.printStackTrace;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.stream.events.StartElement;
import jdk.nashorn.internal.ir.BreakNode;
import static projectserver.Projectserver.bid;
import static projectserver.Projectserver.bidcount;
import static projectserver.Projectserver.bidder;
import static projectserver.Projectserver.drawcard1;
import static projectserver.Projectserver.drawcard2;
import static projectserver.Projectserver.highestbid;
import static projectserver.Projectserver.highestbidder;
import static projectserver.Projectserver.istrumpset;
import static projectserver.Projectserver.trump;
import static projectserver.Projectserver.play1;
import static projectserver.Projectserver.play2;
import static projectserver.Projectserver.play3;
import static projectserver.Projectserver.play4;
import static projectserver.Projectserver.dealpressed;

public class Projectserver {

    public static ArrayList<Socket> allclientsock = new ArrayList<>();
    public static boolean dealpressed = false;
    public static int start2count = 0;
    public static int bidcount = 0;

    static boolean istrumpset = false;
    static int bid = 0;
    static int bidder = 1;
    static int highestbid = 0;
    static int highestbidder = 0;
    static Random rndNumbers = new Random();

    static String trump = null;

    static int ourpoint = 0;
    static int theirpoint = 0;
    static int ourscore = 0;
    static int theirscore = 0;

    static int array[] = new int[33];
    static int x;
    static int play1[] = new int[9];
    static int play2[] = new int[9];
    static int play3[] = new int[9];
    static int play4[] = new int[9];

    public static void drawcard1(int play1[], int play2[], int play3[], int play4[]) {

        for (int i = 0; i < 33; i++) {
            array[i] = 0;
        }
        for (int i = 1; i <= 4; i++) {
            x = rndNumbers.nextInt();
            if (x < 0) {
                x = -x;
            }
            x = x % 32 + 1;
            if (array[x] == 0) {
                play1[i] = x;
                array[x] = 1;

            } else {
                while (true) {
                    x++;
                    if (x > 32) {
                        x -= 32;
                    }
                    if (array[x] == 0) {
                        play1[i] = x;
                        array[x] = 1;
                        break;
                    }
                }
            }
        }

        for (int i = 1; i <= 4; i++) {

            x = rndNumbers.nextInt();
            if (x < 0) {
                x = -x;
            }
            x = x % 32 + 1;

            if (array[x] == 0) {
                play2[i] = x;
                array[x] = 1;

            } else {
                while (true) {
                    x++;
                    if (x > 32) {
                        x -= 32;
                    }
                    if (array[x] == 0) {
                        play2[i] = x;
                        array[x] = 1;
                        break;
                    }
                }
            }
        }

        for (int i = 1; i <= 4; i++) {
            x = rndNumbers.nextInt();
            if (x < 0) {
                x = -x;
            }
            x = x % 32 + 1;
            if (array[x] == 0) {
                play3[i] = x;
                array[x] = 1;

            } else {
                while (true) {
                    x++;
                    if (x > 32) {
                        x -= 32;
                    }
                    if (array[x] == 0) {
                        play3[i] = x;
                        array[x] = 1;
                        break;
                    }
                }
            }
        }

        for (int i = 1; i <= 4; i++) {
            x = rndNumbers.nextInt();
            if (x < 0) {
                x = -x;
            }
            x = x % 32 + 1;
            if (array[x] == 0) {
                play4[i] = x;
                array[x] = 1;

            } else {
                while (true) {
                    x++;
                    if (x > 32) {
                        x -= 32;
                    }
                    if (array[x] == 0) {
                        play4[i] = x;
                        array[x] = 1;
                        break;
                    }
                }
            }
        }

        Arrays.sort(play1, 1, 5);
        Arrays.sort(play2, 1, 5);
        Arrays.sort(play3, 1, 5);
        Arrays.sort(play4, 1, 5);

    }

    public static void drawcard2(int play1[], int play2[], int play3[], int play4[]) {

        for (int i = 5; i <= 8; i++) {
            x = rndNumbers.nextInt();
            if (x < 0) {
                x = -x;
            }
            x = x % 32 + 1;
            if (array[x] == 0) {
                play1[i] = x;
                array[x] = 1;

            } else {
                while (true) {
                    x++;
                    if (x > 32) {
                        x -= 32;
                    }
                    if (array[x] == 0) {
                        play1[i] = x;
                        array[x] = 1;
                        break;
                    }
                }
            }
        }

        for (int i = 5; i <= 8; i++) {
            x = rndNumbers.nextInt();
            if (x < 0) {
                x = -x;
            }
            x = x % 32 + 1;
            if (array[x] == 0) {
                play2[i] = x;
                array[x] = 1;

            } else {
                while (true) {
                    x++;
                    if (x > 32) {
                        x -= 32;
                    }
                    if (array[x] == 0) {
                        play2[i] = x;
                        array[x] = 1;
                        break;
                    }
                }
            }
        }

        for (int i = 5; i <= 8; i++) {
            x = rndNumbers.nextInt();
            if (x < 0) {
                x = -x;
            }
            x = x % 32 + 1;
            if (array[x] == 0) {
                play3[i] = x;
                array[x] = 1;

            } else {
                while (true) {
                    x++;
                    if (x > 32) {
                        x -= 32;
                    }
                    if (array[x] == 0) {
                        play3[i] = x;
                        array[x] = 1;
                        break;
                    }
                }
            }
        }

        for (int i = 5; i <= 8; i++) {
            x = rndNumbers.nextInt();
            if (x < 0) {
                x = -x;
            }
            x = x % 32 + 1;
            if (array[x] == 0) {
                play4[i] = x;
                array[x] = 1;

            } else {
                while (true) {
                    x++;
                    if (x > 32) {
                        x -= 32;
                    }
                    if (array[x] == 0) {
                        play4[i] = x;
                        array[x] = 1;
                        break;
                    }
                }
            }
        }

        /*
        Arrays.sort(play1, 1, 9);
        Arrays.sort(play2, 1, 9);
        Arrays.sort(play3, 1, 9);
        Arrays.sort(play4, 1, 9);
         */
    }

    public static void main(String argv[]) throws Exception {
        int workerThreadCount = 0;
        int id = 1;

        ServerSocket welcomeSocket = new ServerSocket(1234);
        while (true) {
            Socket connectionSocket = welcomeSocket.accept();
            allclientsock.add(connectionSocket);
            WorkerThread wt = new WorkerThread(connectionSocket, id);
            Thread t = new Thread(wt);
            t.start();
            workerThreadCount++;

            System.out.println("Recieved data from client");
            id++;
        }
    }
}

class WorkerThread implements Runnable {

    private Socket connectionSocket;
    private int id;

    ObjectOutputStream out;
    ObjectInputStream in;

    public WorkerThread(Socket ConnectionSocket, int id) {
        this.connectionSocket = ConnectionSocket;
        this.id = id;

        try {
            out = new ObjectOutputStream(connectionSocket.getOutputStream());
            out.flush();
            in = new ObjectInputStream(connectionSocket.getInputStream());
            out.writeObject(id);

        } catch (IOException ex) {
            Logger.getLogger(WorkerThread.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Initializing data for id: " + id);
    }

    //MAIN LOGIC IS INSIDE RUN
    public void run() {

        String s1 = null, s2;
        int command;

        //INITIALIZING CARDS FOR EACH PLAYER BY DRAWCARD FUNCTION
        try {
            if (id == 1 && dealpressed == false) {
                s1 = (String) in.readObject();
                if (s1.equals("SENDCARD")) {
                    dealpressed = true;

                    drawcard1(play1, play2, play3, play4);
                    drawcard2(play1, play2, play3, play4);
                }
            } else {
                while (true) {
                    if (dealpressed == true) {
                        break;
                    }
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(WorkerThread.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(WorkerThread.class.getName()).log(Level.SEVERE, null, ex);
        }

        //SENDING 1ST 4 CARDS
        while (true) {
            if (dealpressed == true) {
                try {
                    if (id == 1) {
                        for (int x = 1; x < 5; x++) {
                            out.writeObject(play1[x]);
                        }
                        break;

                    }
                    if (id == 2) {
                        for (int x = 1; x < 5; x++) {
                            out.writeObject(play2[x]);
                        }
                        break;
                    }
                    if (id == 3) {
                        for (int x = 1; x < 5; x++) {
                            out.writeObject(play3[x]);
                        }
                        break;
                    }
                    if (id == 4) {
                        for (int x = 1; x < 5; x++) {
                            out.writeObject(play4[x]);
                        }
                        break;
                    }

                } catch (IOException ex) {
                    Logger.getLogger(WorkerThread.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            //System.out.println("Inside Client " + id);
        }

        //SETTING BID
        while (true) {
            System.out.println("Inside Client " + id);

            try {
                if (id == bidder) {
                    System.out.println("Inside bidder " + id);

                    out.writeObject("bidder");
                    String temp = (String) in.readObject();

                    //System.out.println("got bid"+id);
                    if (!temp.equals("PASS")) {

                        int tempbid = Integer.parseInt(temp);
                        System.out.println("for id " + id + "bid " + tempbid);
                        if (tempbid > bid) {
                            while (true) {
                                bid = tempbid;
                                highestbidder = bidder;
                                break;
                            }
                        }
                    }

                    bidder++;
                    bidcount++;
                    if (bidder == 5 && bidcount < 4) {
                        bidder = 1;
                    }
                }
            } catch (IOException ex) {
                Logger.getLogger(WorkerThread.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(WorkerThread.class.getName()).log(Level.SEVERE, null, ex);
            }

            if (bidcount == 4) {
                break;
            }
        }

        //BIDSHOWING
        System.out.println("HERE I AM " + id);
        while (true) {

            System.out.println("HERE I AM2 " + id);

            try {
                highestbid = bid;
                //System.out.println("THERE I GO2 "+ id);
                out.writeObject(highestbid);
                out.writeObject(highestbidder);
            } catch (IOException ex) {
                Logger.getLogger(WorkerThread.class.getName()).log(Level.SEVERE, null, ex);
            }
            break;
        }

        System.out.println("HERE I AM3 " + id);
        try {

            //TRUMP SET
            if (id == highestbidder) {
                out.writeObject("settrump");
                trump = (String) in.readObject();
                System.out.println("trump received");
                istrumpset = true;
            } else {
                while (true) {
                    System.out.println("HERE I AM4 " + id);
                    if (istrumpset == true) {
                        int x = 1;
                        out.writeObject(x);
                        break;
                    }
                }
            }
            //SENDING 2ND 4 CARDS
            while (true) {
                System.out.println("HERE I AM5 " + id);

                if (id == 1) {
                    for (int x = 5; x < 9; x++) {
                        out.writeObject(play1[x]);
                    }
                } else if (id == 2) {
                    for (int x = 5; x < 9; x++) {
                        out.writeObject(play2[x]);
                    }
                } else if (id == 3) {
                    for (int x = 5; x < 9; x++) {
                        out.writeObject(play3[x]);
                    }
                } else if (id == 4) {
                    for (int x = 5; x < 9; x++) {
                        out.writeObject(play4[x]);
                    }
                }
                System.out.println("HERE I AM6 " + id);
                break;
            }
        } catch (IOException ex) {
            Logger.getLogger(WorkerThread.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(WorkerThread.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
