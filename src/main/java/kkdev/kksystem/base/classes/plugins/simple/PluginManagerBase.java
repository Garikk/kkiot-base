/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kkdev.kksystem.base.classes.plugins.simple;

import kkdev.kksystem.base.classes.plugins.PluginMessage;
import kkdev.kksystem.base.interfaces.IPluginBaseInterface;
import kkdev.kksystem.base.interfaces.IPluginKKConnector;

/**
 *
 * @author blinov_is
 */
public class PluginManagerBase {
    public IPluginKKConnector Connector;
    public IPluginBaseInterface BaseConnector;
    
    public void BASE_SendPluginMessage(String PinName, Object PinData) {
        PluginMessage Msg = new PluginMessage();
        Msg.PinName = PinName;
        Msg.PinData = PinData;
        
        Connector.SendPinMessage(Msg);

    }
        public void _BASE_SendPluginMessageDirect(String PluginUUID,String PinName, Object PinData) {
        PluginMessage Msg = new PluginMessage();
        Msg.PinName = PinName;
        Msg.PinData = PinData;
        
        BaseConnector._ExecutePinCommandDirect(PluginUUID, Msg);

    }


}
