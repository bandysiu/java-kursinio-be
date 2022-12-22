package com.parcel.model.domain.forum;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Entity(name = "FORUM")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DtoForum {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "FORUM_ID", nullable = false)
    private Long id;

    @Column(name = "FORUM_NAME", nullable = false, length = 20)
    private String forumName;

    @OneToMany(mappedBy = "forum")
    private List<DtoComments> comments;
}
