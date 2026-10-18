import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Client {

        public static void main(String[] args) {

            JFrame princ = new JFrame("Claudio Leppo 2172201");

            JPanel su = new JPanel();

            JPanel mid = new JPanel();

            mid.setLayout(new GridLayout(1,3));

            ArrayList<JPanel> pannelli = new ArrayList<>();

            for(int i = 0; i<3; i++) {

                JPanel striscia = new JPanel();
                pannelli.add(striscia);
                striscia.setBackground(Color.LIGHT_GRAY);
                mid.add(striscia);



            }

            JPanel giu = new JPanel();



            JTextField indirizzo = new JTextField("127.0.0.1");
            JTextField porta = new JTextField("4400");

            JButton connect = new JButton("connect");
            JButton disconnect = new JButton("disconnect");


            JButton start = new JButton("start");
            JButton stop = new JButton("stop");


            su.setLayout(new GridLayout(1,4));

            giu.setLayout(new GridLayout(1,2));

            su.add(indirizzo);
            su.add(porta);
            su.add(connect);
            su.add(disconnect);

            giu.add(start);
            giu.add(stop);

            princ.setLayout(new BorderLayout());

            princ.add(su, BorderLayout.NORTH);
            princ.add(mid, BorderLayout.CENTER);
            princ.add(giu, BorderLayout.SOUTH);


            princ.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

            princ.pack();
            princ.setVisible(true);

            ascoltatore asc = new ascoltatore(pannelli,indirizzo,porta,disconnect,connect,start,stop);

            connect.addActionListener(asc);
            start.addActionListener(asc);
            stop.addActionListener(asc);
            disconnect.addActionListener(asc);



            stop.setEnabled(false);
            disconnect.setEnabled(false);
            start.setEnabled(false);
            connect.setEnabled(true);





        }


}
