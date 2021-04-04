package zju.edu.als.util;

/**
 * @author Ma
 * @create 2019-09-13 20:08
 */
public enum Executors {
    PYTHON2,
    PYTHON,//python or python3 depends on your platform
    GENERAL;

    private Executors() {
    }

    public String getId() {
        return this.name().toLowerCase();
    }

    public static Executors fromId(String id) {
        try {
            return valueOf(id.toUpperCase());
        } catch (IllegalArgumentException e) {
            return null;
        }
    }
}
