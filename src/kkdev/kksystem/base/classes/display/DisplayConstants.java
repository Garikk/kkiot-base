/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kkdev.kksystem.base.classes.display;

/**
 *
 * @author blinov_is
 */
public final class DisplayConstants {
     public static enum KK_DISPLAY_COMMAND
    {
        DISPLAY_KKSYS_GETINFO,
        DISPLAY_KKSYS_POWER,
        DISPLAY_KKSYS_PAGE_CHANGE_SETTINGS,
        DISPLAY_KKSYS_PAGE_INIT,
        DISPLAY_KKSYS_PAGE_ACTIVATE,
        DISPLAY_RAW_EXEC_DISPLAY_COMMAND
    }
       public static enum KK_DISPLAY_DATA
    {
        DISPLAY_KKSYS_TEXT,
        DISPLAY_KKSYS_TEXT_UPDATE,
        DISPLAY_KKSYS_DISPLAY_STATE,
        DISPLAY_RAW_EXEC_DISPLAY_DATA,
    }
       //
       //public final int DISPLAY_CMD_SETTINGS_INT_POS_POWER=0;
       //public final int DISPLAY_CMD_SETTINGS_INT_POS_BRIGHTNESS=1;
       //public final int DISPLAY_CMD_SETTINGS_INT_POS_CONTRAST=2;
       //
       
}
