package restaurant.restaurant.dto;

import lombok.*;
import org.apache.catalina.User;
import restaurant.restaurant.entity.MyplaceEntity;
import restaurant.restaurant.entity.UserEntity;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@NoArgsConstructor // 기본 생성자
@AllArgsConstructor // 모든 필드를 매개변수로 하는 생성자
public class MyplaceDTO {

    private int id;
    private String placeName;
    private String address;
    private String category;
    private String contents;
    private byte[] photo;
    private boolean share;
    private int likes;
    private int views;
    private LocalDateTime createdTime;
    private LocalDateTime updatedTime;


    private UserEntity user;
    private int userId;
    private String userNickname;

    public MyplaceDTO(int id, String placeName, String address, String category, String contents,
                      boolean share, int views, int likes, LocalDateTime createdTime,
                      int userId, String userNickname) {
        this.id = id;
        this.placeName = placeName;
        this.address = address;
        this.category = category;
        this.contents = contents;
        this.share = share;
        this.views = views;
        this.likes = likes;
        this.createdTime = createdTime;
        this.userId = userId;
        this.userNickname = userNickname;
    }

    public static MyplaceDTO toMyplaceDTO(MyplaceEntity myplaceEntity) {
        MyplaceDTO myplaceDTO = new MyplaceDTO();

        myplaceDTO.setId(myplaceEntity.getId());
        myplaceDTO.setPlaceName(myplaceEntity.getPlaceName());
        myplaceDTO.setAddress(myplaceEntity.getAddress());
        myplaceDTO.setCategory(myplaceEntity.getCategory());
        myplaceDTO.setContents(myplaceEntity.getContents());
        myplaceDTO.setViews(myplaceEntity.getViews());
        myplaceDTO.setLikes(myplaceEntity.getLikes());
        myplaceDTO.setCreatedTime(myplaceEntity.getCreatedTime());
        myplaceDTO.setUpdatedTime(myplaceEntity.getUpdatedTime());
        myplaceDTO.setShare(myplaceEntity.isShare());
        myplaceDTO.setUserId(myplaceEntity.getUserId());
        myplaceDTO.setUserNickname(myplaceEntity.getUser().getNickname());

        return myplaceDTO;

    }

}