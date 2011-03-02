/*
 * Copyright (C) 2010 eXo Platform SAS.
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

package org.exoplatform.portal.mop.user;

import org.exoplatform.portal.mop.SiteKey;

import java.util.List;

/**
 * @author <a href="mailto:julien.viet@exoplatform.com">Julien Viet</a>
 * @version $Revision$
 */
public interface UserPortal
{

   /**
    * Returns the sorted list of current user navigations.
    *
    * @return the current user navigations
    * @throws Exception any exception
    */
   List<UserNavigation> getNavigations() throws Exception;

   /**
    * Returns a user navigation for a specified site key, null is returned when such navigation does not exist.
    *
    * @param key the site key
    * @return the corresponding user navigation
    * @throws Exception any exception
    */
   UserNavigation getNavigation(SiteKey key) throws Exception;

   /**
    * Returns the default navigation path.
    *
    * @return the default navigation path
    * @throws Exception any exception
    */
   NavigationPath getDefaultPath() throws Exception;

   /**
    * Resolves and returns a navigation path among all user navigations for a specified path.
    *
    * @param path the path
    * @return the navigation path
    * @throws Exception any exception
    */
   NavigationPath resolvePath(String path) throws Exception;

   /**
    * Resolves and returns a navigation path for the specified navigation and for a specified path.
    *
    * @param navigation the navigation
    * @param path the path
    * @return the navigation path
    * @throws Exception any exception
    */
   NavigationPath resolvePath(UserNavigation navigation, String path) throws Exception;

}