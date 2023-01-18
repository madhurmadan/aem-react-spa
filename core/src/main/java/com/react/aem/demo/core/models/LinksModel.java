package com.react.aem.demo.core.models;

import com.adobe.cq.export.json.ComponentExporter;
import com.adobe.cq.export.json.ExporterConstants;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Exporter;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ChildResource;

import javax.annotation.PostConstruct;
import java.util.Collection;

@Model(
   adaptables = SlingHttpServletRequest.class, adapters = {LinksModel.class, ComponentExporter.class},
   resourceType = LinksModel.RESOURCE_TYPE, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
@Exporter(
   name = ExporterConstants.SLING_MODEL_EXPORTER_NAME, extensions = ExporterConstants.SLING_MODEL_EXTENSION)
public class LinksModel implements ComponentExporter {
   protected static final String RESOURCE_TYPE = "react-aem-demo/components/links";
   
   @ChildResource Collection<LinksItems> linkItems;

   @PostConstruct
   protected void init() {
      linkItems = CollectionUtils.emptyIfNull(this.linkItems);
   }

   public Collection<LinksItems> getLinkItems() {
      return linkItems;
   }

   @Override
   public String getExportedType() {
      return RESOURCE_TYPE;
   }
}