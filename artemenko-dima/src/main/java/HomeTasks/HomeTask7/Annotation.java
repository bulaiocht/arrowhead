package HomeTasks.HomeTask7;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;

//Дополнение:
//Создать свою аннотацию для методов классов.
//Написать утилитный класс,
// который будет по имени класса и по интерфейсу,
// который он имплементирует, создавать прокси объект,
// который будет смотреть помечен ли метод вашей аннотацией и если да,
// то будет логгировать в консоль имя метода и время за которое тело метода был выполнено.
public class  Annotation  {

    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.METHOD)
    public @interface AnnotationHW7 {
    }

    public static void run(Class testClass) {

        Method[] method = testClass.getDeclaredMethods();
        for (Method m : method) {
            if (m.isAnnotationPresent( AnnotationHW7.class )) {



            }
            System.out.println( m.getName() );

        }
    }
}
