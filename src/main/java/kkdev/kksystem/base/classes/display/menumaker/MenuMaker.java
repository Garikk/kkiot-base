/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kkdev.kksystem.base.classes.display.menumaker;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;
import kkdev.kksystem.base.classes.display.DisplayConstants.KK_DISPLAY_DATA;
import kkdev.kksystem.base.classes.display.PinLedData;
import kkdev.kksystem.base.classes.plugins.simple.managers.PluginManagerDataProcessor;
import kkdev.kksystem.base.interfaces.IPluginBaseInterface;
import kkdev.kksystem.base.interfaces.IPluginKKConnector;


/**
 *
 * @author blinov_is
 */
public class MenuMaker {
    public static final String KK_MENUMAKER_SPECIALCMD_SUBMENU="KK_SUBMENU";
    
    PluginManagerDataProcessor PManager;
    boolean InSystemMode;
    String MenuFeatureID;
    MKMenuItem[] MenuItems;
    Deque<MKMenuItem[]> MenuTree;
    IMenuMakerItemSelected CallBack;
    MKMenuView MViewer;
    String SystemLCD;
    //
            
   public interface IMenuMakerItemSelected{
       public void SelectedItem(String ItemCMD);
   }

    public MenuMaker(String FeatureID, IPluginBaseInterface BaseConnector, IMenuMakerItemSelected MenuCallback, String SystemLCD_ID) {
        CallBack = MenuCallback;
        PManager = new PluginManagerDataProcessor();
        PManager.BaseConnector = BaseConnector;
        InSystemMode=true;
        SystemLCD=SystemLCD_ID;
        MenuFeatureID=FeatureID;
        
   
    }

    public MenuMaker(String FeautreID, IPluginKKConnector PluginConnector, IMenuMakerItemSelected MenuCallback) {
        CallBack = MenuCallback;
        PManager = new PluginManagerDataProcessor();
        PManager.Connector = PluginConnector;
        InSystemMode=false;
    }


   public void AddMenuItems(MKMenuItem[] Items)
   {
       MenuTree=new ArrayDeque<>();
       MenuItems=Items;
       MViewer=new MKMenuView(2,Items.length);  
       
       for (int i=0;i<Items.length;i++)
       {
           MViewer.SetItemData(i,Items[i]);
        }
    }
   public void UpdateMenuItems(MKMenuItem[] Items,boolean IsBackCommand)
   {
       if (!IsBackCommand)
        MenuTree.push(MenuItems);
      
       MenuItems=Items;
       MViewer.ResetMenuView(Items.length);
       for (int i=0;i<Items.length;i++)
       {
           MViewer.SetItemData(i,Items[i]);
        }
       MenuRefreshDisplay();
   }

   
    public void ShowMenu() {
        PinLedData PLD = new PinLedData();
        PLD.FillFrameValues(MViewer.GetMenu());
        PLD.FeatureUID = MenuFeatureID;
        PLD.TargetPage = MViewer.DEF_MENU_PAGE;
        PLD.DataType=KK_DISPLAY_DATA.DISPLAY_KKSYS_TEXT_UPDATE_FRAME;
        

        
        if (InSystemMode)
        {
            PManager._DISPLAY_ActivatePageDirect(MenuFeatureID,SystemLCD,MViewer.DEF_MENU_PAGE);
            PManager._DISPLAY_SendPluginMessageDataDirect(MenuFeatureID,SystemLCD, PLD);
        }
        else
        {
            PManager.DISPLAY_ActivatePage(MenuFeatureID,MViewer.DEF_MENU_PAGE);
            PManager.DISPLAY_SendPluginMessageData(MenuFeatureID, PLD);
        }
    }

    public void MenuSelectUp() {
        PinLedData PLD = new PinLedData();
        PLD.DataType = KK_DISPLAY_DATA.DISPLAY_KKSYS_TEXT_UPDATE_FRAME;
        PLD.FillFrameValues(MViewer.MoveMenuUP());
        PLD.FeatureUID = MenuFeatureID;
        PLD.TargetPage = MViewer.DEF_MENU_PAGE;
        if (InSystemMode) {
            PManager._DISPLAY_SendPluginMessageDataDirect(MenuFeatureID,SystemLCD,  PLD);
        } else {
            PManager.DISPLAY_SendPluginMessageData(MenuFeatureID, PLD);
        }
    }
     public void MenuRefreshDisplay() {
        PinLedData PLD = new PinLedData();
        PLD.DataType = KK_DISPLAY_DATA.DISPLAY_KKSYS_TEXT_UPDATE_FRAME;
        PLD.FillFrameValues(MViewer.GetView());
        PLD.FeatureUID = MenuFeatureID;
        PLD.TargetPage = MViewer.DEF_MENU_PAGE;
        if (InSystemMode) {
            PManager._DISPLAY_SendPluginMessageDataDirect(MenuFeatureID,SystemLCD,  PLD);
        } else {
            PManager.DISPLAY_SendPluginMessageData(MenuFeatureID, PLD);
        }
    }

    public void MenuSelectDown() {
        PinLedData PLD = new PinLedData();
        PLD.DataType = KK_DISPLAY_DATA.DISPLAY_KKSYS_TEXT_UPDATE_FRAME;
        PLD.FillFrameValues(MViewer.MoveMenuDown());
        PLD.TargetPage = MViewer.DEF_MENU_PAGE;   
        PLD.FeatureUID = MenuFeatureID;
        
        if (InSystemMode)
            PManager._DISPLAY_SendPluginMessageDataDirect(MenuFeatureID,SystemLCD, PLD);
        else
            PManager.DISPLAY_SendPluginMessageData(MenuFeatureID, PLD);
    }
    public void MenuSelectBack() {
        System.out.println(MenuTree.size());
        
        if (MenuTree.size()>0)
            UpdateMenuItems(MenuTree.pop(),true);
        
        System.out.println(MenuTree.size());
    }
    public void MenuExec() {
        if (!ExecSpecialCommand(GetCurrentSelection())) {
            CallBack.SelectedItem(GetCurrentSelection().ItemCommand);
        }

    }

    private boolean ExecSpecialCommand(MKMenuItem Item)
    {
        switch (Item.ItemCommand)
        {
            case KK_MENUMAKER_SPECIALCMD_SUBMENU:
                
                UpdateMenuItems(Item.SubItems,false);
                return true;
        }
        
        return false;
    }
    
    public MKMenuItem GetCurrentSelection()
    {
        return MViewer.GetCurrentMenuItem();
    }
}
