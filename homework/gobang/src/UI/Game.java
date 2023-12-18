package src.UI;
import javax.swing.*;
import java.awt.*;

public class Game extends JFrame{
    public Game(){
        super("五子棋(按 R 悔棋)");
        JPanel panel = new JPanel(new BorderLayout());
        add(panel);
        placeComponents(panel, 15, 15);
    }
    public Game(int rows, int columns) {
        super("五子棋(按 R 悔棋)");
        JPanel panel = new JPanel(new BorderLayout());
        add(panel);
        placeComponents(panel, rows, columns);
    }

    private void placeComponents(JPanel panel, int rows, int columns) {
        panel.setLayout(null);

        //        setExtendedState(JFrame.MAXIMIZED_BOTH);//设置全屏
        setSize( (columns + 2) * ChessBoard.CELL_SIZE,(rows + 2) * ChessBoard.CELL_SIZE);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);

//        ChessBoardTest chessBoard = new ChessBoardTest(rows, columns);
        ChessBoard chessBoard = new ChessBoard(rows, columns);
        chessBoard.setBounds(0,0,(rows + 2)*ChessBoard.CELL_SIZE,(columns + 2)*ChessBoard.CELL_SIZE);

        panel.add(chessBoard);

        setLocationRelativeTo(null);
        setVisible(true);
    }
}

