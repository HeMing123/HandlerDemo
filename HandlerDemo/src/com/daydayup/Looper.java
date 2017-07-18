package com.daydayup;

import javax.management.RuntimeErrorException;

public class Looper {
	static final ThreadLocal<Looper> sThreadLocal = new ThreadLocal<Looper>();
	static final MessageQueue mQueue = new MessageQueue();

	private Looper() {

	}

	// 初始化Looper，创建TheadLocal对象，用于将thread和Looper进行结合
	public static void prepare() {
		// 如果去除不为空就说明已经创建了Looper，每个线程只能创建一个Looper
		if (sThreadLocal.get() != null) {
			throw new RuntimeException("每个线程只能创建一个Looper");
		}
		sThreadLocal.set(new Looper());
	}

	/**
	 * 获取Looper对象
	 * 
	 * @return
	 */
	public static Looper myLooper() {
		return sThreadLocal.get();
	}

	/**
	 * 关键方法，不停地从队列中去除消息。
	 */
	public static void loop(){
		Looper me = myLooper();
		MessageQueue queue = me.mQueue;
		for(;;){
			Message message = queue.next();
			if(message != null){
				message.target.dispatchMessage(message);
			}
		}
	}
}
