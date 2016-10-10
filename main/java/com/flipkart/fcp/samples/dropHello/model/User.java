package com.flipkart.fcp.samples.dropHello.model;


import javax.persistence.*;
import lombok.Data;



/**
 * Created by satheesh.konidala on 29/06/16.
 */

@Entity
@Table (name = "user")
@NamedQueries ({
        @NamedQuery (name = "User.FindByEmailId", query = "select t from user where t.email_id = :emailId"),
        @NamedQuery (name = "User.FindByUserName", query = "select t from user where t.first_name = :firstName AND t.last_name = :lastName"),
        @NamedQuery (name = "User.GetAll", query = "select t from user"),

})

// @Data is a convenient shortcut annotation that bundles the features of @ToString, @EqualsAndHashCode, @Getter / @Setter and @RequiredArgsConstructor together: I
// In other words, @Data generates all the boilerplate that is normally associated with simple POJOs (Plain Old Java Objects) and beans: getters for all fields, setters for all non-final fields, and appropriate toString, equals and hashCode implementations that involve the fields of the class, and a constructor that initializes all final fields, as well as all non-final fields with no initializer that have been marked with @NonNull, in order to ensure the field is never null.
// @Basic(fetch=FetchType.LAZY)

@Data
public class User {
        @Id
        @GeneratedValue (strategy = GenerationType.IDENTITY)
        @Column (name = "id")
        private long id;

        @Column (name = "email_id")
        public String email_id;

        @Column (name = "first_name")
        public String first_name;

        @Column (name = "last_name")
        public String last_name;

        @Column (name = "address")
        public String address;

        @Column (name = "pincode")
        public String pincode;

}
