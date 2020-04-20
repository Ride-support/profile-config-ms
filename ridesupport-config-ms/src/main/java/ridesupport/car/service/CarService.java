package ridesupport.car.service;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import ridesupport.car.model.Car;

import java.util.List;

@Stateless
public class CarService {

    @PersistenceContext
    EntityManager entityManager;

    public List<Car> getAllCars(int first, int maxResult) {
        return entityManager.createNamedQuery(Car.FIND_ALL)
                .setFirstResult(first).setMaxResults(maxResult).getResultList();
    }

    public Car getCarByPlates(String plateNumber){
        return entityManager.find(Car.class, plateNumber);
    }

    public void createCar(Car car) {
        entityManager.persist(car);
    }

    public Car updateCar(String plateNumber, Car car) {
        Car carToUpdate = entityManager.find(Car.class, plateNumber);
        carToUpdate.setPlateNumber(car.getPlateNumber());
        carToUpdate.setModel(car.getModel());
        carToUpdate.setBrand(car.getBrand());
        return entityManager.merge(carToUpdate);
    }

    public void deleteCar(String plateNumber) {
        Car carToDelete = entityManager.find(Car.class, plateNumber);
        entityManager.remove(carToDelete);
    }
}
