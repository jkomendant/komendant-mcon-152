package komendant.cashier;

public class Cash {
    private int amountPenny;
    private int amountNickle;
    private int amountDime;
    private int amountQuarter;
    private int amount1Dollar;
    private int amount5Dollar;
    private int amount10Dollar;
    private int amount20Dollar;

    public Cash(){

    }

    public Cash(int amountPenny, int amountNickle, int amountDime, int amountQuarter,
                int amount1Dollar, int amount5Dollar, int amount10Dollar, int amount20Dollar) {
        this.amountPenny = amountPenny;
        this.amountNickle = amountNickle;
        this.amountDime = amountDime;
        this.amountQuarter = amountQuarter;
        this.amount1Dollar = amount1Dollar;
        this.amount5Dollar = amount5Dollar;
        this.amount10Dollar = amount10Dollar;
        this.amount20Dollar = amount20Dollar;
    }


    public int getAmountPenny() {
        return amountPenny;
    }

    public int getAmountNickle() {
        return amountNickle;
    }

    public int getAmountDime() {
        return amountDime;
    }

    public int getAmountQuarter() {
        return amountQuarter;
    }

    public int getAmount1Dollar() {
        return amount1Dollar;
    }

    public int getAmount5Dollar() {
        return amount5Dollar;
    }

    public int getAmount10Dollar() {
        return amount10Dollar;
    }

    public int getAmount20Dollar() {
        return amount20Dollar;
    }

    public void increasePenny(int coin) {
        amountPenny += coin;
    }

    public void increaseNickle(int coin) {
        amountNickle += coin;
    }

    public void increaseDime(int coin) {
        amountDime += coin;
    }

    public void increaseQuarter(int coin) {
        amountQuarter += coin;
    }

    public void increase1Dollar(int dollars) {
        amount1Dollar += dollars;
    }

    public void increase5Dollar(int dollars) {
        amount5Dollar += dollars;
    }

    public void increase10Dollar(int dollars) {
        amount10Dollar += dollars;
    }

    public void increase20Dollar(int dollars) {
        amount20Dollar += dollars;
    }

    public void decreasePenny(int coin) {
        amountPenny -= coin;
    }

    public void decreaseNickle(int coin) {
        amountNickle -= coin;
    }

    public void decreaseDime(int coin) {
        amountDime -= coin;
    }

    public void decreaseQuarter(int coin) {
        amountQuarter -= coin;
    }

    public void decrease1Dollar(int dollars) {
        amount1Dollar -= dollars;
    }

    public void decrease5Dollar(int dollars) {
        amount5Dollar -= dollars;
    }

    public void decrease10Dollar(int dollars) {
        amount10Dollar -= dollars;
    }

    public void decrease20Dollar(int dollars) {
        amount20Dollar -= dollars;
    }

    public double calculateTotalCashAmount() {
        final double PENNY = 0.01;
        final double NICKLE = 0.05;
        final double DIME = 0.10;
        final double QUARTER = 0.25;
        final double DOLLAR = 1.00;
        final double FIVE_DOLLAR = 5.00;
        final double TEN_DOLLAR = 10.00;
        final double TWENTY_DOLLAR = 20.00;
        return (amountPenny * PENNY) + (amountNickle * NICKLE) + (amountDime * DIME) + (amountQuarter * QUARTER)
                + (amount1Dollar * DOLLAR) + (amount5Dollar * FIVE_DOLLAR) + (amount10Dollar * TEN_DOLLAR)
                + (amount20Dollar * TWENTY_DOLLAR);
    }
}