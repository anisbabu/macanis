package com.armr.core.model;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.Type;



@Entity
@Data
@Table(name = "AUTH_USER_META")
public class AuthUserMeta {
    @Id
    @GeneratedValue//(strategy = GenerationType.IDENTITY)
    private String id;

    @Column(name = "json_data", columnDefinition = "CLOB")
    @Lob
    private String jsonData;

    @OneToOne(cascade = CascadeType.ALL) // One-to-One Relationship
    @JoinColumn(name = "Auth_User_id", referencedColumnName = "id") // Foreign Key
    private AuthUser authUser;

}


