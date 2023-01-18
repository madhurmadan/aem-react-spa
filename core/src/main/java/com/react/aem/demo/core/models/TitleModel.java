package com.react.aem.demo.core.models;

import com.adobe.cq.export.json.ComponentExporter;
import com.adobe.cq.export.json.ExporterConstants;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Exporter;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

@Model(
     adaptables = SlingHttpServletRequest.class,
            adapters = {TitleModel.class, ComponentExporter.class},
     resourceType = TitleModel.RESOURCE_TYPE,
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
@Exporter(
     name = ExporterConstants.SLING_MODEL_EXPORTER_NAME,
        extensions = ExporterConstants.SLING_MODEL_EXTENSION)
public class TitleModel implements ComponentExporter {

   protected static final String RESOURCE_TYPE = "react-aem-demo/components/title";

   @ValueMapValue
   private String title;

   public String getTitle() {
       return title;
   }

   @Override
   public String getExportedType() {
       return RESOURCE_TYPE;
   }

}