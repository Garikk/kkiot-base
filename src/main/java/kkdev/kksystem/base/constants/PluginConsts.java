/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kkdev.kksystem.base.constants;

/**
 *
 * @author blinov_is
 */
public final class PluginConsts {
    public static enum KK_PLUGIN_TYPE
    {
        PLUGIN_INPUT,
        PLUGIN_OUTPUT,
        PLUGIN_PROCESSOR
    }
    
    public static enum KK_PLUGIN_MESSAGES
    {
        BASE_MESSAGE_INFO
    }
    
    //
    //
    // Default system PINS
    public final static String KK_PLUGIN_BASE_PIN_COMMAND="PIN_KK_COMMAND";
    //
    // Default ODB2 Pins
    public final static String KK_PLUGIN_BASE_ODB2_COMMAND="PIN_KK_ODB2_COMMAND";
    public final static String KK_PLUGIN_BASE_ODB2_DATA="PIN_KK_ODB2_DATA";
    public final static String KK_PLUGIN_BASE_ODB2_RAW="PIN_KK_ODB2_RAW";
    

    public final static String KK_PLUGIN_BASE_LED_COMMAND="PIN_KK_LED_COMMAND";
    public final static String KK_PLUGIN_BASE_LED_DATA="PIN_KK_LED_DATA";
    public final static String KK_PLUGIN_BASE_LED_RAW="PIN_KK_LED_RAW";

    
    public static String KK_PLUGIN_BASE_PLUGIN_ODB2="KKODB2Reader";
    public static String KK_PLUGIN_BASE_PLUGIN_ODB2_UUID="44b5dab1-f596-458a-b09b-d9565b91464e";
    public static String KK_PLUGIN_BASE_PLUGIN_LEDDISPLAY="KKLEDDisplay";
    public static String KK_PLUGIN_BASE_PLUGIN_LEDDISPLAY_UUID="7fbac0f7-6939-4380-bcb0-0ef8b1580fbf";   
    public static String KK_PLUGIN_BASE_PLUGIN_DATADISPLAY="KKDataDisplay";
    public static String KK_PLUGIN_BASE_PLUGIN_DATADISPLAY_UUID="b5b50412-c02a-4674-a112-ddc5805ea4e5";
 

    
}
