package komendant.cashier;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CashierTest {
    @Test
    public void pay() throws Cashier.NotEnoughChangeException {
        //given
        Cashier cashier = new Cashier();
        Cash customerCash = new Cash(0,0,0,0,3,
                0,0,0);
        double price = 2.49;

        //when
        Cash expected = new Cash(1,0,0,2,0,
                0,0,0);
        Cash change = cashier.pay(price, customerCash);

        //then
        assertEquals(expected.getAmountPenny(), change.getAmountPenny());
        assertEquals(expected.getAmountNickle(), change.getAmountNickle());
        assertEquals(expected.getAmountDime(), change.getAmountDime());
        assertEquals(expected.getAmountQuarter(), change.getAmountQuarter());
        assertEquals(expected.getAmount1Dollar(), change.getAmount1Dollar());
        assertEquals(expected.getAmount5Dollar(), change.getAmount5Dollar());
        assertEquals(expected.getAmount10Dollar(), change.getAmount10Dollar());
        assertEquals(expected.getAmount20Dollar(), change.getAmount20Dollar());
    }

    @Test
    public void pay1260() throws Cashier.NotEnoughChangeException {
        //given
        Cashier cashier = new Cashier();
        Cash customerCash = new Cash(0,0,0,0,0,
                1,1,0);
        double price = 12.60;

        //when
        Cash expected = new Cash(0,1,1,1,2,
                0,0,0);
        Cash change = cashier.pay(price, customerCash);

        //then
        assertEquals(expected.getAmountPenny(), change.getAmountPenny());
        assertEquals(expected.getAmountNickle(), change.getAmountNickle());
        assertEquals(expected.getAmountDime(), change.getAmountDime());
        assertEquals(expected.getAmountQuarter(), change.getAmountQuarter());
        assertEquals(expected.getAmount1Dollar(), change.getAmount1Dollar());
        assertEquals(expected.getAmount5Dollar(), change.getAmount5Dollar());
        assertEquals(expected.getAmount10Dollar(), change.getAmount10Dollar());
        assertEquals(expected.getAmount20Dollar(), change.getAmount20Dollar());
    }
    @Test(expected = Cashier.NotEnoughChangeException.class)
    public void payBroke() throws Cashier.NotEnoughChangeException {
        //given
        Cashier cashier = new Cashier(new Cash());

        //when
        cashier.pay(3.00, new Cash());
    }

    @Test(expected = Cashier.NotEnoughChangeException.class)
    public void payNotEnoughChange() throws Cashier.NotEnoughChangeException {
        //given
        Cashier cashier = new Cashier(new Cash(0,0,0,0,
                0,0,1,0));

        //when
        cashier.pay(3.00, new Cash(0,0,0,0,
                0,1,0,0));
    }

    @Test
    public void payNotEnoughChangeRegister() {
        //given
        Cash cash = new Cash();
        cash.increase10Dollar(1);
        Cashier cashier = new Cashier(cash);

        //when
        try {
            cashier.pay(2.49, new Cash(0, 0, 0, 0,
                    3, 0, 0, 0));
        }
        //then
        catch(Exception NotEnoughChangeException)
        {
            assertEquals(0, cash.getAmountPenny());
            assertEquals(0, cash.getAmountNickle());
            assertEquals(0, cash.getAmountDime());
            assertEquals(0, cash.getAmountQuarter());
            assertEquals(0, cash.getAmount1Dollar());
            assertEquals(0, cash.getAmount5Dollar());
            assertEquals(1, cash.getAmount10Dollar());
            assertEquals(0, cash.getAmount20Dollar());
        }
    }


}