package org.example;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.awt.Desktop;
import java.net.URI;
import java.net.URISyntaxException;
import java.awt.geom.RoundRectangle2D;

public class Panel extends JPanel {
    private  Image background;
    private Window  window;
    private static final int HEIGHT_BUTTON = 30,WIDTH_BUTTON=180,DELTA=10,X_LINE=10,Y_LINE=440,WIDTH_LINE=480,HEIGHT_LINE=20;

    public Panel(Window window){
        addBackgroundPicture();
        this.window=window;
        this.setLayout(null);
        addByLine();
        buttonAndAction();
    }

    public void addByLine() {
        JLabel by = new JLabel("YoniJJAdler ");
        by.setBounds(X_LINE, Y_LINE, WIDTH_LINE, HEIGHT_LINE);
        by.setFont(new Font("Arial", Font.BOLD, 9));
        by.setVisible(true);
        by.setForeground(Color.BLACK);
        this.add(by);
    }

    public JButton createButton(String text, int x, int y) {
        JButton button = new JButton(text);
        button.setBounds(x, y, WIDTH_BUTTON, HEIGHT_BUTTON);
        button.setBackground(Color.CYAN);
        button.setForeground(Color.BLACK);
        button.setFont(new Font("Arial", Font.BOLD, 12));
        button.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1, true));
        button.setOpaque(true);
        return button;
    }

    public void buttonAndAction() {
        JButton managementActivities = createButton("Management Activities ", HEIGHT_BUTTON, HEIGHT_BUTTON);
        managementActivities.addActionListener(e -> {
            System.out.println("Management Activities");
            window.managementActivities();
        });
        this.add(managementActivities);

        JButton userStatistics = createButton("User Statistics ", HEIGHT_BUTTON, managementActivities.getY()+HEIGHT_BUTTON+DELTA);
        userStatistics.addActionListener(e -> {
            System.out.println("User Statistics");
            window.userStatistic();
        });
        this.add(userStatistics);

        JButton activityHistory = createButton("Activity history ", HEIGHT_BUTTON, userStatistics.getY()+HEIGHT_BUTTON+DELTA);
        activityHistory.addActionListener(e -> {
            System.out.println("Activity history");
            window.activityHistory();
        });
        this.add(activityHistory);

        JButton graph = createButton("Graph ", HEIGHT_BUTTON, activityHistory.getY()+HEIGHT_BUTTON+DELTA);
        graph.addActionListener(e -> {
            System.out.println(" graph");
            window.graph();
        });
        this.add(graph);

        JButton telegramBotLink = createButton("TelegramBotLink", HEIGHT_BUTTON, graph.getY() + HEIGHT_BUTTON + DELTA);
        telegramBotLink.addActionListener(e -> {
            try {
                Desktop.getDesktop().browse(new URI("http://t.me/Yoni_Edenbot"));
            } catch (IOException | URISyntaxException ex) {
                ex.printStackTrace();
            }
        });
        this.add(telegramBotLink);
    }

    public  void addBackgroundPicture() {
        try {
            background=ImageIO.read(new File("src/main/java/Utility/YoniEden3.jpg"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void paintComponent(Graphics g) {
        super.paintComponents(g);
        g.drawImage(background,0,0,getWidth(),getHeight(),this);
    }

    public static class RoundedButton extends JButton {
        public RoundedButton(String label) {
            super(label);
            setOpaque(false);
            setContentAreaFilled(false);
            setFocusPainted(false);
            setBorderPainted(false);
        }

        @Override
        protected void paintComponent(Graphics g) {
            Graphics2D g2 = (Graphics2D) g.create();
            g2.setPaint(Color.CYAN);
            g2.fill(new RoundRectangle2D.Float(0, 0, getWidth(), getHeight(), 25, 25));
            g2.dispose();

            super.paintComponent(g);
        }
    }


}


