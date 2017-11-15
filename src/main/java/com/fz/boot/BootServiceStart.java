package com.fz.boot;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ImportResource;

import com.fz.abaoworld.filter.MemberLoginFilter;
import com.fz.abaoworld.filter.WebFilter;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@ImportResource({"classpath:spring/spring.xml"})
public class BootServiceStart implements EmbeddedServletContainerCustomizer{
	
	private final static Logger logger = LoggerFactory.getLogger(BootServiceStart.class);
	
	@Value("${abao.http.port}") 
	private int httpPort;
	
	public static void main(String[] args) throws InterruptedException {
		
	long start=System.currentTimeMillis();
		
	 ApplicationContext ctx = new SpringApplicationBuilder()
               .sources(BootServiceStart.class)
               .web(true)  //开启web服务
               .run(args);
	 
		long end=System.currentTimeMillis();
		
		logger.info("abaoworld启动成功,耗时：{} ms",end-start);
     
	}

	@Override
	public void customize(ConfigurableEmbeddedServletContainer container) {
		container.setPort(httpPort);//指定web端口
	}

	@Bean
	public WebFilter WebFilter(){
		
		return new WebFilter();
		
	}
	
	@Bean
	public MemberLoginFilter memberLoginFilter() {
		return new MemberLoginFilter();
	}
	
}
