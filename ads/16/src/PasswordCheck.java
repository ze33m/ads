import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PasswordCheck extends JFrame {

    private JTextField loginField;
    private JPasswordField passwordField;
    private JLabel resultLabel;

    public PasswordCheck() {
        super("Проверка пароля");
        initUI();
    }

    private void initUI() {
        setLayout(new BorderLayout(10, 10));

        JPanel centerPanel = new JPanel(new GridLayout(3, 2, 5, 5));

        JLabel loginLabel = new JLabel("Логин:");
        loginField = new JTextField();

        JLabel passwordLabel = new JLabel("Пароль:");
        passwordField = new JPasswordField();

        JButton okButton = new JButton("OK");
        resultLabel = new JLabel("", SwingConstants.CENTER);

        centerPanel.add(loginLabel);
        centerPanel.add(loginField);
        centerPanel.add(passwordLabel);
        centerPanel.add(passwordField);
        centerPanel.add(okButton);
        centerPanel.add(resultLabel);

        add(centerPanel, BorderLayout.CENTER);

        okButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                checkPassword();
            }
        });

        passwordField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER)
                    checkPassword();
            }
        });

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 180);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void checkPassword() {
        String login = loginField.getText();
        String password = new String(passwordField.getPassword());

        if (login.equals("ze33m") && password.equals("12345")) {
            resultLabel.setText("Вход выполнен");
            resultLabel.setForeground(Color.GREEN);
        } else {
            resultLabel.setText("Логин или пароль введены неверно");
            resultLabel.setForeground(Color.RED);
        }
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> new PasswordCheck());
    }
}
