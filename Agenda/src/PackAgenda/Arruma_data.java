package PackAgenda;


import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

	public class Arruma_data {

	    public static String arrumaDate(Calendar cal) {
	        if (cal == null) {
	            return null;
	        } else {

	            SimpleDateFormat dateformt = new SimpleDateFormat("yyyy-MM-dd HH:mm");
	            String tempo = dateformt.format(cal.getTime());

	            return tempo;

	        }

	    }

	    public static Calendar arrumaDateStrToCal(String dat) {
	        if (dat == "") {
	            return Calendar.getInstance();

	        } else {
	            Calendar cal = Calendar.getInstance();
	            try {
	                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	                cal.setTime(sdf.parse(dat));
	            } catch (Exception e) {
	            }
	            return cal;
	        }
	    }

	    public static Calendar arrumaDateToCal(Date date) {
	        Calendar cal = Calendar.getInstance();
	        cal.setTime(date);
	        return cal;
	    }
	    
	    public static Date arrumaCalendar(Calendar cal) {
	    	return cal.getTime();
		
	    }

}
