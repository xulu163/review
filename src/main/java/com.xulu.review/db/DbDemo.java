package com.xulu.review.db;

/**
 * 数据库方面
 *
 * @author xulu  E-mail:java_xul@163.com
 * @version 1.0
 * @create 2019-07-17 08:48
 **/
public class DbDemo {

    /**
     * 索引：
     *      索引是帮助mysql高校获取数据的排好序的数据结构，索引存储在文件里！
     *
     * 索引结构：
     *      二叉树
     *      红黑树
     *      hash
     *      btree
     *
     *
     * 二叉数在实现索引的问题：如果二叉树维护的是单边增长的数据，那就完蛋了，效率跟没有索引是一样的。
     *
     * 红黑树解决了二叉树实现索引的问题：红黑树当单边高度超过三个节点时会做一次平衡转换，转换后
     *      三个节点会转换成一个二叉树。
     * 红黑树在实现索引时的弊端：一旦表的数据量大了以后，树的高度很深，很深的话磁盘io很多。
     *
     * BTree：b树，通过增加横向节点的数据来减少树的高度。
     *  1。度：节点的数据存储个数
     *  2。叶节点具有相同的深度
     *  3。叶节点的指针为空
     *  4。节点中的数据key从左到右递增排列
     *
     * B+Tree：bTree的变种
     *  1。非叶子节点不存储data，只存key，可以增大度
     *  2。叶子节点不存储指针，指针就是下一个节点在磁盘文件上的地址
     *  3。顺序访问指针，提高区间访问的性能
     *
     *
     *
     */

    /**
     * mysql的innodb和mylsam数据引擎的区别？一个db中不同的表可以有不同的存储引擎
     *
     *  1、innodb支持事务，且默认是autocommit，所以每一条sql语句都会封装成一个事务，
     * 如果执行多条sql，最好加上begin和commit；mylsam不支持事务，也就无法回滚；
     *  2、innodb支持行锁，mylsam进行写操作会全表上锁，所以mylsam的写操作性能会差些；
     *  3、在查询较多的表中，使用mylsam引擎较好；写比较多的表，使用innodb；
     *  4、innodb的数据是存储在索引的叶子节点的，它的主键索引叫聚集索引；mylsam的主键索引叫非
     *  聚集索引，它是在叶子节点中存储数据行的物理地址
     *
     *
     */

    /**
     * 复合索引问题？
     *
     *  创建一个a、b、c三个字段的复合索引，相对于维护三个单字段索引，维护一个复合索引
     * 的开销更低。但是，复合索引需要满足一个最左匹配原则，也就是它会依次查找a、b、c三个字段，当
     * 左边的字段未作为判断条件时，就不会再去执行接下来的索引了。
     */

    /**
     * 面试题：
     * 1）为什么innodb的表必须要有主键，并且推荐使用整形自增主键？
     *      1。不宜用字符串，因为插入的时候默认会走索引按顺序去插入，整形数据有利于比较，提高插入的效率
     *      2。如果不是自增，会造成节点的分裂、平衡，会比较耗性能。
     *
     * 2）为什么b+树的索引要有指针呢？
     *
     *
     * 3）为什么索引算法不实用hash算法呢？
     * hash算法将索引字段做一个hash函数，得到一个值与数据行在磁盘文件上的地址对应
     * 因为范围查找做不到！
     *
     * 不手动建主键mysql会默认帮你建一个主键，并有主键索引
     */

    /**
     * mysql优化
     * explain
     *
     */


    /**
     * 如果网站性能慢，cpu没有达到满负荷，硬盘没有满负荷，网络没有达到满负荷，那么瓶颈在数据库。
     */

    /**
     * 1。优化sql，explain查看每个sql的索引使用情况
     * 2。主从架构，读写分离（会有数据一致性的问题）
     * 3。引入redis缓存
     * 4。分库分表
     */

    /**
     * mysql主从架构的数据一致性问题？
     *
     *  1）在主库事务提交的时候，同时发起两个操作，操作一是将日志写到本地磁盘，操作二是将日志同步
     * 到从库并确保落盘；
     *  2）主库此时等待两个擦欧哦全部成功之后，才返回给应用程序，事务提交成功；当有多个从库的时候
     * 为了提升性能，只要有一个从库返回日志落盘成功，在主库日志已落盘的情况下，我们即可返回应用程
     * 序提交事务成功。
     *
     * 如何保证主从架构的高可用性呢？
     *  HA检测工具应运而生：HA工具一般部署在第三台服务器上，同时连接主从，检测主从是否存活，如果主库
     * 宕机则即使将从库升级为主库，将原来的主库降级为从库，具体操作如下：
     *  主机宕机后，HA探测到，发起一个将从库提升为主库的操作，新的主库对外提供服务，此时，由于主备的
     * 数据是通过日志强同步的，因此数据并没有丢失，数据一致性得到保证。
     *
     * HA软件自身的可用性我们如何保障呢？
     *   增加HA服务，由一台HA主机变为多台HA主机。
     *   HA服务，本身是无状态的，多台HA主机，可以通过Paxos？Raft进行自动选主
     */

    /**
     * binlog：
     * mysql的二进制日志可以说是mysql最重要的日志了，它记录了多有的ddl和dml（除了查询以外）的语句，
     * 以事件的形式记录，还包含语句执行的消耗时间，mysql的二进制日志是事务安全型的。
     *
     * binlog有两个使用场景：
     * 1）主从复制在master端开启binlog，master把它的binlog日志传递给slaves来达到主从数据一致的目的。
     * 2）数据恢复，通过使用mysqlbinlog工具来使数据恢复，可以指定恢复的起止点。
     *
     * 完整的备份命令：mysqldump -uroot -p123456 -lF --log-error=/root/myDump.err -B zyyshop > /root/BAK.zyyshop.sql
     */
}
