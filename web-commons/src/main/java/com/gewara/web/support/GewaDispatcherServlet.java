package com.gewara.web.support;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.web.servlet.DispatcherServlet;

import com.gewara.util.BaseWebUtils;
import com.gewara.util.GewaLogger;
import com.gewara.util.WebLogger;

public class GewaDispatcherServlet extends DispatcherServlet {
	private static final long serialVersionUID = 8852617763890075853L;
	private final transient GewaLogger dbLogger = WebLogger.getLogger(getClass());
	@Override
	protected void noHandlerFound(HttpServletRequest request, HttpServletResponse response) throws Exception {
		dbLogger.warnWithType("pageNotFound", 
				"uri=" + request.getRequestURL().toString() + 
				", params=" + BaseWebUtils.getParamStr(request, true) +
				", header=" + BaseWebUtils.getHeaderStr(request)
		);
		ResourceStatsUtil.addUrlNoHandler(request.getRequestURI());
		response.sendError(404);
	}
	
	@Override
	protected void initFrameworkServlet() throws ServletException {
		WebAppPostProcessor initiator = null;
		try{
			initiator = this.getWebApplicationContext().getBean(WebAppPostProcessor.class);
		}catch(NoSuchBeanDefinitionException e){
			
		}catch(Exception e){
			logger.warn("", e);
		}
		if(initiator!=null){
			logger.warn("start customer FrameworkServlet..." + initiator.getClass());
			initiator.init();
		}
	}
	
}
