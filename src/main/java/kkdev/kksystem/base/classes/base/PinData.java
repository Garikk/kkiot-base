/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kkdev.kksystem.base.classes.base;

/**
 *
 * @author blinov_is
 */
public abstract class PinData {

    public enum BASE_DATA_TYPE {
        TAGGED_INT,
        TAGGED_OBJ,
        OTHER
    }
    public String featureID;
    public String dataDescription;
    public BASE_DATA_TYPE pinDataType;

}
