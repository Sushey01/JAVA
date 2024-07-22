import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@SuppressWarnings("serial")
public class CalculatorGUI extends JFrame implements ActionListener {

    private JTextField num1Field;
    private JTextField num2Field;
    private JLabel resultLabel;
    private Calculator logic;

    public CalculatorGUI() {
        logic = new Calculator();

        setTitle("Calculator GUI");
        setSize(400, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setBackground(Color.WHITE);

        JPanel inputPanel = new JPanel(new GridLayout(2, 2, 10, 10));
        inputPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        inputPanel.setBackground(new Color(240, 240, 240));

        JLabel num1Label = new JLabel("Enter First Number:");
        num1Label.setFont(new Font("Arial", Font.BOLD, 14));
        num1Field = new JTextField(10);
        JLabel num2Label = new JLabel("Enter Second Number:");
        num2Label.setFont(new Font("Arial", Font.BOLD, 14));
        num2Field = new JTextField(10);

        inputPanel.add(num1Label);
        inputPanel.add(num1Field);
        inputPanel.add(num2Label);
        inputPanel.add(num2Field);

        JPanel buttonPanel = new JPanel(new GridLayout(1, 4, 10, 10));
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        buttonPanel.setBackground(new Color(240, 240, 240));

        String[] operations = {"+", "-", "*", "/"};
        for (String op : operations) {
            JButton button = new JButton(op);
            button.addActionListener(this);
            button.setBackground(new Color(100, 160, 200));
            button.setForeground(Color.WHITE);
            button.setFont(new Font("Arial", Font.BOLD, 14));
            buttonPanel.add(button);
        }

        JPanel resultPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        resultPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        resultPanel.setBackground(new Color(240, 240, 240));

        resultLabel = new JLabel("Result:");
        resultLabel.setFont(new Font("Arial", Font.BOLD, 16));
        resultPanel.add(resultLabel);

        add(inputPanel, BorderLayout.NORTH);
        add(buttonPanel, BorderLayout.CENTER);
        add(resultPanel, BorderLayout.SOUTH);

        setLocationRelativeTo(null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        try {
            double num1 = Double.parseDouble(num1Field.getText());
            double num2 = Double.parseDouble(num2Field.getText());
            double result = 0;

            switch (command) {
                case "+":
                    result = logic.add(num1, num2);
                    break;
                case "-":
                    result = logic.subtract(num1, num2);
                    break;
                case "*":
                    result = logic.multiply(num1, num2);
                    break;
                case "/":
                    result = logic.divide(num1, num2);
                    break;
            }
            resultLabel.setText("Result: " + result);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Please enter valid numbers", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (ArithmeticException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
