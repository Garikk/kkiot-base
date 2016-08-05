/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kkdev.kksystem.base.classes.plugins;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author blinov_is
 */
public class PluginConfiguration {
    public String configurationUUID;

    Map<String,String> stringParameters;
    Map<String, Boolean> boolParameters;
    Map<String, Integer> intParameters;

    public PluginConfiguration() {
        stringParameters = new HashMap<>();
        boolParameters = new HashMap<>();
        intParameters = new HashMap<>();
    }

    public void setParameterString(String Name, String Value) {
        stringParameters.put(Name, Value);
    }

    public void setParameterBool(String Name, Boolean Value) {
        boolParameters.put(Name, Value);
    }

    public void setParameterInteger(String Name, Integer Value) {
        intParameters.put(Name, Value);
    }
    
    public String getParameterString(String Name)
    {
        return stringParameters.get(Name);
    }
    
    public Integer getParametersInteger(String Name)
    {
        return intParameters.get(Name);    
    }
    public Integer getParametersBoolean(String Name)
    {
        return intParameters.get(Name);    
    }
    
    
}
