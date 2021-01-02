import java.time.LocalTime;
import java.util.Date;

public class Openings {	
	
	public LocalTime[] startTime;
	public LocalTime[] endTime;
	public LocalTime[] startBreak;
	public LocalTime[] stopBreak;
	private String[] dayofweek = {"Sonntag", "Montag", "Dienstag", "Mittwoch", "Donnerstag", "Freitag", "Samstag"};
	
	
	public Openings(LocalTime[] start, LocalTime[] end, LocalTime[] breakStart, LocalTime[] breakStop) 
	{
		super();
		
		this.startTime = start;
		this.endTime = end;
		this.startBreak = breakStart;
		this.stopBreak = breakStop;
	}
	
	/**
	 * checks if an item is currently open or closed, according to the current day and time
	 * 
	 * @param currentTime  time in format HH:mm (LocalTime)
	 * @param weekday     day of the week (int)
	 * @return  boolean
	 */
	public boolean isOpen(LocalTime currentTime, int weekday)
	{
				
		if (this.startTime[weekday] != null && this.endTime[weekday] != null) {
			//check if current time is in some ranges between start and stop-times
			if (currentTime.isAfter(this.startTime[weekday]) && currentTime.isBefore(this.endTime[weekday])) {
				return true;
			} 
			
			if (this.startBreak[weekday] != null && this.stopBreak[weekday] != null) {
				if (
						currentTime.isAfter(this.startTime[weekday]) && currentTime.isBefore(this.startBreak[weekday]) ||
						currentTime.isAfter(this.stopBreak[weekday]) && currentTime.isBefore(this.endTime[weekday])
					) 
				{
					return true;
				} else {
					return false;
				}
			}
			
			
		} else {
			//no start-time and end-time set for a day
			return false;
		}
		return false;		
		
	}
	
	/**
	 * returns the next opening-time (or next day which is open)
	 * 
	 * @param currentTime   time in format HH:mm (LocalTime)
	 * @param weekday     day of the week (int)
	 * @return  String
	 */
	public String getNextOpeningTime(LocalTime currentTime, int weekday)
	{
			
		if (this.isOpen(currentTime, weekday) == false) {
			//first check if break-times are set for a specific day (current time is in a break-time-range)
			if (this.startBreak[weekday] != null && this.stopBreak[weekday] != null) {
				if (currentTime.isAfter(this.startBreak[weekday]) && currentTime.isBefore(this.stopBreak[weekday])) {
					
					return "öffnet wieder um " + this.stopBreak[weekday] + " Uhr";
					
				}
			}
			//check if current time is before start-time of a day
			if (this.startTime[weekday] != null) {
				if (currentTime.isBefore(this.startTime[weekday])) {
					return "öffnet um " + this.startTime[weekday] + " Uhr";
				}
			}
			
		
			
			if (weekday < 6) {
				weekday = weekday + 1;
			} else {
				weekday = 0;
			} 
				
			if (this.startTime[weekday] != null) {
				return "öffnet morgen um " + this.startTime[weekday] + " Uhr";
			} else {
				//check if next day is open
				while (this.startTime[weekday] == null) {
					if (weekday < 6) {
						weekday = weekday + 1;
					} else {
						weekday = 0;
					}
						
				}
			
				return "öffnet am " + this.dayofweek[weekday]  + " um " + this.startTime[weekday] + " Uhr";
			}
			
		} else {
			return null;
		}
		
		
	}
	
	/**
	 * returns next closing time of an item
	 * 
	 * @param currentTime  time in format HH:mm (LocalTime)
	 * @param weekday   day of the week (int)
	 * @return  LocalTime (format HH:mm)
	 */
	public LocalTime getNextClosing(LocalTime currentTime, int weekday)
	{
		LocalTime nextClosing = null;
		//first check if break-times are set for a specific day (current time is in a break-time-range)
		if (this.startBreak[weekday] != null && this.stopBreak[weekday] != null) {
			//current time is smaller than start-break-time
			if (currentTime.isBefore(this.startBreak[weekday])) {
				nextClosing = this.startBreak[weekday];
			} else {
				nextClosing = this.endTime[weekday];
			}
		} else {
			//current time is smaller than end-time
			if (currentTime.isBefore(this.endTime[weekday])) {
				nextClosing = this.endTime[weekday];
			}
		}		
		
		
		return nextClosing;
	}
	
	
	/**
	 * returns closingtime of a specific weekday
	 * 
	 * @param weekday day of the week (int)
	 * @return LocalTime
	 */
	public LocalTime getClosingTime(int weekday)
	{
		return this.endTime[weekday];
	}
	
	/**
	 * returns starttime of a break of a specific weekday
	 * 
	 * @param weekday day of the week (int)
	 * @return LocalTime
	 */
	public LocalTime getStartBreak(int weekday)
	{
		return this.startBreak[weekday];
	}
	
	/**
	 * returns endtime of a break of a specific weekday
	 * 
	 * @param weekday day of the week (int)
	 * @return LocalTime
	 */
	public LocalTime getEndBreak(int weekday)
	{
		return this.stopBreak[weekday];
	}
	
	/**
	 * returns all starttimes
	 * 
	 * @return LocalTime[]
	 */
	public LocalTime[] getStartTimes()
	{
		return this.startTime;
	}
	
	/**
	 * returns all endtimes
	 * 
	 * @return LocalTime[]
	 */
	public LocalTime[] getEndTimes()
	{
		return this.endTime;
	}


	@Override
	public String toString() 
	{
		return "Openings [startTime=" + startTime + ", endTime=" + endTime + ", startBreak="
				+ startBreak + ", stopBreak=" + stopBreak + "]";
	}
	
	/**
	 * returns a complete list with all days of the week with opening-times, 
	 * beginning from current weekday as offset
	 * 
	 * @param weekday   day of the week (int)
	 * @return  String 
	 */
	public String printFormattedOpenings(int weekday) {
				
		String output = "";
		String newline = "\n";
		
		output += "ÖFFNUNGSZEITEN: \n";
		output += "----------------";
		
		if (weekday > 0) {
			//begin printing at any day of week (x, if weekday is not sunday, i.e. 0)
			for (int i=weekday; i <= 6; i++) {							
				
				output += newline + this.dayofweek[i] + ": ";
				if (this.startTime[i] == null) {
					output += " geschlossen";
				} else {
					if (this.startBreak[i] == null && this.stopBreak[i] == null) {
						output += this.startTime[i] + " - " + this.endTime[i];
					} else {
						output += this.startTime[i] + " - " + this.startBreak[i];
						output += "  " + this.stopBreak[i] + " - " + this.endTime[i];
					}
					
				}
			}
			for (int i=0; i < weekday; i++) {							
				
				output += newline + this.dayofweek[i] + ": ";
				if (this.startTime[i] == null) {
					output += " geschlossen";
				} else {
					if (this.startBreak[i] == null && this.stopBreak[i] == null) {
						output += this.startTime[i] + " - " + this.endTime[i];
					} else {
						output += this.startTime[i] + " - " + this.startBreak[i];
						output += "  " + this.stopBreak[i] + " - " + this.endTime[i];
					}
				}
			}
			
		} else {
			//begin printing at beginning of week (0= sunday)
			for (int i=0; i < 6; i++) {						
				
				output += newline + this.dayofweek[i] + ": ";
				if (this.startTime[i] == null) {
					output += " geschlossen";
				} else {
					if (this.startBreak[i] == null && this.stopBreak[i] == null) {
						output += this.startTime[i] + " - " + this.endTime[i];
					} else {
						output += this.startTime[i] + " - " + this.startBreak[i];
						output += "  " + this.stopBreak[i] + " - " + this.endTime[i];
					}
				}
			}
		}		
		
		
		return output;
		
		
	}
	
	

}
