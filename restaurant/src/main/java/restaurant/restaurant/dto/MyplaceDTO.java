package restaurant.restaurant.dto;

import lombok.*;
import org.springframework.web.multipart.MultipartFile;
import restaurant.restaurant.entity.MyplaceEntity;
import restaurant.restaurant.entity.MyplaceFileEntity;
import restaurant.restaurant.entity.UserEntity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

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

    private List<MultipartFile> File; // write.html -> Controller 파일 담는 용도
    private List<String> originalFileName; // 원본 파일 이름
    private List<String> storedFileName; // 서버 저장용 파일 이름
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
        myplaceDTO.setUser(myplaceEntity.getUser());

        myplaceDTO.setUserNickname(myplaceEntity.getUser().getNickname());

        if (myplaceEntity.getFileAttached() == 0) {
            myplaceDTO.setFileAttached(myplaceEntity.getFileAttached()); // 0
        } else {
            List<String> originalFileNameList = new ArrayList<>();
            List<String> storedFileNameList = new ArrayList<>();
            myplaceDTO.setFileAttached(myplaceEntity.getFileAttached()); // 1

            for(MyplaceFileEntity myplaceFileEntity: myplaceEntity.getMyplaceEntityList()) {
                originalFileNameList.add(myplaceFileEntity.getOriginalFileName());
                storedFileNameList.add(myplaceFileEntity.getStoredFileName());
            }
            myplaceDTO.setOriginalFileName(originalFileNameList);
            myplaceDTO.setStoredFileName(storedFileNameList);
        }

        return myplaceDTO;

    }
}

