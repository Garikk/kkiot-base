/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kkdev.kksystem.base.interfaces;

import java.util.List;
import kkdev.kksystem.base.classes.kkcontroller.RS232Device;

/**
 *
 * @author blinov_is
 */
public interface IHWDevicesUtils {
        //HWDevices
    public List<RS232Device> getRS232Devices();
}
