package src.UI;

import src.Info;
import src.Player;

import javax.swing.*;
import java.io.*;
import java.net.Socket;

public class Menu {
    public static Menu instance = new Menu();
    public JButton btn1;
    public JButton btn2;
    public JTextField userText;
    public JTextField resultField;
    public JFrame frame;
    public Socket roomInfoSocket;
    public String name;
    public String otherName;
    public String address;
    private Menu(){
        frame = new JFrame("菜单");
        frame.setSize(400,300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);

        JPanel panel = new JPanel();
        frame.add(panel);

        frame.setVisible(true);
        frame.setLocationRelativeTo(null);

        name = JOptionPane.showInputDialog("名字:");

        placeComponents(panel);
        frame.repaint();

    }
    public static void main(String[] args){
        Menu m = Menu.instance;
    }

    public void lock(String str){
        btn1.setEnabled(false);
        btn2.setEnabled(false);
        userText.setEnabled(false);
        resultField.setText(str);
    }

    public void unlock(){
        btn1.setEnabled(true);
        btn2.setEnabled(true);
        userText.setEnabled(true);
        resultField.setText("");
    }

    private void placeComponents(JPanel panel) {
        panel.setLayout(null);

        JLabel userLabel = new JLabel("五子棋");
        userLabel.setBounds(50,50,300,100);
        userLabel.setHorizontalAlignment(JLabel.CENTER);
        userLabel.setFont(userLabel.getFont().deriveFont(30.0f));
        panel.add(userLabel);

        btn1 = new JButton("创建");
        btn2 = new JButton("加入");
        btn1.setBounds(50,150,100,50);
        btn2.setBounds(250,150,100,50);
        panel.add(btn1);
        panel.add(btn2);

        userText = new JTextField(20);
        userText.setBounds(150,163,100,25);
        panel.add(userText);

        resultField = new JTextField(20);
        resultField.setBounds(130,220,140,25);
        resultField.setEditable(false);
        panel.add(resultField);

        btn1.addActionListener(e -> {
            String port = userText.getText();
            if(isValid(userText.getText())) {
                lock("创建房间 端口:" + port);
                try {
                    new Create(Integer.parseInt(userText.getText()));
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
        btn2.addActionListener(e -> {
            String port = userText.getText();
            if(isValid(port)) {
                lock("进入房间 端口" + port);
                try {
                    roomInfoSocket = new Socket("127.0.0.1", Integer.parseInt(port));
                    Player player = null;
                    try {
                        ObjectInputStream ois = new ObjectInputStream(roomInfoSocket.getInputStream());
                        Info info = (Info) ois.readObject();

                        if(info.getString() != null){
                            otherName = info.getString();
                        }

                        if (info.getRoom() != null) {
                            player = new Player(Integer.parseInt(port), info.getRoom().getRow(),
                                    info.getRoom().getColumn(), false);
                        } else {
                            unlock();
                            resultField.setText("?...房间不存在");
                        }

                        ObjectOutputStream oos = new ObjectOutputStream(roomInfoSocket.getOutputStream());
                        Info info2 = new Info(name);
                        info2.setAddress(player.getSocket().getLocalSocketAddress().toString());
                        oos.writeObject(info2);

                        ois.close();
                        oos.close();
                    }catch (Exception exception){
                        exception.printStackTrace();
                    }
                    finally {
                        roomInfoSocket.close();
                    }
                } catch (Exception ex) {
                    unlock();
                    resultField.setText("该端口未开房");
                }
            }
        });
    }

    private boolean isValid(String port){
        try {
            int Port = Integer.parseInt(port);
            if(Port < 1 || Port > 65535){
                userText.setText("");
                resultField.setText("端口范围应在0~65535中");
                return false;
            }
            return true;
        } catch (NumberFormatException e) {
            userText.setText("");
            resultField.setText("输入不合法");
            return false;
        }
    }

}
