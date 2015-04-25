package com.prayogshaale.passwordmanagement.configuration;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class PasswordManagementInitializer implements WebApplicationInitializer {

	

	        public void onStartup(ServletContext container) throws ServletException
	        {
	                AnnotationConfigWebApplicationContext rootContext = new AnnotationConfigWebApplicationContext();
	                rootContext.register(WebMvcConfig.class);

	                container.addListener(new ContextLoaderListener(rootContext));

	                AnnotationConfigWebApplicationContext dispatcherContext = new AnnotationConfigWebApplicationContext();
	                dispatcherContext.register(DIConfiguration.class);

	                ServletRegistration.Dynamic dispatcherServlet =
	                        container.addServlet("dispatcherServlet", new DispatcherServlet(dispatcherContext));
	                dispatcherServlet.setLoadOnStartup(1);
	                dispatcherServlet.addMapping("/");
	        }

	}

