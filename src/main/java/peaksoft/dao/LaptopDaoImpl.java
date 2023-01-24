package peaksoft.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Query;
import peaksoft.OperationSystem;
import peaksoft.config.DatabaseConnection;
import peaksoft.model.Laptop;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LaptopDaoImpl implements LaptopDao, AutoCloseable {
    private EntityManagerFactory entityManagerFactory = DatabaseConnection.createEntityManagerFactory();


    @Override
    public Laptop saveProgrammer(Laptop laptop) {

        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(laptop);
        entityManager.getTransaction().commit();
        entityManager.close();
        return laptop;
    }

    @Override
    public List<Laptop> saveAll(List<Laptop> laptops) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        for (Laptop laptop : laptops) {
            entityManager.persist(laptop);
        }
        entityManager.getTransaction().commit();
        entityManager.close();
        return laptops;

    }

    @Override
    public Laptop deleteById(Long id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        Laptop laptop = entityManager.createQuery("select l from Laptop l where l.id=:id", Laptop.class).
                setParameter("id", id).getSingleResult();
        entityManager.remove(laptop);
        entityManager.getTransaction().commit();
        entityManager.close();
        return laptop;
    }

    @Override
    public void deleteAll() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.createQuery("delete from Laptop ").executeUpdate();
        entityManager.getTransaction().commit();
        entityManager.close();

    }

    @Override
    public List<Laptop> findAll() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        List<Laptop> laptop = entityManager.createQuery("from Laptop ", Laptop.class).getResultList();
        entityManager.getTransaction().commit();
        entityManager.close();

        return laptop;
    }

    @Override
    public Laptop update(Long id, Laptop laptop) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        Laptop laptop1 = entityManager.getReference(Laptop.class,id);
        laptop1.setBrand(laptop.getBrand());
        laptop1.setOperationSystem(laptop.getOperationSystem());
        laptop1.setMemory(laptop.getMemory());
        laptop1.setPrice(laptop.getPrice());
        laptop1.setDate_of_issue(laptop.getDate_of_issue());
        entityManager.getTransaction().commit();
        entityManager.close();

        return laptop1;
    }

    @Override
    public Map<OperationSystem, List<Laptop>> groupBy() {
        EntityManager entityManager=entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        Map<OperationSystem,List<Laptop>> laptopList= entityManager.createQuery
                ("select l from Laptop l", Laptop.class).getResultStream().
                collect(Collectors.groupingBy(Laptop::getOperationSystem));
        return laptopList;
    }

    @Override
    public List<Laptop> sortByDifferentColumn(String column, String ascOrDesc) {

        return null;
    }

    @Override
    public void close() throws Exception {
        entityManagerFactory.close();

    }
}
