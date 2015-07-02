/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kkdev.kksystem.base.classes.odb2.tools.odbdecoder;

/**
 *
 * @author blinov_is
 */
public class ODBDecoder {
    public ODBSimpleData SimpleData;
    public ODBExtendedData ExtendedData;
    
    public ODBDecoder()
    {
        SimpleData=new ODBSimpleData();
        ExtendedData=new ODBExtendedData();
    
    }
}
