package komendant.cashier;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CashierTest {
    @Test
    public void pay()
    {
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
    public void pay2()
    {
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

}