package nickrukos.curs4;

import jakarta.persistence.*;
import lombok.Getter;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

@Getter
@Entity
@Table(name="tb_group", schema = "itmo",indexes = {@Index(columnList = "code",unique = true)})

public class Group extends Unique
{
    @Column(nullable = false)
    private int mountain_code;
    @Column(nullable = false)
    private boolean open_sign;
    @Column(nullable = false)
    private LocalDate date_start;
    @Column(nullable = false)
    private LocalTime time_start;
    @Column(nullable = false)
    private LocalDate date_finish;
    @Column(nullable = false)
    private LocalTime time_finish;
    @ManyToOne
    private Mountain mountain;
    @ManyToMany(mappedBy = "groups")
    private ArrayList<Alpinist> alpinists;
}
