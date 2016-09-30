/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kkdev.kksystem.base.interfaces;

import java.util.List;
import java.util.Map;
import kkdev.kksystem.base.classes.plugins.PluginConfiguration;
import kkdev.kksystem.base.classes.plugins.PluginInfo;

/**
 *
 * @author blinov_is
 */
public interface IPluginUtils {
      // Plugin information
    public List<PluginInfo> getPluginsInfo();
    public Map<PluginInfo,PluginConfiguration> getPluginsParameters();
}
