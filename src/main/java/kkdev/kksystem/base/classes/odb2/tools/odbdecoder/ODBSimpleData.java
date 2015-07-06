/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kkdev.kksystem.base.classes.odb2.tools.odbdecoder;

import java.util.Map;
import kkdev.kksystem.base.classes.odb2.ODB2_SAE_J1979_PID_MODE_1;
import static kkdev.kksystem.base.classes.odb2.ODB2_SAE_J1979_PID_MODE_1.*;

/**
 *
 * @author blinov_is
 */
public class ODBSimpleData {
    Map<Integer,Integer> ODBData;

    public static int[] GetSimpleDiagRequest()
    {
        int[] Ret=new int[2];
        Ret[0]=ODB2_SAE_J1979_PID_MODE_1.PID_05_COLIANT_TEMP;
        Ret[1]=ODB2_SAE_J1979_PID_MODE_1.PID_0D_VEHICLE_SPEED;
        return Ret;
    }
    
    public void SetODBData()
    {
    }
    
    
    public int DIAG_GetCarSpeed()
    {
        if (ODBData==null)
            return 0;
        
        return ODBData.get(PID_0D_VEHICLE_SPEED);
    }
    public int DIAG_GetCarEngineRPM()
    {
        if (ODBData==null)
            return 0;
        
        return ODBData.get(PID_0D_VEHICLE_SPEED);
    }
    public int DIAG_GetCarEngineCooliantTemp()
    {
        if (ODBData==null)
            return 0;
        
        return ODBData.get(PID_0C_ENGINE_RPM);
    }
     public int DIAG_GetCarBattVoltage()
    {
        if (ODBData==null)
            return 0;
        
        return ODBData.get(PID_42_CONTROL_MODULE_VOLTAGE);
    }
}
