package com.parcel.model.domain.forum;

import com.parcel.model.domain.user.DtoUser;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.Date;

@Data
@Entity(name = "COMMENTS")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DtoComments {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "COMMENT_ID", nullable = false)
    private Long id;

    @Column(name = "COMMENT", nullable = false, length = 255)
    private String comment;

    @Column(name = "FORUM_ID", nullable = false)
    private Long forumId;

    @Column(name = "DATE", nullable = false)
    private String date;

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "FORUM_ID")
//    private DtoForum forum;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "USER_ID")
    private DtoUser user;
}
