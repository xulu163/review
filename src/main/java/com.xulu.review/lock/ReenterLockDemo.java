package com.xulu.review.lock;

public class ReenterLockDemo {

    public static void main(String[] args){

    }

}

class Phone{

    public synchronized void sendSms(){
        System.out.println("sendSms");
        sendMail();
    }

    public synchronized void sendMail(){
        System.out.println();
        sendSms();
    }




}