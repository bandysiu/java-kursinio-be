package com.parcel.model.domain.forum;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity(name = "Forum")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DtoForum {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "FORUM_ID", nullable = false)
    private Long id;

    @Column(name = "FORUM_NAME", nullable = false)
    private String name;

    @Column(name = "MANAGER", nullable = false)
    private Boolean isManager;
}
