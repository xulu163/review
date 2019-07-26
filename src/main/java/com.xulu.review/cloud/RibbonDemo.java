package com.xulu.review.cloud;

/**
 * ribbon负载均衡
 *
 * @author xulu  E-mail:java_xul@163.com
 * @version 1.0
 * @create 2019-07-04 15:25
 **/
public class RibbonDemo {

    /**
     * nginx、ribbon、feign有什么区别？
     */

    /**
     * SpringCouldRibbon是基于netflix ribbon实现的一套客户端的负载均衡工具
     */

    /**
     * ribbon的7种负载均衡算法：
     *   1。RoundRobinRule轮询
     *   2。RandomRule随机
     *   3。AvailabilityFilteringRule
     *      会先过滤掉由于多次访问故障而处于断路器跳闸状态的服务
     *      还有并发的连接数超过阈值的服务，然后对剩余的服务列表按照
     *      轮询的策略
     *   4。WeightedResponseTimeRule
     *      根据平均响应时间计算左右无福的权重，相应时间越快服务权重越大，命中的概率
     *      越高，刚启动时如果统计信息不足，则使用轮询策略，等统计信息足够，会切换到
     *      WeightResponseTimrRule
     *   5。RetryRule
     *      先按照轮询的策略获取服务，如果获取服务失败则在指定的时间内进行重试，获取可用的服务
     *   6。BestAvailableRule
     *      会先过滤掉由于多次访问故障而处于断路器跳闸的服务，然后选择一个并发量最小的服务
     *   7。ZoneAvoidanceRule
     *      复合判断server所在区域的性能和server的可用性选择服务器
     *
     */
}
