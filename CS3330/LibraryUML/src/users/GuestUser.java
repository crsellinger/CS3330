/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package users;

/**
 *
 * @author Junlin Wang, TA at cs3330@missouri.edu
 */
public class GuestUser extends User {
    
    private static int numOfGuestUsers = 0; 
    
    public GuestUser(UserType userType){
        super(genUserId(), userType); 
        numOfGuestUsers++; 
    }
    
    protected GuestUser(String userId, UserType userType){
        super(userId, userType);
        numOfGuestUsers++;
    }
    
    public static final int getNumOfGuestUsers(){
        return GuestUser.numOfGuestUsers; 
    }

    @Override
    public void bookPurchase(double bookPrice) {
        System.out.println("Book Price: " + bookPrice);
    }

    @Override
    public void coffeePurchase(double coffeePrice) {
        System.out.println("Food Price " + coffeePrice);
    }

    @Override
    public String getUserInfo() {
        return String.format("User ID: %s, User Type: " + userType, userId);
    }

    @Override
    public String getUsername() {
        return username; 
    }

    @Override
    public Boolean setUsername(String username) {
        this.username = username; 
        return !this.username.isEmpty(); 
    }
    
    MemberUser register(String username, String password){
        MemberUser member = new MemberUser(userId, userType.MEMBER, username, password);
        return member;
    }
}