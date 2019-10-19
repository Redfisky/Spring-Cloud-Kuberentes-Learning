package china.nanjing.mykingdom.repository;

import china.nanjing.mykingdom.object.Duchy;
import china.nanjing.mykingdom.object.estates_general.Noble;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @author Chen Hongyu
 */
public interface NobleRepository extends JpaRepository<Noble, Long>, JpaSpecificationExecutor<Noble> {
}
