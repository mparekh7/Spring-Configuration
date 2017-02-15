xml based configuration::

web.xml

<web-app>
	<display-name>Archetype Created Web Application</display-name>
	 <servlet> 
	 <servlet-name>springrest</servlet-name> 
	 <servlet-class> org.springframework.web.servlet.DispatcherServlet </servlet-class>
		<load-on-startup>1</load-on-startup>
		</servlet>
		<servlet-mapping> 
		<servlet-name>springrest</servlet-name>
		<url-pattern>/</url-pattern> 
		</servlet-mapping> 
</web-app>
-------------------------------------------
springrest-servlet.xml

<beans xmlns="http://www.springframework.org/schema/beans"
	xmlns:context="http://www.springframework.org/schema/context"
	xmlns:mvc="http://www.springframework.org/schema/mvc" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xsi:schemaLocation=" http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans-3.0.xsd http://www.springframework.org/schema/context 
        http://www.springframework.org/schema/context/spring-context-3.0.xsd http://www.springframework.org/schema/mvc http://www.springframework.org/schema/mvc/spring-mvc-3.0.xsd">

	 <mvc:annotation-driven /> 
	 <context:component-scan base-package="com.demo.app"/> 
</beans>

======================================================================================================================
Annotation based configuration::

AppConfig and AppInitializer classes needed:

AppConfig.class

@Configuration
@EnableWebMvc // equals to <mvc:annotation-driven /> 
@ComponentScan(basePackages = "com.demo.app") // equals to <context:component-scan base-package="com.demo.app"/> 
public class AppConfig {

	@Bean
	public ViewResolver viewResolver() { // this method not required if you dont want to use jsp pages
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setViewClass(JstlView.class);
		viewResolver.setPrefix("/WEB-INF/views/");
		viewResolver.setSuffix(".jsp");
		return viewResolver;
	}

	@Bean
	public MessageSource messageSource() { // not necessary
		ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
		messageSource.setBasename("messages");
		return messageSource;
	}

}
----------------------------------------------------------------------------------
AppInitializer.class (2 ways)

package com.demo.app.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import com.demo.app.spring.AppConfig;

//public class AppInitializer implements WebApplicationInitializer {
// 
//    public void onStartup(ServletContext container) throws ServletException {
// 
//        AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext();
//        ctx.register(AppConfig.class);
//        ctx.setServletContext(container);
// 
//        ServletRegistration.Dynamic servlet = container.addServlet(
//                "dispatcher", new DispatcherServlet(ctx));
// 
//        servlet.setLoadOnStartup(1);
//        servlet.addMapping("/");
//    }
// 
//}

public class AppInitializer extends
		AbstractAnnotationConfigDispatcherServletInitializer {

<!-- 
for <servlet> 
	 <servlet-name>springrest</servlet-name> 
	 <servlet-class> org.springframework.web.servlet.DispatcherServlet </servlet-class>
		<load-on-startup>1</load-on-startup>
		</servlet>
		<servlet-mapping> 
		<servlet-name>springrest</servlet-name>
		<url-pattern>/</url-pattern> 
		</servlet-mapping> 
-->
	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class[] { AppConfig.class };
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return null;
	}

	@Override
	protected String[] getServletMappings() {
		return new String[] { "/" };
	}

}
