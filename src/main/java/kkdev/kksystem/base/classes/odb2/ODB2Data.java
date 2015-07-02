/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kkdev.kksystem.base.classes.odb2;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author blinov_is
 */
public class ODB2Data {
    int[] PID;
    int[] PIDValues;
    
    public Map<Integer,Integer> GetHT()
    {
        Map<Integer,Integer> Ret=new HashMap<>();
        
        for (int i=0;i<PID.length;i++)
        {
            Ret.put(PID[i], PIDValues[i]);
        }
        
        return Ret;
    }
    
    
}
