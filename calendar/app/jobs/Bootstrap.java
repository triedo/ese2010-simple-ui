package jobs;
import play.jobs.*;
import play.*;
import play.mvc.*;

import java.util.*;
import play.deps.*;
import models.*;
import models.Database;

import java.util.ArrayList;


import org.bouncycastle.jce.provider.symmetric.Grain128.Base;
 
@OnApplicationStart
public class Bootstrap extends Job {
    public User albert;
    
    
    public void doJob() {
    	albert = new User("albert123","abcd");
    	Database.addNewUser("alber123",albert);
    }
    
}

