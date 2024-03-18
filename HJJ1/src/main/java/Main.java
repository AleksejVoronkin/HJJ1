import org.example.Tools.*;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.example.Tools.Streams;

public class Main {
    public static void main(String[] args) {
        List<Streams.Person> persons = Arrays.asList(
                new Streams.Person("Alex", 25, 70000, new Streams.Department("Development")),
                new Streams.Person("Chris", 45, 120000, new Streams.Department("Development")),
                new Streams.Person("Egor", 28, 70000, new Streams.Department("HR")),
                new Streams.Person("Bob", 35, 60000, new Streams.Department("HR")),
                new Streams.Person("Dima", 42, 90000, new Streams.Department("Marketing")),
                new Streams.Person("Fedor", 30, 80000, new Streams.Department("Marketing"))
        );

        Homework homework = new Homework();

        System.out.println("Отсортированные имена:");
        homework.printNamesOrdered(persons);

        System.out.println("\nСамый старший сотрудник в каждом департаменте:");
        Map<Streams.Department, Streams.Person> oldestInDepartment = homework.printDepartmentOldestPerson(persons);
        oldestInDepartment.forEach((department, person) ->
                System.out.println(department.getName() + " -> " + person.getName()));

        System.out.println("\n10 первых молодых сотрудников с зарплатой выше 50,000:");
        List<Streams.Person> youngRichPersons = homework.findFirstPersons(persons);
        youngRichPersons.forEach(person ->
                System.out.println(person.getName() + " - " + person.getSalary()));

        System.out.println("\nДепартамент с максимальной суммарной зарплатой:");
        Optional<Streams.Department> topDepartment = homework.findTopDepartment(persons);
        topDepartment.ifPresent(department ->
                System.out.println(department.getName()));
    }
}