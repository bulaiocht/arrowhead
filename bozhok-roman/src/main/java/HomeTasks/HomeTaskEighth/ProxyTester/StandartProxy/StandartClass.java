package HomeTasks.HomeTaskEighth.ProxyTester.StandartProxy;

import HomeTasks.HomeTaskEighth.ProxyTester.StandartProxy.InterFace;

public class StandartClass implements InterFace {
    @Override
    public void printer(String s) {
        System.out.println(s);
    }
}
