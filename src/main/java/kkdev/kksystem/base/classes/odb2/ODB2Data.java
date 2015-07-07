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
    Map<Integer,Integer> PIDValues;
    //int[] PID;
    //int[] PIDValues;
    public ODB2Data()
    {
        PIDValues=new HashMap<>();
    }
    public Map<Integer,Integer> GetHT()
    {
        return PIDValues;

    }
    
    public void AddPID(Integer PID, Integer Value)
    {
        PIDValues.put(PID, Value);
    }
    
    
}
