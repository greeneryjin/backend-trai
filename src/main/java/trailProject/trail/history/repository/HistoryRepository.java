package trailProject.trail.history.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import trailProject.trail.history.entity.History;

public interface HistoryRepository extends JpaRepository<History, Long> {

    Page<History> findAllByAccountId(Pageable pageable, Long id);

}