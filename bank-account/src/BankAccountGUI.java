import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class BankAccountGUI extends JFrame implements ActionListener {
    private JLabel amountLabel = new JLabel("Please Input Amount:");
    private JTextField amountField = new JTextField(10);
    private JButton depositButton = new JButton("Deposit Funds");
    private JButton withdrawButton = new JButton("Withdraw Funds");
    private JLabel balanceLabel = new JLabel("Current Balance: $0.00");

    private JPanel topPanel = new JPanel();
    private JPanel middlePanel = new JPanel();
    private JPanel bottomPanel = new JPanel();

    BankAccount myAccount = new BankAccount("12345", "John Doe");

    public BankAccountGUI() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 200);
        setLocationRelativeTo(null);

        depositButton.addActionListener(this);
        withdrawButton.addActionListener(this);

        topPanel.add(amountLabel);
        topPanel.add(amountField);

        middlePanel.add(depositButton);
        middlePanel.add(withdrawButton);

        bottomPanel.add(balanceLabel);

        add(topPanel, BorderLayout.NORTH);
        add(middlePanel, BorderLayout.CENTER);
        add(bottomPanel, BorderLayout.SOUTH);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String text = amountField.getText();
        double amount = 0;

        try {
            amount = Double.parseDouble(text);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Please enter a valid number", "Invalid Input", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (e.getSource() == depositButton) {
            myAccount.deposit(amount);
            updateBalanceLabel();
        } else if (e.getSource() == withdrawButton) {
            boolean success = myAccount.withdraw(amount);
            if (success) {
                updateBalanceLabel();
            } else {
                JOptionPane.showMessageDialog(this, "Insufficient funds", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void updateBalanceLabel() {
        balanceLabel.setText(String.format("Current Balance: $%.2f", myAccount.getBalance()));
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new BankAccountGUI());
    }
}
