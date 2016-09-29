/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kkdev.kksystem.base.interfaces;

import java.util.List;
import kkdev.kksystem.base.classes.display.pages.DisplayPage;

/**
 *
 * @author blinov_is
 */
public interface IDisplayUtils {
    public List<DisplayPage> GetUIDisplayPages();
    public DisplayPage GetUIDisplayPage(String Page);
    public void AddUIDisplayPage(DisplayPage Page);
}
