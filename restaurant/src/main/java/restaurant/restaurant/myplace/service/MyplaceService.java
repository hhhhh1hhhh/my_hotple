package restaurant.restaurant.myplace.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;
import restaurant.restaurant.myplace.dto.MyplaceDTO;
import restaurant.restaurant.myplace.entity.MyplaceEntity;
import restaurant.restaurant.myplace.entity.MyplaceFileEntity;
import restaurant.restaurant.myplace.repository.MyplaceFileRepository;
import restaurant.restaurant.myplace.repository.MyplaceRepository;
import restaurant.restaurant.shared.service.SharedService;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MyplaceService {

    private final MyplaceRepository myplaceRepository;
    private final SharedService sharedService;
    private final MyplaceFileRepository myplaceFileRepository;

    public void save(MyplaceDTO myplaceDTO) throws IOException {

        System.out.println("myplaceDTO.getFile().isEmpty() = " + myplaceDTO.getFile().isEmpty());
        // 파일 첨부 여부에 따라 로직 분리
        if (myplaceDTO.getFile().isEmpty()) {
            // 첨부 파일 없음.
            MyplaceEntity myplaceEntity = MyplaceEntity.toSaveEntity(myplaceDTO);
            myplaceRepository.save(myplaceEntity);
        } else {
            MyplaceEntity myplaceEntity = MyplaceEntity.toSaveFileEntity(myplaceDTO);
            int savedId = myplaceRepository.save(myplaceEntity).getId(); // 6. myplace_table에 해당 데이터 save 처리
            MyplaceEntity myplace = myplaceRepository.findById(savedId).get(); // 7. myplace_file_table에 해당 데이터 save 처리

            for (MultipartFile file:  myplaceDTO.getFile()) {
                String originalFilename = file.getOriginalFilename(); // 2. 파일의 이름을 가져옴
                String storedFileName = System.currentTimeMillis() + "_" + originalFilename; // 3. 서버 저장용 이름을 만듦
                String savePath = "c:/springboot_img/" + storedFileName; // 4. 저장 경로 설정
                file.transferTo(new File(savePath));  // 5. 해당 경로에 파일 저장
                MyplaceFileEntity myplaceFileEntity = MyplaceFileEntity.toMyplaceFileEntity(myplace, originalFilename, storedFileName);
                myplaceFileRepository.save(myplaceFileEntity);
            }

        }
    }


    public List<MyplaceDTO> findByUserId(Model model) {
        Integer userId = (Integer) model.getAttribute("id");
        List<MyplaceEntity> myplaceEntityList = myplaceRepository.findByUser_Id(userId);
        List<MyplaceDTO> myplaceDTOList = new ArrayList<>();

        for (MyplaceEntity myplaceEntity : myplaceEntityList) {
            myplaceDTOList.add(MyplaceDTO.toMyplaceDTO(myplaceEntity));
        }

        return myplaceDTOList;
    }


    public Page<MyplaceDTO> paging(Pageable pageable, Model model) {
        int page = pageable.getPageNumber() - 1;
        int pageLimit = 6; // 한 페이지에 보여줄 글 갯수

        Integer userId = (Integer) model.getAttribute("id");

        Page<MyplaceEntity> myplaceEntities = myplaceRepository
                .findAllByUser_Id(userId, PageRequest.of(page, pageLimit, Sort.by(Sort.Direction.DESC, "id")));

        Page<MyplaceDTO> myplaceDTOS = myplaceEntities.map(myplace
                -> new MyplaceDTO(myplace.getId(), myplace.getPlaceName(), myplace.getAddress(),
                myplace.getCategory(), myplace.getContents(), myplace.isShare(), myplace.getViews(),
                myplace.getCreatedTime(), myplace.getUserId(), myplace.getUser().getNickname()));

        return myplaceDTOS;
    }



    public MyplaceDTO edit(MyplaceDTO myplaceDTO) throws IOException{
        MyplaceEntity existingEntity = myplaceRepository.findById(myplaceDTO.getId()).orElse(null);
        if (existingEntity != null) {

            // 업로드한 새로운 파일들이 있는지 확인
            if (myplaceDTO.getFile() != null && !myplaceDTO.getFile().isEmpty()) {
                for (MultipartFile file : myplaceDTO.getFile()) {
                    String originalFilename = file.getOriginalFilename(); // 파일의 이름을 가져옴
                    String storedFileName = System.currentTimeMillis() + "_" + originalFilename; // 서버 저장용 이름을 만듦
                    String savePath = "c:/springboot_img/" + storedFileName; // 저장 경로 설정
                    file.transferTo(new File(savePath)); // 해당 경로에 파일 저장

                    // 새로운 파일 엔티티 생성 및 저장
                    MyplaceFileEntity myplaceFileEntity = MyplaceFileEntity.toMyplaceFileEntity(existingEntity, originalFilename, storedFileName);
                    myplaceFileRepository.save(myplaceFileEntity);
                }
            }

            existingEntity.setPlaceName(myplaceDTO.getPlaceName());
            existingEntity.setAddress(myplaceDTO.getAddress());
            existingEntity.setCategory(myplaceDTO.getCategory());
            existingEntity.setContents(myplaceDTO.getContents());
            existingEntity.setShare(myplaceDTO.isShare());
            existingEntity.setUserId(myplaceDTO.getUserId());

            myplaceRepository.save(existingEntity);

            MyplaceDTO updatedDTO = sharedService.findByPlaceId(myplaceDTO.getId());
            return updatedDTO;

        } else {
            return null;
        }
    }

    public void delete(int id) {
        myplaceRepository.deleteById(id);
    }

}
