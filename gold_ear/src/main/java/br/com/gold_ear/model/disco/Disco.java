package br.com.gold_ear.model.disco;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.UuidGenerator;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "disco")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Disco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_disco")
    private Long id;

    @UuidGenerator
    private UUID uuid;

    @Column(nullable = false, length = 80)
    private String nome;

    @Column(name = "ano_lancamento")
    private Integer anoLancamento;

    @Column(length = 300)
    private String capa;
}

