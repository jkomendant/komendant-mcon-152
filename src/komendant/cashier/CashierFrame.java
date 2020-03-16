package komendant.cashier;

import javax.swing.*;
import java.awt.*;

public class CashierFrame extends JFrame {
        private Cash payment = new Cash();
        private Cash registerCash = new Cash();

        private JPanel cashierPanel;
        private JLabel totalPayment;
        private JButton pennies;
        private JButton nickels;
        private JButton dimes;
        private JButton quarters;
        private JButton oneDollars;
        private JButton fiveDollars;
        private JButton tenDollars;
        private JButton twentyDollars;
        private JLabel priceLabel;
        private JTextField price;
        private JButton clear;
        private JButton pay;
        private JLabel registerLabel;
        private JLabel register;
        private JLabel changeLabel;
        private JLabel change;
        private JLabel error;
        private JPanel payPanel;
        private JPanel pricePanel;
        private JPanel registerPanel;
        private JPanel changePanel;

    public CashierFrame(){
        setSize(600, 300);
        setTitle("Cashier");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        cashierPanel = new JPanel();
        cashierPanel.setLayout(new BoxLayout(cashierPanel, BoxLayout.PAGE_AXIS));
        payPanel =  new JPanel();
        payPanel.setLayout(new FlowLayout());
        totalPayment = new JLabel("0.00");
        pennies = new JButton("P");
        nickels = new JButton("N");
        dimes = new JButton("D");
        quarters = new JButton("Q");
        oneDollars = new JButton("$1");
        fiveDollars = new JButton("$5");
        tenDollars = new JButton("$10");
        twentyDollars = new JButton("$20");
        payPanel.add(totalPayment);
        payPanel.add(pennies);
        payPanel.add(nickels);
        payPanel.add(dimes);
        payPanel.add(quarters);
        payPanel.add(oneDollars);
        payPanel.add(fiveDollars);
        payPanel.add(tenDollars);
        payPanel.add(twentyDollars);

        pricePanel = new JPanel();
        pricePanel.setLayout(new FlowLayout());
        priceLabel = new JLabel("Price: ");
        price = new JTextField();
        price.setColumns(10);
        clear = new JButton("Clear");
        pay = new JButton("Pay");
        pricePanel.add(priceLabel);
        pricePanel.add(price);
        pricePanel.add(clear);
        pricePanel.add(pay);

        registerPanel = new JPanel();
        registerPanel.setLayout(new FlowLayout());
        registerLabel = new JLabel("Register: ");
        fillRegister();
        register = new JLabel(registerCash.getTotalMoneyPieces());
        registerPanel.add(registerLabel);
        registerPanel.add(register);

        changePanel = new JPanel();
        changePanel.setLayout(new FlowLayout());
        changeLabel = new JLabel("Change: ");
        change = new JLabel();
        changePanel.add(changeLabel);
        changePanel.add(change);

        error = new JLabel();

        cashierPanel.add(payPanel);
        cashierPanel.add(pricePanel);
        cashierPanel.add(registerPanel);
        cashierPanel.add(changePanel);
        cashierPanel.add(error);

        add(cashierPanel);

        pennies.addActionListener(actionEvent -> addPennies());
        nickels.addActionListener(actionEvent -> addNickels());
        dimes.addActionListener(actionEvent -> addDimes());
        quarters.addActionListener(actionEvent -> addQuarters());
        oneDollars.addActionListener(actionEvent -> addOnes());
        fiveDollars.addActionListener(actionEvent -> addFives());
        tenDollars.addActionListener(actionEvent -> addTens());
        twentyDollars.addActionListener(actionEvent -> addTwenties());
        clear.addActionListener(actionEvent -> clearFrame());
        pay.addActionListener(actionEvent -> payCashier());

    }

    private void payCashier() {
        Cashier cashier = new Cashier(registerCash);
        double parsedPrice = Double.parseDouble(price.getText());
        try {
            Cash changeAmount = cashier.pay(parsedPrice, payment);
            change.setText(changeAmount.getTotalMoneyPieces());
            register.setText(registerCash.getTotalMoneyPieces());
            error.setText("");


        } catch (Cashier.NotEnoughChangeException e) {
            error.setText("Not Enough Change");
        } catch (Cashier.NotEnoughPaymentException e) {
            error.setText("Not Enough Payment");
        }
    }

    private void fillRegister() {
        registerCash.increasePenny(100);
        registerCash.increaseNickle(23);
        registerCash.increaseQuarter(30);
        registerCash.increase1Dollar(26);
        registerCash.increase10Dollar(10);
    }


    private void clearFrame() {
        payment.reset();
        totalPayment.setText(String.format("%.2f", payment.calculateTotalCashAmount()));
        price.setText("");
        change.setText("");
        error.setText("");
    }

    private void addTwenties() {
        payment.increase20Dollar(1);
        totalPayment.setText(String.format("%.2f", payment.calculateTotalCashAmount()));
    }

    private void addTens() {
        payment.increase10Dollar(1);
        totalPayment.setText(String.format("%.2f", payment.calculateTotalCashAmount()));
    }

    private void addFives() {
        payment.increase5Dollar(1);
        totalPayment.setText(String.format("%.2f", payment.calculateTotalCashAmount()));
    }

    private void addOnes() {
        payment.increase1Dollar(1);
        totalPayment.setText(String.format("%.2f", payment.calculateTotalCashAmount()));
    }

    private void addQuarters() {
        payment.increaseQuarter(1);
        totalPayment.setText(String.format("%.2f", payment.calculateTotalCashAmount()));
    }

    private void addDimes() {
        payment.increaseDime(1);
        totalPayment.setText(String.format("%.2f", payment.calculateTotalCashAmount()));
    }

    private void addNickels() {
        payment.increaseNickle(1);
        totalPayment.setText(String.format("%.2f", payment.calculateTotalCashAmount()));
    }

    private void addPennies() {
        payment.increasePenny(1);
        totalPayment.setText(String.format("%.2f", payment.calculateTotalCashAmount()));
    }

    public static void main(String[] args) {
        new CashierFrame().setVisible(true);
    }

}
