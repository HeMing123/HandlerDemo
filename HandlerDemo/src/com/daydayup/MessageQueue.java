package com.daydayup;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class MessageQueue {
	/**
	 * 将消息添加到队列中
	 */
	BlockingQueue<Message> mQueue = new ArrayBlockingQueue<Message>(50);
	public void enqueueMessage(Message message){
		try {
			mQueue.put(message);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public Message next(){
		Message msg= null;
		try {
			msg =  mQueue.take();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return msg;
	}
}
