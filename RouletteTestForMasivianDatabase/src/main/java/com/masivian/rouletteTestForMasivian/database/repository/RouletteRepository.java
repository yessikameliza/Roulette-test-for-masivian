package com.masivian.rouletteTestForMasivian.database.repository;

import java.util.List;

import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import com.masivian.rouletteTestForMasivian.database.entity.Roulette;

@Repository
public class RouletteRepository {		
    public static final String ROULETTE_KEY = "ROULETTE";	 
    private HashOperations<String, String, Roulette> hashOperations; 
    private RedisTemplate<String, ?> redisTemplate;
 
    public RouletteRepository(RedisTemplate<String, ?> redisTemplate){
        this.redisTemplate = redisTemplate;
        this.hashOperations = this.redisTemplate.opsForHash();
    }
 
    public Long save(Roulette roulette) {
    	hashOperations.put(ROULETTE_KEY, Long.toString(roulette.getId()), roulette);
    	
    	return roulette.getId();
    }
 
    public List<Roulette> findAll(){
        return hashOperations.values(ROULETTE_KEY);
    }
 
    public Roulette findById(String id) {
        return (Roulette) hashOperations.get(ROULETTE_KEY, id);
    }
 
    public void update(Roulette roulette) {
        save(roulette);
    }
 
    public void delete(String id) {
        hashOperations.delete(ROULETTE_KEY, id);
    } 
}
