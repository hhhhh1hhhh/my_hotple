package restaurant.restaurant.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
public class CommentDTO {
    private int id;
    private String commentWriter;
    private String commentContents;
    private int myplaceId;
    private LocalDateTime commentCreatedTime;

}
