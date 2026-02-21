package poshlie_parni.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

public class BankResponseDTO {
    private String bankCode;
    private Integer gracePeriodDays;
    private BigDecimal loanAmount;
    private LocalDate loanStart;
    private Integer gracePeriodGap;

    // Конструктор для упрощения создания объектов
    public BankResponseDTO(String bankCode, Integer gracePeriodDays, BigDecimal loanAmount, LocalDate loanStart, Integer gracePeriodGap) {
        this.bankCode = bankCode;
        this.gracePeriodDays = gracePeriodDays;
        this.loanAmount = loanAmount;
        this.loanStart = loanStart;
        this.gracePeriodGap = gracePeriodGap;
    }
}
