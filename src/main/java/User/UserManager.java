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
        else if(role.equals("user 3")){
            baseId = 263000;
        }
        else if(role.equals("user 4")){
            baseId = 264000;
        }
        else if(role.equals("user 5")){
            baseId = 265000;
        }
        else if(role.equals("user 6")){
            baseId = 266000;
        }
        else if(role.equals("user 7")){
            baseId = 267000;
        }
        else if(role.equals("user 8")){
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
