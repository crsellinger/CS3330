/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crsb74mvcstopwatchfxmls20;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Caleb Sellinger
 */
public class AboutModel {
    
    private File file;
    private String stringFile = "";
    
    public AboutModel(String filename){
        this.file = new File(filename);
    }
    
    public String loadFile(){
        try {
            FileInputStream in = new FileInputStream(file.getAbsolutePath());
            try {
                int c;
                while ((c = in.read()) != -1){
                    stringFile += (char)c;
                }
            } catch (IOException ex) {
                Logger.getLogger(Page2Controller.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Page2Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
        return stringFile;
    }
}
