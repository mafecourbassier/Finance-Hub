package com.financehub.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

@Entity
@Table(name = "transactions")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "A descrição é obrigatória.")
    private String description;

    @NotNull(message = "O valor é obrigatório.")
    private Double amount;

    @NotBlank(message = "O tipo da transação é obrigatório.")
    private String type; // INCOME ou EXPENSE

    private String paymentMethod; // PIX, Crédito, Débito, Dinheiro

    @NotNull(message = "A data é obrigatória.")
    private LocalDate date;

    private String status; // PAID ou PENDING

    private boolean recurring;

    // RELACIONAMENTO COM CATEGORY
    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;

    // Construtor vazio obrigatório pelo JPA
    public Transaction() {}

    public Transaction(String description, Double amount, String type, String paymentMethod,
                       LocalDate date, String status, boolean recurring, Category category) {
        this.description = description;
        this.amount = amount;
        this.type = type;
        this.paymentMethod = paymentMethod;
        this.date = date;
        this.status = status;
        this.recurring = recurring;
        this.category = category;
    }

    // GETTERS E SETTERS
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public Double getAmount() { return amount; }
    public void setAmount(Double amount) { this.amount = amount; }

    public String getType() { return type; }
    public void setType(String type) { this.type = type; }

    public String getPaymentMethod() { return paymentMethod; }
    public void setPaymentMethod(String paymentMethod) { this.paymentMethod = paymentMethod; }

    public LocalDate getDate() { return date; }
    public void setDate(LocalDate date) { this.date = date; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public boolean isRecurring() { return recurring; }
    public void setRecurring(boolean recurring) { this.recurring = recurring; }

    public Category getCategory() { return category; }
    public void setCategory(Category category) { this.category = category; }
}
