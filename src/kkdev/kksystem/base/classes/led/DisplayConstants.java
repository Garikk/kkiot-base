/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kkdev.kksystem.base.classes.led;

/**
 *
 * @author blinov_is
 */
public final class DisplayConstants {
     public static enum KK_DISPLAY_COMMAND
    {
        DISPLAY_KKSYS_GETINFO,
        DISPLAY_KKSYS_POWER,
        DISPLAY_KKSYS_CHANGE_SETTINGS,
        DISPLAY_KKSYS_CREATE_PAGE,
        DISPLAY_KKSYS_SELECT_PAGE,
        DISPLAY_RAW_EXEC_DISPLAY_COMMAND
        
    }
       public static enum KK_DISPLAY_DATA
    {
        DISPLAY_KKSYS_TEXT,
        DISPLAY_KKSYS_TEXT_UPDATE,
        DISPLAY_KKSYS_DISPLAY_STATE,
        DISPLAY_RAW_EXEC_DISPLAY_DATA,
        
        
    }
}
