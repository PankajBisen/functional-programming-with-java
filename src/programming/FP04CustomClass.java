package programming;


import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

class Course {
    private String name;
    private String category;
    private int reviewScore;
    private int numberOfStudent;

    public Course(String name, String category, int reviewScore, int noOdStudent) {
        this.name = name;
        this.category = category;
        this.reviewScore = reviewScore;
        this.numberOfStudent = noOdStudent;
    }

    @Override
    public String toString() {
        return "course{" + "name='" + name + '\'' + ", category='" + category + '\'' + ", reviewScore=" + reviewScore + ", noOdStudent=" + numberOfStudent + '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getReviewScore() {
        return reviewScore;
    }

    public void setReviewScore(int reviewScore) {
        this.reviewScore = reviewScore;
    }

    public int getNoOdStudent() {
        return numberOfStudent;
    }

    public void setNoOdStudent(int noOdStudent) {
        this.numberOfStudent = noOdStudent;
    }
}

public class FP04CustomClass {
    public static void main(String[] args) {

        List<Course> courses = List.of(
                new Course("Spring", "FrameWork", 98, 20000),
                new Course("Spring Boot", "FrameWork", 95, 18000),
                new Course("API", "Microservices", 97, 22000),
                new Course("Microservices", "Microservices", 96, 25000),
                new Course("FullStack", "FullStack", 95, 14000),
                new Course("AWS", "Cloud", 94, 21000),
                new Course("Azure", "Cloud", 99, 21000),
                new Course("Docker", "Cloud", 92, 20000),
                new Course("Kubernetes", "Cloud", 91, 20000));

        Predicate<Course> reviewScoreGreaterThan95Predicate = course -> course.getReviewScore() > 95;
        Predicate<Course> reviewScoreGreaterThan90Predicate = course -> course.getReviewScore() > 90;
        Predicate<Course> reviewScoreLessThan90Predicate = course -> course.getReviewScore() < 90;

        System.out.println(courses.stream().allMatch(reviewScoreGreaterThan95Predicate));
        System.out.println(courses.stream().noneMatch(reviewScoreLessThan90Predicate));
        System.out.println(courses.stream().anyMatch(reviewScoreLessThan90Predicate));
        System.out.println(courses.stream().anyMatch(reviewScoreGreaterThan95Predicate));

        Comparator <Course> comparatorByNoOfStudentsIncreasing= Comparator
                .comparingInt(Course::getNoOdStudent);
        System.out.println(courses
                .stream()
                .sorted(comparatorByNoOfStudentsIncreasing)
                .collect(Collectors.toList()));


        Comparator <Course> comparatorByNoOfStudentsDecreasing=Comparator
                .comparingInt(Course::getNoOdStudent)
                .reversed();
        System.out.println(courses
                .stream()
                .sorted(comparatorByNoOfStudentsDecreasing)
                .collect(Collectors.toList()));
//
//
        Comparator <Course> comparatorByNoOfStudentsAndNoOfReviews=Comparator
                .comparingInt(Course::getNoOdStudent)
                .thenComparingInt(Course::getReviewScore)
                .reversed();
        System.out.println(courses
                .stream()
                .sorted(comparatorByNoOfStudentsAndNoOfReviews)
                .collect(Collectors.toList()));
        System.out.println(courses
                .stream()
                .sorted(comparatorByNoOfStudentsAndNoOfReviews)
                .limit(5)
                .collect(Collectors.toList()));
        System.out.println(courses
                .stream()
                .sorted(comparatorByNoOfStudentsAndNoOfReviews)
                .skip(3)
                .collect(Collectors.toList()));
        System.out.println(courses
                .stream()
                .sorted(comparatorByNoOfStudentsAndNoOfReviews)
                .skip(3)
                .limit(5)
                .collect(Collectors.toList()));
//
        System.out.println(courses);
//
        System.out.println(courses.stream()
                .takeWhile(course -> course.getReviewScore()>=95)
                .collect(Collectors.toList()));
        System.out.println(courses.stream()
                .dropWhile(course -> course.getReviewScore()>=95)
                .collect(Collectors.toList()));
//
        System.out.println(courses.stream()
                .max(comparatorByNoOfStudentsAndNoOfReviews));
        System.out.println(courses.stream()
                .min(comparatorByNoOfStudentsAndNoOfReviews)
                .orElse(new Course("Kubernates ","Cloud",91,20000)));
        System.out.println(courses.stream()
                .filter(reviewScoreLessThan90Predicate)
                .min(comparatorByNoOfStudentsAndNoOfReviews)
                .orElse(new Course("Kubernates ","Cloud",91,20000)));
        System.out.println(courses.stream()
                .filter(reviewScoreGreaterThan95Predicate)
                .findFirst());

        System.out.println(courses.stream()
                .filter(reviewScoreGreaterThan95Predicate)
                .findAny());

        System.out.println(courses.stream()
                .filter(reviewScoreGreaterThan95Predicate)
                .mapToInt(Course::getNoOdStudent)
                .average());

        System.out.println(courses.stream()
                .filter(reviewScoreGreaterThan95Predicate)
                .mapToInt(Course::getNoOdStudent)
                .count());

        System.out.println(courses.stream()
                .filter(reviewScoreGreaterThan95Predicate)
                .mapToInt(Course::getNoOdStudent)
                .max());

        System.out.println(courses.stream()
                .filter(reviewScoreGreaterThan95Predicate)
                .mapToInt(Course::getNoOdStudent)
                .min());

        System.out.println(
                courses.stream()
                    .collect(Collectors.groupingBy(Course::getCategory)));

        System.out.println(
                courses.stream()
                        .collect(Collectors.groupingBy(Course::getCategory,
                                Collectors.counting())));

        System.out.println(
                courses.stream()
                        .collect(Collectors.groupingBy(Course::getCategory,
                                Collectors.maxBy(Comparator.comparing(Course::getReviewScore)))));

        System.out.println(
                courses.stream()
                        .collect(Collectors.groupingBy(Course::getCategory,
                                Collectors.mapping(Course::getName,
                                        Collectors.toList()))));


        Predicate<Course> reviewScoreGreaterThan95Predicate2 =
                createPredicateWithCutOffReviewScore(95);
        Predicate<Course> reviewScoreGreaterThan90Predicate2=
                createPredicateWithCutOffReviewScore(90);
    }

    //HigherOrderFunction
    private static Predicate<Course> createPredicateWithCutOffReviewScore(int cutOfReviewScore) {
        return course -> course.getReviewScore() > cutOfReviewScore;
    }
}