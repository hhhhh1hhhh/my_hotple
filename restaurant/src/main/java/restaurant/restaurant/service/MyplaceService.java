package restaurant.restaurant.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import restaurant.restaurant.dto.MyplaceDTO;
import restaurant.restaurant.entity.MyplaceEntity;
import restaurant.restaurant.repository.MyplaceRepository;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MyplaceService {

    private final MyplaceRepository myplaceRepository;

    public void save(MyplaceDTO myplaceDTO) {
        MyplaceEntity myplaceEntity = MyplaceEntity.toSaveEntity(myplaceDTO);
        myplaceRepository.save(myplaceEntity);
    }


    public List<MyplaceDTO> findAll() {
        List<MyplaceEntity> myplaceEntityList = myplaceRepository.findAll();
        List<MyplaceDTO> myplaceDTOList = new ArrayList<>();

        for (MyplaceEntity myplaceEntity: myplaceEntityList) {
            myplaceDTOList.add(MyplaceDTO.toMyplaceDTO(myplaceEntity));
        }

        return myplaceDTOList;
    }

}
