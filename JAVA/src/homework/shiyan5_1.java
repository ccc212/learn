package homework;

import java.util.Random;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//编写一个猜数字的游戏，按下“产生随机数”按钮产生一个0~9的随机数，则在屏幕的提示框显示“输入所猜测的数字”，
// 当输入所猜测的数字并按“确定”按钮后，在提示框中提示“输入正确”(或“猜小了”、或“猜大了”)。
public class shiyan5_1 extends JFrame {
    private int randomNumber;
    private JTextField inputField;
    private JLabel resultLabel;
    public shiyan5_1() {
        setTitle("猜数字游戏");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());
        Random random = new Random();
        randomNumber = random.nextInt(10);
        inputField = new JTextField(5);
        JButton submitButton = new JButton("确定");
        resultLabel = new JLabel("输入所猜测的数字");
        add(inputField);
        add(submitButton);
        add(resultLabel);
        submitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                checkGuess();
            }
        });
    }
    private void checkGuess() {
        try {
            int guess = Integer.parseInt(inputField.getText());
            if (guess == randomNumber) {
                resultLabel.setText("输入正确");
            } else if (guess < randomNumber) {
                resultLabel.setText("猜小了");
            } else {
                resultLabel.setText("猜大了");
            }
        } catch (NumberFormatException ex) {
            resultLabel.setText("请输入有效数字");
        }
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            shiyan5_1 game = new shiyan5_1();
            game.setVisible(true);
        });
    }
}
