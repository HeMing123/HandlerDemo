package com.daydayup;

import java.util.UUID;

public class MainThread {
	
	public static void main(String[] args) {
		ExecutorServices.getInstance().initFixedThreadPool(20);
		Looper.prepare();
		final Handler h = new Handler() {

			@Override
			public void handleMessage(Message message) {
				System.out.println(Thread.currentThread()+"--"+message.msg);
			}
		};
		for (int i = 0; i < 20; i++) {
			ExecutorServices.getInstance().getFixedThreadPool().execute(new Runnable() {
				
				public void run() {
					for (int j = 0; j < 30; j++) {
						Message msg = new Message(UUID.randomUUID().toString());
						h.sendMessage(msg);
						System.out.println(Thread.currentThread()+"--"+msg.msg);
					}
					
				}
			});
		}
		
//		new Thread(new Runnable() {
//
//			public void run() {
//				ExecutorServices.getInstance().getFixedThreadPool().
//				h.sendMessage(new Message(UUID.randomUUID().toString()));
//			}
//		}).start();
		Looper.loop();

	}
}
