import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

public class hewantanah1 {
    int boardWidth = 600;
    int boardHeight = 650;
    JFrame frame = new JFrame("Mario: Whac A Mole");
    JLabel textLabel = new JLabel();
    JPanel textPanel = new JPanel();
    JPanel boardPanel = new JPanel();
    JButton[] board = new JButton[9];
    ImageIcon moleIcon;
    ImageIcon plantIcon;
    JButton currMoleTile;
    JButton currPlantTile;
    Random random = new Random();
    Timer setMoleTimer;
    Timer setPlantTimer;
    int score = 0;
    int moleCount = 7;
    int plantCount = 1;
    int moleSpeed = 1000;
    int plantSpeed = 1500;

    hewantanah1() {
        this.frame.setSize(this.boardWidth, this.boardHeight);
        this.frame.setLocationRelativeTo((Component)null);
        this.frame.setResizable(false);
        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.frame.setLayout(new BorderLayout());
        this.textLabel.setFont(new Font("Arial", Font.PLAIN, 50));
        this.textLabel.setHorizontalAlignment(JLabel.CENTER);
        this.textLabel.setText("Score: " + this.score);
        this.textLabel.setOpaque(true);
        this.textPanel.setLayout(new BorderLayout());
        this.textPanel.add(this.textLabel);
        this.frame.add(this.textPanel, BorderLayout.NORTH);
        this.boardPanel.setLayout(new GridLayout(3, 3));
        this.frame.add(this.boardPanel);
        Image moleImage = (new ImageIcon(this.getClass().getResource("./monty.png"))).getImage();
        this.moleIcon = new ImageIcon(moleImage.getScaledInstance(150, 150, Image.SCALE_SMOOTH));
        Image plantImage = (new ImageIcon(this.getClass().getResource("./piranha.png"))).getImage();
        this.plantIcon = new ImageIcon(plantImage.getScaledInstance(150, 150, Image.SCALE_SMOOTH));

        for (int i = 0; i < 9; i++) {
            JButton button = new JButton();
            this.board[i] = button;
            this.boardPanel.add(button);
            button.setFocusable(false);
            button.addActionListener(new hewantanah2(this));
        }

        this.setMoleTimer = new Timer(moleSpeed, new hewantanah3(this));
        this.setPlantTimer = new Timer(plantSpeed, new hewantanah4(this));
        this.setMoleTimer.start();
        this.setPlantTimer.start();
        this.frame.setVisible(true);
    }

    public void updateSpeedAndCounts() {
        if (this.score >= 50 && this.score < 100) {
            this.moleCount--;
            this.plantCount++;
            this.moleSpeed -= 100;
            this.plantSpeed -= 100;
            this.setMoleTimer.setDelay(this.moleSpeed);
            this.setPlantTimer.setDelay(this.plantSpeed);
        } else if (this.score >= 100) {
            this.moleCount--;
            this.plantCount = 3;
            this.moleSpeed -= 200;  // Increase speed more at score 100
            this.plantSpeed -= 200; // Increase speed more at score 100
            this.setMoleTimer.setDelay(this.moleSpeed);
            this.setPlantTimer.setDelay(this.plantSpeed);
        }

        if (this.moleCount <= 0) {
            this.textLabel.setText("You Win!");
            this.setMoleTimer.stop();
            this.setPlantTimer.stop();
            for (int i = 0; i < 9; i++) {
                this.board[i].setEnabled(false);
            }
        }
    }
}