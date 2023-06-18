package nickrukos.curs4;
import jakarta.persistence.*;
import lombok.Getter;

import java.util.ArrayList;

@Getter
@Entity
@Table(name="tb_alpinist", schema = "itmo", indexes = {@Index(columnList = "code",unique = true)})
public class Alpinist extends Unique
{
   @Column(nullable = false)
   private String fullName;
   @Column(nullable = false)
   private String address;
   @ManyToMany(mappedBy = "alpinists")
   private ArrayList<Group> groups;
}
