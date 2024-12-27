package uk.minersonline.adminium.utils;

public enum TriState {
    TRUE,
    FALSE,
    UNDEFINED;

    public static TriState fromBoolean(boolean value) {
        return value ? TRUE : FALSE;
    }

    public static TriState fromString(String value) {
        if (value == null) {
            return UNDEFINED;
        }
        switch (value.toLowerCase()) {
            case "true":
                return TRUE;
            case "false":
                return FALSE;
            default:
                return UNDEFINED;
        }
    }

    public boolean toBoolean() {
        return this == TRUE;
    }

    public String toString() {
        switch (this) {
            case TRUE:
                return "true";
            case FALSE:
                return "false";
            default:
                return "undefined";
        }
    }
}
