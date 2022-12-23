package com.parcel.model.domain.user;

import com.parcel.model.domain.forum.DtoComments;
import com.parcel.model.domain.order.DtoCommission;
import com.parcel.model.domain.order.DtoTrip;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Entity(name = "USERS")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DtoUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "USER_ID", nullable = false)
    private Long id;

    @Column(name = "FIRST_NAME", nullable = false, length = 20)
    private String firstName;

    @Column(name = "LAST_NAME", nullable = false, length = 20)
    private String lastName;

    @Column(name = "EMAIL", nullable = false, length = 30, unique = true)
    private String email;

    @Column(name = "LOGIN", nullable = false, length = 20, unique = true)
    private String login;

    @Column(name = "PASSWORD", nullable = false, length = 20)
    private String password;

    @Column(name = "POSITION")
    private UserPosition position;

    @Column(name = "SALARY")
    private String salary;

    @Column(name = "STATUS")
    private UserStatus status;

    @OneToMany(mappedBy = "user")
    private List<DtoComments> comments;

    @OneToMany(mappedBy = "driver")
    private List<DtoTrip> trips;
}
