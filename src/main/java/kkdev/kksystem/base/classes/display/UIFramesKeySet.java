/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kkdev.kksystem.base.classes.display;

/**
 *
 * @author blinov_is
 */
public class UIFramesKeySet {
    public String[] Keys;
    public String[] Values;
    
    public void AddKeySet(String Key, String Value)
    {
        String[] NewKeys=new String[Keys.length+1];
        String[] NewValues=new String[Keys.length+1];
        
        for (int i=0;i<Keys.length;i++)
        {
            NewKeys[i]=Keys[i];
            NewValues[i]=Values[i];
        }
        NewKeys[Keys.length]=Key;
        NewKeys[Values.length]=Key;
        
        Keys=NewKeys;
        Values=NewValues;
    
    
    }
}
