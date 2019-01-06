package com.offer.singleton;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * ����
 *
 * @author ly
 * @create 2019-01-06 16:24
 **/
public class Singleton {
    //˫�ؼ�鵥��
    static class DoubleCheckSingleton {

        //volatile�������������Ϊ�˷�ָֹ������
        //�ڶ��̻߳������������ָ�����ſ��ܵ��»�ȡ����û�г�ʼ����ɵĶ���
        //volatile������Ϊ�˱�֤�ɼ��� ��˫������������synchronized�Ѿ���֤�˿ɼ���
        private static volatile DoubleCheckSingleton doubleCheckSingleton;

        //��ֹʹ�ù��췽��ʵ��������
        private DoubleCheckSingleton(){}

        public static DoubleCheckSingleton getInstance(){
            if(doubleCheckSingleton == null){
                synchronized (DoubleCheckSingleton.class){
                    if(doubleCheckSingleton == null){
                        //����Ҳ��Ҫ�ж� ��Ϊ�������������߳�ͬʱ������
                        //һ���߳�ȡ������ʵ�����ö��� ��ô�����ڵȴ����߳��ڻ������Ͳ����ٴ�ʵ������
                        doubleCheckSingleton = new DoubleCheckSingleton();
                    }
                }
            }

            return doubleCheckSingleton;
        }
    }

    //����ʽ���� ��֤�̰߳�ȫ
    //�����ʱ�ʹ��� �����Ƿ�ʹ��
    static class HungrySingleton {
        private static HungrySingleton hungrySingleton = new HungrySingleton();

        private HungrySingleton(){}

        public static HungrySingleton getHungrySingleton() {
            return hungrySingleton;
        }
    }

    //ʹ���ڲ���ʵ�ֵ��� ����� ������ʹ�õ�ʱ��Żᴴ�� Ч��Ҳ�ϸ�
    //�Ƽ�ʹ��
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
        //ʹ��CycliBarrierģ��߲�������
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
