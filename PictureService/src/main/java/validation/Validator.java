package validation;

public class Validator {

    final private static String IMAGE_CONTENT_TYPE = "image/jpg";
    final private static long MAX_SIZE = 300;

    public static boolean checkMaxSize(long size) {
        if (size <= MAX_SIZE) {
            return true;
        } else return false;
    }

    public static boolean checkImage(String contentType) {
        if (IMAGE_CONTENT_TYPE.equals(contentType)) {
            return true;
        } else return false;

    }
}
