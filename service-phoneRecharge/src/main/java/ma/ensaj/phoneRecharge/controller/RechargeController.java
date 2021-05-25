package ma.ensaj.phoneRecharge.controller;

import java.util.Calendar;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ma.ensaj.phoneRecharge.beans.Recharge;
import ma.ensaj.phoneRecharge.exception.TelephoneIntrouvableException;
import ma.ensaj.phoneRecharge.repository.RechargeRepository;

@RestController
@RequestMapping("")
public class RechargeController {
	@Autowired
	private RechargeRepository repository;
	
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@PostMapping("/recharge")
	public Recharge save(@RequestBody Recharge recharge){
		String numTel = recharge.getNumTel();
		if(numTel.substring(0,2).equals("06") || numTel.substring(0,2).equals("07")) {
			if(numTel.length()==10) {
				recharge.setDate(Calendar.getInstance().getTime());
				repository.save(recharge);
				return recharge;
			}
		}
		return null;
	}
	
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@GetMapping("/all")
	public List<Recharge>findAll(){
		return repository.findAll();
	}
	
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable (required = true) String id){
		Recharge r = repository.findById(Integer.parseInt(id));
		repository.delete(r);
	}

	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@GetMapping(value = "/count")
	public long countRecharge() {
		return repository.count();
	}

	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@GetMapping(value = "/all/{numTel}")
	public Collection<?> findRechargeByTelNumber(@PathVariable(required = true) int numTel) {

		return repository.findRechargeByTelNumber(numTel);
	}
}
