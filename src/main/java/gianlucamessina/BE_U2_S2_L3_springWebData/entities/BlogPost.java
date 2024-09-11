package gianlucamessina.BE_U2_S2_L3_springWebData.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "blog_posts")
public class BlogPost {
    @Id
    @GeneratedValue
    @Setter(AccessLevel.NONE)
    private UUID id;
    private String categoria;
    private String titolo;
    private String cover;
    private String contenuto;
    @ManyToOne
    @JoinColumn(name = "utente_id")
    private Author author;
    @Column(name = "tempo_lettura")
    private int tempoLettura;
}
