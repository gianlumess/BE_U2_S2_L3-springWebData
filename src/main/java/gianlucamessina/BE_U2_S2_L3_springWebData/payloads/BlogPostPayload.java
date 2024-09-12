package gianlucamessina.BE_U2_S2_L3_springWebData.payloads;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.UUID;
@Getter
@AllArgsConstructor
public class BlogPostPayload {
    private UUID authorId;
    private String categoria;
    private String titolo;
    private String cover;
    private String contenuto;
    private int tempoLettura;


}
