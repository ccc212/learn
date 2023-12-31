package src.UI;
import src.Player;
import src.Server;

import javax.swing.*;
import java.awt.*;
import java.awt.Font;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Game extends JFrame{
    public static Game instance;
    private ChessBoard chessBoard;
    public Game(int rows, int columns) {
        super("五子棋(按 R 悔棋)");
        JPanel panel = new JPanel(new BorderLayout());
        add(panel);
        placeComponents(panel, rows, columns);
    }

    private void placeComponents(JPanel panel, int rows, int columns) {
//        panel.setLayout(null);

        JPanel player1 = new JPanel();
        JLabel name1 = new JLabel("<html>你<hr>" + Menu.instance.name + "</html>");
        name1.setFont(new Font("", Font.BOLD, ChessBoard.CELL_SIZE/2));
        player1.add(name1);
        panel.add(player1, BorderLayout.WEST);

        chessBoard = new ChessBoard(rows, columns);
        chessBoard.setBounds(0,0,(rows + 2)*ChessBoard.CELL_SIZE,(columns + 2)*ChessBoard.CELL_SIZE);
        panel.add(chessBoard,BorderLayout.CENTER);

        JPanel player2 = new JPanel();
        JLabel name2 = new JLabel("<html>对方<hr>" + Menu.instance.otherName + "</html>");
        name2.setFont(new Font("", Font.BOLD, ChessBoard.CELL_SIZE/2));
        player2.add(name2);
        panel.add(player2, BorderLayout.EAST);

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                Menu.instance.unlock();
                if(Player.isRoomOwner()){
                    Server.close();
                }
            }
        });


        //        setExtendedState(JFrame.MAXIMIZED_BOTH);//设置全屏
        setVisible(true);
        setLocationRelativeTo(Menu.instance.frame);
        setSize( (columns + 2) * ChessBoard.CELL_SIZE+player1.getSize().width+player2.getSize().width,(rows + 2) * ChessBoard.CELL_SIZE);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setResizable(false);
    }

    public ChessBoard getChessBoard() {
        return chessBoard;
    }

    public void setChessBoardClickable(boolean clickable) {
        chessBoard.setClickable(clickable);
    }

}

