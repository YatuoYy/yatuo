package canves;

import jdk.nashorn.internal.runtime.regexp.joni.exception.InternalException;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by yatuo on 16-12-4.
 */
public class canvesFrame {
    public static void main(String[] args)
    {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                Frame frame = new Frame();
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setVisible(true);
            }
        });
    }

}
class Frame extends JFrame {
    private static final int DEFAULT_WIDTH = 1200;
    private static final int DEFAULT_HEIGHT = 650;
    JButton Button1 = new JButton("START");
    JButton Button2 = new JButton("RESUME");
    JButton Button3 = new JButton("STOP");
    JButton Button4 = new JButton("START");
    JButton Button5 = new JButton("RESUME");
    JButton Button6 = new JButton("STOP");
    JButton Button7 = new JButton("START");
    JButton Button8 = new JButton("RESUME");
    JButton Button9 = new JButton("STOP");
    JButton ButtonStartAll = new JButton("STARTALL");
    JButton ButtonResumeAll = new JButton("RESUMEALL");
    JButton ButtonStopAll = new JButton("STOPALL");

    JPanel Buttonpanel1 = new JPanel();
    JPanel Buttonpanel2 = new JPanel();
    JPanel Buttonpanel3 = new JPanel();
    JPanel Centerpanel = new JPanel(null);


    canvesPanel panel1 = new canvesPanel();
    canvesPanel2 panel2 = new canvesPanel2();
    canvesPanel3 panel3 = new canvesPanel3();
    JSlider slider1 = new JSlider(15,30,15);
    JSlider slider2 = new JSlider(15,30,15);
    JSlider slider3 = new JSlider(15,30,15);
    int r,r2,r3 = 0;
    boolean suspend1 =false;
    boolean suspend2 =false;
    boolean suspend3 =false;
    long time1 = 16;
    long time2 = 16;
    long time3 = 16;

    Frame() {
        setLayout(null);
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
        canvesrun r = new canvesrun(panel1);
        canvesrun2 r2 = new canvesrun2(panel2);
        canvesrun3 r3 = new canvesrun3(panel3);
        Button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                    r.start();
            }
        });
        Button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                   r.resume();
            }
        });
        Button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                r.suspend();
            }
        });
        Button4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                r2.start();
            }
        });
        Button5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                r2.resume();
            }
        });
        Button6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                r2.suspend();
            }
        });
        Button7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                r3.start();
            }
        });
        Button8.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                r3.resume();
            }
        });
        Button9.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                r3.suspend();
            }
        });
        ButtonStartAll.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                r.start();
                r2.start();
                r3.start();
            }
        });
        ButtonResumeAll.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                r.resume();
                r2.resume();
                r3.resume();
            }
        });
        ButtonStopAll.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                r.suspend();
                r2.suspend();
                r3.suspend();
            }
        });
        slider1.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent changeEvent) {
                JSlider source =(JSlider) changeEvent.getSource();
                time1 = 31 - source.getValue();

            }
        });
        slider2.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent changeEvent) {
                JSlider source =(JSlider) changeEvent.getSource();
                time2 = 31 - source.getValue();

            }
        });
        slider3.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent changeEvent) {
                JSlider source =(JSlider) changeEvent.getSource();
                time3 = 31 - source.getValue();

            }
        });

        Buttonpanel1.add(Button1,BorderLayout.WEST);
        Buttonpanel1.add(Button2,BorderLayout.CENTER);
        Buttonpanel1.add(Button3,BorderLayout.EAST);
        Buttonpanel2.add(Button4,BorderLayout.WEST);
        Buttonpanel2.add(Button5,BorderLayout.CENTER);
        Buttonpanel2.add(Button6,BorderLayout.EAST);
        Buttonpanel3.add(Button7,BorderLayout.WEST);
        Buttonpanel3.add(Button8,BorderLayout.CENTER);
        Buttonpanel3.add(Button9,BorderLayout.EAST);
        Buttonpanel1.setBounds(0,0,400,50);
        Buttonpanel2.setBounds(400,0,400,50);
        Buttonpanel3.setBounds(800,0,400,50);

        panel1.setBounds(0,0,400,400);
        panel2.setBounds(400,0,400,400);
        panel3.setBounds(800,0,400,400);
        Centerpanel.add(panel1);
        Centerpanel.add(panel2);
        Centerpanel.add(panel3);
        Centerpanel.setBounds(0,50,1200,400);

        slider1.setPaintTicks(true);
        slider1.setPaintLabels(true);
        slider1.setMajorTickSpacing(5);
        slider1.setMinorTickSpacing(1);
        slider2.setPaintTicks(true);
        slider2.setPaintLabels(true);
        slider2.setMajorTickSpacing(5);
        slider2.setMinorTickSpacing(1);
        slider3.setPaintTicks(true);
        slider3.setPaintLabels(true);
        slider3.setMajorTickSpacing(5);
        slider3.setMinorTickSpacing(1);

        slider1.setBounds(50,450,300,100);
        slider2.setBounds(460,450,300,100);
        slider3.setBounds(860,450,300,100);

        ButtonStartAll.setBounds(250,550,200,40);
        ButtonResumeAll.setBounds(500,550,200,40);
        ButtonStopAll.setBounds(750,550,200,40);

        add(Centerpanel);
        add(Buttonpanel1);
        add(Buttonpanel2);
        add(Buttonpanel3);
        add(slider1);
        add(slider2);
        add(slider3);
        add(ButtonStartAll);
        add(ButtonResumeAll);
        add(ButtonStopAll);
    }

    class canvesPanel extends JPanel {

        canvesPanel() {

        }

        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2 = (Graphics2D) g;
            g2.setColor(Color.RED);
            g2.fillArc(50, 50, 300, 300, r, 45);
            g2.fillArc(50, 50, 300, 300, r + 90, 45);
            g2.fillArc(50, 50, 300, 300, r + 180, 45);
            g2.fillArc(50, 50, 300, 300, r + 270, 45);
        }
    }
    class canvesPanel2 extends JPanel {
        canvesPanel2() {
        }

        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2 = (Graphics2D) g;
            g2.setColor(Color.RED);
            g2.fillArc(50, 50, 300, 300, r2, 45);
            g2.fillArc(50, 50, 300, 300, r2 + 90, 45);
            g2.fillArc(50, 50, 300, 300, r2 + 180, 45);
            g2.fillArc(50, 50, 300, 300, r2+ 270, 45);
        }
    }
    class canvesPanel3 extends JPanel {
        canvesPanel3() {
        }

        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2 = (Graphics2D) g;
            g2.setColor(Color.RED);
            g2.fillArc(50, 50, 300, 300, r3, 45);
            g2.fillArc(50, 50, 300, 300, r3 + 90, 45);
            g2.fillArc(50, 50, 300, 300, r3 + 180, 45);
            g2.fillArc(50, 50, 300, 300, r3 + 270, 45);
        }
    }

    class canvesrun implements Runnable {
        private Component ccom;
        public Thread t;

        canvesrun(Component component) {
            ccom = component;
        }

        public  void run() {
            try {
                for (r = 0; ; r++) {
                    synchronized (this) {
                        while (suspend1)
                            wait();
                    }

                    ccom.repaint();
                    if (r == 360)
                        r = 0;
                    Thread.sleep(time1);

                }


            } catch (InterruptedException e) {
            }
            ;
        }
            public void start(){
                if(t==null){
                    t = new Thread(this);
                    t.start();
                }

        }
            void suspend(){
                suspend1 = true;
            }
            synchronized void resume(){
                suspend1 = false;
                notify();
            }

    }
    class canvesrun2 implements Runnable {
        private Component ccom;
        public Thread t;

        canvesrun2(Component component) {
            ccom = component;
        }

        public  void run() {
            try {
                for (r2 = 0; ; r2++) {
                    synchronized (this) {
                        while (suspend2)
                            wait();
                    }
                    ccom.repaint();
                    if (r2 == 360)
                        r2 = 0;
                    Thread.sleep(time2);

                }


            } catch (InterruptedException e) {
            }
            ;
        }
        public void start(){
            if(t==null){
                t = new Thread(this);
                t.start();
            }

        }
        void suspend(){
            suspend2 = true;
        }
        synchronized void resume(){
            suspend2 = false;
            notify();
        }

    }
    class canvesrun3 implements Runnable {
        private Component ccom;
        public Thread t;

        canvesrun3(Component component) {
            ccom = component;
        }

        public  void run() {
            try {
                for (r3 = 0; ; r3++) {
                    synchronized (this) {
                        while (suspend3)
                            wait();
                    }
                    ccom.repaint();
                    if (r3 == 360)
                        r3= 0;
                    Thread.sleep(time3);

                }


            } catch (InterruptedException e) {
            }
            ;
        }
        public void start(){
            if(t==null){
                t = new Thread(this);
                t.start();
            }

        }
        void suspend(){
            suspend3 = true;
        }
        synchronized void resume(){
            suspend3 = false;
            notify();
        }

    }
}
