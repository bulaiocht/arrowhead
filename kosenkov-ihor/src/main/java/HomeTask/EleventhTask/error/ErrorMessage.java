package HomeTask.EleventhTask.error;

public enum ErrorMessage {

    NO_ERROR(""),
    INVALID_EMAIL("Invalid email"),
    INVALID_AGE("Age must be over 18"),
    IS_REGISTERED("User is already registered");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
