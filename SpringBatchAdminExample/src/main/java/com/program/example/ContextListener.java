package com.program.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.XmlWebApplicationContext;

//@Component
public class ContextListener implements ApplicationListener<ContextRefreshedEvent> {
	@Autowired
	private WebApplicationContext wac; // this context doesn't contain beans which are in sba-configuration.xml
	
	@Autowired
	private ThreadPoolTaskScheduler scheduler; // in sba-configuration.xml but doesn't have in wac. Spring still injects success.
	
	@Autowired
	private TestScheduler testScheduler;
	
	public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
		XmlWebApplicationContext context = contextRefreshedEvent.getSource() instanceof XmlWebApplicationContext ? (XmlWebApplicationContext) contextRefreshedEvent
				.getSource() : null;
		
		if (context != null && context.getNamespace().contains("Batch Servlet")) { // only work with my spring batch admin servlet
		
			CronTrigger trigger = new CronTrigger("*/5 * * * * *");
			scheduler.schedule(testScheduler, trigger);
		}
		
	}
	
}
