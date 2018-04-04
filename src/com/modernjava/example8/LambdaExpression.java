package com.modernjava.example8;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class LambdaExpression {
	public static void main(String[] args) {

		new Thread(new Runnable() {//未使用Lambda
		    @Override
		    public void run() {
		    	System.out.println("Before Java8, too much code for too little to do");
		    }
		}).start();
		new Thread(() -> {//使用Lambda
			System.out.println("In Java8, Lambda expression rocks !!");
		}).start();
		
		List<String> features = Arrays.asList("Lambdas", "Default Method", "Stream API", "Date and Time API");
		features.forEach(n -> System.out.println(n));
		features.forEach(System.out::println);//方法引用  :: 双冒号操作符
		//-----------------------------Map和Reduce Start
		//Map和Reduce  reduce()函数可以将所有值合并成一个 类似 sum()、avg() 或者 count()
		//IntStream这样的类有类似 average()、count()、sum() 的内建方法来做 reduce 操作，
		//也有mapToLong()、mapToDouble() 方法来做转换	
		List<Integer> costBeforeTax = Arrays.asList(100, 200, 300, 400, 500);
		double total = 0;
		for (Integer cost : costBeforeTax) {
		    double price = cost + .12*cost;//为每个订单加上12%的税
		    total = total + price;
		}
		System.out.println("老方法 Total : " + total);//1680.0
		List<Integer> costBeforeTax2 = Arrays.asList(100, 200, 300, 400, 500);
		double bill = costBeforeTax2.stream()
				.map((cost) -> cost + .12*cost)//为每个订单加上12%的税
				.reduce((sum, cost) -> sum + cost)
				.get();
		System.out.println("新方法 Total : " + bill);//1680.0
		//-----------------------------Map和Reduce End
		//-----------------------------Predicate Start
		List<String> languages = Arrays.asList("Java", "Scala", "C++", "Haskell", "Lisp");
		//合并两个Predicate
		Predicate<String> startsWithJ = (n) -> n.startsWith("J");
		Predicate<String> fourLetterLong = (n) -> n.length() == 4;
		languages.stream()
		    .filter(startsWithJ.and(fourLetterLong))//and()、or()用于将传入 filter() 方法的条件合并起来
		    .forEach((n) -> System.out.println("合并两个Predicate : " + n));//Java
		
		System.out.println("Predicate 1:"); filter2(languages, (str) -> str.startsWith("J"));
		System.out.println("Predicate 2:"); filter2(languages, (str) -> str.endsWith("a"));
		System.out.println("Predicate 3:"); filter2(languages, (str) -> true);//所有条件为true
		System.out.println("Predicate 4:"); filter2(languages, (str) -> str.length() > 4);
	}
	
	public static void filter(List<String> names, Predicate<String> condition) {//java8之前版本
		for (String name : names) {
			if (condition.test(name)) {
				System.out.print(name + "-");
			}
		} System.out.println("");
	}
	public static void filter2(List<String> names, Predicate<String> condition) {//java8
	    names.stream()
		    .filter((name) -> (condition.test(name)))
		    .forEach((name) -> {
		        System.out.print(name + "-");
		    }); System.out.println("");
	}
	
}
