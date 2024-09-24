package hexlet.code.schemas.requirements;

public interface Requirement<T> {
    boolean check(T dataForCheck);
}
