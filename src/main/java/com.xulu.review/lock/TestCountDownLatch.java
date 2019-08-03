package com.xulu.review.lock;

import java.util.concurrent.CountDownLatch;

/**
 * CountDownLatch:闭锁，在完成某些运算时，只有其他所有线程的运算全部完成时，当前运算才能继续进行
 * @author xulu
 * @date 2019/5/15
 * @link https://github.com/xulu163
 */
public class TestCountDownLatch {

    public static void main(String[] args) throws Exception{
        CountDownLatch latch = new CountDownLatch(4);

        for(int i = 1; i <= 4; i++){
            new Thread(()->{
               System.out.println(Thread.currentThread().getName()+"\t");
               latch.countDown();
            },SeasonEnum.forEach(i).getMsg()).start();
        }
        latch.await();
        System.out.println(Thread.currentThread()+"\t 结束");

    }

}

enum SeasonEnum{
    ONE(1,"春"),TWO(2,"夏"),THREE(3,"秋"),FOUR(4,"冬");

    private int code;
    private String msg;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    SeasonEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public static SeasonEnum forEach(int code){
        SeasonEnum[] array = SeasonEnum.values();
        for(SeasonEnum element : array){
            if(code == element.getCode()){
                return element;
            }
        }
        return null;
    }


}