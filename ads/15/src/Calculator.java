import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Calculator extends JFrame {

    private JTextField input1 = new JTextField(10);
    private JTextField input2 = new JTextField(10);

    private JButton addButton = new JButton("+");
    private JButton subButton = new JButton("-");
    private JButton mulButton = new JButton("*");
    private JButton divButton = new JButton("%");

    public Calculator() {
        super("Калькулятор");
        setLayout(new FlowLayout());
        setSize(400, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        add(new JLabel("Первое число:"));
        add(input1);
        add(new JLabel("Второе число:"));
        add(input2);

        add(addButton);
        add(subButton);
        add(mulButton);
        add(divButton);


        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    double a = Double.parseDouble(input1.getText().trim());
                    double b = Double.parseDouble(input2.getText().trim());
                    JOptionPane.showMessageDialog(
                            null,
                            "Результат: " + (a + b),
                            "Сумма",
                            JOptionPane.INFORMATION_MESSAGE
                    );
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(
                            null,
                            "Ошибка: введите корректные числа!",
                            "Ошибка ввода",
                            JOptionPane.ERROR_MESSAGE
                    );
                }
            }
        });

        subButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    double a = Double.parseDouble(input1.getText().trim());
                    double b = Double.parseDouble(input2.getText().trim());
                    JOptionPane.showMessageDialog(
                            null,
                            "Результат: " + (a - b),
                            "Разность",
                            JOptionPane.INFORMATION_MESSAGE
                    );
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(
                            null,
                            "Ошибка: введите корректные числа!",
                            "Ошибка ввода",
                            JOptionPane.ERROR_MESSAGE
                    );
                }
            }
        });

        mulButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    double a = Double.parseDouble(input1.getText().trim());
                    double b = Double.parseDouble(input2.getText().trim());
                    JOptionPane.showMessageDialog(
                            null,
                            "Результат: " + (a * b),
                            "Произведение",
                            JOptionPane.INFORMATION_MESSAGE
                    );
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(
                            null,
                            "Ошибка: введите корректные числа!",
                            "Ошибка ввода",
                            JOptionPane.ERROR_MESSAGE
                    );
                }
            }
        });

        divButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    double a = Double.parseDouble(input1.getText().trim());
                    double b = Double.parseDouble(input2.getText().trim());
                    if (b == 0) {
                        JOptionPane.showMessageDialog(
                                null,
                                "Ошибка: деление на ноль невозможно!",
                                "Ошибка",
                                JOptionPane.ERROR_MESSAGE
                        );
                        return;
                    }
                    JOptionPane.showMessageDialog(
                            null,
                            "Результат: " + (a / b),
                            "Частное",
                            JOptionPane.INFORMATION_MESSAGE
                    );
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(
                            null,
                            "Ошибка: введите корректные числа!",
                            "Ошибка ввода",
                            JOptionPane.ERROR_MESSAGE
                    );
                }
            }
        });

        setVisible(true);
    }

    public static void main(String[] args) {
        new Calculator();
    }
}
