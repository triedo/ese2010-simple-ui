package controllers;

import models.Database;
import models.User;
import jobs.Bootstrap;
 
public class Security extends Secure.Security {
    
	//my method doesn't work and i don't know why
    static boolean authenticate(String username, String password) {
       Database.setupDatabase();
    	if (Database.contains(username)){
    	User user = Database.get(username);				
       return (user.password == password);
       }
       else return false;

    }
    
}

