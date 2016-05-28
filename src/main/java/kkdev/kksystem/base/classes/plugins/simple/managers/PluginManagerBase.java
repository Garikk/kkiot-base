/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kkdev.kksystem.base.classes.plugins.simple.managers;

import static java.lang.System.out;
import java.util.HashMap;
import java.util.Map;
import kkdev.kksystem.base.classes.display.PinLedCommand;
import kkdev.kksystem.base.classes.notify.NotifyConsts;
import kkdev.kksystem.base.classes.notify.PinNotifyData;
import kkdev.kksystem.base.classes.plugins.PluginMessage;
import kkdev.kksystem.base.constants.PluginConsts;
import kkdev.kksystem.base.interfaces.IPluginBaseInterface;
import kkdev.kksystem.base.interfaces.IPluginKKConnector;

/**
 *
 * @author blinov_is
 */
public  class PluginManagerBase {
    public Map<String,String> CurrentFeature; // UIContext => Feature
    public IPluginKKConnector Connector;
    public IPluginBaseInterface BaseConnector;
    
    public PluginManagerBase()
    {
        CurrentFeature=new HashMap<>();
    }
    
    
    public synchronized void BASE_SendPluginMessage(String FeatureID,String PinName, Object PinData) {
        PluginMessage Msg = new PluginMessage();
        Msg.PinName = PinName;
        Msg.PinData = PinData;
        Msg.FeatureID=FeatureID;

        Connector.SendPinMessage(Msg);
        

    }
    public synchronized void _BASE_SendPluginMessageDirect(String FeatureID,String PluginUUID,String PinName, Object PinData) {
        PluginMessage Msg = new PluginMessage();
        Msg.PinName = PinName;
        Msg.PinData = PinData;
        Msg.FeatureID=FeatureID;
        
        BaseConnector._ExecutePinCommandDirect(PluginUUID, Msg);

    }
 
    public synchronized void NOTIFY_SendNotifyMessage(String FeatureID,NotifyConsts.NOTIFY_TYPE NotifyType, NotifyConsts.NOTIFY_METHOD[] NotifyMethod, String NotifyText) {
        PinNotifyData PD;
        PD=new PinNotifyData();
        PD.NotifyText=NotifyText;
        PD.NotifyMethod=NotifyMethod;
        PD.NotifyType=NotifyType;
        
        PluginMessage Msg = new PluginMessage();
        Msg.PinName = PluginConsts.KK_PLUGIN_BASE_NOTIFY_DATA;
        Msg.PinData = PD;
        Msg.FeatureID=FeatureID;

        Connector.SendPinMessage(Msg);
        

    }
}
