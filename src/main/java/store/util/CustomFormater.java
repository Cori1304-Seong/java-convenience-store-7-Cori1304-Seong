package store.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CustomFormater {
    static final String PROMOTION_FORMAT = "yyyy-MM-dd";

    static public Date convertToDate(String source) {
        SimpleDateFormat formatter = new SimpleDateFormat(PROMOTION_FORMAT);
        Date result = new Date();
        try {
            result = formatter.parse(source);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return result;
    }
}
