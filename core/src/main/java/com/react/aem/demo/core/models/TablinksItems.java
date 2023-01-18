package com.react.aem.demo.core.models;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ChildResource;

import java.util.Collection;

import javax.inject.Inject;

@Model(adaptables = Resource.class, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class TablinksItems {

   @Inject private String title;
   @ChildResource private Collection<LinksItems> linkItems;   

   public String getTitle() {
      return title;
   }

   public Collection<LinksItems> getLinkItems() {
      return linkItems;
   }


}