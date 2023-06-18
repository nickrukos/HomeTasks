package nickrukos.curs4;

import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;

@Getter

@MappedSuperclass
abstract public class Unique {
    @Id
    protected int code;

    public Unique() {}

    public Unique(int code) {
        this.code = code;
    }
}
