package src.UI;

import src.Gobang;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Game {
    public Game(int rows, int columns) {
        JFrame frame = new JFrame("Game");
//        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setSize((rows + 2) * ChessBoard.CELL_SIZE, (columns + 3) * ChessBoard.CELL_SIZE);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel(new BorderLayout());
        frame.add(panel);
        placeComponents2(panel, rows, columns);

        frame.setVisible(true);
    }

    public static void main(String[] args) {
//        SwingUtilities.invokeLater(() -> new Game(20, 20));
        new Game(10, 10);
    }

    private static void placeComponents2(JPanel panel, int rows, int columns) {
        ChessBoard chessBoard = new ChessBoard(rows, columns);
//        panel.add(chessBoard, BorderLayout.CENTER);
        panel.add(chessBoard);
    }
}
