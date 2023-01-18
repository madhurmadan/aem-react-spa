package com.react.aem.demo.core.models;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Exporter;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

import com.adobe.cq.export.json.ComponentExporter;
import com.adobe.cq.export.json.ExporterConstants;

@Model(
		adaptables = SlingHttpServletRequest.class,
		resourceType = EmailSubscriptionModel.RESOURCE_TYPE,
		adapters = {EmailSubscriptionModel.class, ComponentExporter.class },
		defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
@Exporter(
		name = ExporterConstants.SLING_MODEL_EXPORTER_NAME,
		extensions = ExporterConstants.SLING_MODEL_EXTENSION)
public class EmailSubscriptionModel implements ComponentExporter {
	protected static final String RESOURCE_TYPE = "react-aem-demo/components/emailSubscription";
	@ValueMapValue(name = "validationMessage")
	private String validationMessage;
	@ValueMapValue(name = "placeholder")
	private String placeholder;
	@ValueMapValue(name = "subscriptionTitle")
	private String subscriptionTitle;

	public String getValidationMessage() {
		return validationMessage;
	}

	public String getPlaceholder() {
		return placeholder;
	}

	public String getSubscriptionTitle() {
		return subscriptionTitle;
	}

	@Override
	public String getExportedType() {
		return RESOURCE_TYPE;
	}
}