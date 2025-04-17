class CourseFullException extends Exception {
    public CourseFullException(String message) {
        super(message);
    }
}

class PrerequisiteNotMetException extends Exception {
    public PrerequisiteNotMetException(String message) {
        super(message);
    }
}

class Course {
    private String name;
    private int capacity;
    private int enrolledStudents;
    private boolean prerequisiteCompleted;

    public Course(String name, int capacity, boolean prerequisiteCompleted) {
        this.name = name;
        this.capacity = capacity;
        this.enrolledStudents = 0;
        this.prerequisiteCompleted = prerequisiteCompleted;
    }

    public void enrollStudent() throws CourseFullException, PrerequisiteNotMetException {
        if (!prerequisiteCompleted) {
            throw new PrerequisiteNotMetException("Complete prerequisite before enrolling in " + name + ".");
        }
        if (enrolledStudents >= capacity) {
            throw new CourseFullException("Course " + name + " is full.");
        }
        enrolledStudents++;
        System.out.println("Enrolled successfully in " + name);
    }
}

public class UniversityEnrollment {
    public static void main(String[] args) {
        Course advancedJava = new Course("Advanced Java", 2, false); // prerequisite not completed

        try {
            advancedJava.enrollStudent();
        } catch (CourseFullException | PrerequisiteNotMetException e) {
            System.out.println("Error: " + e.getClass().getSimpleName() + " - " + e.getMessage());
        }
    }
}
