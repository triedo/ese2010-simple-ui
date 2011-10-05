package models;

import play.*;
import play.db.jpa.*;

import javax.persistence.*;

import java.util.*;

@Entity
public class User extends Model{

	public String username;
	public String password;
	public Calendar calendar;
	
	public User(String name, String password){
		username =name;
		this.password = password;
		calendar = new Calendar(this);
	}
	
		
}
