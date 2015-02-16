package demo.jsp.lib;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class CalculateAge {

  public static int getAge(String dob){
    Date now = new Date();
    DateFormat format = new SimpleDateFormat("MM/dd/YYYY", Locale.ENGLISH);
    Date date = null;
    try {
      date = format.parse(dob);
    } catch (ParseException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    return now.getYear() - date.getYear();
  }

}
