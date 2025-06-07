package mk.ukim.finki.fooddeliverybackend.service.domain.impl;

import mk.ukim.finki.fooddeliverybackend.model.domain.Dish;
import mk.ukim.finki.fooddeliverybackend.model.domain.Order;
import mk.ukim.finki.fooddeliverybackend.model.exceptions.DishOutOfStockException;
import mk.ukim.finki.fooddeliverybackend.repository.DishRepository;
import mk.ukim.finki.fooddeliverybackend.repository.OrderRepository;
import mk.ukim.finki.fooddeliverybackend.service.domain.DishService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DishServiceImpl implements DishService {

    private final DishRepository dishRepository;
    private final OrderRepository orderRepository;

    public DishServiceImpl(DishRepository dishRepository, OrderRepository orderRepository) {
        this.dishRepository = dishRepository;
        this.orderRepository = orderRepository;
    }

    @Override
    public List<Dish> findAll() {
        // TODO: Implement this.
        return dishRepository.findAll();
    }

    @Override
    public Optional<Dish> findById(Long id) {
        return dishRepository.findById(id);
    }

    @Override
    public Dish save(Dish dish) {
        // TODO: Implement this.
        return dishRepository.save(dish);
    }

    @Override
    public Optional<Dish> update(Long id, Dish dish) {
        // TODO: Implement this.
        return findById(id)
                .map(i->{
                    i.setName(dish.getName());
                    i.setDescription(dish.getDescription());
                    i.setPrice(dish.getPrice());
                    i.setQuantity(dish.getQuantity());
                    i.setRestaurant(dish.getRestaurant());
                    dishRepository.save(i);
                    return i;
                });
    }

    @Override
    public Optional<Dish> deleteById(Long id) {
        // TODO: Implement this.
        Optional <Dish> dish=dishRepository.findById(id);
        dishRepository.delete(dish.get());
        return dish;
    }

    @Override
    public Order addToOrder(Dish dish, Order order) {
        // TODO: Implement this.
        if(dish.getQuantity()==0) throw new DishOutOfStockException(dish.getId());
        order.getDishes().add(dish);
        dish.decreaseQuantity();
        orderRepository.save(order);
        return order;
    }

    @Override
    public Order removeFromOrder(Dish dish, Order order) {
        // TODO: Implement this.
        order.getDishes().remove(dish);
        dish.increaseQuantity();
        orderRepository.save(order);
        return order;
    }

}
