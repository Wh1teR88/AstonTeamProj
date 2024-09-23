package Validating;

public class Validate {
    public static boolean validateString(String value) {
        return value != null && !value.trim().isEmpty();
    }

    public static boolean validatePositiveDouble(double value) {
        return value > 0;
    }

    public static boolean validateNonNegativeInt(int value) {
        return value >= 0;
    }
}

