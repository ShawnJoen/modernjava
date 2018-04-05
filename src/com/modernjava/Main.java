package com.modernjava;

public class Main {
/*
 * JAVA8
	Functional(Style) Programming 特点
	1. 相同的输入永远输出同样的结果(不会有 Side Impact)
	2. 并发多线程处理Object时不会出现race Condition现象因为
		Immutability 在Functional int n = 10 是 永远是10 不会有更改 
		一个值使用一次直接扔掉garbage collection(GC)处理效率非常高
	3. 所有的处理都是 Laziness。Functional Programming执行时按需执行处理(懒惰型)而不会提前准备
	4. 无null
	--
	在JAVA8 Lambda也可以看做Closure内部使用外域变量指定变量默认成effectively变量=final.为防止Race Condition
	@FunctionalInterface：
		JDK自带的 Interface默认加上了 @FunctionalInterface来 实现 Lambda Expression
		Interface 只有一个abstract
		Interface 允许有 static 方法
		Interface 有 default方法 此方法可以有函数体
		方法入参和返回参不同的话是普通方法
		方法入参和返回参相同为Identity Function 不过String时内容有变化也是属于普通方法


 * */
	
	public static void main(String[] args) {
	}
}
