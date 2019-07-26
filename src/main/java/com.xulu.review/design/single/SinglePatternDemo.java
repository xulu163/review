package com.xulu.review.design.single;

/**
 * 单例模式
 *
 * @author xulu  E-mail:java_xul@163.com
 * @version 1.0
 * @create 2019-07-21 22:28
 **/
public class SinglePatternDemo {

    public static void main(String[] args) {

        /**
         * 单例模式注意事项和细节说明
         * 1）单例模式保证了系统内存中该类只存在一个对象，节省了系统资源，对于一些需要频繁创建
         * 销毁的对象，使用单例模式可以提高系统性能
         * 2）当想实例化一个单例模式的时候，必须要记住使用相应的获取对象的方法，而不是使用new
         * 3）单例模式使用的场景：需要频繁的进行创建和销毁的对象、创建对象时耗时过多或耗费资源
         * 过多，但又经常用到的对象、工具类对象、频繁访问数据库或文件的对象。
         */
    }


}

//饿汉式（静态变量）
class SingleType0 {

    //构造器私有化，外部不能new
    private SingleType0(){}

    private final static SingleType0 instance = new SingleType0();

    public static SingleType0 getInstance(){
        return instance;
    }

    /**
     * 优缺点说明：
     * 1）优点：这种写法比较简单，就是在类装载的时候就完成实例化，避免了线程同步问题。
     * 2）缺点：在类装载的时候就完成实例化，没有达到懒加载的效果，如果从始至终没有使用过这个实例，
     * 则会造成内存浪费。
     */

}

//饿汉式（静态代码块）
class SingleType1 {

    private SingleType1(){}

    private static SingleType1 instance;

    static {
        instance = new SingleType1();
    }

    public static SingleType1 getInstance(){
        return instance;
    }

    /**
     * 优缺点说明：
     * 这种方式跟第一种类似，只不过将类的实例化的过程放在了静态代码块中，也是在类加载的时候，就执行静态
     * 代码块中的代码，初始化类的实例，优缺点跟上面是一样的。
     * 结论：这种单例模式可用，但是可能造成内存浪费。
     */
}


/**
 * 懒汉式
 */
class SingleType2 {
    private static SingleType2 instance;

    private SingleType2(){}

    /**
     * 提供一个静态的共有方法，当使用该方法时，才去创建instance
     * @return
     */
    public static SingleType2 getInstance(){
        if(null == instance){
            instance = new SingleType2();
        }
        return instance;
    }

    /**
     * 优缺点说明：
     * 1）起到了懒加载的效果，但是只能在单线程下使用。
     * 2）如果在多线程下，可能会产生多个实例
     * 3）结论：在实际开发中，不要使用这种方式。
     */
}

/**
 * 懒汉式（线程安全，同步方法）
 */
class SingleType3 {
    private static SingleType3 instance;

    private SingleType3(){}

    /**
     * 加入了同步处理的代码
     */
    public static synchronized SingleType3 getInstance(){
        if(null == instance){
            instance = new SingleType3();
        }
        return instance;
    }

    /**
     * 优缺点说明：
     * 1）解决了线程不安全的问题
     * 2）方法进行同步效率太低了
     * 3）结论：在实际开发中，不推荐使用这种方法
     */

}

/**
 * 双重检查
 */
class SingleType4 {

    private static volatile SingleType4 instance;

    private SingleType4(){}

    /**
     * 双重检查方式，解决线程安全问题，同时解决懒加载问题
     */
    public static SingleType4 getInstance(){
        if(null == instance){
            synchronized (SingleType4.class){
                if(null == instance){
                    instance = new SingleType4();
                }
            }
        }
        return instance;
    }

}

