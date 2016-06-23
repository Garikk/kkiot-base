/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kkdev.kksystem.base.classes.plugins;

import kkdev.kksystem.base.classes.base.PinData;

/**
 *
 * @author blinov_is
 */
public class PluginMessage {
    public String SenderUID;    //Sender plugin ID
    public String FeatureID;    //Feature ID
    public String UIContextID;
    public String pinName; 
    public PinData pinData;
    
    public PluginMessage newInstance()
    {
        PluginMessage Ret;
        Ret=new PluginMessage();
        Ret.SenderUID=this.SenderUID;
        Ret.FeatureID=this.FeatureID;
        Ret.UIContextID=this.UIContextID;
        Ret.pinName=this.pinName;
        Ret.pinData=this.pinData;
        return Ret;
    }
    
    public Object getPinData()
    {
        return pinData;
    }
    
    public void setPinData(PinData PinData)
    {
        pinData=PinData;
    }
}
