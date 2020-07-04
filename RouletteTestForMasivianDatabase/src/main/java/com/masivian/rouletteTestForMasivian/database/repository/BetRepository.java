package com.masivian.rouletteTestForMasivian.database.repository;

import java.util.List;

import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import com.masivian.rouletteTestForMasivian.database.entity.Bet;
 
@Repository
public class BetRepository {	
    public static final String BET_KEY = "bet";	 
    private HashOperations<String, String, Bet> hashOperations; 
    private RedisTemplate<String, ?> redisTemplate;
 
    public BetRepository(RedisTemplate<String, ?> redisTemplate){
        this.redisTemplate = redisTemplate;
        this.hashOperations = this.redisTemplate.opsForHash();
    }
 
    public void save(Bet bet) {
        hashOperations.put(BET_KEY, Long.toString(bet.getId()), bet);
    }
 
    public List<Bet> findAll(){
        return hashOperations.values(BET_KEY);
    }
 
    public Bet findById(String id) {
        return (Bet) hashOperations.get(BET_KEY, id);
    }
 
    public void update(Bet bet) {
    	save(bet);
    }
 
    public void delete(String id) {
    	hashOperations.delete(BET_KEY, id);
    } 
} 
 