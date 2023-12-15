package src.UI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Win extends JFrame{
    public Win(boolean player, ChessBoard chessBoard) {
        super("获胜");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel label = new JLabel("玩家" + (player ? "2" : "1") + "获胜", JLabel.CENTER);
        label.setFont(new Font("SimSun", Font.BOLD, 20));
        add(label, BorderLayout.CENTER);

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                // 关闭Win窗口时同时关闭ChessBoard
                if (chessBoard != null) {
                    chessBoard.closeBoard();
                }
            }
        });

        setLocationRelativeTo(null);
        setVisible(true);
    }
}
