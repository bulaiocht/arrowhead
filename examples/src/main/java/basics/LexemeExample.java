package basics;

public class LexemeExample {

    private/*this is a private field*/int/*comments are like spaces*/intField;


    /**
     * Default constructor.
     */
    public LexemeExample() {
    }

    /**
     * This is javadoc comment.
     * You can reference different classes here like {@link Object}
     * and methods {@link LexemeExample#weirdOneExample()}.
     *
     * You can write code here as well:
     * <pre>
     *     for(int i = 0; i &#60; intField; i++){
     *         System.out.println(i);
     *     }
     * </pre>
     * and html:
     * <ul>
     *     <li><i>Element 1 is italic</i>
     *     <li><b>Element 2 is bold</b>
     * </ul>
     * @param intField this is field.
     */
    public LexemeExample(int intField) {
        this.intField = intField;
    }

    /**
     * This method is weird.
     * Although all we see is a comment, it's still somehow a part of a code...
     * Also you won't see this javadoc in html,
     * because private methods can change drastically, or disappear at once.
     * But still, do cover it the with javadoc. It will help future you.
     */
    private void weirdOneExample(){
        //This is a comment line.
        //This is weird comment line \u000a System.out.println("Look, mama, no hands!");
    }

    public int getIntField() {
        return intField;
    }

    public void setIntField(int intField) {
        this.intField = intField;
    }

    public void callWeirdMethod() {
        weirdOneExample();
    }

    public static void main(String[] args) {

        LexemeExample example = new LexemeExample();
        example.callWeirdMethod();
        //\u000aHelloWorld.main(args);
        //\u000aHelloWorld2.main(args);

    }

}
