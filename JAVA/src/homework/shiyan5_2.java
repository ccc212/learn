package homework;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class shiyan5_2 extends JFrame {
    private JTextField nameField;
    private JTextField idField;
    private JTextField resultField;

    public shiyan5_2() {
        setTitle("学生信息验证");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());
        JLabel nameLabel = new JLabel("姓名：");
        nameField = new JTextField(15);
        JLabel idLabel = new JLabel("学号：");
        idField = new JTextField(15);
        JButton submitButton = new JButton("确定");
        resultField = new JTextField(20);
        resultField.setEditable(false);
        add(nameLabel);
        add(nameField);
        add(idLabel);
        add(idField);
        add(submitButton);
        add(resultField);
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id = idField.getText();
                if (isValidStudentId(id)) {
                    String name = nameField.getText();
                    resultField.setText("欢迎你！" + name + "同学！");
                } else {
                    resultField.setText("格式不对！");
                }
            }
        });
    }
    private boolean isValidStudentId(String id) {
        return id.startsWith("2020") && id.length() == 10 && id.chars().allMatch(Character::isDigit);
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            shiyan5_2 validator = new shiyan5_2();
            validator.setVisible(true);
        });
    }
}
