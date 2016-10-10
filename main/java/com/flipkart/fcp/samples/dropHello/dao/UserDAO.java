package com.flipkart.fcp.samples.dropHello.dao;

import java.util.ArrayList;
import java.util.List;

import com.flipkart.fcp.samples.dropHello.api.UserRes;
import com.flipkart.fcp.samples.dropHello.model.User;
import javax.persistence.*;
import com.google.common.base.Optional;

import javax.persistence.NamedQueries;
//import io.dropwizard.

/**
 * Created by satheesh.konidala on 29/06/16.
 */
public class UserDAO
{

    private EntityManager entityMgr;
    public UserDAO () {

        EntityManagerFactory entityManagerFactory;
        entityManagerFactory = Persistence.createEntityManagerFactory( "org.hibernate.tutorial.jpa" );
//        entityManagerFactory = Persistence.createEntityManagerFactory( "org.eclipse.persistence");
        entityMgr = entityManagerFactory.createEntityManager();
    }

    public List <UserRes> GetAll ()
    {
        entityMgr.getTransaction().begin();
        List <User> userList = entityMgr.createNamedQuery("User.GetAll").getResultList();
        List <UserRes> usersResList = new ArrayList<UserRes>();
        for (User u: userList)
        {
                usersResList.add(new UserRes(u));
        }
        entityMgr.getTransaction().commit();
        return usersResList;
    }

    public  UserRes FindByEmailId (Optional<String> emailId)
    {
        entityMgr.getTransaction().begin();
        UserRes userRes = (UserRes)entityMgr.createNamedQuery("User.FindByEmailId").setParameter("emailId", emailId).getSingleResult();
        entityMgr.getTransaction().commit();
        return userRes;
    }

}
