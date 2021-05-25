package ma.ensaj.moneyTransfer.controller;

import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ma.ensaj.moneyTransfer.beans.Transfer;
import ma.ensaj.moneyTransfer.repository.TransferRepository;

@RestController
@RequestMapping("")
public class TransferController {
	@Autowired
	private TransferRepository transferRepository;
	
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@PostMapping("/sendMoney")
	public long sendMoney(@RequestBody Transfer transfer){
		transfer.setDateSending(Calendar.getInstance().getTime());
		transfer.setIsReceived(false);
		transferRepository.save(transfer);
		return transfer.getCode();
	}

	
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@PostMapping("/receiveMoney")
	public Transfer receiveMoney(@RequestBody Transfer t){
		Transfer transfer = transferRepository.findByCode(t.getCode());
		if(transfer != null) {
			transfer.setCinReceiver(t.getCinReceiver());
			transfer.setDateReceiving(Calendar.getInstance().getTime());
			transfer.setIsReceived(true);
			transferRepository.save(transfer);
		}
		return transfer;
	}
	
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@DeleteMapping("/{id}")
	public void delete(@PathVariable (required = true) String id){
		Transfer s = transferRepository.findById(Integer.parseInt(id));
		transferRepository.delete(s);
	}

	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@GetMapping("/{id}")
	public Transfer findById(@PathVariable (required = true) String id){
		return transferRepository.findById(Integer.parseInt(id));
	}
	
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@GetMapping("/findByCode/{code}")
	public Transfer findByCode(@PathVariable (required = true) String code){
		return transferRepository.findByCode(Long.parseLong(code));
	}
	
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@GetMapping("/all")
	public List<Transfer>findAll(){
		return transferRepository.findAll();
	}
}
