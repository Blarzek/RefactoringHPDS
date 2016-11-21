package case2;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import org.junit.Test;

public class Alert_ {
    

    @Test
    public void should_allow_basic_alarms() {
        Alert alert = new Alert(2.0, 1, LocalDateTime.of(2013, 2, 10, 8, 15, 30));
        assertEquals(2.0, alert.getAverage(), 0);
        assertEquals(1, alert.getRating());
        assertEquals(LocalDateTime.of(2013, 2, 10, 8, 15, 30), alert.getExpiry());
        assertThat(alert.getMaturity(), is(nullValue));
        assertTrue(alert.isNormalLevel());
        assertFalse(alert.isHighLevel());
        assertFalse(alert.isLowLevel());
    }

    @Test
    public void should_allow_maturity() {
        Alert alert = new Alert(2.0, 1, LocalDateTime.of(2013, 2, 10, 8, 15, 30), LocalDateTime.of(2013, 2, 12, 0, 0, 0));
        assertEquals(2.0, alert.getAverage(), 0);
        assertEquals(1, alert.getRating());
        assertEquals(LocalDateTime.of(2013, 2, 10, 8, 15, 30), alert.getExpiry());
        assertEquals(LocalDateTime.of(2013, 2, 12, 0, 0, 0), alert.getMaturity());
        assertTrue(alert.isNormalLevel());
        assertFalse(alert.isHighLevel());
        assertFalse(alert.isLowLevel());
    }
    
    @Test
    public void should_allow_high_level() {
        Alert alert = new Alert(2.0, 1, LocalDateTime.of(2013, 2, 10, 8, 15, 30), LocalDateTime.of(2013, 2, 12, 0, 0, 0), Alert.HIGH);
        assertEquals(2.0, alert.getAverage(), 0);
        assertEquals(1, alert.getRating());
        assertEquals(LocalDateTime.of(2013, 2, 10, 8, 15, 30), alert.getExpiry());
        assertEquals(LocalDateTime.of(2013, 2, 12, 0, 0, 0), alert.getMaturity());
        assertFalse(alert.isNormalLevel());
        assertTrue(alert.isHighLevel());
        assertFalse(alert.isLowLevel());
    }
	
    @Test
    public void should_allow_normal_level() {
        Alert alert = new Alert(2.0, 1, LocalDateTime.of(2013, 2, 10, 8, 15, 30), LocalDateTime.of(2013, 2, 12, 0, 0, 0), Alert.NORMAL);
        assertEquals(2.0, alert.getAverage(), 0);
        assertEquals(1, alert.getRating());
        assertEquals(LocalDateTime.of(2013, 2, 10, 8, 15, 30), alert.getExpiry());
        assertEquals(LocalDateTime.of(2013, 2, 12, 0, 0, 0), alert.getMaturity());
        assertTrue(alert.isNormalLevel());
        assertFalse(alert.isHighLevel());
        assertFalse(alert.isLowLevel());
    }		
	
    @Test
    public void should_allow_low_level() {
        Alert alert = new Alert(2.0, 1, LocalDateTime.of(2013, 2, 10, 8, 15, 30), LocalDateTime.of(2013, 2, 12, 0, 0, 0), Alert.LOW);
        assertEquals(2.0, alert.getAverage(), 0);
        assertEquals(1, alert.getRating());
        assertEquals(LocalDateTime.of(2013, 2, 10, 8, 15, 30), alert.getExpiry());
        assertEquals(LocalDateTime.of(2013, 2, 12, 0, 0, 0), alert.getMaturity());
        assertFalse(alert.isNormalLevel());
        assertFalse(alert.isHighLevel());
        assertTrue(alert.isLowLevel());
    }	
    
    private Date LocalDateTime.of(int year, int month, int day, int hour, int minute, int second) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month, day, hour, minute, second);
		calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTime();
    }

	private void assertEquals(Date expected, Date result) {
		assertEquals(expected.getTime(), result.getTime());
	}
}
