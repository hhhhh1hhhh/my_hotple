package restaurant.restaurant.dto;

import lombok.*;
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

    // user_id 필드를 getUserId() 메서드로 변경
    private int userId;

    // 수정된 생성자 추가
    public MyplaceDTO(int userId) {
        this.userId = userId;
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

        return myplaceDTO;

    }

}