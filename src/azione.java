import javax.swing.*;
import java.awt.*;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;

public class azione implements Runnable{



    PrintWriter pw;
    Scanner sc;

    ArrayList<JPanel> pannelli;

    JButton disconnect;

    JButton start;
    JButton stop;


    public azione(PrintWriter pw, Scanner sc, ArrayList<JPanel> pannelli, JButton disconnect, JButton start, JButton stop) {

        this.pw = pw;
        this.sc = sc;
        this.pannelli = pannelli;

        this.stop = stop;
        this.start = start;
        this.disconnect = disconnect;


    }






    @Override
    public void run() {

        for(int i = 0; i<3; i++) {
            pannelli.get(i).setBackground(Color.LIGHT_GRAY);
        }


        stop.setEnabled(true);
        disconnect.setEnabled(false);
        start.setEnabled(false);

        pw.println("start");
        pw.flush();

        while(true) {

            String riga = sc.nextLine();
            System.out.println("DEBUG - Ricevuto dal server: " + riga);
            String[] dis = riga.split(";");

            if(dis[0].equals("-1")) {

                break;

            }

            int cod = Integer.parseInt(dis[0]);
            String pos = dis[1];


            if(pos.equals("SX")) {

                if (cod == 0) {
                    pannelli.get(0).setBackground(Color.WHITE);
                }
                if (cod == 1) {
                    pannelli.get(0).setBackground(Color.BLACK);
                }
                if (cod == 2) {
                    pannelli.get(0).setBackground(Color.GREEN);
                }
                if (cod == 3) {
                    pannelli.get(0).setBackground(Color.RED);
                }
                if (cod == 4) {
                    pannelli.get(0).setBackground(Color.YELLOW);
                }
                if (cod == 5) {
                    pannelli.get(0).setBackground(Color.BLUE);
                }
                if (cod == 6) {
                    pannelli.get(0).setBackground(Color.ORANGE);
                }

            }
            if(pos.equals("CX")) {

                if (cod == 0) {
                    pannelli.get(1).setBackground(Color.WHITE);
                }
                if (cod == 1) {
                    pannelli.get(1).setBackground(Color.BLACK);
                }
                if (cod == 2) {
                    pannelli.get(1).setBackground(Color.GREEN);
                }
                if (cod == 3) {
                    pannelli.get(1).setBackground(Color.RED);
                }
                if (cod == 4) {
                    pannelli.get(1).setBackground(Color.YELLOW);
                }
                if (cod == 5) {
                    pannelli.get(1).setBackground(Color.BLUE);
                }
                if (cod == 6) {
                    pannelli.get(1).setBackground(Color.ORANGE);
                }

            }

            if(pos.equals("DX")) {

                if (cod == 0) {
                    pannelli.get(2).setBackground(Color.WHITE);
                }
                if (cod == 1) {
                    pannelli.get(2).setBackground(Color.BLACK);
                }
                if (cod == 2) {
                    pannelli.get(2).setBackground(Color.GREEN);
                }
                if (cod == 3) {
                    pannelli.get(2).setBackground(Color.RED);
                }
                if (cod == 4) {
                    pannelli.get(2).setBackground(Color.YELLOW);
                }
                if (cod == 5) {
                    pannelli.get(2).setBackground(Color.BLUE);
                }
                if (cod == 6) {
                    pannelli.get(2).setBackground(Color.ORANGE);
                }

            }



        }



    }
}
