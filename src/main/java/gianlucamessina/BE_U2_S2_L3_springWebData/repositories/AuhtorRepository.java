package gianlucamessina.BE_U2_S2_L3_springWebData.repositories;

import gianlucamessina.BE_U2_S2_L3_springWebData.entities.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface AuhtorRepository extends JpaRepository<Author, UUID> {

}
