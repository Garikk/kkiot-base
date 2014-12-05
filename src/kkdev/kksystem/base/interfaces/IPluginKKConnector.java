/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kkdev.kksystem.base.interfaces;

import kkdev.kksystem.base.classes.PluginInfo;
import kkdev.kksystem.base.classes.PluginPin;

/**
 *
 * @author blinov_is
 */
public interface IPluginKKConnector {
    public PluginInfo GetPluginInfo();
    public PluginPin[] GetPinsForRegister();

    
    public PluginPin ExecutePin(PluginPin Pin);
    
    public void PluginInit(IKKConnector BaseConnector);
    public void PluginStart();
    public void PluginStop();
}
