package br.com.gold_ear.model.disco;
import br.com.gold_ear.model.usuario.Membro;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.UuidGenerator;

import java.util.UUID;

@Table(name = "avaliacao")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Avaliacao {

    @UuidGenerator
    private UUID uuid;

    @Column(precision = 4, scale = 2)
    private double nota;

    @ManyToOne
    @MapsId("idMembro")
    @JoinColumn(name = "id_membro")
    private Membro membro;

    @ManyToOne
    @MapsId("idDisco")
    @JoinColumn(name = "id_disco")
    private Disco disco;
}
