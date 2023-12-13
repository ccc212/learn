package src.UI;

import javax.swing.*;
import java.awt.*;

public class Game{
    public static void main(String[] args) {
        JFrame frame = new JFrame("Game");
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        frame.add(panel);
        placeComponents2(panel);

        frame.setVisible(true);
    }

    private static void placeComponents2(JPanel panel) {
        panel.setLayout(null);

        panel.add(new BoardPanel());
    }
}

class BoardPanel extends JPanel {
    private static final int GRID_SIZE = 19;

    @Override
    public void paintComponent(Graphics g) {
        setPreferredSize(new Dimension(400, 400));
        super.paintComponent(g);

        int width = getWidth();
        int height = getHeight();
        int cellSize = Math.min(width, height) / GRID_SIZE;

        // 画横线
        for (int i = 0; i <= GRID_SIZE; i++) {
            int y = i * cellSize;
            g.drawLine(0, y, width, y);
        }

        // 画竖线
        for (int i = 0; i <= GRID_SIZE; i++) {
            int x = i * cellSize;
            g.drawLine(x, 0, x, height);
        }
    }
}
