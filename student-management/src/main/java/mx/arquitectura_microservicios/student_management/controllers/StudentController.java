package mx.arquitectura_microservicios.student_management.controllers;

import mx.arquitectura_microservicios.student_management.domain.Student;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/students")
public class StudentController {

    // I am going to simulate the database by now
    private List<Student> students = new ArrayList<>(Arrays.asList(
            new Student(1, "Isabella D'Angelo", "isabella.d@example.com", 20, "Ingeniería de Software"),
            new Student(2, "Sebastián Montoya", "sebastian.m@example.com", 21, "Redes de Computadoras"),
            new Student(3, "Valentina Rosales", "valentina.r@example.com", 19, "Ingeniería de Software"),
            new Student(4, "Alejandro Ruiz", "alejandro.r@example.com", 22, "Matemáticas"),
            new Student(5, "Camila Reyes", "camila.r@example.com", 20, "Diseño Gráfico"),
            new Student(6, "Gabriel Ortega", "gabriel.o@example.com", 21, "Administración de Empresas"),
            new Student(7, "Luciana Serrano", "luciana.s@example.com", 19, "Arquitectura"),
            new Student(8, "Diego Alvarado", "diego.a@example.com", 23, "Psicología"),
            new Student(9, "Fernanda Castillo", "fernanda.c@example.com", 20, "Ingeniería de Software"),
            new Student(10, "Emilio Vargas", "emilio.v@example.com", 22, "Biología"),
            new Student(11, "Mariana Herrera", "mariana.h@example.com", 20, "Ingeniería Civil"),
            new Student(12, "Cristian Mendoza", "cristian.m@example.com", 21, "Química"),
            new Student(13, "Sofía López", "sofia.l@example.com", 19, "Arte y Diseño"),
            new Student(14, "Andrés Castro", "andres.c@example.com", 24, "Filosofía"),
            new Student(15, "Natalia Paredes", "natalia.p@example.com", 20, "Sociología"),
            new Student(16, "Roberto Jiménez", "roberto.j@example.com", 21, "Historia"),
            new Student(17, "Elena Cordero", "elena.c@example.com", 22, "Educación"),
            new Student(18, "Hugo Salazar", "hugo.s@example.com", 20, "Ingeniería Electrónica"),
            new Student(19, "Victoria Palacios", "victoria.p@example.com", 19, "Ciencias Ambientales"),
            new Student(20, "Pablo Ledesma", "pablo.l@example.com", 22, "Música")
    ));

    // GET STUDENTS
    @GetMapping
    public List<Student> getStudents() {
        return students;
    }

    @GetMapping("/{email}")
    public Student getStudent(@PathVariable String email) {
        for (Student s : students) {
            if (s.getEmail().equalsIgnoreCase(email)) {
                return s;
            }
        }
        return null; // Bad practice but I have to do it by now
    }

    // UPLOAD STUDENT
    @PostMapping
    public Student postStudent(@RequestBody Student student) {
        students.add(student);

        return student;
    }

    // UPDATE METHODS
    @PutMapping
    public Student putStudent(@RequestBody Student student) {
        for (Student s : students) {
            if (s.getId() == student.getId()) {
                s.setName(student.getName());
                s.setEmail(student.getEmail());
                s.setAge(student.getAge());
                s.setCourse(student.getCourse());

                return s;
            }
        }
        return null;
    }

    @PatchMapping
    public Student patchStudent(@RequestBody Student student) {
        for (Student s : students) {
            if (s.getId() == student.getId()) {
                if (student.getName() != null) {
                    s.setName(student.getName());
                }
                if (student.getEmail() != null) {
                    s.setEmail(student.getEmail());
                }
                if (student.getAge() != 0) {
                    s.setAge(student.getAge());
                }
                if (student.getCourse() != null) {
                    s.setCourse(student.getCourse());
                }

                return s;
            }
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public Student deleteStudent(@PathVariable int id) {
        for (Student s : students) {
            if (s.getId() == id) {
                students.remove(s);

                return s;
            }
        }
        return null;
    }

}
