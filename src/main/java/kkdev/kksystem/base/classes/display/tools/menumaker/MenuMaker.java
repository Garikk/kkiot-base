/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kkdev.kksystem.base.classes.display.tools.menumaker;

import java.util.ArrayDeque;
import java.util.Deque;
import kkdev.kksystem.base.classes.controls.PinControlData;
import kkdev.kksystem.base.classes.display.pages.PageConsts;
import kkdev.kksystem.base.classes.plugins.simple.managers.PluginManagerDataProcessor;
import kkdev.kksystem.base.interfaces.IKKControllerUtils;
import kkdev.kksystem.base.interfaces.IPluginBaseInterface;
import kkdev.kksystem.base.interfaces.IPluginKKConnector;

/**
 *
 * @author blinov_is
 */
public class MenuMaker {

    public static final String KK_MENUMAKER_SPECIALCMD_SUBMENU = "KK_SUBMENU";

    PluginManagerDataProcessor PManager;
    boolean InSystemMode = false;
    String MenuFeatureID;
    String MenuContextID;
    MKMenuItem[] MenuItems;
    Deque<MKMenuItem[]> MenuTree;
    IMenuMakerItemSelected CallBack;
    MKMenuView MViewer;
    String SystemLCD;
    String TargetPage;
    String ActivePage;
    private IKKControllerUtils Utils;
    //
    public String GetActivePage()
    {
        return ActivePage;
    }
    public interface IMenuMakerItemSelected {

        public void SelectedItem(String ItemCMD);
    }

    public MenuMaker(IKKControllerUtils KKUtils, String FeatureID,String UIContextID, String MenuTargetPage, IPluginBaseInterface BaseConnector, IMenuMakerItemSelected MenuCallback, String SystemLCD_ID) {
      
        if (MenuTargetPage == null) {
            TargetPage = PageConsts.KK_DISPLAY_PAGES_SIMPLEMENU_TXT_C1RX_PREFIX;
        } else {
            TargetPage = MenuTargetPage;
        }
        Utils=KKUtils;
        CallBack = MenuCallback;
        PManager = new PluginManagerDataProcessor();
        PManager.BaseConnector = BaseConnector;
        InSystemMode = true;
        SystemLCD = SystemLCD_ID;
        MenuFeatureID = FeatureID;
        MenuContextID=UIContextID;
        

    }

    public MenuMaker(IKKControllerUtils KKUtils, String FeatureID, String UIContextID, String MenuTargetPage, IPluginKKConnector PluginConnector, IMenuMakerItemSelected MenuCallback) {
        if (MenuTargetPage == null | "".equals(MenuTargetPage)) {
            TargetPage = PageConsts.KK_DISPLAY_PAGES_SIMPLEMENU_TXT_C1RX_PREFIX ;
        } else {
            TargetPage = MenuTargetPage;
        }
        //        
        Utils=KKUtils;
        CallBack = MenuCallback;
        PManager = new PluginManagerDataProcessor();
        PManager.Connector = PluginConnector;
        InSystemMode = false;
        MenuFeatureID = FeatureID;
        MenuContextID = UIContextID;
    }

    public void AddMenuItems(MKMenuItem[] Items)
    {
       AddMenuItems(Utils.UICONTEXT_GetUIContextInfo(MenuContextID).UIDisplay.Text_ROWS,Items);
    }
    public void AddMenuItems(int PageRows,MKMenuItem[] Items) {
        MenuTree = new ArrayDeque<>();
        MenuItems = Items;
        MViewer = new MKMenuView(PageRows, Items.length);

        for (int i = 0; i < Items.length; i++) {
            MViewer.SetItemData(i, Items[i]);
        }
    }

    public void UpdateMenuItems(MKMenuItem[] Items, boolean IsBackCommand) {
        if (!IsBackCommand) {
            MenuTree.push(MenuItems);
        }

        MenuItems = Items;
        MViewer.ResetMenuView(Items.length);
        for (int i = 0; i < Items.length; i++) {
            MViewer.SetItemData(i, Items[i]);
        }
        MenuRefreshDisplay();
    }

    public void ShowMenu() {

        if (InSystemMode) {
            ActivePage=TargetPage;
            PManager._DISPLAY_ActivatePageDirect(MenuFeatureID,MenuContextID,SystemLCD, TargetPage);
            PManager._DISPLAY_UpdateUIFramesDirect(MenuFeatureID,MenuContextID, SystemLCD, TargetPage, MViewer.GetMenu());
            
        } else {
            ActivePage=TargetPage;
            PManager.DISPLAY_ActivatePage(MenuFeatureID,MenuContextID, TargetPage);
            PManager.DISPLAY_UpdateUIFrames(MenuFeatureID,MenuContextID, TargetPage, MViewer.GetMenu());

        }
    }

    public void MenuRefreshDisplay() {
        if (InSystemMode) {
            PManager._DISPLAY_UpdateUIFramesDirect(MenuFeatureID,MenuContextID, SystemLCD, TargetPage, MViewer.GetMenu());
        } else {
            PManager.DISPLAY_UpdateUIFrames(MenuFeatureID,MenuContextID, TargetPage, MViewer.GetMenu());
        }
    }

    public void MenuSelectUp() {

        if (InSystemMode) {
            PManager._DISPLAY_UpdateUIFramesDirect(MenuFeatureID,MenuContextID, SystemLCD, TargetPage, MViewer.MoveMenuUP());
        } else {
            PManager.DISPLAY_UpdateUIFrames(MenuFeatureID,MenuContextID, TargetPage, MViewer.MoveMenuUP());
        }
    }

    public void MenuSelectDown() {
        if (InSystemMode) {
            PManager._DISPLAY_UpdateUIFramesDirect(MenuFeatureID,MenuContextID, SystemLCD, TargetPage, MViewer.MoveMenuDown());
        } else {
            PManager.DISPLAY_UpdateUIFrames(MenuFeatureID,MenuContextID, TargetPage, MViewer.MoveMenuDown());
        }
    }

    public void MenuSelectBack() {

        if (MenuTree.size() > 0) {
            UpdateMenuItems(MenuTree.pop(), true);
        }

    }

    public void MenuExec() {
        if (!ExecSpecialCommand(GetCurrentSelection())) {
            CallBack.SelectedItem(GetCurrentSelection().ItemCommand);
        }

    }

    private boolean ExecSpecialCommand(MKMenuItem Item) {
        switch (Item.ItemCommand) {
            case KK_MENUMAKER_SPECIALCMD_SUBMENU:
                UpdateMenuItems(Item.SubItems, false);
                return true;
        }

        return false;
    }

    public MKMenuItem GetCurrentSelection() {
        return MViewer.GetCurrentMenuItem();
    }
    
     public void ProcessControlCommand(String ControlID) {
        switch (ControlID) {
            case PinControlData.DEF_BTN_UP:
                MenuSelectUp();
                break;
            case PinControlData.DEF_BTN_DOWN:
                MenuSelectDown();
                break;
            case PinControlData.DEF_BTN_ENTER:
                MenuExec();
                break;
            case PinControlData.DEF_BTN_BACK:
                MenuSelectBack();
                break;

        }

    }
}
