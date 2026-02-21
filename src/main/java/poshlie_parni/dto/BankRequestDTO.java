package poshlie_parni.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data

public class BankRequestDTO {

    private String bankCode;
    private Integer gracePeriodDays;
    private BigDecimal loanAmount;
    private LocalDate loanStart;
    private Integer gracePeriodGap;
}
