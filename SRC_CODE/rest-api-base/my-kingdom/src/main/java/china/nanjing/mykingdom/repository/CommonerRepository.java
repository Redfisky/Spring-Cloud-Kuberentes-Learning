package china.nanjing.mykingdom.repository;

import china.nanjing.mykingdom.object.estates_general.Clergy;
import china.nanjing.mykingdom.object.estates_general.Commoner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @author Chen Hongyu
 */
public interface CommonerRepository extends JpaRepository<Commoner, Long>, JpaSpecificationExecutor<Commoner> {
}
