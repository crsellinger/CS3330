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
public interface UserAction {
    void bookPurchase(double bookPrice);
    void coffeePurchase(double foodPrice);
}