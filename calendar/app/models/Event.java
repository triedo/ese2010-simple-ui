package models;

import play.*;
import play.db.jpa.*;
import javax.persistence.*;
import java.util.*;

@Entity
public class Event extends Model{
	
	public String startyear, startday,starttime, endyear,endday,endtime,name,visibility;
	public User owner;
	
	public Event(String startyear, String startday, String starttime, String endyear, String endday, String endtime, String name) {
		
		this.startyear = startyear;		//(2011)
		this.startday = startday;		//(10.30) (month.day)
		this.starttime = starttime;		//(10.59)
		this.endyear = endyear;
		this.endday = endday;
		this.endtime = endtime;
		this.name = name;
	}
	
	public Event(String name2) {
		this.name = name2;
	}

	public String toStringYearDay() {
		return startyear + "-" +startday;
		
	}
	
	public boolean isEarlyer(Event other){
		return (this.toStringYearDay().compareTo(other.toStringYearDay())< 0);
		
	}
	
	//returns true if the year and the day matches
	public boolean isOnAGivenDay(String year, String day){
		if ((this.startyear == year) && (this.startday == day))
			return true;
		else	
			return false;
	}
	
	public boolean isOnSameDayOrLater(String year, String day) {
		boolean check = false;
		String date = year + "-" + day;
		if (this.toStringYearDay().compareTo(date) >= 0)
			check = true;
		return check;
	}
	

}
