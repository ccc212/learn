package src.UI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Result extends JFrame{
    private JLabel label;
    public Result(boolean player, ChessBoard chessBoard,boolean win) {
        super("获胜");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        if(win) {
            label = new JLabel("玩家" + (player ? "2" : "1") + "获胜", JLabel.CENTER);
        }else{
            label = new JLabel("平局", JLabel.CENTER);
        }
        label.setFont(new Font("SimSun", Font.BOLD, 20));
        add(label, BorderLayout.CENTER);

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                // 关闭Win时同时关闭ChessBoard
                chessBoard.close();
            }
        });

        setLocationRelativeTo(null);//窗口居中
        setVisible(true);
    }
}
