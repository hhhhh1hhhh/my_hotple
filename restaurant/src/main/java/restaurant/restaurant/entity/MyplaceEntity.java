package restaurant.restaurant.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.apache.catalina.User;
import restaurant.restaurant.dto.MyplaceDTO;

import java.util.ArrayList;
import java.util.List;


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

    private int fileAttached; // 1 or 0

    @ManyToOne
    @JoinColumn(name = "userId", referencedColumnName = "id")
    private UserEntity user;


    @OneToMany(mappedBy = "myplaceEntity", cascade = CascadeType.REMOVE, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<MyplaceFileEntity> myplaceFileEntities = new ArrayList<>();


    public void setUserId(int userId) {
        this.user = new UserEntity();
        this.user.setId(userId);
    }

    public int getUserId() {
        return this.user != null ? this.user.getId() : 0;
    }


    // 첨부 파일이 없는 경우에 호출
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
        myplaceEntity.setFileAttached(0); // 파일 없음.

        return myplaceEntity;

    }

    public static MyplaceEntity toSaveFileEntity(MyplaceDTO myplaceDTO) {

        MyplaceEntity myplaceEntity = new MyplaceEntity();

        myplaceEntity.setPlaceName(myplaceDTO.getPlaceName());
        myplaceEntity.setAddress(myplaceDTO.getAddress());
        myplaceEntity.setCategory(myplaceDTO.getCategory());
        myplaceEntity.setContents(myplaceDTO.getContents());
        myplaceEntity.setViews(0);
        myplaceEntity.setLikes(0);
        myplaceEntity.setShare(myplaceDTO.isShare());
        myplaceEntity.setUserId(myplaceDTO.getUserId());
        myplaceEntity.setFileAttached(1); // 파일 있음.

        return myplaceEntity;
    }

    public static MyplaceEntity toEditEntity(MyplaceDTO myplaceDTO) {

        MyplaceEntity myplaceEntity = new MyplaceEntity();

        myplaceEntity.setId(myplaceDTO.getId());
        myplaceEntity.setPlaceName(myplaceDTO.getPlaceName());
        myplaceEntity.setAddress(myplaceDTO.getAddress());
        myplaceEntity.setCategory(myplaceDTO.getCategory());
        myplaceEntity.setContents(myplaceDTO.getContents());
        myplaceEntity.setViews(myplaceDTO.getViews());
        myplaceEntity.setLikes(myplaceDTO.getLikes());
        myplaceEntity.setShare(myplaceDTO.isShare());
        myplaceEntity.setUserId(myplaceDTO.getUserId());

        return myplaceEntity;

    }

}
