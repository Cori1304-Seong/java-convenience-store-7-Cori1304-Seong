package store.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.Date;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PromotionTest {
    Date START_DATE = new Date(2024, 11, 1);
    Date END_DATE = new Date(2024, 12, 1);

    private Promotion promotion;

    @BeforeEach
    public void setUp() {
        promotion = new Promotion("반짝할인", 3, 1, START_DATE, END_DATE);
    }

    @Test
    public void testGetName() {
        assertEquals("반짝할인", promotion.getName());
    }

    @Test
    public void testSetName() {
        promotion.setName("setName");
        assertEquals("setName", promotion.getName());
    }

    @Test
    public void testGetBuy() {
        assertEquals(3, promotion.getBuyCount());
    }

    @Test
    public void testSetBuy() {
        promotion.setBuyCount(6);
        assertEquals(6, promotion.getBuyCount());
    }

    @Test
    public void testGetGetCount() {
        assertEquals(1, promotion.getGetCount());
    }

    @Test
    public void testSetGetCount() {
        promotion.setGetCount(5);
        assertEquals(5, promotion.getGetCount());
    }

    @Test
    public void testGetStartDate() {
        assertEquals(START_DATE, promotion.getStartDate());
    }

    @Test
    public void testSetStartDate() {
        Date date = new Date(2024, 10, 10);
        promotion.setStartDate(date);
        assertEquals(date, promotion.getStartDate());
    }

    @Test
    public void testGetEndDate() {
        assertEquals(END_DATE, promotion.getEndDate());
    }

    @Test
    public void testSetEndDate() {
        Date date = new Date(2024, 12, 10);
        promotion.setStartDate(date);
        assertEquals(date, promotion.getStartDate());
    }

    @Test
    public void testToString() {
        String expected = "Name: " + promotion.getName() + ", Buy: " + promotion.getBuyCount() + ", Get: "
                + promotion.getGetCount() + ", Start_date: " + promotion.format(START_DATE) + ", End_date: "
                +  promotion.format(END_DATE);
        assertEquals(expected, promotion.toString());
    }
}