package com.example.firstproject.service;

import com.example.firstproject.dto.CoffeeForm;
import com.example.firstproject.entity.Coffee;
import com.example.firstproject.repository.CoffeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CoffeeService {

    @Autowired
    private CoffeeRepository coffeeRepository;

    public List<Coffee> index(){
        return coffeeRepository.findAll();
    }

    public Coffee show(Long id){
        return coffeeRepository.findById(id).orElse(null);
    }

    public Coffee create(CoffeeForm dto){
        Coffee coffee = dto.toEntity();
        return coffeeRepository.save(coffee);
    }

    public Coffee update(Long id, CoffeeForm dto){
        Coffee coffee = dto.toEntity();
        Coffee target = coffeeRepository.findById(id).orElse(null);
        target.patch(coffee);
        return coffeeRepository.save(target);
    }

    public Coffee delete(Long id){
        Coffee coffee = coffeeRepository.findById(id).orElse(null);
        coffeeRepository.delete(coffee);
        return coffee;
    }

}
