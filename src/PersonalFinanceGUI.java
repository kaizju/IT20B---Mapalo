import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Transaction {
    private String description;
    private double amounsss;
    private String date; // Simplified as a String for this example

    public Transaction(String description, double amount, String date) {
        this.description = description;
        this.amount = amount;
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public double getAmount() {
        return amount;
    }

    public String getDate() {
        return date;
    }

    @Override
    public String toString() {
        return description + " | " + amount + " | " + date;
    }
}

class PersonalFinanceManager {
    private List<Transaction> transactions;
    private List<Transaction> transactionHistory;

    public PersonalFinanceManager() {
        transactions = new ArrayList<>();
        transactionHistory = new ArrayList<>();
    }

    public void addTransaction(String description, double amount, String date) {
        Transaction transaction = new Transaction(description, amount, date);
        transactions.add(transaction);
        transactionHistory.add(transaction);
    }

    public void removeTransaction(int index) {
        if (index >= 0 && index < transactions.size()) {
            transactions.remove(index);
        }
    }

    public void undoLastTransaction() {
        if (!transactionHistory.isEmpty()) {
            transactions.remove(transactions.size() - 1);
            transactionHistory.remove(transactionHistory.size() - 1);
        }
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void sortTransactionsByDate() {
        Collections.sort(transactions, Comparator.comparing(Transaction::getDate));
    }

    public void sortTransactionsByAmount() {
        Collections.sort(transactions, Comparator.comparingDouble(Transaction::getAmount));
    }
}

public class PersonalFinanceGUI extends JFrame {
    private PersonalFinanceManager pfm;
    private DefaultTableModel tableModel;
    private JTable transactionTable;

    public PersonalFinanceGUI() {
        pfm = new PersonalFinanceManager();
        setTitle("Personal Finance Manager");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Table for displaying transactions
        tableModel = new DefaultTableModel(new String[]{"Description", "Amount", "Date"}, 0);
        transactionTable = new JTable(tableModel);
        add(new JScrollPane(transactionTable), BorderLayout.CENTER);
 
        // Panel for input and buttons
        JPanel inputPanel = new JPanel();
        JTextField descriptionField = new JTextField(10);
        JTextField amountField = new JTextField(10);
        JTextField dateField = new JTextField(10);
        JButton addButton = new JButton("Add Transaction");
        JButton removeButton = new JButton("Remove Transaction");
        JButton undoButton = new JButton("Undo");
        JButton sortDateButton = new JButton("Sort by Date");
        JButton sortAmountButton = new JButton("Sort by Amount");

        inputPanel.add(new JLabel("Description:"));
        inputPanel.add(descriptionField);
        inputPanel.add(new JLabel("Amount:"));
        inputPanel.add(amountField);
        inputPanel.add(new JLabel("Date (YYYY-MM-DD):"));
        inputPanel.add(dateField);
        inputPanel.add(addButton);
        inputPanel.add(removeButton);
        inputPanel.add(undoButton);
        inputPanel.add(sortDateButton);
        inputPanel.add(sortAmountButton);

        add(inputPanel, BorderLayout.SOUTH);

        // Action listeners
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String description = descriptionField.getText();
                double amount = Double.parseDouble(amountField.getText());
                String date = dateField.getText();
                pfm.addTransaction(description, amount, date);
                updateTable();
                clearFields(descriptionField, amountField, dateField);
            }
        });

        removeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = transactionTable.getSelectedRow();
                if (selectedRow >= 0) {
                    pfm.removeTransaction(selectedRow);
                    updateTable();
                } else {
                    JOptionPane.showMessageDialog(null, "Select a transaction to remove.");
                }
            }
        });

        undoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pfm.undoLastTransaction();
                updateTable();
            }
        });

        sortDateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pfm.sortTransactionsByDate();
                updateTable();
            }
        });

        sortAmountButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pfm.sortTransactionsByAmount();
                updateTable();
            }
        });
    }

    private void updateTable() {
        tableModel.setRowCount(0); // Clear existing rows
        for (Transaction transaction : pfm.getTransactions()) {
            tableModel.addRow(new Object[]{transaction.getDescription(), transaction.getAmount(), transaction.getDate()});
        }
    }

    private void clearFields(JTextField descriptionField, JTextField amountField, JTextField dateField) {
        descriptionField.setText("");
        amountField.setText("");
        dateField.setText("");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            PersonalFinanceGUI gui = new PersonalFinanceGUI();
            gui.setVisible(true);
        });
    }
}
