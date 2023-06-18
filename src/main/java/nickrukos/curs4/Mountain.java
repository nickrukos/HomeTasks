package nickrukos.curs4;
import jakarta.persistence.*;
import lombok.Getter;

import java.util.ArrayList;

@Getter
@Entity
@Table(name="tb_mountain", schema = "itmo", indexes = {@Index(columnList = "code",unique = true)})
public class Mountain extends Unique
{
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String country;
    @Column(nullable = false)
    private int height;
    @OneToMany(mappedBy = "mountain")
    private ArrayList<Group> groups;
}
