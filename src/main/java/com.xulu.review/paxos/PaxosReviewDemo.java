package com.xulu.review.paxos;

/**
 * 二阶段提交和paxos算法的比较
 * @author xulu  E-mail:java_xul@163.com
 * @version 1.0
 * @create 2019-07-11 14:48
 **/
public class PaxosReviewDemo {


    /**
     * 为了实现分布式事务，必须实现一套协商算法，使得多个参与者对某一个状态的变更保持一致！
     *
     *
     *    两阶段提交算法大致是这样的：定义coordinator为某一状态变更的发起者，有多个participant，
     * 且为了一致性participant只接受coordinator发起的自增，要增全部增，否则回滚。
     *
     *    第一阶段：coordinator发起投票，每一个participant都投了赞成票，它得先做两件事情
     * 1.持久化该同意（并不是最终提交）;
     * 2.向coordinator回应同意该提案。
     *
     *    第二阶段：如果每一个participant都投了赞成票，则coordinator做三件事
     * 1.向每一个participant发起最终的commit
     * 2.每一个participant接到commit后提交事务，释放锁，删掉redo undo log，并向coordinator确认
     * 3.当coordinator收到所有的确认后提交该事务。
     *
     *   当然，如果第一阶段有participant投了反对票，则会向coordinator回应反对，那coordinator就向
     * 所有投了赞成票的participant回滚，目的是回到最初的状态。
     *
     *   优点是能实现分布式下的强一致性，缺点也很明显，单点的coordinator是个严重的问题：
     * 1。没有热备机制，coordinator节点crash了或者连接它的网络坏了会阻塞该事务；
     * 2。吞吐量不行，没有充分发挥数量更多的participants的力量，一旦某个participant第一阶段
     * 投了赞成票就得在它上面加独占锁，其他事务不得介入，直到当前事务提交或者回滚。
     */

    /**
     *   paxos算法是一种基于消息传递且具有高度容错特性的一致性算法，它将角色分为proposers、accept和leaners，
     * proposers提出提案，提案信息包含提案编号和提案的值；acceptor收到提案后可以接受提案，若提案获得多数acceptor
     * 的接受，则该提案被批准；leaners只能学习被批准的提案，角色可以客串，算法的核心分为两个阶段：
     * 1。prepare阶段：
     *      a。proposer选择一个提案编号n并将prepare请求发送给足够多的acceptors
     *      b。acceptor收到prepare消息后，如果提案的编号大于它已经回复的所有prepare消息，则acceptor将自己上次接受
     *    的提案回复给proposer，并承诺不再回复小于n的提案
     * 2。accept阶段：
     *      a。当一个propose收到acceptors对prepare的回复后，就进入批准阶段。他要向回复prepare请求的acceptors发送
     *    accept请求，包括编号n和一个suitable value；
     *      b。在不违背自己向其他proposer的承诺的前提下，acceptor收到的accept请求后丢弃曾经accept过的value，接着
     *    接受这个请求并持久化
     * 本来还有第三阶段：proposer最终提交事务，它跟2PC的第二阶段基本一样：proposer收到过半的accept后向所有acceptor
     * 发布最终的决议（有的实现版本是由learner负责统计accept票数并发布决议，这里是为了跟2PC作比较不特别区分）
     * proposer选择一个会自增的编号n，这个编号可以由一个同意的机构颁发，但是一定得保证从这里去的的编号是自增并且唯一的。
     */

    /**
     * 总结：
     *   paxos虽然也是分布式情况下强一致性算法，但是它在2PC上至少有亮点改进
     * 1。不存在说网络问题导致事务阻塞甚至是啊比，尤其是连接coordinator的，因为paxos的角色是可以互串的，必要时
     * 🎫articipant也能充当coordinator
     * 2。加在任何一个在2pc阶段投了赞成票的participant上的锁是可以被砸开的：只要新提案的编号更大，这样就提高吞吐量了，
     * 当然频繁的产生新proposer可能会导致活锁：永远无法大成协议，最好设置一个超时机制，过了一定的时间才产生一个proposer。
     */
}
