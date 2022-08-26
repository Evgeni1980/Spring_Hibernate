package ru.kremenia;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import org.hibernate.cfg.Configuration;
import ru.kremenia.model.Product;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .buildSessionFactory();

        EntityManager entityManager = entityManagerFactory.createEntityManager();

        // Insert
        entityManager.getTransaction().begin();

        entityManager.persist(new Product("product_1",1000));
        entityManager.persist(new Product("product_2",2000));
        entityManager.persist(new Product("product_3",3000));

        entityManager.getTransaction().commit();

        entityManager.close();
        entityManagerFactory.close();
    }
}

// SELECT
//        Product products = entityManager.find(Product.class, 1L);

// JPQL, HQL
//        List<Product> products = entityManager.createQuery("select p from Product p where p.id in (1, 2)", Product.class)
//                .getResultList();
//
//        for (Product productFromDb : products) {
//            System.out.println(productFromDb);
//        }

// UPDATE
//        entityManager.getTransaction().begin();
//
//        Product product = entityManager.find(Product.class, 1L);
//        product.setProductName("new productName");
//
//        entityManager.getTransaction().commit();
//
//        entityManager.getTransaction().begin();
//
//        Product products = new Product("Product2New", 4000);
//        products.setId(2L);
//        entityManager.merge(products);
//
//        entityManager.getTransaction().commit();

// DELETE
//        entityManager.getTransaction().begin();
//
//        Product product = entityManager.find(Product.class, 2L);
//        entityManager.remove(product);
//        entityManager.createQuery("delete from Product p where p.id = 3").executeUpdate();
//
//        entityManager.getTransaction().commit();


// Java text blocks
//        Object singleResult = entityManager.createNativeQuery("""
//                            select p.id as userId
//                            from product p
//                            where p.productName like '%brain%'
//                """, String.class).getSingleResult();



