package com.react.aem.demo.core.models;

import java.util.Collection;

import javax.annotation.PostConstruct;
import com.adobe.cq.export.json.ComponentExporter;
import com.adobe.cq.export.json.ExporterConstants;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Exporter;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ChildResource;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

@Model(
	adaptables = SlingHttpServletRequest.class, adapters = {TileModel.class, ComponentExporter.class},
	resourceType = TileModel.RESOURCE_TYPE, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
@Exporter(
   name = ExporterConstants.SLING_MODEL_EXPORTER_NAME, extensions = ExporterConstants.SLING_MODEL_EXTENSION)
public class TileModel  implements ComponentExporter {
	protected static final String RESOURCE_TYPE = "react-aem-demo/components/tile";	
	@ValueMapValue private String title;
	@ValueMapValue private String subTitle;
	@ValueMapValue private String quotes;
	@ValueMapValue private String layout;
	@ChildResource Collection<TileItem> tileItems;

	@PostConstruct
   protected void init() {
      tileItems = CollectionUtils.emptyIfNull(this.tileItems);
   }
	
	public String getTitle() {
		return title;
	}

	public String getSubTitle() {
		return subTitle;
	}

	public Boolean isQuotes() {
		return Boolean.valueOf(quotes);
	}

	public String getLayout() {
		return layout;
	}

	public Collection<TileItem> getTileItems() {		
		return tileItems;
	}

	@Override
	public String getExportedType() {		
		return RESOURCE_TYPE;
	}

}
