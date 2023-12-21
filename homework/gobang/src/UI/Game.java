package src.UI;
import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Game extends JFrame{
    private ChessBoard chessBoard;
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
//        panel.setLayout(null);
        //        setExtendedState(JFrame.MAXIMIZED_BOTH);//设置全屏
        setSize( (columns + 2) * ChessBoard.CELL_SIZE,(rows + 2) * ChessBoard.CELL_SIZE);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setResizable(false);

//        ChessBoardTest chessBoard = new ChessBoardTest(rows, columns);
        chessBoard = new ChessBoard(rows, columns);
        chessBoard.setBounds(0,0,(rows + 2)*ChessBoard.CELL_SIZE,(columns + 2)*ChessBoard.CELL_SIZE);

        panel.add(chessBoard);

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                Menu.unlock();
            }
        });

        setLocationRelativeTo(null);
        setVisible(true);
    }

    public ChessBoard getChessBoard() {
        return chessBoard;
    }
}

