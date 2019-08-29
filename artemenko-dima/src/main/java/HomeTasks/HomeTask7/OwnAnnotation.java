package HomeTasks.HomeTask7;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//Дополнение:
//Создать свою аннотацию для методов классов.
//Написать утилитный класс,
// который будет по имени класса и по интерфейсу,
// который он имплементирует, создавать прокси объект,
// который будет смотреть помечен ли метод вашей аннотацией и если да,
// то будет логгировать в консоль имя метода и время за которое тело метода был выполнено.

@Retention(RetentionPolicy.RUNTIME)
@Target(value = ElementType.METHOD)
public @interface OwnAnnotation {
}