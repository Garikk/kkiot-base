/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kkdev.kksystem.base.classes;

import java.io.Serializable;
import kkdev.kksystem.base.constants.PluginConsts.KK_PLUGIN_TYPE;

/**
 *
 * @author blinov_is
 */
public class PluginInfo implements Serializable {
    public String PluginName;
    public String PluginDescription;
    public String PluginJarName;
    public KK_PLUGIN_TYPE PluginType;
    public int PluginVersion;
    public String[] ReceivePins;
    public String[] TransmitPins;
    public String ConnectorClass;
    public boolean Enabled;
}
