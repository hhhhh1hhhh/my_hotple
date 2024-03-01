package restaurant.restaurant.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.apache.catalina.User;
import restaurant.restaurant.dto.MyplaceDTO;


@Entity
@Setter
@Getter
public class MyplaceEntity extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String placeName; // 장소 이름

    @Column(nullable = false)
    private String address; // 주소

    private String category; // 카테고리

    @Column(length = 500)
    private String contents; // 내용

    private byte[] photo; // 사진

    private boolean share; // 공유 여부

    private int likes; // 좋아요

    private int views; // 조회수

    @ManyToOne
    @JoinColumn(name = "userId", referencedColumnName = "id")
    private UserEntity user;

    // 다음 메서드를 이용하여 userId 값을 설정
    public void setUserId(int userId) {
        this.user = new UserEntity();
        this.user.setId(userId);
    }

    // userId 값을 반환하는 메서드
    public int getUserId() {
        return this.user != null ? this.user.getId() : 0;
    }

    public static MyplaceEntity toSaveEntity(MyplaceDTO myplaceDTO) {
        MyplaceEntity myplaceEntity = new MyplaceEntity();
        myplaceEntity.setPlaceName(myplaceDTO.getPlaceName());
        myplaceEntity.setAddress(myplaceDTO.getAddress());
        myplaceEntity.setCategory(myplaceDTO.getCategory());
        myplaceEntity.setContents(myplaceDTO.getContents());
        myplaceEntity.setViews(0);
        myplaceEntity.setLikes(0);
        myplaceEntity.setShare(myplaceDTO.isShare());
        myplaceEntity.setUserId(myplaceDTO.getUserId());

        return myplaceEntity;

    }
}
