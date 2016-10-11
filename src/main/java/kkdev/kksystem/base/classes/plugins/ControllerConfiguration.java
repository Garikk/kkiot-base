/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kkdev.kksystem.base.classes.plugins;

import kkdev.kksystem.base.classes.display.tools.menumaker.MKMenuItem;
import static kkdev.kksystem.base.classes.plugins.weblink.WM_KKMasterConsts.WEBMASTER_SYSSTATE_STATE_MAIN;

/**
 *
 * @author blinov_is
 */
public class ControllerConfiguration extends PluginConfiguration{
    public String configurationStamp;
    public FeatureConfiguration[] features;
    //
    public String systemDisplay_UID;
    public String systemHID_UID;
    //
    public String defaultFeature;
    public MKMenuItem[] systemMenuItems;
    //
    public int WeblinkMaxlevel=WEBMASTER_SYSSTATE_STATE_MAIN;
}
