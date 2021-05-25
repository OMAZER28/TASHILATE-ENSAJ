package ma.ensaj.moneyTransfer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ma.ensaj.moneyTransfer.beans.Transfer;

public interface TransferRepository extends JpaRepository<Transfer, Integer> {
	Transfer findById(int id);
	
	@Query("SELECT t FROM Transfer t WHERE t.code= :code AND t.isReceived= false")
	Transfer findByCode(@Param("code") long code);
}
