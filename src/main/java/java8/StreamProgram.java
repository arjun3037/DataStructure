package java8;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StreamProgram {

    public static List<Student> getStudents(){
        List<Student> list = Arrays.asList(
                new Student(1, "Rohit", "Mall", 30, "Male", "Mechanical Engineering", 2015, "Mumbai", 122),
                new Student(2, "Pulkit", "Singh", 56, "Male", "Computer Engineering", 2018, "Delhi", 67),
                new Student(11, "Arjun", "Singh", 32, "Male", "Computer Engineering", 2018, "Delhi", 67),
                new Student(3, "Ankit", "Patil", 25, "Female", "Mechanical Engineering", 2019, "Kerala", 164),
                new Student(4, "Satish Ray", "Malaghan", 30, "Male", "Mechanical Engineering", 2014, "Kerala", 26),
                new Student(5, "Roshan", "Mukd", 23, "Male", "Biotech Engineering", 2022, "Mumbai", 12),
                new Student(6, "Chetan", "Star", 24, "Male", "Mechanical Engineering", 2023, "Karnataka", 90),
                new Student(7, "Arun", "Vittal", 26, "Male", "Electronics Engineering", 2014, "Karnataka", 324),
                new Student(8, "Nam", "Dev", 31, "Male", "Computer Engineering", 2014, "Karnataka", 433),
                new Student(9, "Sonu", "Shankar", 27, "Female", "Computer Engineering", 2018, "Karnataka", 7),
                new Student(10, "Shubham", "Pandey", 26, "Male", "Instrumentation Engineering", 2017, "Mumbai", 98));

        return list;
    }

    public static void main(String[] args) {

        // get Students whose first name start with A
        getStudents().stream().filter(a -> a.getFirstName().startsWith("A")).forEach(System.out::println);

        // group the students by deopartment names
        Map<String, List<Student>> collect = getStudents().stream().collect(Collectors.groupingBy(Student::getDepartmantName));
        System.out.println(collect);

        // Total count of students
        Long collect1 = getStudents().stream().collect(Collectors.counting());
        System.out.println(collect1);

        // max age of student
        getStudents().stream().max(Comparator.comparing(Student::getAge)).ifPresent(System.out::println);

        //Find all departments names
        getStudents().stream().map(p -> p.getDepartmantName()).collect(Collectors.toList()).forEach(System.out::println);

        //count of students in each department

        getStudents().stream().collect(Collectors.groupingBy(Student::getDepartmantName , Collectors.counting())).entrySet().stream().forEach(a -> System.out.println(a.getKey() + "-" + a.getValue()
        ));

        // find the list of students whose age is less than 30
        getStudents().stream().filter(p -> p.getAge() < 30).collect(Collectors.toList()).forEach(System.out::println);

        // find the Students whose rank is between 50 and 100
        getStudents().stream().filter(p -> p.getRank() > 50 && p.getRank() < 100).collect(Collectors.toList()).forEach(System.out::println);

        // find the average age of male and femail students
        getStudents().stream().collect(Collectors.groupingBy(Student::getGender , Collectors.averagingInt(Student::getAge))).entrySet().stream().forEach(p -> System.out.println(p.getKey() + "--" + p.getValue()));

        // find the department who is having maximum number of students.
        getStudents().stream().collect(Collectors.groupingBy(Student::getDepartmantName , Collectors.counting())).entrySet().stream().max(Map.Entry.comparingByValue()).ifPresent(System.out::println);

        // find the studnets who stays in delhi and sort them by their names

        getStudents().stream().filter(p-> p.getCity().equals("Delhi")).sorted(Comparator.comparing(Student::getFirstName)).forEach(System.out::println);

        // find the average rank of all departments
        getStudents().stream().collect(Collectors.groupingBy(Student::getDepartmantName , Collectors.averagingInt(Student::getRank))).entrySet().forEach(p-> System.out.println(p.getKey() + "-" + p.getValue()));

        // find the highest rank in each department

        getStudents().stream().collect(Collectors.groupingBy(Student::getDepartmantName , Collectors.maxBy(Comparator.comparing(Student::getRank)))).entrySet().forEach(p->System.out.println(p.getKey() + "--" + p.getValue()));

        // find the students and sort them by Their rank
        getStudents().stream().sorted(Comparator.comparingInt(Student::getRank)).collect(Collectors.toList()).forEach(System.out::println);

        // find the student who has second rank

        getStudents().stream().sorted(Comparator.comparingInt(Student::getRank).reversed()).skip(1).findFirst().map(p->p.getRank()).ifPresent(System.out::println);

    }
}
