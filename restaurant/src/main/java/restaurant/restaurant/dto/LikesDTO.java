package restaurant.restaurant.dto;

import lombok.Getter;
import lombok.Setter;
import restaurant.restaurant.entity.MyplaceEntity;
import restaurant.restaurant.entity.UserEntity;

@Getter
@Setter
public class LikesDTO {
    private int id;

    private int myplaceId;

    private int userId;
}
