package User;

import java.util.ArrayList;

public class UserManager {

    public int generateNewUserId (String role, ArrayList <User> users){
        int baseId = 0;
        if(role.equals("Aircraft Carrier Captain")){
            baseId = 261000;
        }
        else if(role.equals("Air Operation Officer")){
            baseId = 262000;
        }
        else if(role.equals("Pilot")){
            baseId = 263000;
        }
        else if(role.equals("Aircraft Maintenance Engineer")){
            baseId = 264000;
        }
        else if(role.equals("Flight Deck officer")){
            baseId = 265000;
        }
        else if(role.equals("Maintenance Logistics Officer")){
            baseId = 266000;
        }
        else if(role.equals("Carrier navigation officer")){
            baseId = 267000;
        }
        else if(role.equals("Medical Officer")){
            baseId = 268000;
        }
        else{
            return -1;
        }

        int highId = baseId;
        for(User user : users){
            if(user.getRole().equals(role) && user.getUserId() > highId){
                highId = user.getUserId();
            }
        }

        if(highId >= baseId+999){
            return -1;
        }
        return highId + 1;
    }
}
