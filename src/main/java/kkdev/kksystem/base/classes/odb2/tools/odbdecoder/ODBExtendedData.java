/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kkdev.kksystem.base.classes.odb2.tools.odbdecoder;

import kkdev.kksystem.base.classes.odb2.ODB2_SAE_J1979_PID_MODE_1;

/**
 *
 * @author blinov_is
 */
public class ODBExtendedData {
     public static int[] GetExtendedDiagRequest()
    {
        int[] Ret=new int[4];
        Ret[0]=ODB2_SAE_J1979_PID_MODE_1.PID_05_COLIANT_TEMP;
        Ret[1]=ODB2_SAE_J1979_PID_MODE_1.PID_42_CONTROL_MODULE_VOLTAGE;
        Ret[2]=ODB2_SAE_J1979_PID_MODE_1.PID_0D_VEHICLE_SPEED;
        Ret[3]=ODB2_SAE_J1979_PID_MODE_1.PID_0C_ENGINE_RPM;
        return Ret;
    }
     
      
    public void SetODBData()
    {
    }
    
}
