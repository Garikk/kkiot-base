/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kkdev.kksystem.base.classes.plugins.simple.managers;

import java.util.Set;
import kkdev.kksystem.base.classes.controls.PinDataControl;
import kkdev.kksystem.base.classes.controls.PinDataControl.KK_CONTROL_DATA;
import static kkdev.kksystem.base.constants.PluginConsts.KK_PLUGIN_BASE_CONTROL_DATA;

/**
 *
 * @author blinov_is
 */
public class PluginManagerControls extends PluginManagerBase {

    public synchronized void CONTROL_SendPluginMessageData(String FeatureID,String UIContextID , Set<String> ControlID, KK_CONTROL_DATA EventType, int IntValue) {

        PinDataControl PData = CONTROL_SendPluginMessageData_PData(FeatureID,UIContextID, ControlID, EventType, IntValue);
        //
                    
        this.BASE_SendPluginMessage(FeatureID, UIContextID,KK_PLUGIN_BASE_CONTROL_DATA, PData);
    }

    public static synchronized PinDataControl CONTROL_SendPluginMessageData_PData(String FeatureID,String UIContextID, Set<String> ControlID, KK_CONTROL_DATA EventType, int IntValue) {

        PinDataControl PData = new PinDataControl();
        //
        PData.featureID = FeatureID;
        PData.controlID = ControlID;
        PData.controlDataType = EventType;
        PData.controlValue = IntValue;
        PData.UIContextID=UIContextID;
        //
        return PData;
    }
}
