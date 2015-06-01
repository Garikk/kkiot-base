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
    private  int MenuRowCount;
    
    public String[] DisplayedMenuNames;
    public String[] DisplayedMenuIDs;
    public HashMap TemplateKeys;
    
    public final String DEF_MENU_ITEM_PFX="SYSMENU_";
    public final String DEF_MENU_SELECTOR_PFX="SEL_";
    public final String DEF_MENU_PAGE="SYSMENU_1";
    
    private int CurrentPosition=0;
    private int SelectorPosition=0;
    
    private int ViewRowCount;
    
    
    
    public MenuView(int ViewRows,int MenuRows)
    {
        DisplayedMenuNames=new String[MenuRows];
        DisplayedMenuIDs=new String[MenuRows];
        ViewRowCount=ViewRows;
    }
    public void SetItemData(int Position, String DisplayName, String ItemID)
    {
        DisplayedMenuNames[Position]=DisplayName;
        DisplayedMenuIDs[Position]=ItemID;
    }
    
    public HashMap<String, String> GetMenu()
    {
        return GetView();
    }
    
    public HashMap<String, String> MoveMenuUP() {
    if (SelectorPosition > 0) {
            SelectorPosition--;
        } else {
            if (CurrentPosition > 0) {
                CurrentPosition = MenuRowCount-ViewRowCount;
                SelectorPosition = ViewRowCount;
            } else {
                CurrentPosition--;
            }
        }

        return GetView();
    }

    public HashMap<String, String> MoveMenuDown() {
        if (SelectorPosition < ViewRowCount) {
            SelectorPosition++;
        } else {
            if ((CurrentPosition + ViewRowCount) > MenuRowCount) {
                CurrentPosition = 0;
                SelectorPosition = 0;
            } else {
                CurrentPosition++;
            }
        }

        return GetView();

    }
    
    
    private HashMap<String,String> GetView()
    {
       HashMap<String, String> Ret;
        Ret = new HashMap<>();
        //
        for (int i = 0; i < ViewRowCount; i++) {
            Ret.put(DEF_MENU_ITEM_PFX + i, DisplayedMenuNames[CurrentPosition + i]);
            if (i != SelectorPosition) {
                Ret.put(DEF_MENU_SELECTOR_PFX + i, " ");
            } else {
                Ret.put(DEF_MENU_SELECTOR_PFX + i, "*");
            }

        }
        return Ret;
    }

    HashMap<String, String> MoveMenuUp() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
