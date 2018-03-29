package lab;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Ex {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd", Locale.KOREA);
		Date currentDay = new Date();
		String today = formatter.format(currentDay);
		try {
			Date date = new SimpleDateFormat("yyyy-MM-dd").parse(today);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
