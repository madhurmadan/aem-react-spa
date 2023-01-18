package com.react.aem.demo.core.models;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

import javax.inject.Inject;

@Model(adaptables = Resource.class, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class BlogItems {

   @ValueMapValue private String blogTitle;
   @Inject private String blogSubTitle;
   @Inject private String blogDescription;
   @Inject private String blogLinkUrl;
   @Inject private String blogImage;
   @Inject private String blogLinkTarget;

   public String getBlogTitle() {
      return blogTitle;
   }

   public String getBlogSubTitle() {
      return blogSubTitle;
   }

   public String getBlogDescription() {
      return blogDescription;
   }

   public String getBlogLinkUrl() {
      return blogLinkUrl;
   }

   public String getBlogImage() {
      return blogImage;
   }

   public boolean isBlogLinkTarget() {
      return Boolean.valueOf(blogLinkTarget);
   }
}