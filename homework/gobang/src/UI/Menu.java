package src.UI;

import javax.swing.*;

public class Menu extends JFrame{
    JTextField userText;
    JTextField resultField;
    public Menu(){
        JFrame frame = new JFrame("菜单");
        frame.setSize(400,300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        frame.add(panel);
        placeComponents(panel);

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
    public static void main(String[] args) {
        Menu menu = new Menu();
    }

    private void placeComponents(JPanel panel) {
        panel.setLayout(null);

        JLabel userLabel = new JLabel("五子棋");
        userLabel.setBounds(50,50,300,100);
        userLabel.setHorizontalAlignment(JLabel.CENTER);
        userLabel.setFont(userLabel.getFont().deriveFont(30.0f));
        panel.add(userLabel);

        JButton btn1 = new JButton("创建");
        JButton btn2 = new JButton("加入");
        btn1.setBounds(50,150,100,50);
        btn2.setBounds(250,150,100,50);
        panel.add(btn1);
        panel.add(btn2);

        userText = new JTextField(20);
        userText.setBounds(150,163,100,25);
        panel.add(userText);

        resultField = new JTextField(20);
        resultField.setBounds(150,220,100,25);
        resultField.setEditable(false);
        panel.add(resultField);

        btn1.addActionListener(e -> {
            if(isValid(userText.getText())) {
                new Creat(Integer.parseInt(userText.getText()));
            }
        });
        btn2.addActionListener(e -> {
            if(isValid(userText.getText())) {
                String port = userText.getText();
                System.out.println("加入端口" + port);
            }
//            try {
//                new Other(Integer.parseInt(port));
//            } catch (Exception ex) {
//                ex.printStackTrace();
//            }
        });
    }

    private boolean isValid(String port){
        try {
            int Port = Integer.parseInt(port);
            if(Port < 0 || Port > 65535){
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

    public static void close() {
        JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(new Menu());
        try {
            frame.dispose();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
