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
public class VipUser extends MemberUser implements VipUserAction {
    
    private Integer vipLevel;
    public double vipDiscount = 0.8; 
    protected static final String CATEGORY = "VIP";
    
    public VipUser(String username, String password, int vipLevel) {
        super(genUserId(), UserType.VIP, username, password); 
        vipDiscount = vipDiscount - 0.3 * vipLevel;
        this.vipLevel = vipLevel;
    }
    
    protected VipUser(String userId, UserType userType, String username, String password, int vipLevel) {
        super(userId, userType, username, password);
        vipDiscount = vipDiscount - 0.3 * vipLevel;
        this.vipLevel = vipLevel;
    }

    public Integer getVipLevel() {
        return vipLevel;
    }

    public void setVipLevel(int vipLevel) {
        this.vipLevel = vipLevel;
    }
    
    @Override
    public void bookPurchase(double bookPrice) {
        System.out.println("Book Price: " + bookPrice * vipDiscount);
    }

    @Override
    public void coffeePurchase(double foodPrice) {
        System.out.println("Food Price " + foodPrice * vipDiscount);
    }
    
    @Override
    public String getUserInfo(){
        return String.format("User ID: %s, Username: %s, Password: %s , Vip Level: %d, User Type: " + userType, userId, username, password,vipLevel);
    }  

    @Override
    public void rentConferenceRoom(String confRoomId) {
        System.out.println("User " + userId + " has rent room:" + confRoomId);
    }
    
    public void upperLevel(){
        vipLevel++;
        vipDiscount = vipDiscount - 0.3*vipLevel;
    }
}