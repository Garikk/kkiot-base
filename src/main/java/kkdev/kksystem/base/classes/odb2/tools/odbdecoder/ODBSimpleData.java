/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kkdev.kksystem.base.classes.odb2.tools.odbdecoder;

import java.util.Map;
import kkdev.kksystem.base.classes.odb2.ODB2Data;
import kkdev.kksystem.base.classes.odb2.ODB2_SAE_J1979_PID_MODE_1;
import static kkdev.kksystem.base.classes.odb2.ODB2_SAE_J1979_PID_MODE_1.*;

/**
 *
 * @author blinov_is
 */
public class ODBSimpleData {
    Map<Integer,Integer> ODBData;

    public int[] GetSimpleDiagRequest()
    {
        int[] Ret=new int[2];
        Ret[0]=ODB2_SAE_J1979_PID_MODE_1.PID_05_COLIANT_TEMP;
        Ret[2]=ODB2_SAE_J1979_PID_MODE_1.PID_0D_VEHICLE_SPEED;
        return Ret;
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
/*
   public static final int PID_01_DTC_STATUS=0x01;
   public static final int PID_02_FREEZE_DTC=0x02;
   public static final int PID_03_FUEL_SYSTEM_STATE=0x03;
   public static final int PID_04_ENGINE_LOAD=0x04;
   public static final int PID_05_COLIANT_TEMP=0x05;
    //
    //06-09 currently not supported
    //
   public static final int PID_0A_FUEL_PRESSURE=0x0A;
   public static final int PID_0B_INTAKE_MANIFOLD_ABS_PRESSURE=0x0B;
   public static final int PID_0C_ENGINE_RPM=0x0C;
   public static final int PID_0D_VEHICLE_SPEED=0x0D;
   public static final int PID_0E_TIMING_ADVANCE=0x0E;
   public static final int PID_0F_INTAKE_AIR_TEMP=0x0F;
   public static final int PID_10_MAF_AIR_FLOW_RATE=0x10;
   public static final int PID_11_THROTTLE_POSITION=0x11;
*/