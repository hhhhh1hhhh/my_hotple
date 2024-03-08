package restaurant.restaurant.dto;

import lombok.*;
import org.apache.catalina.User;
import org.springframework.web.multipart.MultipartFile;
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
    private boolean share;
    private int likes;
    private int views;

    private LocalDateTime createdTime;
    private LocalDateTime updatedTime;

    private UserEntity user;
    private int userId;
    private String userNickname;

    private MultipartFile file; // write.html -> Controller 파일 담는 용도
    private String originalFileName; // 원본 파일 이름
    private String storedFileName; // 서버 저장용 파일 이름
    private int fileAttached; // 파일 첨부 여부(첨부 1, 미첨부 0)

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
        if (myplaceEntity.getFileAttached() == 0) {
            myplaceDTO.setFileAttached(myplaceEntity.getFileAttached()); // 0
        } else {
            myplaceDTO.setFileAttached(myplaceEntity.getFileAttached()); // 1
            // 파일 이름을 가져가야 함.
            // originalFileName, storedFileName : myplace_file_table(MyplaceFileEntity)
            /* [JOIN]
            select *
            from myplace_table m, myplace_file_table mf
            where m.id=mf.myplace_id and where m.id=>;
             */
            myplaceDTO.setOriginalFileName(myplaceEntity.getMyplaceFileEntities().get(0).getOriginalFileName());
            myplaceDTO.setStoredFileName(myplaceEntity.getMyplaceFileEntities().get(0).getStoredFileName());

        }

        return myplaceDTO;

    }

}