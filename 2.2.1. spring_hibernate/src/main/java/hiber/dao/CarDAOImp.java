package hiber.dao;

import hiber.model.Car;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.List;
@Repository
public class CarDAOImp implements CarDao{
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void add(Car car) {
        sessionFactory.getCurrentSession().save(car);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Car> listCars() {
        TypedQuery<Car> query=sessionFactory.getCurrentSession().createQuery("from Car");
        return query.getResultList();
    }

    @Override
    public Car getUserCar(long usesrId) {
        TypedQuery<Car> query=sessionFactory.getCurrentSession().createQuery("from Car where id=:userId");
        query.setParameter("userId", usesrId);
        return query.getSingleResult();
    }

    public void deleteAllCars() {
        List<Car> cars = listCars();
        for (Car car: cars) {
            sessionFactory.getCurrentSession().delete(car);
        }
    }


}
