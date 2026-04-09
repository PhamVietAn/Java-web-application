package ra.edu.ex05.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ra.edu.ex05.model.Dish;
import ra.edu.ex05.repository.DishRepository;

import java.util.List;
import java.util.Optional;

@Service
public class AdminDishService {

    @Autowired
    private DishRepository dishRepository;

    public List<Dish> getAllDishes() {
        return dishRepository.findAll();
    }

    public Optional<Dish> findById(Long id) {
        return dishRepository.findById(id);
    }

    public boolean updateDish(Long id, Dish updatedDish) {
        updatedDish.setId(id);
        return dishRepository.update(updatedDish);
    }
}