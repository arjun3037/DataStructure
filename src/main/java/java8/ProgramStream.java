package java8;

import java.util.Arrays;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class ProgramStream {
	
	
	public static void main(String args[]){
		
		List<Integer> data = Arrays.asList(10,15,8,49,25,98,32,1000,101,98,15);
		maxElement(data);

		String input = "Java Articles ar awesome";
		findFirstRepeatedChar(input);

		int arr[] = {1,2,3,4};
		CheckElementExistAtleastTwiceInArray(arr);

		List<String> list1 = Arrays.asList("Java", "8");
		List<String> list2 = Arrays.asList("explained", "through", "programs");

		concatTwoStream(list1,list2);

		List<Integer> integerList = Arrays.asList(4,5,6,7,1,2,3);
		//cubeOfElement(integerList);
		sortedAndConvertToArray(arr);

		String[] array = {"ss","sa","aa","bb","Ad"};
		toUpperCase(array);
		
	}


	public static void toUpperCase(String[] s){
		Stream.of(s).map(a -> a.toUpperCase()).forEach(System.out::println);

	}

	public static void sortedAndConvertToArray(int[] arr){

		IntStream.of(arr).sorted().forEach(System.out::println);
		//IntStream.of(arr).sorted().forEach(a -> System.out.println(a));



	}

	public static void cubeOfElement(List<Integer> list){

		list.stream().map(a -> a*a*a).filter(a -> a> 50).forEach(System.out::println);

	}

	public static void concatTwoStream(List<String> l1 , List<String> s2){
		Stream<String> concat = Stream.concat(l1.stream(), s2.stream());
		concat.forEach(System.out::println);
	}


	public static void CheckElementExistAtleastTwiceInArray(int[] arr){
		boolean b = IntStream.of(arr).boxed().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
				.entrySet()
				.stream()
				.anyMatch(a -> a.getValue() >= 2);

		System.out.println(b);
	}

	public static void sortAllInteger(int[] arr){
		IntStream.of(arr).sorted().forEach(System.out::println);
	}
	
	public static void sortAllIntegerInDesc(int[] arr){
		IntStream.of(arr).boxed().sorted(Collections.reverseOrder()).forEach(System.out::println);
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

	public static void findFirstRepeatedChar(String s1){
		
		s1.chars()
			  .mapToObj(s -> Character.toLowerCase(Character.valueOf((char)s)) )
			  .collect(Collectors.groupingBy(Function.identity(),LinkedHashMap::new , Collectors.counting()))
			  .entrySet().stream()
			  .filter(s -> s.getValue() > 1)
			  .map(s-> s.getKey())
			  .findFirst()
				.ifPresent(System.out::println);


	}
	
	

}
