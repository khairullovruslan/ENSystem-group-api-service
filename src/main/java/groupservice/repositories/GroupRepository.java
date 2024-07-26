package groupservice.repositories;

import groupservice.models.Group;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GroupRepository  extends JpaRepository<Group, Long> {
}
