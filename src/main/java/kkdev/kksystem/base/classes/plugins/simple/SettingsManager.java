/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kkdev.kksystem.base.classes.plugins.simple;

import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.util.logging.Level;
import java.util.logging.Logger;
import kkdev.kksystem.base.classes.plugins.ManagedParameter;
import kkdev.kksystem.base.classes.plugins.PluginConfiguration;
import kkdev.kksystem.base.constants.SystemConsts;

/**
 *
 * @author blinov_is
 */
public class SettingsManager {

    String configurationFile;
    Type settingsClassType;

    public SettingsManager(String FileName, Type SettingsClass) {
        settingsClassType = SettingsClass;
        configurationFile = FileName;
    }

    public void saveConfig(PluginConfiguration Configuration) {
        try {
            Gson gson = new Gson();

            String Res = gson.toJson(Configuration);

            FileWriter fw;
            fw = new FileWriter(SystemConsts.KK_BASE_CONFPATH + "/" + configurationFile);
            fw.write(Res);
            fw.flush();
            fw.close();

        } catch (IOException ex) {
            //  Logger.getLogger(kk_DefaultConfig.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public PluginConfiguration loadConfig() {
        PluginConfiguration Ret;
        try {
            Gson gson = new Gson();
            //
            try (BufferedReader br = new BufferedReader(
                    new FileReader(SystemConsts.KK_BASE_CONFPATH + "/" + configurationFile))) {
                //
                Ret = gson.fromJson(br, settingsClassType);
                //
            }
            //
            return Ret;
        } catch (FileNotFoundException  ex ) {
            return null;
        }
          catch (IOException  ex ) {
              return null;
        }

    }
    
    //ONLY BOOLEAN PARAMETER SUPPORTED BY NOW!!
    public void setManagedParameterValue__BoolOnly(PluginConfiguration Settings, String ParameterName,Object value)
    {
         for (Field F : Settings.getClass().getDeclaredFields()) {
                if (F.isAnnotationPresent(ManagedParameter.class) & F.getName().equals(ParameterName)) {
                    try {
                        F.setBoolean(Settings, ((String)value).toLowerCase().equals("true"));
                    } catch (IllegalArgumentException ex) {
                        Logger.getLogger(SettingsManager.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (IllegalAccessException ex) {
                        Logger.getLogger(SettingsManager.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
         }
    }

}
