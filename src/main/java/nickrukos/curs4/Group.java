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
    @JoinColumn(name = "mountain_id", foreignKey = @ForeignKey(name="FK_mountain"))
    private Mountain mountain;
    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name="tb_group_alpinist", joinColumns = @JoinColumn(name = "group_code",
               foreignKey = @ForeignKey(name = "FK_group"), nullable = false),
               inverseJoinColumns = @JoinColumn(name="alpinist_code", foreignKey = @ForeignKey(name = "FK_alpinists"),
               nullable = false))
    private ArrayList<Alpinist> alpinists;
}
