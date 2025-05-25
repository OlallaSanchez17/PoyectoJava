
package model.entity;


public class user {

    public user(String user, String psswd) {
        this.user = user;
        this.psswd = psswd;
        
    }

    public String getUser() {
        return user;
    }

    public String getPsswd() {
        return psswd;
    }
    
   
    private final String user;
    private final String psswd;
    
}


