package com.example.Story.Service;

import com.example.Story.DTO.ChapterDTO;
import com.example.Story.DTO.StoryDTO;
import com.example.Story.Entity.*;
import com.example.Story.Exception.NotFoundException;
import com.example.Story.Helper.ExcelHelper;
import com.example.Story.Mapper.ChapterMapper;
import com.example.Story.Mapper.StoryMapper;
import com.example.Story.Model.ECategory;
import com.example.Story.Rebository.*;
import com.example.Story.Request.storyRequest;
import com.example.Story.messagse.ResponseMessage;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;


@Service
public class StoryService {

    private static final Logger logger = LoggerFactory.getLogger(StoryService.class);

    @Autowired
    private StoryRebository storyRebository;
    @Autowired
    private ChapterRebository chapterRebository;
    @Autowired
    private authorRebository authorrebository;
    @Autowired
    private CategoryRebository categoryRebository;
    @Autowired
    private StoryCategoryRebository storyCategoryRebository;
    @Autowired
    private ChapterMapper chapterMapper;
    @Autowired
    StoryMapper storyMapper;


    public Story addStory(storyRequest request)  {

        Story story = new Story();
        story.setName(request.getNameStory());
        story.setImageUrl(request.getImageUrl());
        story.setIntroduction(request.getIntroduction());
        story.setFull(request.isFull());
        Author author = authorrebository.findByUsername(request.getNameAuthor());
        if(author == null)  {
            Author au = new Author();
            au.setUsername(request.getNameAuthor());
            authorrebository.save(au);
            story.setAuthor(au);
        }
        story.setAuthor(author);
        Set<Category> categories = new HashSet<>();
        Set<String> strCategory = request.getCategory();
            strCategory.forEach(category ->{
                switch (category){
//                    case "Tiên Hiệp":
//                        Category TIENHIEP = categoryRebository.findByName(ECategory.TIENHIEP);
//                        if(TIENHIEP == null)  {
//                            throw new RuntimeException("Error: Category is not found");
//                        }
                       // categories.add(TIENHIEP);
                    case "Tiên Hiệp":
                        Category KIEMHIEP = categoryRebository.findByName(ECategory.KIEMHIEP);
                        if(KIEMHIEP == null)  {
                            throw new RuntimeException("Error: Category is not found");
                        }
                        categories.add(KIEMHIEP);
                        break;
                    case "Ngôn Tình":
                        Category NGONTINH = categoryRebository.findByName(ECategory.NGONTINH);
                        if(NGONTINH == null)  {
                            throw new RuntimeException("Error: Category is not found");
                        }
                        categories.add(NGONTINH);
                        break;
                    case "Đô Thị":
                        Category DOTHI = categoryRebository.findByName(ECategory.DOTHI);
                        if(DOTHI == null)  {
                            throw new RuntimeException("Error: Category is not found");
                        }
                        categories.add(DOTHI);
                        break;
                    case "Quan Trường":
                        Category QUANTRUONG = categoryRebository.findByName(ECategory.QUANTRUONG);
                        if(QUANTRUONG == null)  {
                            throw new RuntimeException("Error: Category is not found");
                        }
                        categories.add(QUANTRUONG);
                        break;
                    case "Võng Du":
                        Category V0NGDU = categoryRebository.findByName(ECategory.VONGDU);
                        if(V0NGDU == null)  {
                            throw new RuntimeException("Error: Category is not found");
                        }
                        categories.add(V0NGDU);
                        break;
                    case "Khoa Huyền":
                        Category KHOAHUYEN = categoryRebository.findByName(ECategory.KHOAHUYEN);
                        if(KHOAHUYEN == null)  {
                            throw new RuntimeException("Error: Category is not found");
                        }
                        categories.add(KHOAHUYEN);
                        break;
                    case "Huyễn Huyền":
                        Category HUYENHUYEN = categoryRebository.findByName(ECategory.HUYENHUYEN);
                        if(HUYENHUYEN == null)  {
                            throw new RuntimeException("Error: Category is not found");
                        }
                        categories.add(HUYENHUYEN);
                        break;
                    case "Dị Giới":
                        Category DIGIOI = categoryRebository.findByName(ECategory.DIGIOI);
                        if(DIGIOI == null)  {
                            throw new RuntimeException("Error: Category is not found");
                        }
                        categories.add(DIGIOI);
                        break;
                    case "DINANG":
                        Category DINANG = categoryRebository.findByName(ECategory.KHOAHUYEN);
                        if(DINANG == null)  {
                            throw new RuntimeException("Error: Category is not found");
                        }
                        categories.add(DINANG);
                        break;
                    case "QUANSU":
                        Category QUANSU = categoryRebository.findByName(ECategory.QUANSU);
                        if(QUANSU == null)  {
                            throw new RuntimeException("Error: Category is not found");
                        }
                        categories.add(QUANSU);
                        break;
                    case "LICHSU":
                        Category LICHSU = categoryRebository.findByName(ECategory.LICHSU);
                        if(LICHSU == null)  {
                            throw new RuntimeException("Error: Category is not found");
                        }
                        categories.add(LICHSU);
                        break;
                    case "XUYENKHONG":
                        Category XUYENKHONG = categoryRebository.findByName(ECategory.XUYENKHONG);
                        if(XUYENKHONG == null)  {
                            throw new RuntimeException("Error: Category is not found");
                        }
                        categories.add(XUYENKHONG);
                        break;
                    case "TRONGSINH":
                        Category TRONGSINH = categoryRebository.findByName(ECategory.TRONGSINH);
                        if(TRONGSINH == null)  {
                            throw new RuntimeException("Error: Category is not found");
                        }
                        categories.add(TRONGSINH);
                        break;
                    case "TRINHTHAM":
                        Category TRINHTHAM = categoryRebository.findByName(ECategory.TRINHTHAM);
                        if(TRINHTHAM == null)  {
                            throw new RuntimeException("Error: Category is not found");
                        }
                        categories.add(TRINHTHAM);
                        break;
                    case "THAMHIEM":
                        Category THAMHIEM = categoryRebository.findByName(ECategory.THAMHIEM);
                        if(THAMHIEM == null)  {
                            throw new RuntimeException("Error: Category is not found");
                        }
                        categories.add(THAMHIEM);
                        break;
                    case "LINHDI":
                        Category LINHDI = categoryRebository.findByName(ECategory.LINHDI);
                        if(LINHDI == null)  {
                            throw new RuntimeException("Error: Category is not found");
                        }
                        categories.add(LINHDI);
                        break;
                    case "TRUYENSAC":
                        Category TRUYENSAC = categoryRebository.findByName(ECategory.TRUYENSAC);
                        if(TRUYENSAC == null)  {
                            throw new RuntimeException("Error: Category is not found");
                        }
                        categories.add(TRUYENSAC);
                        break;
                    case "TRUYENNGUOC":
                        Category TRUYENNGUOC = categoryRebository.findByName(ECategory.TRUYENNGUOC);
                        if(TRUYENNGUOC == null)     {
                            throw new RuntimeException("Error: Category is not found");
                        }
                        categories.add(TRUYENNGUOC);
                        break;
                    case "TRUYENSUNG":
                        Category TRUYENSUNG = categoryRebository.findByName(ECategory.TRUYENSUNG);
                        if(TRUYENSUNG == null)  {
                            throw new RuntimeException("Error: Category is not found");
                        }
                        categories.add(TRUYENSUNG);
                        break;
                    case "TRUYENCUNGDAU":
                        Category TRUYENCUNGDAU = categoryRebository.findByName(ECategory.TRUYENCUNGDAU);
                        if(TRUYENCUNGDAU == null)  {
                            throw new RuntimeException("Error: Category is not found");
                        }
                        categories.add(TRUYENCUNGDAU);
                        break;
                    case "TRUYENNUCUONG":
                        Category TRUYENNUCUONG = categoryRebository.findByName(ECategory.TRUYENNUCUONG);
                        if(TRUYENNUCUONG == null)  {
                            throw new RuntimeException("Error: Category is not found");
                        }
                        categories.add(TRUYENNUCUONG);
                        break;
                    case "TRUYENGIADAU":
                        Category TRUYENGIADAU = categoryRebository.findByName(ECategory.TRUYENGIADAU);
                        if(TRUYENGIADAU == null)  {
                            throw new RuntimeException("Error: Category is not found");
                        }
                        categories.add(TRUYENGIADAU);
                        break;
                    case "DONGPHUONG":
                        Category DONGPHUONG = categoryRebository.findByName(ECategory.DONGPHUONG);
                        if(DONGPHUONG == null)  {
                            throw new RuntimeException("Error: Category is not found");
                        }
                        categories.add(DONGPHUONG);
                        break;
                    case "DAMMY":
                        Category DAMMY = categoryRebository.findByName(ECategory.DAMMY);
                        if(DAMMY == null)  {
                            throw new RuntimeException("Error: Category is not found");
                        }
                        categories.add(DAMMY);
                        break;
                    case "BACHHOP":
                        Category BACHHOP = categoryRebository.findByName(ECategory.BACHHOP);
                        if(BACHHOP  == null)  {
                            throw new RuntimeException("Error: Category is not found");
                        }
                        categories.add(BACHHOP );
                    case "HAIHUOC":
                        Category HAIHUOC = categoryRebository.findByName(ECategory.HAIHUOC);
                        if(HAIHUOC == null)  {
                            throw new RuntimeException("Error: Category is not found");
                        }
                        categories.add(HAIHUOC);
                        break;
                    case "DIEMVAN":
                        Category DIENVAN = categoryRebository.findByName(ECategory.DIENVAN);
                        if(DIENVAN== null)  {
                            throw new RuntimeException("Error: Category is not found");
                        }
                        categories.add(DIENVAN);
                        break;
                    case "CODAI":
                        Category CODAI = categoryRebository.findByName(ECategory.CODAI);
                        if(CODAI == null)  {
                            throw new RuntimeException("Error: Category is not found");
                        }
                        categories.add(CODAI);
                        break;
                    case "MATTHE":
                        Category MATTHE = categoryRebository.findByName(ECategory.MATTHE);
                        if(MATTHE == null)  {
                            throw new RuntimeException("Error: Category is not found");
                        }
                        categories.add(MATTHE);
                        break;
                    case "TRUYENTEEN":
                        Category TRUYENTEEN = categoryRebository.findByName(ECategory.TRUYENTEEN);
                        if(TRUYENTEEN == null)  {
                            throw new RuntimeException("Error: Category is not found");
                        }
                        categories.add(TRUYENTEEN);
                        break;
                    case "PHUONGTAY":
                        Category PHUONGTAY = categoryRebository.findByName(ECategory.PHUONGTAY);
                        if(PHUONGTAY == null)  {
                            throw new RuntimeException("Error: Category is not found");
                        }
                        categories.add(PHUONGTAY);
                        break;
//                    case "NUPHU":
//                        Category NUPHU = categoryRebository.findByName(ECategory.NUPHU);
//                        if(NUPHU == null)  {
//                            throw new RuntimeException("Error: Category is not found");
//                        }
//                        categories.add(NUPHU);
//                        break;
                    case "LIGHTNOVEL":
                        Category LIGHTNOVEL = categoryRebository.findByName(ECategory.LIGHTNOVEL);
                        if(LIGHTNOVEL == null)  {
                            throw new RuntimeException("Error: Category is not found");
                        }
                        categories.add(LIGHTNOVEL);
                        break;
                    case "VIETNAM":
                        Category VIETNAM = categoryRebository.findByName(ECategory.VIETNAM);
                        if(VIETNAM == null)  {
                            throw new RuntimeException("Error: Category is not found");
                        }
                        categories.add(VIETNAM);
                        break;
                    case "DOANVAN":
                        Category DOANVAN = categoryRebository.findByName(ECategory.DOANVAN);
                        if(DOANVAN == null)  {
                            throw new RuntimeException("Error: Category is not found");
                        }
                        categories.add(DOANVAN);
                        break;
                    default:
                        Category TRUYENKHAC = categoryRebository.findByName(ECategory.NUPHU);
                        if(TRUYENKHAC == null)  {
                            throw new RuntimeException("Error: Category is not found");
                        }
                        categories.add(TRUYENKHAC);
                }
            });
        List<StoryCategory> list_str_category = new ArrayList<>();

        for(Category category : categories) {
            StoryCategory sc = new StoryCategory();
            sc.setCategory(category);
            sc.setStory(story);
            list_str_category.add(sc);
        }
        story.setStoryCategory(list_str_category);
        return storyRebository.save(story);

    }

    public Story getStory(long id) {
        Story story = storyRebository.findById(id);
        if(story == null)   {
            throw new NotFoundException("Khong tim thay truyen");
        }
        return story;
    }

    public List<Story> getAllStory()    {
        return storyRebository.findAll();
    }

    public List<StoryDTO> getStoryByCategory(long id)   {
        List<StoryCategory> storyCategory = storyCategoryRebository.findByIdAndCategory(id);
        List<Story> list_story = storyCategory.stream().map(StoryCategory::getStory).collect(Collectors.toList());
        List<StoryDTO> list_dto = new ArrayList<>();
        for(Story st : list_story) {
            StoryDTO dto = storyMapper.covertEntityToDTO(st);
            list_dto.add(dto);
        }
        return list_dto;
    }
    public Chapter addChapter(long id, ChapterDTO entity)    {

        Story story = storyRebository.findById(id);
        if(story == null)   {
            throw new NotFoundException("Khong tim thay");
        }
        Chapter chapter = new Chapter();
        chapter.setIndex(entity.getIndex());
        chapter.setContent(entity.getContent());
        chapter.setTitle(entity.getTitle());
        chapter.setStory(story);
        chapterRebository.save(chapter);
        storyRebository.save(story);
        return chapter;
    }
    public void AddChapter(MultipartFile file) throws IOException {
        ExcelHelper excelHelper = new ExcelHelper();
        List<Chapter> chapters = this.csvToChapter(file.getInputStream());
        chapterRebository.saveAll(chapters);
    }

    public ResponseEntity<ResponseMessage> add_chapters(MultipartFile file){
        ExcelHelper excelHelper = new ExcelHelper();
        String message = "";

        if (excelHelper.hasCSVFormat(file)) {
            try {
                this.AddChapter(file);
                message = "Uploaded the file successfully: " + file.getOriginalFilename();
                return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
            } catch (Exception e) {
                message = "Could not upload the file: " + file.getOriginalFilename() + "!";
                return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
            }
        }
        message = "Please upload a csv file!";
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseMessage(message));

    }

    public Chapter getChapter(long id, String index)    {
        Story story = storyRebository.findById(id);
        Chapter chapter = chapterRebository.findByIndexAndStory(index, story);
        return chapter;
    }
    public List<StoryDTO> getIsfull(boolean bool)  {
        List<Story> list_story = storyRebository.findIsFull(bool);
        List<StoryDTO> dto_ = new ArrayList<>();
        for(Story story : list_story){
            dto_.add(storyMapper.covertEntityToDTO(story));
        }
        return dto_;
    }
    public List<StoryDTO> search(String name)   {
        List<Story> list_story = storyRebository.findByNameLike(name);
        List<StoryDTO> dto_ = new ArrayList<>();
        for(Story story : list_story){
            dto_.add(storyMapper.covertEntityToDTO(story));
        }
        return dto_;
    }
    public void CSVtoStory(MultipartFile file) throws IOException {

        List<storyRequest> requets =  ExcelHelper.csvToStory(file.getInputStream());
        for(storyRequest sr :requets) this.addStory(sr);

    }

    public ResponseEntity<ResponseMessage> saveAll(MultipartFile file) {
        String message = "";

        if (ExcelHelper.hasCSVFormat(file)) {
            try {
                this.CSVtoStory(file);

                message = "Uploaded the file successfully: " + file.getOriginalFilename();
                return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
            } catch (Exception e) {
                message = "Could not upload the file: " + file.getOriginalFilename() + "!";
                return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
            }
        }
        message = "Please upload a csv file!";
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseMessage(message));
    }
    public List<Chapter> csvToChapter(InputStream is) {
        try (BufferedReader fileReader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
             CSVParser csvParser = new CSVParser(fileReader,
                     CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim());) {

            List<Chapter> chapters = new ArrayList<>();

            Iterable<CSVRecord> csvRecords = csvParser.getRecords();
            int index = 1;
            for (CSVRecord csvRecord : csvRecords) {
                Chapter chapter = new Chapter();
                Story story = storyRebository.findByName("Tây Du Ký");
                if (story == null) {
                    throw new NotFoundException("Story not found!!!");
                }
                String ind = String.valueOf(index);
                chapter.setStory(story);
                chapter.setIndex(ind);
                chapter.setTitle(csvRecord.get("title"));
                chapter.setContent(csvRecord.get("content"));
                chapters.add(chapter);
                index++;
            }
            return chapters;
        } catch (IOException e) {
            throw new RuntimeException("fail to parse CSV file: " + e.getMessage());
        }
    }
}
