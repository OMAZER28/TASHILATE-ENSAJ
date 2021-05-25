package ma.ensaj.wePayment.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ma.ensaj.wePayment.beans.WaterElectricity;

public interface WeRepository extends JpaRepository<WaterElectricity, Integer> {
	
	WaterElectricity findById(int id);
	
	@Query("SELECT we FROM WaterElectricity we WHERE we.contractNbr=:contractNbr AND agency=:agency AND isPaid=false")
	Collection<?> findPaymentByContractNumber(@Param("contractNbr") String contractNbr,@Param("agency") String agency);

}
