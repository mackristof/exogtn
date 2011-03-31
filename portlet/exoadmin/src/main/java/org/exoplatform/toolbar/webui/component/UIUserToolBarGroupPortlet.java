/**
 * Copyright (C) 2009 eXo Platform SAS.
 * 
 * This is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 2.1 of
 * the License, or (at your option) any later version.
 * 
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 * 
 * You should have received a copy of the GNU Lesser General Public
 * License along with this software; if not, write to the Free
 * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 * 02110-1301 USA, or see the FSF site: http://www.fsf.org.
 */

package org.exoplatform.toolbar.webui.component;

import org.exoplatform.portal.config.model.PageNode;
import org.exoplatform.portal.config.model.PageNavigation;
import org.exoplatform.portal.config.model.PortalConfig;
import org.exoplatform.portal.webui.navigation.PageNavigationUtils;
import org.exoplatform.portal.webui.util.Util;
import org.exoplatform.webui.config.annotation.ComponentConfig;
import org.exoplatform.webui.config.annotation.EventConfig;
import org.exoplatform.webui.core.UIPortletApplication;
import org.exoplatform.webui.core.lifecycle.UIApplicationLifecycle;
import org.exoplatform.webui.event.Event;
import org.exoplatform.webui.event.EventListener;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by The eXo Platform SAS
 * Author : Pham Thanh Tung
 *          thanhtungty@gmail.com
 * May 26, 2009  
 */
@ComponentConfig(lifecycle = UIApplicationLifecycle.class, template = "app:/groovy/admintoolbar/webui/component/UIUserToolBarGroupPortlet.gtmpl",
   events = {
      @EventConfig(listeners = UIUserToolBarGroupPortlet.NavigationChangeActionListener.class)
   }
)
public class UIUserToolBarGroupPortlet extends UIPortletApplication
{
   public UIUserToolBarGroupPortlet() throws Exception
   {
   }

   public List<PageNavigation> getGroupNavigations() throws Exception
   {
      String remoteUser = Util.getPortalRequestContext().getRemoteUser();
      //List<PageNavigation> allNavigations = Util.getUIPortal().getNavigations();
      List<PageNavigation> allNavigations = Util.getUIPortalApplication().getNavigations();
      List<PageNavigation> navigations = new ArrayList<PageNavigation>();
      for (PageNavigation navigation : allNavigations)
      {
         if (navigation.getOwnerType().equals(PortalConfig.GROUP_TYPE))
         {
            navigations.add(PageNavigationUtils.filter(navigation, remoteUser));
         }
      }
      return navigations;
   }

   public PageNode getSelectedPageNode() throws Exception
   {
      return Util.getUIPortal().getSelectedNode();
   }
   
   public static class NavigationChangeActionListener extends EventListener<UIUserToolBarGroupPortlet>
   {
      @Override
      public void execute(Event<UIUserToolBarGroupPortlet> event) throws Exception
      {
         // This event is only a trick for updating the Toolbar group portlet
      }
   }
}