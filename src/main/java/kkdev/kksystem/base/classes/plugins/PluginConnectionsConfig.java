/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kkdev.kksystem.base.classes.plugins;

import kkdev.kksystem.base.classes.plugins.PluginConnection;

/**
 *
 * @author blinov_is
 */
public class PluginConnectionsConfig {
    public String ConfigName;
    public String ConfigUUID;
    public PluginConnection[] Connections;
    public int MinVersion;
    // for system menu
    public String SystemDisplay_UID;
    public String SystemHID_UID;
    //
}
