/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kkdev.kksystem.base.classes.display.menumaker;

import java.util.HashMap;

/**
 *
 * @author blinov_is
 */
public class MenuView {

    private int MenuRowCount;

    public String[] DisplayedMenuNames;
    public String[] DisplayedMenuCMDs;
    public HashMap TemplateKeys;

    public final String DEF_MENU_ITEM_PFX = "SYSMENU_";
    public final String DEF_MENU_SELECTOR_PFX = "SEL_";
    public final String DEF_MENU_PAGE = "SYSMENU_1";

    private int CurrentViewPosition = 0;
    private int SelectorPosition = 0;

    private int ViewRowCount;

    public MenuView(int ViewRows, int MenuRows) {
        DisplayedMenuNames = new String[MenuRows];
        DisplayedMenuCMDs = new String[MenuRows];
        MenuRowCount = MenuRows;
        ViewRowCount = ViewRows;
    }

    public void SetItemData(int Position, String DisplayName, String ItemID) {
        DisplayedMenuNames[Position] = DisplayName;
        DisplayedMenuCMDs[Position] = ItemID;
    }

    public HashMap<String, String> GetMenu() {
        return GetView();
    }

    public HashMap<String, String> MoveMenuUP() {
        if (SelectorPosition > 0) {
            SelectorPosition--;
        } else {
            if (CurrentViewPosition == 0) {
                CurrentViewPosition = MenuRowCount - ViewRowCount;
                SelectorPosition = ViewRowCount-1;
            } else {
                CurrentViewPosition--;
            }
        }

        return GetView();
    }

    public HashMap<String, String> MoveMenuDown() {
        if (SelectorPosition < ViewRowCount - 1) {
            SelectorPosition++;
        } else {
            if ((CurrentViewPosition + ViewRowCount) > MenuRowCount - 1) {
                CurrentViewPosition = 0;
                SelectorPosition = 0;
            } else {
                CurrentViewPosition++;
            }
        }

        return GetView();

    }

    public String GetCurrentMenuCommand()
    {
        return DisplayedMenuCMDs[CurrentViewPosition+SelectorPosition];
    }
    private HashMap<String, String> GetView() {
        HashMap<String, String> Ret;
        Ret = new HashMap<>();
        //
        for (int i = 0; i < ViewRowCount; i++) {
            Ret.put(DEF_MENU_ITEM_PFX + i, DisplayedMenuNames[CurrentViewPosition + i]);
            if (i != SelectorPosition) {
                Ret.put(DEF_MENU_SELECTOR_PFX + i, " ");
            } else {
                Ret.put(DEF_MENU_SELECTOR_PFX + i, "*");
            }

        }
        return Ret;
    }
}
