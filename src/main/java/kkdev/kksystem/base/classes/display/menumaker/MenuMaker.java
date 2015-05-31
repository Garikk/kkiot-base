/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kkdev.kksystem.base.classes.display.menumaker;

import kkdev.kksystem.base.classes.display.DisplayConstants;
import kkdev.kksystem.base.classes.display.DisplayConstants.KK_DISPLAY_DATA;
import kkdev.kksystem.base.classes.display.PinLedData;
import kkdev.kksystem.base.classes.plugins.simple.managers.PluginManagerBase;
import kkdev.kksystem.base.classes.plugins.simple.managers.PluginManagerDataProcessor;
import kkdev.kksystem.base.interfaces.IPluginBaseInterface;
import kkdev.kksystem.base.interfaces.IPluginKKConnector;


/**
 *
 * @author blinov_is
 */
public class MenuMaker {
    PluginManagerDataProcessor PManager;
    boolean InSystemMode;
    String FeatureID;
    String[][] MenuItems;
    IMenuMakerItemSelected CallBack;
    MenuView MViewer;
    //
            
   public interface IMenuMakerItemSelected{
       public void SelectedItem(String ItemID);
   }

    public MenuMaker(String FeautreID, IPluginBaseInterface BaseConnector, IMenuMakerItemSelected MenuCallback) {
        CallBack = MenuCallback;
        PManager = new PluginManagerDataProcessor();
        PManager.BaseConnector = BaseConnector;
        
   
    }

    public MenuMaker(String FeautreID, IPluginKKConnector PluginConnector, IMenuMakerItemSelected MenuCallback) {
        CallBack = MenuCallback;
        PManager = new PluginManagerDataProcessor();
        PManager.Connector = PluginConnector;
    }


   public void AddMenuItems(String[][] Items)
   {
       MenuItems=Items;
       MViewer=new MenuView(2,Items.length);   
       for (int i=0;i<Items.length;i++)
       {
           MViewer.SetItemData(i,Items[i][0], Items[i][1]);
        }
    }

    public void ShowMenu() {
        PinLedData PLD = new PinLedData();
        PLD.FillFrameValues(MViewer.GetMenu());
        PLD.FeatureUID = FeatureID;
        PLD.TargetPage = MViewer.DEF_MENU_PAGE;
        
        PManager.DISPLAY_SendPluginMessageData(FeatureID, PLD);
    }

    public void MenuSelectUp() {
        PinLedData PLD = new PinLedData();
        PLD.DataType = KK_DISPLAY_DATA.DISPLAY_KKSYS_TEXT_UPDATE_FRAME;
        PLD.FillFrameValues(MViewer.MoveMenuUP());
        PLD.FeatureUID = FeatureID;
        PLD.TargetPage = MViewer.DEF_MENU_PAGE;
        PManager.DISPLAY_SendPluginMessageData(FeatureID, PLD);
    }

    public void MenuSelectDown() {
        PinLedData PLD = new PinLedData();
        PLD.DataType = KK_DISPLAY_DATA.DISPLAY_KKSYS_TEXT_UPDATE_FRAME;
        PLD.FillFrameValues(MViewer.MoveMenuDown());
        PLD.TargetPage = MViewer.DEF_MENU_PAGE;
        
        PManager.DISPLAY_SendPluginMessageData(FeatureID, PLD);
    }

    private void ShowPage(String PageID) {
      //  PManager.DISPLAY_ActivatePage(FeatureID,CurrentPageName);
   
   }
}
