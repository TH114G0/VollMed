package voll.med.api.exception;

public class DoctorNotFoundException extends RuntimeException{
    public DoctorNotFoundException() {
    }

    public DoctorNotFoundException(String message) {
        super(message);
    }
}
