package komendant.cashier;

import java.text.DecimalFormat;

public class Cashier {
    DecimalFormat df = new DecimalFormat("#0.00");
    Cash cashierCash;

    public Cashier() {
        cashierCash = new Cash(100, 100, 100, 100,
                100, 100, 100, 100);

    }

    public Cashier(Cash cash) {
        cashierCash = cash;
    }


    public Cash pay(double price, Cash customerCash) throws NotEnoughChangeException {
        double totalCash = customerCash.calculateTotalCashAmount();
        double totalChange = Double.parseDouble(df.format((totalCash - price)));
        if (cashierCash.calculateTotalCashAmount() == 0) {
            throw new NotEnoughChangeException();
        }
        Cash change = new Cash(0, 0, 0, 0, 0,
                0, 0, 0);

        while (totalChange != 0) {
            if (totalChange >= 20.00 && cashierCash.getAmount20Dollar() != 0) {
                cashierCash.decrease20Dollar(1);
                change.increase20Dollar(1);
                totalChange = Double.parseDouble(df.format((totalChange - 20.00)));
            } else if (totalChange >= 10.00 && cashierCash.getAmount10Dollar() != 0) {
                cashierCash.decrease10Dollar(1);
                change.increase10Dollar(1);
                totalChange = Double.parseDouble(df.format((totalChange - 10.00)));
            } else if (totalChange >= 5.00 && cashierCash.getAmount5Dollar() != 0) {
                cashierCash.decrease5Dollar(1);
                change.increase5Dollar(1);
                totalChange = Double.parseDouble(df.format((totalChange - 5.00)));
            } else if (totalChange >= 1.00 && cashierCash.getAmount1Dollar() != 0) {
                cashierCash.decrease1Dollar(1);
                change.increase1Dollar(1);
                totalChange = Double.parseDouble(df.format((totalChange - 1.00)));
            } else if (totalChange >= 0.25 && cashierCash.getAmountQuarter() != 0) {
                cashierCash.decreaseQuarter(1);
                change.increaseQuarter(1);
                totalChange = Double.parseDouble(df.format((totalChange - 0.25)));
            } else if (totalChange >= 0.10 && cashierCash.getAmountDime() != 0) {
                cashierCash.decreaseDime(1);
                change.increaseDime(1);
                totalChange = Double.parseDouble(df.format((totalChange - 0.10)));
            } else if (totalChange >= 0.05 && cashierCash.getAmountNickle() != 0) {
                cashierCash.decreaseNickle(1);
                change.increaseNickle(1);
                totalChange = Double.parseDouble(df.format((totalChange - 0.05)));
            } else if (totalChange >= 0.01 && cashierCash.getAmountPenny() != 0) {
                cashierCash.decreasePenny(1);
                change.increasePenny(1);
                totalChange = Double.parseDouble(df.format((totalChange - 0.01)));
            } else {
                cashierCash.increasePenny(change.getAmountPenny());
                change.decreasePenny(change.getAmountPenny());
                cashierCash.increaseNickle(change.getAmountNickle());
                change.decreaseNickle(change.getAmountNickle());
                cashierCash.increaseDime(change.getAmountDime());
                change.decreaseDime(change.getAmountDime());
                cashierCash.increaseQuarter(change.getAmountQuarter());
                change.decreaseQuarter(change.getAmountQuarter());
                cashierCash.increase1Dollar(change.getAmount1Dollar());
                change.decrease1Dollar(change.getAmount1Dollar());
                cashierCash.increase5Dollar(change.getAmount5Dollar());
                change.decrease5Dollar(change.getAmount5Dollar());
                cashierCash.increase1Dollar(change.getAmount1Dollar());
                change.decrease10Dollar(change.getAmount10Dollar());
                cashierCash.increase20Dollar(change.getAmount20Dollar());
                change.decrease20Dollar(change.getAmount20Dollar());
                throw new NotEnoughChangeException();
            }
        }
        while (totalCash != 0) {
            if (totalCash >= 20.00 && customerCash.getAmount20Dollar() != 0) {
                cashierCash.increase20Dollar(customerCash.getAmount20Dollar());
                totalCash -= (20.00 * customerCash.getAmount20Dollar());
                customerCash.decrease20Dollar(customerCash.getAmount20Dollar());
            } else if (totalCash >= 10.00 && customerCash.getAmount10Dollar() != 0) {
                cashierCash.increase10Dollar(customerCash.getAmount10Dollar());
                totalCash -= (10.00 * customerCash.getAmount10Dollar());
                customerCash.decrease10Dollar(customerCash.getAmount10Dollar());
            } else if (totalCash >= 5.00 && customerCash.getAmount5Dollar() != 0) {
                cashierCash.increase5Dollar(customerCash.getAmount5Dollar());
                totalCash -= (5.00 * customerCash.getAmount5Dollar());
                customerCash.decrease5Dollar(customerCash.getAmount5Dollar());
            } else if (totalCash >= 1.00 && customerCash.getAmount1Dollar() != 0) {
                cashierCash.increase1Dollar(customerCash.getAmount1Dollar());
                totalCash -= (1.00 * customerCash.getAmount1Dollar());
                customerCash.decrease1Dollar(customerCash.getAmount1Dollar());
            } else if (totalCash >= 0.25 && customerCash.getAmountQuarter() != 0) {
                cashierCash.increaseQuarter(customerCash.getAmountQuarter());
                totalCash -= (0.25 * customerCash.getAmountQuarter());
                customerCash.decreaseQuarter(customerCash.getAmountQuarter());
            } else if (totalCash >= 0.10 && customerCash.getAmountDime() != 0) {
                cashierCash.increaseDime(customerCash.getAmountDime());
                totalCash -= (0.10 * customerCash.getAmountDime());
                customerCash.decreaseDime(customerCash.getAmountDime());
            } else if (totalCash >= 0.05 && customerCash.getAmountNickle() != 0) {
                cashierCash.increaseNickle(customerCash.getAmountNickle());
                totalCash -= (0.05 * customerCash.getAmountNickle());
                customerCash.decreaseNickle(customerCash.getAmountNickle());
            } else if (totalCash >= 0.01 && customerCash.getAmountPenny() != 0) {
                cashierCash.increasePenny(customerCash.getAmountPenny());
                totalCash -= (0.01 * customerCash.getAmountPenny());
                customerCash.decreasePenny(customerCash.getAmountPenny());
            }
        }
        return change;
    }

    public class NotEnoughChangeException extends Exception {

    }
}