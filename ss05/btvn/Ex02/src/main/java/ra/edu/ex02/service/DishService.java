package ra.edu.ex02.service;

import org.springframework.stereotype.Service;
import ra.edu.ex02.model.Dish;

import java.util.ArrayList;
import java.util.List;

@Service
public class DishService {

    public List<Dish> getAllDishes() {
        List<Dish> list = new ArrayList<>();

        list.add(new Dish(1, "Phở bò", 50000, true));
        list.add(new Dish(2, "Bún chả", 45000, false));
        list.add(new Dish(3, "Cơm rang", 40000, true));

        return list;
    }
}
