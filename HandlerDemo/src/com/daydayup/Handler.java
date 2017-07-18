package com.daydayup;

public abstract class Handler {
	private MessageQueue mQueue;
	private Looper mLooper;

	public Handler() {
		mLooper = Looper.myLooper();
		mQueue = mLooper.mQueue;
	}

	/**
	 * 发送消息，将消息加到队列中
	 * 
	 * @param message
	 */
	public void sendMessage(Message message) {
		message.target = this;
		mQueue.enqueueMessage(message);
	}

	/**
	 * 在looper中死循环调用dispatchMessage
	 * 
	 * @param message
	 */
	public void dispatchMessage(Message message) {
		handleMessage(message);
	}

	/**
	 * 回调
	 * 
	 * @param message
	 */
	public abstract void handleMessage(Message message);
}
