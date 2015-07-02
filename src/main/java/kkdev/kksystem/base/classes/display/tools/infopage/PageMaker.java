/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kkdev.kksystem.base.classes.display.tools.infopage;
import java.util.List;
import kkdev.kksystem.base.classes.display.DisplayConstants;
import kkdev.kksystem.base.classes.display.PinLedData;
import kkdev.kksystem.base.classes.plugins.simple.managers.PluginManagerDataProcessor;
import kkdev.kksystem.base.interfaces.IPluginKKConnector;

/**
 *
 * @author blinov_is
 */
public class PageMaker {
    String CurrentFeature;
    MKPageView PViewer;
    PluginManagerDataProcessor PManager;
    
   public interface IPageMakerExecCommand{
       public void ExecCommand(String PageCMD);
   }
   
   public PageMaker(String FeatureID, IPluginKKConnector PluginConnector, IPageMakerExecCommand PageExecCallback) {
       PManager=new PluginManagerDataProcessor();
       PManager.Connector=PluginConnector;
       CurrentFeature=FeatureID;
   }
   public void AddPages(MKPageItem[] Page)
   {
       PViewer=new MKPageView(Page.length);
       
       for (int i=0;i<Page.length;i++)
       {
           PViewer.SetPageData(i,Page[i]);
       }
   }
   
   public void ShowInfoPage()
   {
       ShowPage(PViewer.GetPage());
   }
   
   public void SelectNextPage()
   {
        ShowPage(PViewer.MovePageNext());
   }
   public void SelectPrevPage()
   {
       ShowPage(PViewer.MovePagePrev());
   }
   
   private void ShowPage(MKPageItem Page)
   {
       PManager.DISPLAY_ActivatePage(CurrentFeature,Page.PageName);
       PManager.DISPLAY_UpdateUIFrames(CurrentFeature,Page.PageName,Page.UIFrames);
   }
}
