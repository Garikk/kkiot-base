/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kkdev.kksystem.base.classes.display;

/**
 *
 * @author blinov_is
 */
public class DisplayInfo {
    public enum UIDisplayType
    {
        DISPLAY_TEXT,
        DISPLAY_GRAPHIC,
        DISPLAY_MIXED
    }
    public UIDisplayType DisplayType;
    public int Text_COLS;
    public int Text_ROWS;
    public int Graphic_Width_px;
    public int Graphic_Height_px;
    public int MaxBackLight;
    public int MaxContrast;
    public String DisplayID;
}
