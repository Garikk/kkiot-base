/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kkdev.kksystem.base.classes.odb2;

/**
 *
 * @author blinov_is
 */
public final class ODBConstants {
       public static enum KK_ODB_DATAPACKET
    {
        ODB_PIDINFO,
        ODB_RAWINFO,
        ODB_OTHERCMD
    }
    public static enum KK_ODB_DATATYPE
    {
        ODB_PID_COOLIANT_TEMP,
        ODB_PID_ENGINE_RPM,
        ODB_PID_VEHICLE_SPEED,
        ODB_PID_VOLTAGE,
        ODB_PID_MIL_STATE,
        ODB_PID_DTC_CODE
    }
    
    public static enum KK_ODB_COMMANDTYPE
    {
        ODB_KKSYS_CONNECT,
        ODB_KKSYS_GETINFO,
        ODB_KKSYS_DISCONNECT,
        ODB_KKSYS_EXEC_COMMAND,
        ODB_RAW_EXEC_ODB_COMMAND
        
    }
}

