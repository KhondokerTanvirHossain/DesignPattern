package OOP.Relations.src;

import java.util.ArrayList;
import java.util.List;

// Dependency
class Course {
    String getKnowledge() {
        return "Knowledge from the course";
    }
}

// Association
class Professor {
    private Student student; // Association between Professor and Student

    void setStudent(Student student) {
        this.student = student;
    }

    void teach(Course course) {
        String knowledge = course.getKnowledge();
        this.student.remember(knowledge);
    }
}

// Aggregation
class Department {
    private List<Professor> professors; // Aggregation of Professors

    Department(List<Professor> professors) {
        this.professors = professors;
    }

    void printProfessors() {
        System.out.println("Professors in the department: " + professors.size());
    }
}

// Composition
class University {
    private List<Department> departments; // Composition of Departments

    University() {
        this.departments = new ArrayList<>();
        this.departments.add(new Department(new ArrayList<>()));
    }

    void printDepartments() {
        System.out.println("Departments in the university: " + departments.size());
    }
}

// Implementation and Inheritance
interface Learner {
    void remember(String knowledge);
}

class Student implements Learner {
    @Override
    public void remember(String knowledge) {
        System.out.println("Student remembered: " + knowledge);
    }
}

class Main {
    public static void main(String[] args) {
        Professor professor = new Professor();
        Student student = new Student();
        professor.setStudent(student);
        Course course = new Course();
        professor.teach(course);

        List<Professor> professors = new ArrayList<>();
        professors.add(professor);
        Department department = new Department(professors);
        department.printProfessors();

        University university = new University();
        university.printDepartments();
    }
}
