/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pets;

import java.time.LocalDateTime;

/**
 *
 * @author Caleb
 */

//all methods must be abstract, static, default, or final
//By default, methods are public and abstract unless explicitly stated
public interface LicensedPet {
    public abstract Boolean isLicensed();
    
    public abstract void assignLicense();
    
    public abstract LocalDateTime whenLicensed();
}