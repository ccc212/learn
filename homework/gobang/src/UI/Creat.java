package src.UI;

import src.Player;
import src.Room;
import src.Server;
import src.thread.ServerThread;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Creat extends JFrame{
    private int rowMax=30;
    private int columnMax=30;

    private int fontSize=20;
    private JTextField textRow;
    private JTextField textColumn;
    private JTextField resultField;
    private int port;

    public Creat(int port) throws Exception {
        super("创建");
        this.port = port;
        placeComponents();
    }

    private void startGame(int row,int column) throws Exception {
        Room room = new Room(row,column);
        Server.rooms.put(port,room);
        ChessBoard.init();
        new Thread(()->{
            try {
                new Server(port);
            }catch (Exception ex){
                ex.printStackTrace();
            }
        }).start();

        new Thread(()->{
            try {
                new Game(row,column);
            }catch (Exception ex){
                ex.printStackTrace();
            }
        }).start();

        dispose();
    }

    private void isValid(String row,String column) throws Exception {
        if(row.equals("") && column.equals("")){
            startGame(15,15);
        }
        try {
            int Row = Integer.parseInt(row);
            int Column = Integer.parseInt(column);
            if (Row > rowMax) {
                resultField.setText("行数超范围了");
                clearText();
                return;
            }
            if (Column > columnMax) {
                resultField.setText("列数超范围了");
                clearText();
                return;
            }
            if (Row <= 5 || Column <= 5 /*Row < 5 && Column < 5 || Row == 1 || Column == 1*/) {
                resultField.setText("无法创建棋盘");
                clearText();
                return;
            }
            startGame(Row,Column);
        } catch (NumberFormatException e) {
            resultField.setText("输入不合法");
            clearText();
        }
    }

    private void clearText(){
        textRow.setText("");
        textColumn.setText("");
    }

    private void placeComponents(){
        setLayout(null);
        setSize(300, 170);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);

        JLabel labelRow = new JLabel("行");
        labelRow.setBounds(2*fontSize,fontSize,fontSize,fontSize);
        labelRow.setFont(new Font("SimSun", Font.BOLD, fontSize));
        add(labelRow);

        JLabel labelColumn = new JLabel("列");
        labelColumn.setBounds(2*fontSize,3*fontSize,fontSize,fontSize);
        labelColumn.setFont(new Font("SimSun", Font.BOLD, fontSize));
        add(labelColumn);

        textRow = new JTextField(10);
        textRow.setBounds(3*fontSize,fontSize,2*fontSize,fontSize);
        add(textRow);

        textColumn = new JTextField(10);
        textColumn.setBounds(3*fontSize,3*fontSize,2*fontSize,fontSize);
        add(textColumn);

        resultField = new JTextField(20);
        resultField.setBounds(3*fontSize,5*fontSize-fontSize/2,7*fontSize,fontSize);
        resultField.setEditable(false);
        add(resultField);

        JButton submitButton = new JButton("确定");
        submitButton.setBounds(8*fontSize,fontSize,4*fontSize,3*fontSize);
        add(submitButton);

        // 将按钮与文本框关联
        getRootPane().setDefaultButton(submitButton);

        submitButton.addActionListener(e -> {
            String row = textRow.getText();
            String column = textColumn.getText();
            try {
                isValid(row,column);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                try {
                    Menu.unlock();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });

        setLocationRelativeTo(null);
        setVisible(true);
    }

}