package com.chenjw.review.singleton_demo;

/**
 *  枚举类实现单例模式  可防止反序列化
 */
public enum SingletonFactoryMostPrefect {

    /**
     * 枚举类实现单例模式
     */
    INSTANCE;

    public static void main(String[] args) {
        for (int i = 0 ; i < 100 ; i++){
            new Thread(() -> {
                SingletonFactoryMostPrefect instance = SingletonFactoryMostPrefect.INSTANCE;
                System.out.println(instance.hashCode());;
            }).start();
        }
    }
}



