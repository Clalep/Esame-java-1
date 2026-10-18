import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;

public class ascoltatore implements ActionListener {

    ArrayList<JPanel> pannelli;
    JTextField indirizzo;
    JTextField porta;

    JButton connect;
    JButton disconnect;

    JButton start;
    JButton stop;

    Socket s;
    Scanner sc;
    PrintWriter pw;


    public ascoltatore(ArrayList<JPanel> pannelli, JTextField indirizzo, JTextField porta, JButton disconnect, JButton connect, JButton start, JButton stop){

        this.pannelli = pannelli;
        this.indirizzo = indirizzo;
        this.porta = porta;
        this.connect = connect;
        this.disconnect = disconnect;
        this.start = start;
        this.stop = stop;




    }




    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getActionCommand().equals("connect")) {


            try {

                s = new Socket(indirizzo.getText(), Integer.parseInt(porta.getText()));
                sc = new Scanner(s.getInputStream());
                pw = new PrintWriter(s.getOutputStream());

                stop.setEnabled(false);
                disconnect.setEnabled(true);
                start.setEnabled(true);
                connect.setEnabled(false);

                System.out.println("CONNESSO");

            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }

        }

        if(e.getActionCommand().equals("disconnect")) {

            stop.setEnabled(false);
            disconnect.setEnabled(false);
            start.setEnabled(false);
            connect.setEnabled(true);

            for(int i = 0; i<3; i++) {
                pannelli.get(i).setBackground(Color.LIGHT_GRAY);
            }

            pw.println("disconnect");
            pw.flush();

            pw.close();
            sc.close();
            try {
                s.close();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }


        }

        if(e.getActionCommand().equals("start")) {

            azione prova = new azione(pw,sc,pannelli,disconnect,start,stop);
            Thread sus = new Thread(prova);
            sus.start();

        }


        if(e.getActionCommand().equals("stop")) {

            pw.println("stop");
            pw.flush();

            stop.setEnabled(false);
            disconnect.setEnabled(true);
            start.setEnabled(true);


        }


    }
}
