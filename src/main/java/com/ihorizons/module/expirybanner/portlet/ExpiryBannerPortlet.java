package com.ihorizons.module.expirybanner.portlet;

import com.ihorizons.module.expirybanner.constants.ExpiryBannerPortletKeys;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;

/**
 * @author Doaa.Farouk
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.header-portlet-css=/css/main.css",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=ExpiryBanner",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"action-url-redirect=true",
		"javax.portlet.name=" + ExpiryBannerPortletKeys.EXPIRYBANNER,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user", "expiry_date=2024-05-30"
	},
	service = Portlet.class
)
public class ExpiryBannerPortlet extends MVCPortlet {
	
	@Override
	public void render(RenderRequest renderRequest, RenderResponse renderResponse)
	    throws PortletException, IOException {
		//read expiry from properties file
		Properties props = new Properties();
		InputStream input = new FileInputStream("D:/config/my.properties");
        props.load(input);
        String expiry=props.getProperty("expiry");
        System.out.println(">>>>>>>>>>>props.expiry: "+expiry);
        input.close();
        
        //set response param
        renderRequest.setAttribute("expiry", expiry);
        
        super.render(renderRequest, renderResponse);
	}
	
	
}
