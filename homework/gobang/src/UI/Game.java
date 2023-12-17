package src.UI;

import src.Gobang;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Game {
    public Game(int rows, int columns) {
        JFrame frame = new JFrame("五子棋(按 R 悔棋)");
//        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setSize( (columns + 2) * ChessBoard.CELL_SIZE,(rows + 2) * ChessBoard.CELL_SIZE);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel(new BorderLayout());
        frame.add(panel);
        placeComponents2(panel, rows, columns);

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private static void placeComponents2(JPanel panel, int rows, int columns) {
//        ChessBoardTest chessBoard = new ChessBoardTest(rows, columns);
        ChessBoard chessBoard = new ChessBoard(rows, columns);

//        panel.add(chessBoard, BorderLayout.CENTER);
        panel.add(chessBoard);
    }
}

