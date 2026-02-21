package poshlie_parni.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "banks")
public class Banks {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "person_id" , nullable = false)
    private Person person;



    @Column(name = "bank_code", nullable = false, length = 50)
    private String bankCode;

    @Column(name = "grace_period_days")
    private Integer gracePeriodDays;

    @Column(name = "loan_amount")
    private BigDecimal loanAmount;

    @Column(name = "loan_start")
    private LocalDate loanStart;

    @Column(name = "grace_period_gap")
    private Integer gracePeriodGap;
}
