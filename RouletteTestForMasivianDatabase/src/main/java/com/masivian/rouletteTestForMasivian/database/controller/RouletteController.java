package com.masivian.rouletteTestForMasivian.database.controller;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.masivian.rouletteTestForMasivian.database.entity.Bet;
import com.masivian.rouletteTestForMasivian.database.entity.Roulette;
import com.masivian.rouletteTestForMasivian.database.repository.RouletteRepository;
import com.masivian.rouletteTestForMasivian.database.services.BetService;
import com.masivian.rouletteTestForMasivian.database.utils.ValidateFields;
 
@RestController
@CrossOrigin
@RequestMapping("/roulettes")
public class RouletteController {
 
    @Autowired
    private RouletteRepository rouletteRepository;
    
    @Autowired
    private BetService betService;
 
    @PostMapping("/save_roulettes")
    public ResponseEntity<HashMap<String, Object>> createRoulette(@RequestBody Bet bet){
    	boolean isValidate = ValidateFields.validateFields(bet);
    	ResponseEntity<HashMap<String, Object>> response = null;
    	
    	if (isValidate) {
    		response = betService.createBet(bet); 
    		return response;
		}    	 	
    	HashMap<String, Object> aux=new HashMap<String, Object>(); 
    	response = new ResponseEntity<HashMap<String, Object>>(aux, HttpStatus.BAD_REQUEST);
        return response;
    }
 
    @GetMapping("all_roulettes")
    public List<Roulette> list(){
        return rouletteRepository.findAll();
    }
 
    @GetMapping("/{id}")
    public Roulette getroulette(@PathVariable String id){
        return rouletteRepository.findById(id);
    }
 
    @PutMapping
    public Roulette update(@RequestBody Roulette roulette){
        rouletteRepository.update(roulette);
        
        return roulette;
    }
 
    @DeleteMapping("/{id}")
    public String deleteroulette(@PathVariable String id){
        rouletteRepository.delete(id);
        
        return id;
    } 
}
