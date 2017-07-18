package com.daydayup;

import javax.management.RuntimeErrorException;

public class Looper {
	static final ThreadLocal<Looper> sThreadLocal = new ThreadLocal<Looper>();
	static final MessageQueue mQueue = new MessageQueue();

	private Looper() {

	}

	// ��ʼ��Looper������TheadLocal�������ڽ�thread��Looper���н��
	public static void prepare() {
		// ���ȥ����Ϊ�վ�˵���Ѿ�������Looper��ÿ���߳�ֻ�ܴ���һ��Looper
		if (sThreadLocal.get() != null) {
			throw new RuntimeException("ÿ���߳�ֻ�ܴ���һ��Looper");
		}
		sThreadLocal.set(new Looper());
	}

	/**
	 * ��ȡLooper����
	 * 
	 * @return
	 */
	public static Looper myLooper() {
		return sThreadLocal.get();
	}

	/**
	 * �ؼ���������ͣ�شӶ�����ȥ����Ϣ��
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
