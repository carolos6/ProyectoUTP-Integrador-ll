package com.plastics.UTPplastics.entities;

import jakarta.persistence.*;
import lombok.*;
import org.antlr.v4.runtime.misc.NotNull;
import org.hibernate.annotations.BatchSize;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.aot.generate.GeneratedTypeReference;
import org.springframework.boot.autoconfigure.web.WebProperties;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "customers")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer id;
    private String first_name;
    private String last_name;
    private String email;
    private String address;
    private String cellular_phone;
    private String dni;
    private String password;
    @Basic(optional = false)
    @NotNull
    @Column(name = "estado")
    private String estado;
    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;

    @JoinColumn(name = "tipo_persona_id", referencedColumnName = "id")
    @ManyToOne
    private TypePerson tipoPersonaId;
}


