package com.xulu.review.lock;

import java.util.concurrent.Callable;

/**
 * @author xulu
 * @date 2019/5/15
 * @link https://github.com/xulu163
 */
public class VolatileDemo {
    //volatile可以保证当多个线程操作共享数据时，内存的数据是可见的

}

class ThreadDemo implements Runnable {

    @Override
    public void run(){

    }
}

class ThreadDemo2 implements Callable{

    @Override
    public Object call() throws Exception {
        return null;
    }
}
