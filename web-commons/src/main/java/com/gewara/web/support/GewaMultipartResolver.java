package com.gewara.web.support;

import javax.servlet.http.HttpServletRequest;

import org.springframework.util.Assert;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.multipart.MultipartException;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.multipart.support.DefaultMultipartHttpServletRequest;

import com.gewara.util.GewaLogger;
import com.gewara.util.WebLogger;

public class GewaMultipartResolver extends CommonsMultipartResolver{
	private final transient GewaLogger dbLogger = WebLogger.getLogger(getClass());
	@Override
	public MultipartHttpServletRequest resolveMultipart(final HttpServletRequest request) throws MultipartException {
		Assert.notNull(request, "Request must not be null");
		if(!isMultipart(request)) {
            return new ErrorMultipartRequest(request, "������ѡ���ļ��ϴ���");
        }
		try{
			MultipartParsingResult parsingResult = parseRequest(request);
			return new DefaultMultipartHttpServletRequest(request, parsingResult.getMultipartFiles(), 
					parsingResult.getMultipartParameters(), parsingResult.getMultipartParameterContentTypes());
		}catch(MaxUploadSizeExceededException e){
			return new ErrorMultipartRequest(request, "�ļ���С������Χ��");
		}catch(Exception e){
			dbLogger.warn("", e);
			return new ErrorMultipartRequest(request, "�ϴ����ִ���");
		}
	}
}
