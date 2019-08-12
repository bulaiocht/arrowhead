package HomeTasks.HomeTask5.Utilities;

import HomeTasks.HomeTask5.Classes.Point;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class JoinLists {

    public static <T extends Point> List<T> joinLists(
                Collection <? extends Point> inputA,
                Collection <? extends Point> inputB) {

        if (inputA == null) {
            throw new NullPointerException("listA is null");
        }
        if (inputB == null) {
            throw new NullPointerException("listB is null");
        }
        if (inputA.isEmpty()) {
            return new ArrayList<T>( (Collection<? extends T>) inputB );
        } else if (inputB.isEmpty()) {
            return new ArrayList<T>( (Collection<? extends T>) inputA );
        } else {
            ArrayList<T> result = new ArrayList<T>( inputA.size() + inputB.size());
            result.addAll( (Collection<? extends T>) inputA );
            result.addAll( (Collection<? extends T>) inputB );
            return result;
        }
    }
}
