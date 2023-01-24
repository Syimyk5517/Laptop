package org.example.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Query;
import org.example.config.HibernateConfig;
import org.example.entity.Laptop;
import org.hibernate.HibernateException;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LaptopDaoImpl implements LaptopDao {

    private final EntityManagerFactory entityManagerFactory=HibernateConfig.entityManagerFactory();

    @Override
    public Laptop saveProgrammer(Laptop laptop) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.merge(laptop);
        entityManager.getTransaction().commit();
        entityManager.close();
        return laptop;

    }

    @Override
    public List<Laptop> saveAll(List<Laptop> laptops) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(laptops);
        entityManager.getTransaction().commit();
        entityManager.close();
        return laptops;
    }

    @Override
    public Laptop deleteById(Long id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        Laptop id1 = entityManager.createQuery("delete from Laptop where  id =:id", Laptop.class).setParameter("id", id).getSingleResult();
        entityManager.getTransaction().commit();
        entityManager.close();
        return id1;
    }

    @Override
    public void deleteAll() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction();
        entityManager.getTransaction().begin();
        entityManager.createQuery("delete from Laptop ");
        entityManager.getTransaction().commit();
        entityManager.close();

    }

    @Override
    public List<Laptop> findAll() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        List<Laptop> laptops1 = entityManager.createQuery("select  l from Laptop l", Laptop.class).getResultList();
        entityManager.getTransaction().commit();
        entityManager.close();
        return laptops1;
    }

    @Override
    public Laptop update(Long id, Laptop laptop) {
        return null;
    }

    @Override
    public Map<String, List<Laptop>> groupBy() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        Map<String,List<Laptop>> map = entityManager.createQuery("select l from Laptop l ",Laptop.class).getResultStream().
                collect(Collectors.groupingBy(Laptop::getOpertionSystem));
        entityManager.getTransaction().commit();
        entityManager.close();
        return map;
    }

    @Override
    public List<Laptop> sortByDifferentColumn(String column, String ascOrDesc) {
        List<Laptop> laptops = new ArrayList<>();
        try{
            EntityManager entityManager = entityManagerFactory.createEntityManager();
            entityManager.getTransaction().begin();
            String sql = "SELECT l FROM Laptop ORDER BY " + column + " " + ascOrDesc;
            laptops = entityManager.createQuery(sql).getResultList();
            entityManager.getTransaction().commit();
            entityManager.close();
        }catch (HibernateException e){
            System.out.println(e.getMessage());
        }
        return laptops;
    }

    @Override
    public void close() throws Exception {
      entityManagerFactory.close();


    }
    public void saveMy(){
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction();
        entityManager.getTransaction().begin();
        entityManager.createQuery("delete from Laptop ", Laptop.class).getResultList();
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    }

