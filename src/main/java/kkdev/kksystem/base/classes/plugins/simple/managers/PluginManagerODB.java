/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kkdev.kksystem.base.classes.plugins.simple.managers;

import kkdev.kksystem.base.classes.odb2.ODB2Data;
import kkdev.kksystem.base.classes.odb2.ODBConstants;
import kkdev.kksystem.base.classes.odb2.PinOdb2ConnectorInfo;
import kkdev.kksystem.base.classes.odb2.PinDataOdb2;
import static kkdev.kksystem.base.constants.PluginConsts.KK_PLUGIN_BASE_ODB2_COMMAND;
import static kkdev.kksystem.base.constants.PluginConsts.KK_PLUGIN_BASE_ODB2_DATA;

/**
 *
 * @author blinov_is
 */
public class PluginManagerODB extends PluginManagerBase {
    
    public void ODB_SendPluginMessageCommand(String FeatureID,ODBConstants.KK_ODB_COMMANDTYPE Command, ODBConstants.KK_ODB_DATACOMMANDINFO Request, int[] DataInt, int[] ReadInterval) {

        //
        this.BASE_SendPluginMessage(FeatureID,null,KK_PLUGIN_BASE_ODB2_COMMAND, ODB_SendPluginMessageCommand_PMData(Command,Request,DataInt,ReadInterval));
    }
    public void ODB_SendConnectionState(String FeatureID,PinOdb2ConnectorInfo ConnInfo) {
        //
        PinDataOdb2 PData = new PinDataOdb2();
        PData.Odb2DataType=ODBConstants.KK_ODB_DATATYPE.ODB_BASE_CONNECTOR;
        PData.AdapterInfo=ConnInfo;
        PData.featureID=FeatureID;
        //
       this.BASE_SendPluginMessage(FeatureID,null,KK_PLUGIN_BASE_ODB2_DATA, PData);
    }
     public void ODB_SendODBInfo(String FeatureID,PinOdb2ConnectorInfo ConnInfo, ODB2Data Data) {
        //
        PinDataOdb2 PData = new PinDataOdb2();
        PData.Odb2DataType=ODBConstants.KK_ODB_DATATYPE.ODB_DIAG_DATA;
        PData.ODBData=Data;
        PData.AdapterInfo=ConnInfo;
        PData.featureID=FeatureID;
        //
       this.BASE_SendPluginMessage(FeatureID,null,KK_PLUGIN_BASE_ODB2_DATA, PData);
    }
      public void ODB_SendODBErrors(String FeatureID,PinOdb2ConnectorInfo ConnInfo, ODB2Data Data) {
        //
        PinDataOdb2 PData = new PinDataOdb2();
        PData.Odb2DataType=ODBConstants.KK_ODB_DATATYPE.ODB_DIAG_CE_ERRORS;
        PData.ODBData=Data;
        PData.AdapterInfo=ConnInfo;
        PData.featureID = FeatureID;
        //
        this.BASE_SendPluginMessage(FeatureID,null, KK_PLUGIN_BASE_ODB2_DATA, PData);
    }

    public static PinDataOdb2 ODB_SendPluginMessageCommand_PMData(ODBConstants.KK_ODB_COMMANDTYPE Command, ODBConstants.KK_ODB_DATACOMMANDINFO Request, int[] DataInt, int[] ReadInterval) {
        PinDataOdb2 PData = new PinDataOdb2();
        PData.command = Command;
        PData.commandData = Request;
        //
        PData.requestPIDs = DataInt;
        PData.dynamicRequestInterval = ReadInterval;

        return PData;
    }
}
