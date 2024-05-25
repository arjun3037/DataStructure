package java8;

import java.sql.Array;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class ProgramStream {
	
	
	public static void main(String args[]){

		ProgramStream programStream = new ProgramStream();
		List<Student> data = programStream.getData();

		Integer collect = data.stream().collect(Collectors.summingInt(Student::getSalary));
		System.out.println(collect);

		Map<Integer, Student> collect1 = data.stream().collect(
				Collectors.toMap(
						Student::getSalary, Function.identity(),
						(oldValue, NewValue) -> {
							return ((Student)oldValue).address.equals("delhi") ? oldValue : NewValue;


						}));

		collect1.entrySet().stream().forEach(e -> System.out.println(e.getKey() + "-" + e.getValue().getName()) );


		List<String> names = Arrays.asList("AA", "BB", "AA", "CC");

		Map<String, Long> collect2 = names.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		collect2.entrySet().stream().forEach(a -> System.out.println(a.getKey() + "-->" + a.getValue()));

		List<String> names1 = Arrays.asList("AA", "BB", "AA", "CC","BB","BB");

		names1.stream().collect(Collectors.groupingBy(Function.identity() , Collectors.counting())).entrySet().stream().filter(a -> a.getValue() >1).forEach(System.out::println);

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

	public  List<Student> getData(){

		List<Student> data = new ArrayList<>();
		data.add(new Student("Arjun","Delhi",100));
		data.add(new Student("Pooja","Noida",150));
		data.add(new Student("Ashu","Meerut",200));
		data.add(new Student("Ashi","Jaipur",125));
		data.add(new Student("Mishti","Delhi",150));
		return data;

	}


	class Student {
		String name;

		String address;

		int salary;

		public Student(String name , String address , int salary){
			this.address=address;
			this.name=name;
			this.salary=salary;

		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getAddress() {
			return address;
		}

		public void setAddress(String address) {
			this.address = address;
		}

		public int getSalary() {
			return salary;
		}

		public void setSalary(int salary) {
			this.salary = salary;
		}
	}
	
	

}
