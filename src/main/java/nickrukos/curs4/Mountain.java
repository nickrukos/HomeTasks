package nickrukos.curs4;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@Setter
@Entity
@Table(name="tb_mountain", schema = "itmo", indexes = {@Index(columnList = "code",unique = true)})
public class Mountain extends Unique
{
    @Column(columnDefinition = "TEXT NOT NULL")
    private String name;
    @Column(columnDefinition = "TEXT NOT NULL")
    private String country;
    @Column(nullable = false)
    private int height;
    @OneToMany(mappedBy = "mountain")
    private ArrayList<Group> groups = new ArrayList<>();
    public void addGroup(Group group)
    {
        this.groups.add(group);
        group.setMountain(this);
    }
}