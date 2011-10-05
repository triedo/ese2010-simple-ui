package models;

import play.*;
import play.db.jpa.*;

import javax.persistence.*;

import java.util.*;

import java.util.ArrayList;
import java.util.Iterator;

@Entity
public class Calendar extends Model{
	public ArrayList<Event> privateEvents;
	public User owner;
	
	public Calendar(User owner) {
		privateEvents = new ArrayList<Event>();
		this.owner = owner;
	}
	
	public String addPrivateEvent(Event event) {
				privateEvents.add(event);
				return "done";
	}
	
	public String addPublicEvent(Event event, Database app) {
				app.publicEvents.add(event);
				return "done";
	}
	
	public ArrayList<Event> SeeEventsOn(String year, String day, Database app){
		ArrayList<Event> list = new ArrayList<Event>();
			Iterator<Event> iter1 = privateEvents.iterator();
			Iterator<Event> iter2 = app.publicEvents.iterator();
			while (iter1.hasNext()){
				Event temp = iter1.next();
				if (temp.isOnAGivenDay(year, day))
						list.add(temp);
			}
			while (iter2.hasNext()){
				Event temp2 = iter2.next();
				if (temp2.isOnAGivenDay(year, day))
						list.add(temp2);
			}
		list = insertionSort(list);	
		return list;
	}
	
	public Iterator<Event> iteratorOverEventsStartAt(String year, String day, Database app){
		ArrayList<Event> list = new ArrayList<Event>();
	
			Iterator<Event> iter1 = privateEvents.iterator();
			Iterator<Event> iter2 = app.publicEvents.iterator();
			while (iter1.hasNext()){
				Event temp = iter1.next();
				if (temp.isOnSameDayOrLater(year, day))
						list.add(temp);
			}
			while (iter2.hasNext()){
				Event temp2 = iter2.next();
				if (temp2.isOnSameDayOrLater(year, day))
						list.add(temp2);
			}
		list = insertionSort(list);
		return list.iterator();
	}

	private ArrayList<Event> insertionSort(ArrayList<Event> list) {
		if (list.size() >= 2){
			for(int i=1;i<=list.size()-1;i++){
				Event temp =list.remove(i);
				int j = 0;
				boolean set =false;
				while(j < i && !set){
					if (temp.isEarlyer(list.get(j))) {
						list.add(j, temp);
						set = true;							//break
					}
					j++;
				}
				if (!set) list.add(i, temp);
			}
		}
		return list;
	}
}
