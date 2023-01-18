package com.react.aem.demo.core.models;

import com.adobe.cq.export.json.ComponentExporter;
import com.adobe.cq.export.json.ExporterConstants;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Exporter;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ChildResource;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

import javax.annotation.PostConstruct;
import java.util.Collection;

@Model(
   adaptables = SlingHttpServletRequest.class, adapters = {BlogsModel.class, ComponentExporter.class},
   resourceType = BlogsModel.RESOURCE_TYPE, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
@Exporter(
   name = ExporterConstants.SLING_MODEL_EXPORTER_NAME, extensions = ExporterConstants.SLING_MODEL_EXTENSION)
public class BlogsModel implements ComponentExporter {
   protected static final String RESOURCE_TYPE = "react-aem-demo/components/blogs";
   @ValueMapValue private String title;
   @ValueMapValue private String subtitle;
   @ValueMapValue private String desc;
   @ChildResource Collection<BlogItems> blogItems;

   @PostConstruct
   protected void init() {
      blogItems = CollectionUtils.emptyIfNull(this.blogItems);
   }

   public String getTitle() {
      return title;
   }

   public String getDesc() {
      return desc;
   }
   public String getSubtitle() {
      return subtitle;
   }

   public Collection<BlogItems> getBlogItems() {
      return blogItems;
   }

   @Override
   public String getExportedType() {
      return RESOURCE_TYPE;
   }
}