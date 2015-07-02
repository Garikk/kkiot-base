/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kkdev.kksystem.base.classes.display.tools.infopage;

/**
 *
 * @author blinov_is
 */
public class MKPageView {
    int PageSelector;
    MKPageItem[] CurrentPages;
    
    public MKPageView(int CountPages)
    {
        CurrentPages=new MKPageItem[CountPages];
    }
    
    public MKPageItem MovePageNext()
    {
        if (PageSelector<CurrentPages.length)
            PageSelector++;
        else
            PageSelector=0;
        
        return GetPage();
    }
    public MKPageItem MovePagePrev()
    {
    if (PageSelector>0)
            PageSelector--;
        else
            PageSelector=CurrentPages.length;
    
        return GetPage();
    }
    
    public void SetPageData(int Position,MKPageItem Page)
    {
           CurrentPages[Position]=Page;
    }
    
    public MKPageItem GetPage()
    {
        return CurrentPages[PageSelector];
    }
}

