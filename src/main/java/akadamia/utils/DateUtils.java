package akadamia.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class DateUtils {

  public static String dateToString(Date date) {
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
    return sdf.format(date);
  }

  public static Date stringToDate(String stringDate) {
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
    Date date;
    try {
      date =  sdf.parse(stringDate);
    } catch (ParseException e) {
      e.printStackTrace();
      return null;
    }
    return date;
  }

  public static String localDateTimeToString(LocalDateTime date) {
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:MM:ss");
    return sdf.format(date);
  }

  public static String localDateTimeToString2(LocalDateTime date) {
   LocalDateTime current = LocalDateTime.now();
    DateTimeFormatter formatter = DateTimeFormatter.ISO_DATE_TIME;
    return current.format(formatter);
  }
}
