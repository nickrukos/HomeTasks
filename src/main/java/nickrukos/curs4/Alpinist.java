package nickrukos.curs4;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name="tb_alpinist", schema = "itmo", indexes = {@Index(columnList = "code",unique = true)})
public class Alpinist extends Unique
{
   @Column(columnDefinition = "TEXT NOT NULL")
   private String fullName;
   @Column(columnDefinition = "TEXT NOT NULL")
   private String address;
   @ManyToMany(mappedBy = "alpinists")
   private List<Group> groupAlpinists;
   public Alpinist()
   {
      groupAlpinists = new ArrayList<>();
   }
}