package com.react.aem.demo.core.models;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

import javax.inject.Inject;

@Model(adaptables = Resource.class, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class LinksItems {

   @ValueMapValue private String linkText;
   @Inject private String linkUrl;
   @Inject private String imageUrl;
   @Inject private String altText;
   @Inject private String linkCheckbox;

   public String getLinkText() {
      return linkText;
   }

   public String getLinkUrl() {
      return linkUrl;
   }

   public String getImageUrl() {
      return imageUrl;
   }

   public String getAltText() {
      return altText;
   }

   public boolean isLinkCheckbox() {
      return Boolean.valueOf(linkCheckbox);
   }
}