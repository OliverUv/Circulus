/**
 * Copyright 2010 ArcBees Inc.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */

package org.oliveruv.circulus.client;

import org.oliveruv.circulus.client.resources.BundledResources;

import com.google.gwt.inject.client.AbstractGinModule;
import com.google.inject.Singleton;

public class InjectionModule extends AbstractGinModule {

  protected void configure() {
    //bind(EventBus.class).to(SimpleEventBus.class).in(Singleton.class);
    
    bind(QuerySelector.class).in(Singleton.class);
    bind(BundledResources.class).in(Singleton.class);
    bind(SizeManager.class).in(Singleton.class);
    
    
  }
}