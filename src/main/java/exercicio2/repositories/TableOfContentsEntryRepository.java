package exercicio2.repositories;

import exercicio2.domain.TableOfContentsEntry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface TableOfContentsEntryRepository extends JpaRepository<TableOfContentsEntry, UUID> {
    List<TableOfContentsEntry> findByEditionIdAndParentIsNull(UUID editionId);
    List<TableOfContentsEntry> findByEditionId(UUID editionId);
}
