package com.offer.singleton;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 单例
 *
 * @author ly
 * @create 2019-01-06 16:24
 **/
public class Singleton {
    //双重检查单例
    static class DoubleCheckSingleton {

        //volatile在这里的作用是为了防止指令重排
        //在多线程环境中如果存在指令重排可能导致获取到还没有初始化完成的对象
        //volatile并不是为了保证可见性 在双重锁的样例中synchronized已经保证了可见性
        private static volatile DoubleCheckSingleton doubleCheckSingleton;

        //禁止使用构造方法实例化对象
        private DoubleCheckSingleton(){}

        public static DoubleCheckSingleton getInstance(){
            if(doubleCheckSingleton == null){
                synchronized (DoubleCheckSingleton.class){
                    if(doubleCheckSingleton == null){
                        //这里也需要判断 因为可能两个或多个线程同时争夺锁
                        //一个线程取得锁后实例化该对象 那么另外在等待的线程在获得锁后就不能再次实例化了
                        doubleCheckSingleton = new DoubleCheckSingleton();
                    }
                }
            }

            return doubleCheckSingleton;
        }
    }

    //饿汉式单例 保证线程安全
    //类加载时就创建 不管是否使用
    static class HungrySingleton {
        private static HungrySingleton hungrySingleton = new HungrySingleton();

        private HungrySingleton(){}

        public static HungrySingleton getHungrySingleton() {
            return hungrySingleton;
        }
    }

    //使用内部类实现单例 代码简单 并且在使用的时候才会创建 效率也较高
    //推荐使用
    static class NestedSingleton {
        private static NestedSingleton nestedSingleton;

        private NestedSingleton(){}

        public static NestedSingleton getNestedSingleton() {
            return Nested.nestedSingleton;
        }

        static class Nested {
            static NestedSingleton nestedSingleton = new NestedSingleton();
        }
    }

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(20);
        //使用CycliBarrier模拟高并发环境
        final CyclicBarrier cyclicBarrier = new CyclicBarrier(20);
        for(int i=0;i<20;i++){
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        cyclicBarrier.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (BrokenBarrierException e) {
                        e.printStackTrace();
                    }
                    System.out.println(NestedSingleton.getNestedSingleton());
                }
            });
        }
        executorService.shutdown();
    }
}
