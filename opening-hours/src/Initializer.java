import java.time.LocalTime;
import java.util.HashMap;

public class Initializer {

	
	/**
	 * creates a HashMap with all relevant data about opening-times for each object. 
	 * An object is represented by a name (String) as key and an Opening obejct as value.
	 * The Opening object consists of LocalTime[] arrays saving the opening-time, closing-time,
	 * break-time beginning and end (for representing a temporal daily closing time).
	 * Each array-entry stands for a weekday (beginning with 0 for Sunday, ending up with 6
	 * for Saturday). This method creates a number of objects with information about all
	 * closing and opening-times for each object. This data structure is expendable.
	 * 
	 * @return  HashMap<String,Openings>
	 */
	public static HashMap<String,Openings> initializeData()
	{
		//data for bank
		LocalTime[] opentimes_bank = new LocalTime[] {
				null,
				LocalTime.parse("08:30"),
				LocalTime.parse("08:30"),
				LocalTime.parse("08:30"),
				LocalTime.parse("08:30"),
				LocalTime.parse("08:30"),
				null,
		};
		LocalTime[] closingtimes_bank = new LocalTime[] {
				null,
				LocalTime.parse("17:30"),
				LocalTime.parse("17:30"),
				LocalTime.parse("17:30"),
				LocalTime.parse("17:30"),
				LocalTime.parse("17:30"),
				null,
		};
		LocalTime[] breakFrom_bank = new LocalTime[] {
				null,
				LocalTime.parse("13:00"),
				LocalTime.parse("13:00"),
				LocalTime.parse("13:00"),
				LocalTime.parse("13:00"),
				LocalTime.parse("13:00"),
				null,
		};
		LocalTime[] breakTo_bank = new LocalTime[] {
				null,
				LocalTime.parse("14:00"),
				LocalTime.parse("14:00"),
				LocalTime.parse("14:00"),
				LocalTime.parse("14:00"),
				LocalTime.parse("14:00"),
				null,
		};
		
		//data for playground
		LocalTime[] opentimes_playground = new LocalTime[] { 
				LocalTime.parse("08:00"),
				LocalTime.parse("08:00"),
				LocalTime.parse("08:00"),
				LocalTime.parse("08:00"),
				LocalTime.parse("08:00"),
				LocalTime.parse("08:00"),
				LocalTime.parse("08:00"),
		};
		LocalTime[] closingtimes_playground = new LocalTime[] {
				LocalTime.parse("18:00"),
				LocalTime.parse("18:00"),
				LocalTime.parse("18:00"),
				LocalTime.parse("18:00"),
				LocalTime.parse("18:00"),
				LocalTime.parse("18:00"),
				LocalTime.parse("18:00"),
		};
		LocalTime[] breakFrom_playground = new LocalTime[] {null, null, null, null, null, null, null};
		LocalTime[] breakTo_playground = new LocalTime[] {null, null, null, null, null, null, null};
		
		//data for bar
		LocalTime[] opentimes_bar = new LocalTime[] { 
				null,
				LocalTime.parse("08:00"),
				LocalTime.parse("08:00"),
				LocalTime.parse("08:00"),
				LocalTime.parse("08:00"),
				LocalTime.parse("08:00"),
				LocalTime.parse("18:00"),
		};
		LocalTime[] closingtimes_bar = new LocalTime[] {
				null,
				LocalTime.parse("01:00"),
				LocalTime.parse("01:00"),
				LocalTime.parse("01:00"),
				LocalTime.parse("01:00"),
				LocalTime.parse("01:00"),
				LocalTime.parse("03:00"),
		};
		LocalTime[] breakFrom_bar = new LocalTime[] {null, LocalTime.parse("12:00"), LocalTime.parse("12:00"), LocalTime.parse("12:00"), LocalTime.parse("12:00"), LocalTime.parse("12:00"), null};
		LocalTime[] breakTo_bar = new LocalTime[] {null, LocalTime.parse("18:00"), LocalTime.parse("18:00"), LocalTime.parse("18:00"), LocalTime.parse("18:00"), LocalTime.parse("18:00"), null};
		
		//data for barber
		LocalTime[] opentimes_barber = new LocalTime[] { 
				LocalTime.parse("08:30"),
				null,
				LocalTime.parse("07:30"),
				LocalTime.parse("07:30"),
				LocalTime.parse("07:30"),
				LocalTime.parse("07:30"),
				LocalTime.parse("08:30"),
		};
		LocalTime[] closingtimes_barber = new LocalTime[] {
				LocalTime.parse("14:30"),
				null,
				LocalTime.parse("18:30"),
				LocalTime.parse("18:30"),
				LocalTime.parse("18:30"),
				LocalTime.parse("18:30"),
				LocalTime.parse("14:30"),
		};
		LocalTime[] breakFrom_barber = new LocalTime[] {null, null, null, null, null, null, null};
		LocalTime[] breakTo_barber = new LocalTime[] {null, null, null, null, null, null, null};
		
		//data for disco
		LocalTime[] opentimes_disco = new LocalTime[] { 
				null,
				LocalTime.parse("20:00"),
				LocalTime.parse("20:00"),
				LocalTime.parse("20:00"),
				LocalTime.parse("20:00"),
				LocalTime.parse("20:00"),
				LocalTime.parse("20:00"),
		};
		LocalTime[] closingtimes_disco = new LocalTime[] {
				null,
				LocalTime.parse("01:00"),
				LocalTime.parse("01:00"),
				LocalTime.parse("01:00"),
				LocalTime.parse("01:00"),
				LocalTime.parse("03:00"),
				LocalTime.parse("03:00"),
		};
		LocalTime[] breakFrom_disco = new LocalTime[] {null, null, null, null, null, null, null};
		LocalTime[] breakTo_disco = new LocalTime[] {null, null, null, null, null, null, null};
		
		//data for cafe
		LocalTime[] opentimes_cafe = new LocalTime[] { 
				LocalTime.parse("09:00"),
				null,
				LocalTime.parse("09:00"),
				LocalTime.parse("09:00"),
				LocalTime.parse("09:00"),
				LocalTime.parse("09:00"),
				LocalTime.parse("09:00"),
		};
		LocalTime[] closingtimes_cafe = new LocalTime[] {
				LocalTime.parse("18:00"),
				null,
				LocalTime.parse("18:00"),
				LocalTime.parse("18:00"),
				LocalTime.parse("18:00"),
				LocalTime.parse("18:00"),
				LocalTime.parse("18:00"),
		};
		LocalTime[] breakFrom_cafe = new LocalTime[] {
				LocalTime.parse("11:30"),
				null,
				LocalTime.parse("11:30"),
				LocalTime.parse("11:30"),
				LocalTime.parse("11:30"),
				LocalTime.parse("11:30"),
				LocalTime.parse("11:30"),
		};
		LocalTime[] breakTo_cafe = new LocalTime[] {
				LocalTime.parse("12:30"),
				null,
				LocalTime.parse("12:30"),
				LocalTime.parse("12:30"),
				LocalTime.parse("12:30"),
				LocalTime.parse("12:30"),
				LocalTime.parse("12:30"),
		};
		
		
		//data for supermarket
		LocalTime[] opentimes_supermarket = new LocalTime[] { 
				null,
				LocalTime.parse("07:00"),
				LocalTime.parse("07:00"),
				LocalTime.parse("07:00"),
				LocalTime.parse("07:00"),
				LocalTime.parse("07:00"),
				LocalTime.parse("08:00"),
		};
		LocalTime[] closingtimes_supermarket = new LocalTime[] {
				null,
				LocalTime.parse("22:00"),
				LocalTime.parse("22:00"),
				LocalTime.parse("22:00"),
				LocalTime.parse("22:00"),
				LocalTime.parse("22:00"),
				LocalTime.parse("18:30"),
		};
		LocalTime[] breakFrom_supermarket = new LocalTime[] {null, null, null, null, null, null, null};
		LocalTime[] breakTo_supermarket = new LocalTime[] {null, null, null, null, null, null, null};
		
		//data for shop
		LocalTime[] opentimes_shop = new LocalTime[] { 
				null,
				LocalTime.parse("09:00"),
				LocalTime.parse("09:00"),
				null,
				null,
				LocalTime.parse("08:00"),
				LocalTime.parse("08:00"),
		};
		LocalTime[] closingtimes_shop = new LocalTime[] {
				null,
				LocalTime.parse("18:00"),
				LocalTime.parse("19:00"),
				null,
				null,
				LocalTime.parse("19:00"),
				LocalTime.parse("15:00"),
		};
		LocalTime[] breakFrom_shop = new LocalTime[] {null, null, null, null, null, null, null};
		LocalTime[] breakTo_shop = new LocalTime[] {null, null, null, null, null, null, null};
		
		HashMap<String, Openings> datas = new HashMap<String, Openings>();
		
		// create objects with sample-data
		Openings sparkasse = new Openings(opentimes_bank, closingtimes_bank, breakFrom_bank, breakTo_bank);		
		Openings spielplatz = new Openings(opentimes_playground, closingtimes_playground, breakFrom_playground, breakTo_playground);
		Openings bar = new Openings(opentimes_bar, closingtimes_bar, breakFrom_bar, breakTo_bar);
		Openings barber = new Openings(opentimes_barber, closingtimes_barber, breakFrom_barber, breakTo_barber);
		Openings disco = new Openings(opentimes_disco, closingtimes_disco, breakFrom_disco, breakTo_disco);
		Openings cafe = new Openings(opentimes_cafe, closingtimes_cafe, breakFrom_cafe, breakTo_cafe);
		Openings supermarket = new Openings(opentimes_supermarket, closingtimes_supermarket, breakFrom_supermarket, breakTo_supermarket);
		Openings shop = new Openings(opentimes_shop, closingtimes_shop, breakFrom_shop, breakTo_shop);
		
		// put it all together
		datas.put("Sparkasse", sparkasse);
		datas.put("Spielplatz", spielplatz);
		datas.put("Bar", bar);
		datas.put("Friseur", barber);
		datas.put("Disco", disco);
		datas.put("Cafe", cafe);
		datas.put("Supermarkt", supermarket);
		datas.put("Shop", shop);
		
		
		return datas;
	
	
	}
	
	
	
}
