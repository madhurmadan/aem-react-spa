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
   adaptables = SlingHttpServletRequest.class, adapters = {TablinksModel.class, ComponentExporter.class},
   resourceType = TablinksModel.RESOURCE_TYPE, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
@Exporter(
   name = ExporterConstants.SLING_MODEL_EXPORTER_NAME,extensions = ExporterConstants.SLING_MODEL_EXTENSION)
public class TablinksModel implements ComponentExporter {
   protected static final String RESOURCE_TYPE = "react-aem-demo/components/tabLinks";
  
   @ChildResource private Collection<TablinksItems> tabs;

   @PostConstruct
   protected void init() {
      tabs = CollectionUtils.emptyIfNull(this.tabs);
   }

   public Collection<TablinksItems> getTabs() {
		return tabs;
	}
   
   @Override
   public String getExportedType() {
      return RESOURCE_TYPE;
   }
}