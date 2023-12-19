package src.UI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Result extends JFrame{
    private JLabel label;
    public Result(boolean player, ChessBoard chessBoard,int status) {
        super("获胜");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        if(status == 1) {
            label = new JLabel("玩家" + (player ? "2" : "1") + "获胜", JLabel.CENTER);
        }
        else if(status == 2){
            label = new JLabel("平局", JLabel.CENTER);
        }
        else if(status == 3){
            label = new JLabel("对手已离开");
        }
        label.setFont(new Font("SimSun", Font.BOLD, 20));
        add(label, BorderLayout.CENTER);

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                // 关闭Result时同时关闭ChessBoard
                chessBoard.close();
            }
        });

        setLocationRelativeTo(null);//窗口居中
        setVisible(true);
    }
}
