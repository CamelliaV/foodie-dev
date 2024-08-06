import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtilsTest {
    @Test
    public void testStringToDate() throws ParseException {
        Date date = new SimpleDateFormat("yyyy-MM-dd").parse("1900-01-01");
        System.out.println(date);

    }
}
