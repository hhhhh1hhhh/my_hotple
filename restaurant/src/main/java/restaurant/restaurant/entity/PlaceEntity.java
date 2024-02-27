package restaurant.restaurant.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Setter
@Getter
public class PlaceEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String category; // 카테고리

    private String placeName; // 장소 이름

    private String address; // 주소

    private String content; // 내용

    private String photo; // 사진

    private boolean share; // 공유 여부

    private int likes;

    private int views;

    @Temporal(TemporalType.TIMESTAMP)
    private Date creationDate;  // 작성한 날짜

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private UserEntity user;

}
