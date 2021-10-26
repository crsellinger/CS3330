/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pets;

import java.time.LocalDateTime;

/**
 *
 * @author Professor Wergeles
 */

//Cat needs to be abstract or implement all methods in abstract superclass
//Always place extends before implements
public class Cat extends Pet implements LicensedPet{
    public final static String GENUS = "Felis";
    
    private LocalDateTime whenLicensed;
    
    public Cat(String name, int age, Gender gender) {
        super(name, age, "cat", gender);
    }

    //Concrete methods that override abstract methods in superclass
    @Override
    public String[] getCoreVaccines() {
        String[] coreVaccines = {
            "Rabies",
            "Feline Distemper",
            "Feline Herpesvirus",
            "Calicivirus"
        }; 
        
        return coreVaccines; 
    }
    
    //Concrete method
    @Override
    public String[] getNonCoreVaccines() {
        String[] nonCoreVaccines = {
            "Feline Leukemia Virus",
            "Bordetella"  
        }; 
        
        return nonCoreVaccines; 
    }
    
    @Override
    public String toString() {
       String info = super.toString();
       
       if (whenLicensed != null) {
           info +=  ", whenLicensed: " + whenLicensed;
       }
       
       return info;
    }

    @Override
    public Boolean isLicensed() {
        return whenLicensed != null;
    }

    @Override
    public void assignLicense() {
        whenLicensed = LocalDateTime.now();
    }

    @Override
    public LocalDateTime whenLicensed() {
        return whenLicensed;
    }
    
}
