package com.react.aem.demo.core.models;

import com.adobe.cq.export.json.ComponentExporter;
import com.adobe.cq.export.json.ExporterConstants;
import com.adobe.cq.wcm.core.components.models.Image;
import com.day.cq.wcm.api.Page;
import com.day.cq.wcm.api.PageManager;
import org.apache.commons.lang3.StringUtils;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Exporter;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.Via;
import org.apache.sling.models.annotations.injectorspecific.ScriptVariable;
import org.apache.sling.models.annotations.injectorspecific.Self;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;
import org.apache.sling.models.annotations.via.ResourceSuperType;

import javax.annotation.PostConstruct;
import java.util.Calendar;

@Model(
     adaptables = SlingHttpServletRequest.class, adapters = {CardImpl.class, ComponentExporter.class},
     resourceType = CardImpl.RESOURCE_TYPE, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
@Exporter(
     name = ExporterConstants.SLING_MODEL_EXPORTER_NAME, extensions = ExporterConstants.SLING_MODEL_EXTENSION)
public class CardImpl implements Card {

    protected static final String RESOURCE_TYPE = "react-aem-demo/components/card";

    @ScriptVariable PageManager pageManager;
    @Self private SlingHttpServletRequest request;
    @Self @Via(type = ResourceSuperType.class) private Image image;
    @ValueMapValue private String cardPath;
    @ValueMapValue private String ctaText;
    @ValueMapValue private boolean titleFromPage;
    @ValueMapValue private String cardTitle;

    private Page cardPage;

    @PostConstruct
    // PostConstructs are called after all the injection has occurred, but before the Model object is returned for use.
    public void initModel() {
        if(StringUtils.isNotBlank(cardPath) && pageManager != null)
            cardPage = pageManager.getPage(this.cardPath);
    }

    @Override
    public String getSrc() {
        return null != image ? image.getSrc() : null;
    }

    @Override
    public String getAlt() {
        return null != image ? image.getAlt() : null;
    }

    @Override
    public String getTitle() {
        return null != image ? image.getTitle() : null;
    }

    @Override
    public String getCtaLinkURL() {
        return cardPage != null ? cardPage.getPath() + ".html" : null;
    }

    @Override
    public String getCtaText() {
        return ctaText;
    }

    @Override
    public Calendar getCardLastModified() {
        return (cardPage != null) ? cardPage.getLastModified() : null;
    }

    @Override
    public String getCardTitle() {
        if(titleFromPage)
            return cardPage != null ? cardPage.getTitle() : null;
        return cardTitle;
    }

    @Override
    public String getExportedType() {
        return CardImpl.RESOURCE_TYPE;
    }

}