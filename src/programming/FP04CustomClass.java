package programming;


import java.util.List;

class Course {
    private String name;
    private String category;
    private int reviewScore;
    private int noOfStudent;

    public Course(String name, String category, int reviewScore, int noOdStudent) {
        this.name = name;
        this.category = category;
        this.reviewScore = reviewScore;
        this.noOfStudent = noOdStudent;
    }

    @Override
    public String toString() {
        return "course{" + "name='" + name + '\'' + ", category='" + category + '\'' + ", reviewScore=" + reviewScore + ", noOdStudent=" + noOfStudent + '}';
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
        return noOfStudent;
    }

    public void setNoOdStudent(int noOdStudent) {
        this.noOfStudent = noOdStudent;
    }
}

public class FP04CustomClass {
    public static void main(String[] args) {

        List<Course> courses=List.of(
                new Course("Spring","FrameWork",98,20000),
                new Course("Spring Boot","FrameWork",95,18000),
                new Course("API","Microservices",97,22000),
                new Course("Microservices","Microservices",96,25000),
                new Course("FullStack","FullStack",95,14000),
                new Course("AWS","FrameWork",94,21000),
                new Course("Azure","Cloud",93,21000),
                new Course("Docker","Cloud",92,20000),
                new Course("Kubernetes","Cloud",91,20000)
        );
        System.out.println(courses.stream()
                .allMatch(course->course.getReviewScore()>90));

    }
}
