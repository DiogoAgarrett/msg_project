package exercicio2.repositories;

import exercicio2.domain.Edition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface EditionRepository  extends JpaRepository<Edition, UUID> {
    Optional<Edition> findByEditionNumberAndBook_Code(String editionNumber, String bookCode);
}
