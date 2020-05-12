package com.fivefu.apply.config;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;

@Configuration
public class SchedulingConfiguration implements SchedulingConfigurer{

	/**
	 * 定时任务配置线程池
	 * @return
	 */
	@Override
	public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
		
		//默认是一个线程
		taskRegistrar.setScheduler(Executors.newScheduledThreadPool(3000));
		// TODO Auto-generated method stub
		taskRegistrar.setScheduler(new ScheduledThreadPoolExecutor(Runtime.getRuntime().availableProcessors(),
                new ThreadFactory() {
                    @Override
                    public Thread newThread(Runnable r) {
                        return new Thread(r,"my-schedule");
                    }
                })
	    );
	}

}
