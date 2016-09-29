/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kkdev.kksystem.base.interfaces;

/**
 *
 * @author blinov_is
 */
public interface IControllerUtils {
    public enum ControllerUtilsPinRequestTypes
    {
        HWDev_GetRS232Devices,
        PLUGINS_GetLoadedPlugins,
        DISPLAY_GetUIDisplayPages,
        DISPLAY_GetUIDisplayPage,
        DISPLAY_AddUIDisplayPage,
        UICONTEXT_AddUIContext,
        UICONTEXT_GetUIContext,
        UICONTEXT_UpdateUIContext
    }
    public IContextUtils ContextFunctions();
    public IDisplayUtils DisplayFunctions();
    public IHWDevicesUtils HWManager();
    public IPluginUtils PluginManager();
   
     
}
