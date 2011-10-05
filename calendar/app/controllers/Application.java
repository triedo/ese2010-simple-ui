package controllers;

import play.*;
import play.mvc.*;

import java.util.*;
import play.deps.*;
import models.*;

@With(Secure.class)
public class Application extends Controller {
	
	   public static void index() {
	        Database.setupDatabase();
		   String username = Security.connected();
		   List users = User.find("order by id desc").fetch();
	        render(username, users);
	    }


	
	public static void event() {
		List events = Event.find("order by id desc").fetch();
		render(events);
	}
	
	public static void createEvent( String name){
		Event event = new Event(name).save();
		renderJSON(event);
	}

}