import org.junit.Test;

import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.TreeSet;

public class QuizTest2 {

    @Test
    public void employee() {
        class Employee {
            String name;

            public Employee(String name) {
                this.name = name;
            }

            @Override
            public int hashCode() {
                return 1;
            }
        }

        HashMap<Employee, String> employeeStringHashMap = new HashMap<>();

        employeeStringHashMap.put(new Employee("a"), "1");
        employeeStringHashMap.put(new Employee("b"), "2");
        employeeStringHashMap.put(new Employee("a"), "3");

        System.out.println(employeeStringHashMap.size());

        System.out.println(employeeStringHashMap.get(new Employee("a")));

    }

    @Test
    public void exceptionOrder() {


        try {
            throw new UnsupportedOperationException();
        } catch (Throwable t){
            System.out.println("1");
        }

    }

    @Test
    public void outputTest() throws FileNotFoundException {
        PrintStream out =
                new PrintStream(
                        new BufferedOutputStream(
                                new FileOutputStream("text")));

        PrintStream console = System.out;

        System.setOut(console);

        System.out.println("1");

        System.setOut(out);

        System.out.println("2");

        out.close();

        System.out.println("3");

    }

    @Test
    public void treeSet() {
        TreeSet set = new TreeSet();
        set.add(1);
        set.add(2);
        set.add(3);

        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    @Test
    public void compare() {
        class Employee {
            public Employee(final String name) {
                this.name = name;
            }

            String name;

            @Override
            public String toString() {
                return "Employee{" +
                        "name='" + name + '\'' +
                        '}';
            }
        }
        class NameComparator implements Comparator<Employee> {

            @Override
            public int compare(final Employee o1, final Employee o2) {
                return o1.name.compareTo(o2.name);
            }
        }

        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("Boris"));
        employees.add(new Employee("Andrii"));

        Collections.sort(employees, new NameComparator());

        System.out.println(employees);
    }
}
