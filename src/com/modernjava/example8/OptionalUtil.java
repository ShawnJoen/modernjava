package com.modernjava.example8;

import java.util.Optional;

import com.modernjava.CustomException;

public class OptionalUtil {
	public static void main(String[] args) {
		
		//调用工厂方法创建Optional实例, 参数不能为null如null 抛出NullPointerException
		Optional<String> opname = Optional.of("Shawn");
		System.out.println(opname);//Optional[Shawn]
		//值为null，则返回一个空(注:字符串空""时isPresent()也为true)
		Optional<String> opempty = Optional.ofNullable(null);
		System.out.println(opempty);//Optional.empty
		
		if (opname.isPresent()) {//有值为true否者false
			//有值则将其返回，否则抛出NoSuchElementException
			System.out.println(opname.get());//输出内容Shawn
		}
		//lambda表达式对Optional的值调用consumer进行处理
		opname.ifPresent((value) -> {
			System.out.println("opname: " + value);
		});
		//orElse传入的是默认值. 有值则将其返回,否者其他
		System.out.println(opname.orElse("opname -orElse-"));//Shawn
		System.out.println(opempty.orElse("opempty -orElse-"));//opempty -orElse-
		//orElseGet可以接受一个lambda表达式生成默认值,传入一个Supplier接口
		System.out.println(opname.orElseGet(() -> "Default Value"));//Shawn
		System.out.println(opempty.orElseGet(() -> "Default Value"));//Default Value
		
		try {
			//orElseThrow会抛出lambda表达式或方法生成的异常 
			opempty.orElseThrow(CustomException::new);
		} catch (Throwable e) {
			System.out.println(e.getMessage());//输出: No value present in the Optional instance
		}
		
		//map方法用来对Optional实例的值执行一系列操作。通过一组实现了Function接口
		Optional<String> upperName = opname.map((value) -> value.toUpperCase());
		System.out.println(upperName.orElse("No value found"));//SHAWN
		
		//flatMap与map（Funtion）方法类似，区别在于flatMap中的mapper返回值必须是Optional
		//map方法的mapping函数返回值可以是任何类型T，而flatMap方法的mapping函数必须是Optional
		upperName = opname.flatMap((value) -> Optional.of(value.toUpperCase()));
		System.out.println(upperName.orElse("No value found"));//SHAWN
		
		//filter函数我们应该传入实现了Predicate接口
		Optional<String> longName = opname.filter((value) -> value.length() > 6);
		System.out.println(longName.orElse("The name is less than 6 characters"));//The name is less than 6 characters

	}

}
