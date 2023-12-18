package src.UI;
import javafx.util.Pair;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Stack;

public class ChessBoardTest extends JPanel {

    private int rows;
    private int columns;
    public static int CELL_SIZE = 50;

    public ChessBoardTest(int rows, int columns) {
        setBackground(Color.CYAN);
        this.rows = rows;
        this.columns = columns;
        Stack<Pair<Integer, Integer>> stack = new Stack<>();
        setPreferredSize(new Dimension(columns * CELL_SIZE, rows * CELL_SIZE));
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        // 绘制背景
        g.setColor(getBackground());
        g.fillRect(0, 0, getWidth(), getHeight());

        // 绘制网格线
        g.setColor(Color.BLACK);
        for (int i = 1; i <= rows; i++) {
            int coordinate = i * CELL_SIZE;
            g.drawLine(CELL_SIZE, coordinate, columns * CELL_SIZE, coordinate);
            g.drawLine(coordinate, CELL_SIZE, coordinate, rows * CELL_SIZE);
        }
    }
}
