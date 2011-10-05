package models;

import play.*;
import java.util.HashMap;
import play.db.jpa.*;

import javax.persistence.*;

import java.util.*;

import java.util.ArrayList;

@Entity
public class Database extends Model{
	
	public static HashMap<String,User> database = new HashMap<String,User>();
	public ArrayList<Event> publicEvents;
	
	public static void addNewUser(String username, User user) {
		database.put(username, user);
	}

	public static User get(String key){
		return database.get(key);
	}
	public static boolean contains(String key){
		return database.containsKey(key);
	}
	
	public static void setupDatabase(){
		User albert = new User("albert123","abcd");
    	Database.addNewUser("alber123",albert);
	}
}
