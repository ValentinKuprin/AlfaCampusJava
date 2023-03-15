package app;

public enum ContextType {
    NATIVE("NATIVE_APP"),
    WEBVIEW("WEBVIEW_org.wikipedia");
    private final String value;

    ContextType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
