package java8;

import java.util.Arrays;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ProgramStream {
	
	
	public static void main(String args[]){
		
		List<Integer> data = Arrays.asList(10,15,8,49,25,98,32,1000,101,98,15);
		maxElement(data);

		String input = "Java Articles ar awesome";
		firstNonrepeatedChar(input);
		
	}


    public static void printEvenNumber(List<Integer> list){
		list.stream().filter(a -> a % 2 ==0).forEach(System.out::println);
    }
	
	public static void printStartWith1(List<Integer> list){
		list.stream()
			.map(s -> s+"")
			.filter(s-> s.startsWith("1")).forEach(System.out::println);
	}
	
	public static void findDuplicateInArray(List<Integer> list){
		Set<Integer> set = new HashSet<>();
		list.stream().
			filter(a -> !set.add(a))
			.forEach(System.out::println);
	}
	
	public static void findFirstElement(List<Integer> list){
		 list.stream().findFirst().ifPresent(System.out::println);
	}

	public static void totalNoOfElement(List<Integer> list){
		long count = list.stream().count();
		System.out.println(count);
	}

	public static void maxElement(List<Integer> list){
		list.stream().max(Integer::compare).ifPresent(System.out::println);

	}

	public static void firstNonrepeatedChar(String string){
		string.chars()
				.mapToObj(a -> Character.toLowerCase(Character.valueOf((char) a)))
				.collect(Collectors.groupingBy(Function.identity(),LinkedHashMap::new , Collectors.counting()))
				.entrySet()
				.stream().filter( entry -> entry.getValue() == 1)
				.map(a->a.getKey())
				.findFirst().ifPresent(System.out::println);
	}

	public static void findFirstRepeatedChar(String s){


	}
}
