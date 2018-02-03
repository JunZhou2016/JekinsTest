package com.example.quartz;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * Description : 定时任务调度配置类
 * @author JunZhou
 * @Time 2018年1月27日下午2:17:18
 */
@Component
public class TimedTask {
	/**
	 * Description :定时任务:每隔1分钟执行一次 (可配置) 服务订单营业时间内?分钟未接单自动取消订单并且实现退款功能(线上下单)
	 * 
	 * @author: 王晓祥
	 *
	 */
	@Scheduled(cron = "*/2 * * * * ?")
	public void serviceOrderTask() {
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("YY:MM:DD hh:mm:ss");
        String formatDataStr = sdf.format(date);
        System.out.println("|_"+formatDataStr);
	}

}
