package com.daydayup;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

/**
 * Created by jiaokx on 2016/9/8.
 */
public class ExecutorServices {
    private static ExecutorServices instance = null;
    private ExecutorService mExeFixedThread = null;
    private ExecutorService mExeCachedThread = null;
    public static ExecutorServices getInstance(){
        if (instance == null){
            synchronized (ExecutorServices.class){
                if (instance == null){
                    instance = new ExecutorServices();
                }
            }
        }
        return instance;
    }

    public void initFixedThreadPool(final int count){
        mExeFixedThread = Executors.newFixedThreadPool(count);
    }
    // 返回固定线程数量的线程池对象
    public ExecutorService getFixedThreadPool(){
        return mExeFixedThread;
    }
    // 返回缓存功能的线程池对象
    public ExecutorService getCachedThreadPool(){
        if (mExeCachedThread == null){
            mExeCachedThread = Executors.newCachedThreadPool();
        }
        return mExeCachedThread;
    }
}