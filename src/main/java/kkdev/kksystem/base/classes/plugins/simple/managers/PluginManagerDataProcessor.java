/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kkdev.kksystem.base.classes.plugins.simple.managers;

import kkdev.kksystem.base.classes.display.DisplayConstants;
import kkdev.kksystem.base.classes.display.PinLedCommand;
import kkdev.kksystem.base.classes.display.PinLedData;
import kkdev.kksystem.base.classes.odb2.ODBConstants;
import kkdev.kksystem.base.classes.odb2.PinOdb2Command;
import static kkdev.kksystem.base.constants.PluginConsts.KK_PLUGIN_BASE_LED_COMMAND;
import static kkdev.kksystem.base.constants.PluginConsts.KK_PLUGIN_BASE_LED_DATA;
import static kkdev.kksystem.base.constants.PluginConsts.KK_PLUGIN_BASE_ODB2_COMMAND;

/**
 *
 * @author blinov_is
 */
public class PluginManagerDataProcessor extends PluginManagerBase {

    public void ODB_SendPluginMessageCommand(String FeatureID,ODBConstants.KK_ODB_COMMANDTYPE Command, ODBConstants.KK_ODB_DATAPACKET Request, int[] DataInt, int[] ReadInterval) {
        PinOdb2Command PData = new PinOdb2Command();
        PData.Command = Command;
        PData.CommandData = Request;
        //
        PData.RequestPIDs = DataInt;
        PData.DynamicRequestInterval = ReadInterval;
        //
        this.BASE_SendPluginMessage(FeatureID,KK_PLUGIN_BASE_ODB2_COMMAND, PData);
    }
    
    
    public void DISPLAY_InitPage(String FeatureID,String PageName)
    {
         DISPLAY_SendPluginMessageCommand(FeatureID,DisplayConstants.KK_DISPLAY_COMMAND.DISPLAY_KKSYS_PAGE_INIT,PageName, null, null, null);
    }
    public void DISPLAY_ActivatePage(String FeatureID, String PageName)
    {
          DISPLAY_SendPluginMessageCommand(FeatureID,DisplayConstants.KK_DISPLAY_COMMAND.DISPLAY_KKSYS_PAGE_ACTIVATE,PageName, null, null, null);
    }

    public void DISPLAY_SendPluginMessageCommand(String FeatureID,DisplayConstants.KK_DISPLAY_COMMAND Command, String PageID, String[] DataStr, int[] DataInt, boolean[] DataBool) {
        PinLedCommand PData = new PinLedCommand();
        PData.Command = Command;
        PData.BOOL = DataBool;
        PData.INT = DataInt;
        PData.STRING = DataStr;
        PData.PageID=PageID;
        //
        this.BASE_SendPluginMessage(FeatureID,KK_PLUGIN_BASE_LED_COMMAND, PData);
    }

    public void DISPLAY_SendPluginMessageData(String FeatureID, PinLedData PData) {

        //
        this.BASE_SendPluginMessage(FeatureID,KK_PLUGIN_BASE_LED_DATA, PData);
    }
      public void _DISPLAY_SendPluginMessageDataDirect(String PluginID,String FeatureID, PinLedData PData) {

        //
        this._BASE_SendPluginMessageDirect(FeatureID,PluginID,KK_PLUGIN_BASE_LED_DATA, PData);
    }

}