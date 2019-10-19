package china.nanjing.mykingdom.repository;

import china.nanjing.mykingdom.object.Kingdom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @author Chen Hongyu
 */
public interface KingdomRepository extends JpaRepository<Kingdom, Long>, JpaSpecificationExecutor<Kingdom> {
}
