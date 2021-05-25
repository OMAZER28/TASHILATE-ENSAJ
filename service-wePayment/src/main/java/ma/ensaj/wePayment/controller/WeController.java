package ma.ensaj.wePayment.controller;

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

import ma.ensaj.wePayment.beans.WaterElectricity;
import ma.ensaj.wePayment.repository.WeRepository;

@RestController
@RequestMapping("")
public class WeController {
	@Autowired
	private WeRepository repository;
	
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@PostMapping("/pay")
	public WaterElectricity save(@RequestBody WaterElectricity we){
		WaterElectricity bill = repository.findById(we.getId());
		bill.setDate(Calendar.getInstance().getTime());
		bill.setIsPaid(true);
		repository.save(bill);
		return bill;
	}
	
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@PostMapping(value = "/allBills")
	public Collection<?> findPaymentByContractNumber(@RequestBody WaterElectricity we) {
		Collection<?> bills = repository.findPaymentByContractNumber(we.getContractNbr(),we.getAgency());
		if(bills.size() != 0) {
			return bills;
		}
		return null;
	}
	
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@GetMapping("/all")
	public List<WaterElectricity>findAll(){
		return repository.findAll();
	}
	
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable (required = true) String id){
		WaterElectricity r = repository.findById(Integer.parseInt(id));
		repository.delete(r);
	}

	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@GetMapping(value = "/count")
	public long countRecharge() {
		return repository.count();
	}

}
