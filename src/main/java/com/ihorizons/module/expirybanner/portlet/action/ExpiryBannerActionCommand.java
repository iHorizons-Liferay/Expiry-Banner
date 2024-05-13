package com.ihorizons.module.expirybanner.portlet.action;

import com.ihorizons.module.expirybanner.constants.ExpiryBannerPortletKeys;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.Properties;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;

@Component(
		immediate = true,
		property = {
				"javax.portlet.name="+ExpiryBannerPortletKeys.EXPIRYBANNER,
				"mvc.command.name=handleForm"
		},
		service = MVCActionCommand.class
		)
public class ExpiryBannerActionCommand extends BaseMVCActionCommand{

	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		String expiryDate=actionRequest.getParameter("expiry");
		
		//persist the expiry property in a file
		Properties props = new Properties();
//		ClassLoader classLoader = ClassLoader.getSystemClassLoader();
//		props.load(classLoader.getResourceAsStream("com/ihorizons/props/my.properties"));
		props.setProperty("expiry", expiryDate);
		FileOutputStream fos = new FileOutputStream("D:/config/my.properties");
		props.store(fos,null);
        fos.flush();
        fos.close();
        
		//redirect the param and response to the Banner page: page2.jsp
		//actionResponse.setRenderParameter("expiry", expiryDate);
        actionResponse.setRenderParameter("status", "Expiry date saved successfully");
		//actionResponse.sendRedirect("page2.jsp");
		//actionResponse.setRenderParameter("jspPage","/page2.jsp");
	}

}
