package com.flipkart.fcp.samples.dropHello.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.Length;
import  com.flipkart.fcp.samples.dropHello.dao.UserDAO;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by satheesh.konidala on 30/06/16.
 */

import javax.ws.rs.*;

import com.google.common.base.Optional;
import com.codahale.metrics.annotation.Timed;

import javax.ws.rs.core.MediaType;

@Produces(MediaType.APPLICATION_JSON)
@Path("/User")
public class UserApi {
    public UserApi() {

    }

    @GET
    @Path("/")
    @Timed
//    @UnitOfWork
    public List <UserRes> GetAll(@PathParam("id") Optional<String> id) {
        UserDAO userDao = new UserDAO();
        //return userDao.GetAll();
        UserRes r1 = new UserRes("a.b@abc.com","a","b","add1","500032");
        UserRes r2 = new UserRes("c.d@abc.com","c","d","add2","560103");
        List<UserRes> userList = new ArrayList<UserRes>();
        userList.add(r1);
        userList.add(r2);

        return userList;
    }

    //
    @GET
    @Path("/{id}")
    @Timed
    public UserRes FindByEMail
    (@PathParam("id") Optional<String> id) {
        UserDAO userDao = new UserDAO();
        return userDao.FindByEmailId(id);
//        return new HelloRes(counter.incrementAndGet(),value);
    }

/*        public List <UserRes> GetAll ()
        {
            entityMgr.getTransaction().begin();
            List <User> userList = entityMgr.createNamedQuery("User.GetAll").getResultList();
            List <UserRes> usersResList = new List<UserRes>;
            for (User u: userList)
            {
                usersResList.add(new UserRes(u));
            }
            entityMgr.getTransaction().commit();
            return usersResList;
        }

        public  UserRes FindByEmailId (String emailId)
        {
            entityMgr.getTransaction().begin();
            UserRes userRes = UserRes(entityMgr.createNamedQuery("User.FindByEmailId").setParameter("emailId", emailId).getFirstResult());
            entityMgr.getTransaction().commit();
            return userRes;
        }
        */

}
