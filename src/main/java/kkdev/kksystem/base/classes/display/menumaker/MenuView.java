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
    public int RowsCount;
    
    public String[] DisplayedMenuNames;
    public String[] DisplayedMenuIDs;
    public HashMap TemplateKeys;
    
    final String DEF_MENU_ITEM_PFX="SYSMENU_";
    final String DEF_MENU_SELECTOR_PFX="SEL_";
    
    
    public MenuView(int Rows)
    {
        DisplayedMenuNames=new String[Rows];
        DisplayedMenuIDs=new String[Rows];
    }
    public void SetItemData(int Position, String DisplayName, String ItemID)
    {
        DisplayedMenuNames[Position]=DisplayName;
        DisplayedMenuIDs[Position]=ItemID;
    }
    
    
}
