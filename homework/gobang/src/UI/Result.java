package src.UI;

import src.Player;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Result extends JFrame{
    private JLabel label;
    public Result(boolean player, Component cmp,int status) {
        super("结果");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        label = new JLabel(getResultLabelText(player, status), JLabel.CENTER);
        label.setFont(new Font("SimSun", Font.BOLD, 20));
        add(label, BorderLayout.CENTER);

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                if(cmp instanceof ChessBoard) {
                    ((ChessBoard) cmp).close();
                    Player.instance.closeSocket();
                }
                Menu.instance.unlock();
            }
        });

        setLocationRelativeTo(cmp);
        setVisible(true);
    }

    private String getResultLabelText(boolean player, int status) {
        switch (status) {
            case Status.WIN:
                return "玩家" + (player ? "2" : "1") + "获胜";
            case Status.DRAW:
                return "平局";
            case Status.LEAVE:
                return "对手已离开";
            case Status.CLOSE:
                return "房间已关闭";
            case Status.LOSE:
                return "你输了"; 
            case Status.WAIT:
                return "等待玩家加入";
            default:
                return "未知结果";
        }
    }

    public void close(){
        dispose();
        Menu.instance.unlock();
    }
}
