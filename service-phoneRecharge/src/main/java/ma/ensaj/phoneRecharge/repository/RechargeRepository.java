package ma.ensaj.phoneRecharge.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ma.ensaj.phoneRecharge.beans.Recharge;


public interface RechargeRepository extends JpaRepository<Recharge, Integer> {
	Recharge findById(int id);
	
	@Query("SELECT id,amount,date,numTel,typeRecharge FROM Recharge r WHERE r.numTel=:numTel")
	Collection<?> findRechargeByTelNumber(@Param("numTel") int numTel);
}