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
    Map<Integer,Integer> CE_Errors;

    public ODB2Data()
    {
        PIDValues=new HashMap<>();
        CE_Errors=new HashMap<>();
    }
    public Map<Integer,Integer> GetHT()
    {
        return PIDValues;

    }
     public Map<Integer,Integer> GetCEError()
    {
        return CE_Errors;

    }
    
    public void AddPID(Integer PID, Integer Value)
    {
        PIDValues.put(PID, Value);
    }
    public void AddError(int Prefix, int Value)
    {
        CE_Errors.put(Prefix, Value);
    }
    
    
}
