package com.modernjava.example;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ReadFile {

	public static void main(String[] args) throws IOException {
		try(final Stream<String> lines = Files.lines(Paths.get("D:\\test.txt"))) {
			System.out.println(
				lines.map(line -> line.split("[\\s]+"))
					.flatMap(Arrays::stream)
					.distinct() //유일한 값 뽑기
					.sorted() //스트링이 컴패어버우이기 때문에 소팅 가능
					.collect(Collectors.toList()) //리스트로 변환
			);
			/* Print out
			 * [a1, b2, c3, test1, test2]
			 * */
		}
	}
}
