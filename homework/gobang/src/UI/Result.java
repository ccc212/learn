package src.UI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Result extends JFrame{
    private JLabel label;
    public Result(boolean player, ChessBoard chessBoard,int status) {
        super("结果");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        if(status == Status.WIN) {
            label = new JLabel("玩家" + (player ? "2" : "1") + "获胜", JLabel.CENTER);
        }
        else if(status == Status.DRAW){
            label = new JLabel("平局", JLabel.CENTER);
        }
        else if(status == Status.LEAVE){
            label = new JLabel("对手已离开", JLabel.CENTER);
        }
        else if(status == Status.CLOSE){
            label = new JLabel("房间已关闭", JLabel.CENTER);
        }
        else if(status == Status.LOSE){
            label = new JLabel("你输了", JLabel.CENTER);
        }
        label.setFont(new Font("SimSun", Font.BOLD, 20));
        add(label, BorderLayout.CENTER);

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                chessBoard.close();
                Menu.unlock();
            }
        });

        setLocationRelativeTo(chessBoard);
        setVisible(true);
    }
}
