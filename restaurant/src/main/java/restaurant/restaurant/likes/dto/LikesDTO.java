package restaurant.restaurant.likes.dto;

import lombok.Getter;
import lombok.Setter;
import restaurant.restaurant.myplace.entity.MyplaceEntity;


@Getter
@Setter
public class LikesDTO {
    private int id;
    private int myplaceId;
    private int userId;

    private MyplaceEntity myplaceEntity;
}
