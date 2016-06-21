/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kkdev.kksystem.base.classes.base;

/**
 *
 * @author blinov_is
 */
public class PinBaseCommand {
    public enum BASE_COMMAND_TYPE
    {
        GET_CURRENT_FEATURE,
        CHANGE_FEATURE,
        CURRENT_FEATURE,
        PLUGIN,
        INTERNET_STATE_ACTIVE,
        INTERNET_STATE_INACTIVE,
        SYSTEM_UTILS
    }
    
    public PinBaseCommand()
    {
        baseCommand=BASE_COMMAND_TYPE.PLUGIN;
    }
    
    public BASE_COMMAND_TYPE baseCommand;
    public String changeUIContextID;
    public String changeFeatureID;
    public String logReason;
    
}
