package poshlie_parni.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import poshlie_parni.entity.Banks;

import java.util.List;

@Repository
public interface BankRepository extends JpaRepository<Banks, Long> {
    List<Banks> findByPersonId(Long personId);
}
