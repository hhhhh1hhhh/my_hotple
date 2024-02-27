package restaurant.restaurant.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import restaurant.restaurant.dto.MyplaceDTO;


@Entity
@Setter
@Getter

public class MyplaceEntity extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String placeName; // 장소 이름

    private String address; // 주소

    private String category; // 카테고리

    @Column(length = 500)
    private String contents; // 내용

    private byte[] photo; // 사진

    private boolean share; // 공유 여부

    private int likes; // 좋아요

    private int views; // 조회수

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
//    @Column(nullable = false)
    private UserEntity user;

    public static MyplaceEntity toSaveEntity(MyplaceDTO myplaceDTO) {
        MyplaceEntity myplaceEntity = new MyplaceEntity();
        myplaceEntity.setPlaceName(myplaceDTO.getPlaceName());
        myplaceEntity.setAddress(myplaceDTO.getAddress());
        myplaceEntity.setCategory(myplaceDTO.getCategory());
        myplaceEntity.setContents(myplaceDTO.getContents());
        myplaceEntity.setViews(0);

        return myplaceEntity;
    }
}
