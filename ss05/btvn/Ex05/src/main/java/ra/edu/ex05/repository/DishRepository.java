package ra.edu.ex05.repository;

import org.springframework.stereotype.Repository;
import ra.edu.ex05.model.Dish;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class DishRepository {
    private final List<Dish> dishes = new ArrayList<>();

    public DishRepository() {
        dishes.add(new Dish(1L, "Phở bò", 50000, true));
        dishes.add(new Dish(2L, "Bún chả", 45000, false));
        dishes.add(new Dish(3L, "Cơm rang", 40000, true));
    }

    public List<Dish> findAll() {
        return new ArrayList<>(dishes);
    }

    public Optional<Dish> findById(Long id) {
        return dishes.stream()
                .filter(dish -> dish.getId().equals(id))
                .findFirst();
    }

    public boolean update(Dish updatedDish) {
        return findById(updatedDish.getId())
                .map(existingDish -> {
                    existingDish.setName(updatedDish.getName());
                    existingDish.setPrice(updatedDish.getPrice());
                    existingDish.setAvailable(updatedDish.isAvailable());
                    return true;
                })
                .orElse(false);
    }
}