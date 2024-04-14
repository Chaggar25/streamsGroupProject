package challenges;

import data.FetchData;
import domain.Student;

import java.io.IOException;
import java.time.LocalDate;
import java.time.Period;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

public class StudentOps {

    //  1. Filter Students by Gender: Write a method to filter a list of students by their gender.

    public static List<Student> filterStudentsByGender(List<Student> students, String gender) {
        return students.stream()
                .filter(student -> student.getGender().equalsIgnoreCase(gender))
                .toList();
    }

    //2. Sort Students by Age: Sort the list of students by their age (based on date of birth).
    public static List<Student> sortStudentsByAge(List<Student> students) {
        LocalDate currentDate = LocalDate.now();
        students.forEach(student -> {
            LocalDate dob = student.getDob();
            Period period = Period.between(dob, currentDate);
            student.setAge(period.getYears());
        });
        return  students.stream()
                    .sorted(Comparator.comparing(Student::getAge))
                    .toList();
        }


//        3. Calculate Average Age: Calculate the average age of all students.
          public static double averageAgeofStudents(List<Student> students) {
              OptionalDouble avg = students.stream()
                      .mapToDouble(Student::getAge)
                      .average();
              return avg.orElse(0.0);
          }

//          Print Student Names: Print the full names of all students.



//    Find Maximum Age: Find the maximum age among all students.

    public static int maxAgeOfAllStudents(List<Student> student) {
        int maxAge = student.stream()
//                in the code above the plan is to the max age. i set it to a int cause i guess studen and number i thought of double but wasnt sure how that would work. and named my variable maxage
//                after i set it to map to int i used the .max to find the max age then added a orelse to make sure it was handeled in case it was empty.
                .mapToInt(Student::getAge)
                .max()
                .orElse(0);
        return maxAge;
    }

//    Group Students by Gender: Group the students by gender.
    public static void groupByGender(List<Student> students){
        Map<String, List<Student>> groupByGender = students.stream()
                .collect(Collectors.groupingBy(Student::getGender));
    }


//    Transform to Map: Convert the list of students into a map where the key is the student ID and the value is the student object.
    public static void groupByStudentIDStudentObject(List<Student> students){
        Map<Integer, Student> studentMap = students.stream()
                .collect(Collectors.toMap(Student::getId, student -> student));

    }

//    Get Student Emails: Retrieve a list of student emails.
    public static void studentEmails(List<Student> students){
        students.stream()
                .map(Student::getEmail)
                .collect(Collectors.toList());
    }

// Check if Any Student is Adult: Check if any student is an adult (age 18 or older).
    public static boolean overAge18(List<Student> students){
        students.stream()
                .anyMatch(student -> student.getAge() >= 18);

        return false;
    }

// Count Students by Gender: Count the number of students for each gender.
    public static void numOfStudentsEachGender(List<Student> students){
        students.stream()
                .collect(Collectors.groupingBy(Student::getGender, Collectors.counting()));

    }

// Find Youngest Female Student: Find the youngest female student.
    public static void youngestFemale (List<Student> students){
        students.stream()
                .filter(student -> student.getGender().equals("female"))
                .min((s1, s2) -> Integer.compare(s1.getAge(), s2.getAge()));

    }

//    Join Student Names: Join the first names of all students into a single string.
    public static void allStudentNamesIntoAnString(List<Student> students){
        students.stream()
                .map(Student::getFirst_name)
                .collect(Collectors.joining(" "));

        System.out.println("First Names" + allStudentNamesIntoAnString());
    }


//  Calculate Age Sum: Calculate the sum of ages for all students.
    public static int sumOfAllStudents(List<Student> students){
        students.stream()
                .map(Student::getAge);
//                .sum();
//        not sure what is wrong in the code that isnt allowing this to work but if i need to get the sum of all the ages that i would need to use the sum function?

        return 0;
    }

//    Check if All Students are Adults: Check if all students are adults (age 18 or older)
    public static boolean allOverAge18(List<Student> students){
        students.stream()
                .allMatch(student -> student.getAge() >= 18);
        return false;
    }

// Find Oldest Student: Find the oldest student.
    public static void oldestStudent(List<Student> students){

        students.stream()
                .max(Comparator.comparing(Student::getAge));
// not sure how to close this one whatever im trying isnt working for me.

    }

//    Convert to Uppercase: Convert all student first names to uppercase.
    public static List<String> firstNameToUpperCase(List<Student> students){
         students.stream()
                .map(student -> student.getFirst_name().toUpperCase())
                 .forEach(System.out::println);
        return List.of();
    }

//    Find Student by ID: Find a student by their ID.
    public static void findStudentById(List<Student> students, String id){
        students.stream()
                .filter(student -> student.getId().equals(id))
                .findFirst();
    }






}
