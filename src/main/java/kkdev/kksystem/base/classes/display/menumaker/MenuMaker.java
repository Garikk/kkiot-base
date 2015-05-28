/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kkdev.kksystem.base.classes.display.menumaker;

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
    //
    String CurrentPageName;
            
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
       
   }
   public void ShowMenu()
   {
   
   }
   
   public void MenuSelectUp()
   {
   
   }
   
   public void MenuSelectDown()
   {
    
   }
   
   
   private void ShowPage(String PageID)
   {
        PManager.DISPLAY_ActivatePage(FeatureID,CurrentPageName);
   
   }
}
