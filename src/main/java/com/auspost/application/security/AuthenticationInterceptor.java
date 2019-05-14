package com.auspost.application.security;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

@Component
public class AuthenticationInterceptor extends HandlerInterceptorAdapter {
	private Logger logger = LoggerFactory.getLogger(AuthenticationInterceptor.class.getName());

	private static String AUTH_HEADER_NAME = "authorization";

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		String authToken = request.getHeader(AUTH_HEADER_NAME);
		if (authToken == null) {
			logger.info("Missing authorization token");
			response.setStatus(HttpStatus.FORBIDDEN.value());
			return false;
		}
		logger.info("----Authorization Successful----");

		return true;
	}

}
