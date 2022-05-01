package com.sync;

public class SyncDemo {

    public static void main(String[] args) {

    }

    public void test(){
        synchronized (this) {
            System.out.println(1);
        }
    }/**/
}
