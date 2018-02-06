/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kkdev.kksystem.base.classes.plugins.weblink;

/**
 *
 * @author blinov_is
 */
public final  class WM_KKMasterConsts {
    public final static String WEBMASTER_REQUEST_CHECK = "check";
    public final static String WEBMASTER_REQUEST_ACT = "action";
    public final static String WEBMASTER_REQUEST_MYUUID = "myid";
    public final static String WEBMASTER_REQUEST_CLIENTINFO = "clientinfo";
    public final static String WEBMASTER_REQUEST_CONFUUID = "confuid";
    public final static String WEBMASTER_REQUEST_JSON_OBJ = "json_object";
    public final static String WEBMASTER_REQUEST_REQFILESBIN = "reqfilesbin";
    public final static String WEBMASTER_REQUEST_EXTCONN_PINDATA = "pindata";
    
    /*
    public final static int WEBMASTER_REQUEST_GET_SYSSTATE = 0;           //check server available
    public final static int WEBMASTER_REQUEST_GET_MYCONF_INFO = 1;           //get ctrlr configuration, ID, stamp
    public final static int WEBMASTER_REQUEST_GET_MYCONF_DATA = 2;           //get ctrlr configuration
    public final static int WEBMASTER_REQUEST_GET_PLUGINS_INFO = 5;          //get plugins id, version and config stamp
    public final static int WEBMASTER_REQUEST_GET_PLUGINS_DATA = 6;          //get extended plugins info (with file names)
    public final static int WEBMASTER_REQUEST_GET_FILES_INFO_BIN = 10;          //get extended plugins info (with file names)
    public final static int WEBMASTER_REQUEST_GET_FILES_INFO_EXTCONF = 11;          //get extended plugins info (with file names)
    public final static int WEBMASTER_REQUEST_CTRLR_DATA_KKPIN = 50;               //KKSystem PIN
   */
    public final static String WEBMASTER_REQUEST_GET_SYSSTATE = "system_state";           //check server available
    public final static String WEBMASTER_REQUEST_GET_MYCONF_INFO = "configuration_info";           //get ctrlr configuration, ID, stamp
    public final static String WEBMASTER_REQUEST_GET_MYCONF_DATA = "configuration_data";           //get ctrlr configuration
    public final static String WEBMASTER_REQUEST_GET_PLUGINS_INFO = "plugins_info";          //get plugins id, version and config stamp
    public final static String WEBMASTER_REQUEST_GET_PLUGINS_DATA = "plugins_info";          //get extended plugins info (with file names)
    public final static String WEBMASTER_REQUEST_GET_FILES_INFO_BIN = "files_bin_info";          //get extended plugins info (with file names)
    public final static String WEBMASTER_REQUEST_GET_FILES_INFO_EXTCONF = "files_exc_info";          //get extended plugins info (with file names)
    public final static String WEBMASTER_REQUEST_CTRLR_DATA_KKPIN = "pin_exchange";               //KKSystem PIN
    
    public final static int WEBMASTER_REQUEST_EXTCONN_GETPIN = 70;               //KKSystem PIN
    public final static int WEBMASTER_REQUEST_EXTCONN_PUTPIN = 71;               //KKSystem PIN
    
    
    public final static int WEBMASTER_SYSSTATE_STATE_MAIN=1;
    public final static int WEBMASTER_SYSSTATE_STATE_BETA=2;
    public final static int WEBMASTER_SYSSTATE_STATE_DEV=3;
    public final static int WEBMASTER_SYSSTATE_STATE_SPECIAL=10;

}
