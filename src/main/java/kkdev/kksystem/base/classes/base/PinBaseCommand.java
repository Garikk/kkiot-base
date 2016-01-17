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
        CHANGE_FEATURE,
        PLUGIN,
        SYSTEM_RESTART_KKCONTROLLER,
        SYSTEM_REBOOT_HW,
        SYSTEM_POWEROFF,
        SYSTEM_RESTORE_BACKUP,
        SYSTEM_RESTORE_EMERGENCY
    }
    
    public PinBaseCommand()
    {
        BaseCommand=BASE_COMMAND_TYPE.PLUGIN;
    }
    
    public BASE_COMMAND_TYPE BaseCommand;
    public String ChangeFeatureID;
    public String LogReason;
    
}
