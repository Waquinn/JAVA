package fundamentals;

public class user {

    //Allows us to make our important data more private and secure 
    //from third party user access

    //Encapsulates our objects attribute
    private int userID;
	private String userName;
	private String firstName, lastName;

    //Constructor for our object, allows us to set values
    user(int userID, String userName, String firstName, String lastName){
        this.userID = userID;
        this.userName = userName;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    //Object method, this allows us to give value/data to our userID
    //but since a username must not be change we will make use of this as example only
    /* 

    void setUserID(int userID){
        this.userID = userID;
    }

    */

    //Gets the given value only to the userID
    int getUserID(){
        return userID;
    }

    //Allows us to set values to our attributes:
    void setuserName(String userName){
        this.userName = userName;
    }

    void setfirstName(String firstName){
        this.firstName = firstName;
    }

     void setlastName(String lastName){
        this.lastName = lastName;
    }

    //Allows us to get the values of out attribute
    String getuserName(){
        return userName;
    }

    String getfirstName(){
        return lastName;
    }
    
    String getlastName(){
        return lastName;
    }
    
}
