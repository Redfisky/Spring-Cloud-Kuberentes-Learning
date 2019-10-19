package china.nanjing.mykingdom.repository;

import china.nanjing.mykingdom.object.Duchy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @author Chen Hongyu
 */
public interface DuchyRepository extends JpaRepository<Duchy, Long>, JpaSpecificationExecutor<Duchy> {
}
