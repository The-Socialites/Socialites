package com.makersacademy.acebook.model;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;

@Data
@Entity
@Table(name="COMMENTS")
@NoArgsConstructor
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Getter
    @Setter
    private String content;
    @ManyToOne
    @JoinColumn(name="user_id", nullable = false)
    private User user;
    @ManyToOne
    @JoinColumn(name="event_id", nullable = false)
    private Event event;

    @Column(nullable = false, updatable = false)
    @CreationTimestamp
    private java.sql.Timestamp createdAt;

    public Comment(String content, User user, Event event, java.sql.Timestamp createdAt) {
        this.content = content;
        this.createdAt = createdAt;
        this.user = user;
        this.event = event;
    }
}

//package com.makersacademy.acebook.model;
//
//import lombok.*;
//        import org.hibernate.annotations.CreationTimestamp;
//
//import javax.persistence.*;
//
//@Data
//@Entity
//@Table(name="COMMENTS")
//@NoArgsConstructor
//public class Comment {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    @Getter
//    @Setter
//    private String content;
//    @ManyToOne
//    @JoinColumn(name="user_id", nullable = false)
//    private User user;
//    @ManyToOne
//    @JoinColumn(name="event_id", nullable = false)
//    private Event event;
//
//    @Column(nullable = false, updatable = false)
//    @CreationTimestamp
//    private java.sql.Timestamp createdAt;
//
//    public Comment(String content, User user, Event event, java.sql.Timestamp createdAt) {
//        this.content = content;
//        this.createdAt = createdAt;
//        this.user = user;
//        this.event = event;
//    }
//}
