/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kkdev.kksystem.base.classes.display;

import kkdev.kksystem.base.classes.display.DisplayConstants.KK_DISPLAY_DATA;

/**
 *
 * @author blinov_is
 */
public class PinLedData {
    public KK_DISPLAY_DATA DataType;
    public String[] DisplayText;        //Text for display
    public String DisplayTextUpdate;    //Updated text (using positions)
    public int StartPositionColumn;     //Position for update text
    public int StartPositionLine;       //Position for update text
    public String TargetPage;           //Target page
    public DisplayInfo[] DisplayState;    //
}
