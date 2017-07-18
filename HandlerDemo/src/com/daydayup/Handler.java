package com.daydayup;

public abstract class Handler {
	private MessageQueue mQueue;
	private Looper mLooper;

	public Handler() {
		mLooper = Looper.myLooper();
		mQueue = mLooper.mQueue;
	}

	/**
	 * ������Ϣ������Ϣ�ӵ�������
	 * 
	 * @param message
	 */
	public void sendMessage(Message message) {
		message.target = this;
		mQueue.enqueueMessage(message);
	}

	/**
	 * ��looper����ѭ������dispatchMessage
	 * 
	 * @param message
	 */
	public void dispatchMessage(Message message) {
		handleMessage(message);
	}

	/**
	 * �ص�
	 * 
	 * @param message
	 */
	public abstract void handleMessage(Message message);
}
