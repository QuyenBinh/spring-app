package com.example.Story.Service;

import com.example.Story.DTO.ChapterDTO;
import com.example.Story.DTO.StoryDTO;
import com.example.Story.Entity.*;
import com.example.Story.Exception.NotFoundException;
import com.example.Story.Helper.ExcelHelper;
import com.example.Story.Mapper.ChapterMapper;
import com.example.Story.Mapper.StoryMapper;
import com.example.Story.Model.Categories;
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
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.stream.Collectors;


@Service
public class StoryService {

    private static final Logger logger = LoggerFactory.getLogger(StoryService.class);
    @Value("${image.path}")
    private String image;

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
        else {
            story.setAuthor(author);
        }
        Set<Category> categories = new HashSet<>();
        List<String> strCategory = request.getCategory();
            strCategory.forEach(category ->{
                switch (category){
                    case "Tiên Hiệp":
                        Category TIENHIEP = categoryRebository.findByName(Categories.TIENHIEP);
                        if(TIENHIEP == null)  {
                            throw new RuntimeException("Error: Category is not found");
                        }
                        categories.add(TIENHIEP);
                        break;
                    case "Kiếm Hiệp":
                        Category KIEMHIEP = categoryRebository.findByName(Categories.KIEMHIEP);
                        if(KIEMHIEP == null)  {
                            throw new RuntimeException("Error: Category is not found");
                        }
                        categories.add(KIEMHIEP);
                        break;
                    case "Ngôn Tình":
                        Category NGONTINH = categoryRebository.findByName(Categories.NGONTINH);
                        if(NGONTINH == null)  {
                            throw new RuntimeException("Error: Category is not found");
                        }
                        categories.add(NGONTINH);
                        break;
                    case "Đô Thị":
                        Category DOTHI = categoryRebository.findByName(Categories.DOTHI);
                        if(DOTHI == null)  {
                            throw new RuntimeException("Error: Category is not found");
                        }
                        categories.add(DOTHI);
                        break;
                    case "Quan Trường":
                        Category QUANTRUONG = categoryRebository.findByName(Categories.QUANTRUONG);
                        if(QUANTRUONG == null)  {
                            throw new RuntimeException("Error: Category is not found");
                        }
                        categories.add(QUANTRUONG);
                        break;
                    case "Võng Du":
                        Category V0NGDU = categoryRebository.findByName(Categories.VONGDU);
                        if(V0NGDU == null)  {
                            throw new RuntimeException("Error: Category is not found");
                        }
                        categories.add(V0NGDU);
                        break;
                    case "Khoa Huyền":
                        Category KHOAHUYEN = categoryRebository.findByName(Categories.KHOAHUYEN);
                        if(KHOAHUYEN == null)  {
                            throw new RuntimeException("Error: Category is not found");
                        }
                        categories.add(KHOAHUYEN);
                        break;
                    case "Huyền Huyễn":
                        Category HUYENHUYEN = categoryRebository.findByName(Categories.HUYENHUYEN);
                        if(HUYENHUYEN == null)  {
                            throw new RuntimeException("Error: Category is not found");
                        }
                        categories.add(HUYENHUYEN);
                        break;
                    case "Dị Giới":
                        Category DIGIOI = categoryRebository.findByName(Categories.DIGIOI);
                        if(DIGIOI == null)  {
                            throw new RuntimeException("Error: Category is not found");
                        }
                        categories.add(DIGIOI);
                        break;
                    case "Dị Năng":
                        Category DINANG = categoryRebository.findByName(Categories.KHOAHUYEN);
                        if(DINANG == null)  {
                            throw new RuntimeException("Error: Category is not found");
                        }
                        categories.add(DINANG);
                        break;
                    case "Quân Sự":
                        Category QUANSU = categoryRebository.findByName(Categories.QUANSU);
                        if(QUANSU == null)  {
                            throw new RuntimeException("Error: Category is not found");
                        }
                        categories.add(QUANSU);
                        break;
                    case "Lịch Sử":
                        Category LICHSU = categoryRebository.findByName(Categories.LICHSU);
                        if(LICHSU == null)  {
                            throw new RuntimeException("Error: Category is not found");
                        }
                        categories.add(LICHSU);
                        break;
                    case "Xuyên Không":
                        Category XUYENKHONG = categoryRebository.findByName(Categories.XUYENKHONG);
                        if(XUYENKHONG == null)  {
                            throw new RuntimeException("Error: Category is not found");
                        }
                        categories.add(XUYENKHONG);
                        break;
                    case "Trọng Sinh":
                        Category TRONGSINH = categoryRebository.findByName(Categories.TRONGSINH);
                        if(TRONGSINH == null)  {
                            throw new RuntimeException("Error: Category is not found");
                        }
                        categories.add(TRONGSINH);
                        break;
                    case "Trinh Thám":
                        Category TRINHTHAM = categoryRebository.findByName(Categories.TRINHTHAM);
                        if(TRINHTHAM == null)  {
                            throw new RuntimeException("Error: Category is not found");
                        }
                        categories.add(TRINHTHAM);
                        break;
                    case "Thám Hiểm":
                        Category THAMHIEM = categoryRebository.findByName(Categories.THAMHIEM);
                        if(THAMHIEM == null)  {
                            throw new RuntimeException("Error: Category is not found");
                        }
                        categories.add(THAMHIEM);
                        break;
                    case "Linh Dị":
                        Category LINHDI = categoryRebository.findByName(Categories.LINHDI);
                        if(LINHDI == null)  {
                            throw new RuntimeException("Error: Category is not found");
                        }
                        categories.add(LINHDI);
                        break;
                    case "Truyện Sắc":
                        Category TRUYENSAC = categoryRebository.findByName(Categories.TRUYENSAC);
                        if(TRUYENSAC == null)  {
                            throw new RuntimeException("Error: Category is not found");
                        }
                        categories.add(TRUYENSAC);
                        break;
                    case "Truyện Ngược":
                        Category TRUYENNGUOC = categoryRebository.findByName(Categories.TRUYENNGUOC);
                        if(TRUYENNGUOC == null)     {
                            throw new RuntimeException("Error: Category is not found");
                        }
                        categories.add(TRUYENNGUOC);
                        break;
                    case "Truyện Sủng":
                        Category TRUYENSUNG = categoryRebository.findByName(Categories.TRUYENSUNG);
                        if(TRUYENSUNG == null)  {
                            throw new RuntimeException("Error: Category is not found");
                        }
                        categories.add(TRUYENSUNG);
                        break;
                    case "Truyện Cung Đấu":
                        Category TRUYENCUNGDAU = categoryRebository.findByName(Categories.TRUYENCUNGDAU);
                        if(TRUYENCUNGDAU == null)  {
                            throw new RuntimeException("Error: Category is not found");
                        }
                        categories.add(TRUYENCUNGDAU);
                        break;
                    case "Truyện Nữ Cường":
                        Category TRUYENNUCUONG = categoryRebository.findByName(Categories.TRUYENNUCUONG);
                        if(TRUYENNUCUONG == null)  {
                            throw new RuntimeException("Error: Category is not found");
                        }
                        categories.add(TRUYENNUCUONG);
                        break;
                    case "Truyện Gia Đấu":
                        Category TRUYENGIADAU = categoryRebository.findByName(Categories.TRUYENGIADAU);
                        if(TRUYENGIADAU == null)  {
                            throw new RuntimeException("Error: Category is not found");
                        }
                        categories.add(TRUYENGIADAU);
                        break;
                    case "Đông Phương":
                        Category DONGPHUONG = categoryRebository.findByName(Categories.DONGPHUONG);
                        if(DONGPHUONG == null)  {
                            throw new RuntimeException("Error: Category is not found");
                        }
                        categories.add(DONGPHUONG);
                        break;
                    case "Đam Mỹ":
                        Category DAMMY = categoryRebository.findByName(Categories.DAMMY);
                        if(DAMMY == null)  {
                            throw new RuntimeException("Error: Category is not found");
                        }
                        categories.add(DAMMY);
                        break;
                    case "Bách Hợp":
                        Category BACHHOP = categoryRebository.findByName(Categories.BACHHOP);
                        if(BACHHOP  == null)  {
                            throw new RuntimeException("Error: Category is not found");
                        }
                        categories.add(BACHHOP );
                    case "Hài Hước":
                        Category HAIHUOC = categoryRebository.findByName(Categories.HAIHUOC);
                        if(HAIHUOC == null)  {
                            throw new RuntimeException("Error: Category is not found");
                        }
                        categories.add(HAIHUOC);
                        break;
                    case "Diễm Văn":
                        Category DIENVAN = categoryRebository.findByName(Categories.DIENVAN);
                        if(DIENVAN== null)  {
                            throw new RuntimeException("Error: Category is not found");
                        }
                        categories.add(DIENVAN);
                        break;
                    case "Cổ Đại":
                        Category CODAI = categoryRebository.findByName(Categories.CODAI);
                        if(CODAI == null)  {
                            throw new RuntimeException("Error: Category is not found");
                        }
                        categories.add(CODAI);
                        break;
                    case "Mạt Thế":
                        Category MATTHE = categoryRebository.findByName(Categories.MATTHE);
                        if(MATTHE == null)  {
                            throw new RuntimeException("Error: Category is not found");
                        }
                        categories.add(MATTHE);
                        break;
                    case "Truyện Teen":
                        Category TRUYENTEEN = categoryRebository.findByName(Categories.TRUYENTEEN);
                        if(TRUYENTEEN == null)  {
                            throw new RuntimeException("Error: Category is not found");
                        }
                        categories.add(TRUYENTEEN);
                        break;
                    case "Phương Tây":
                        Category PHUONGTAY = categoryRebository.findByName(Categories.PHUONGTAY);
                        if(PHUONGTAY == null)  {
                            throw new RuntimeException("Error: Category is not found");
                        }
                        categories.add(PHUONGTAY);
                        break;
                    case "Nữ Phụ":
                        Category NUPHU = categoryRebository.findByName(Categories.NUPHU);
                        if(NUPHU == null)  {
                            throw new RuntimeException("Error: Category is not found");
                        }
                        categories.add(NUPHU);
                        break;
                    case "Light Novel":
                        Category LIGHTNOVEL = categoryRebository.findByName(Categories.LIGHTNOVEL);
                        if(LIGHTNOVEL == null)  {
                            throw new RuntimeException("Error: Category is not found");
                        }
                        categories.add(LIGHTNOVEL);
                        break;
                    case "Việt Nam":
                        Category VIETNAM = categoryRebository.findByName(Categories.VIETNAM);
                        if(VIETNAM == null)  {
                            throw new RuntimeException("Error: Category is not found");
                        }
                        categories.add(VIETNAM);
                        break;
                    case "Đoản Văn":
                        Category DOANVAN = categoryRebository.findByName(Categories.DOANVAN);
                        if(DOANVAN == null)  {
                            throw new RuntimeException("Error: Category is not found");
                        }
                        categories.add(DOANVAN);
                        break;
                    default:
                        Category TRUYENKHAC = categoryRebository.findByName(Categories.TRUYENKHAC);
                        categories.add(TRUYENKHAC);
                        break;
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

    public StoryDTO getStory(long id) {
        Story story = storyRebository.findById(id);
      //  List<String> categories = new ArrayList<>();
        if(story == null)   {
            throw new NotFoundException("Khong tim thay truyen");
        }
        StoryDTO dto = storyMapper.covertEntityToDTO(story);
        List<StoryCategory> sc = storyCategoryRebository.findByStory(story);
        List<Category> cate = sc.stream().map(StoryCategory::getCategory).collect(Collectors.toList());
        List<String> ecategories = cate.stream().map(Category::getName).collect(Collectors.toList());
        List<Chapter> chapters = chapterRebository.findByStory(story);
        List<ChapterDTO> c_dto = new ArrayList<>();
        for(Chapter c : chapters)   {
            ChapterDTO chapter_dto = chapterMapper.entityToDTO(c);
            c_dto.add(chapter_dto);
        }
        dto.setChapter(c_dto);
        dto.setCategory(ecategories);
        return dto;
    }

    public List<StoryDTO> getAllStory()    {
        List<Story> list = storyRebository.findAll();
        List<StoryDTO> dtos = new ArrayList<>();
        for(Story s :list)  {
            StoryDTO dto = storyMapper.covertEntityToDTO(s);
            List<StoryCategory> sc = storyCategoryRebository.findByStory(s);
            List<Category> cate = sc.stream().map(StoryCategory::getCategory).collect(Collectors.toList());
            List<String> ecategories = cate.stream().map(Category::getName).collect(Collectors.toList());
            dto.setCategory(ecategories);
            dtos.add(dto);
        }
        return dtos;
    }

    public List<StoryDTO> getStoryByCategory(long id)   {
        List<StoryCategory> storyCategory = storyCategoryRebository.findByCategory(id);
        List<Story> list_story = storyCategory.stream().map(StoryCategory::getStory).collect(Collectors.toList());
        List<StoryDTO> list_dto = new ArrayList<>();
        for(Story st : list_story) {
            List<StoryCategory> sc = storyCategoryRebository.findByStory(st);
            List<Category> cate = sc.stream().map(StoryCategory::getCategory).collect(Collectors.toList());
            List<String> categories = cate.stream().map(Category::getName).collect(Collectors.toList());
            StoryDTO dto = storyMapper.covertEntityToDTO(st);
            dto.setCategory(categories);
            dto.setCount(list_story.size());
            list_dto.add(dto);
        }
        return list_dto;
    }
    public List<StoryDTO> storyIsFull()   {
        List<Story> storyList = storyRebository.findIsFull(true);
        List<StoryDTO> list_dto = new ArrayList<>();
        for(Story st : storyList) {
            List<StoryCategory> sc = storyCategoryRebository.findByStory(st);
            List<Category> cate = sc.stream().map(StoryCategory::getCategory).collect(Collectors.toList());
            List<String> categories = cate.stream().map(Category::getName).collect(Collectors.toList());
            StoryDTO dto = storyMapper.covertEntityToDTO(st);
            dto.setCategory(categories);
            dto.setCount(storyList.size());
            list_dto.add(dto);
        }
        return list_dto;
    }
    public List<StoryDTO> storyIsNotFull()   {
        List<Story> storyList = storyRebository.findIsFull(false);
        List<StoryDTO> list_dto = new ArrayList<>();
        for(Story st : storyList) {
            List<StoryCategory> sc = storyCategoryRebository.findByStory(st);
            List<Category> cate = sc.stream().map(StoryCategory::getCategory).collect(Collectors.toList());
            List<String> categories = cate.stream().map(Category::getName).collect(Collectors.toList());
            StoryDTO dto = storyMapper.covertEntityToDTO(st);
            dto.setCategory(categories);
            dto.setCount(storyList.size());
            list_dto.add(dto);
        }
        return list_dto;
    }
    public Chapter addChapter(long id, ChapterDTO entity)    {

        Story story = storyRebository.findById(id);
        if(story == null)   {
            throw new NotFoundException("Khong tim thay truyen");
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

    public ChapterDTO getChapter(long id, String index)    {
        Story story = storyRebository.findById(id);
        if(story == null) throw new NotFoundException("Không tìm thấy truyện!!");
        Chapter chapter = chapterRebository.findByIndexAndStory(index, story);
        Integer ind = Integer.valueOf(index);
        String str = ++ind +"";
        ChapterDTO chapterDTO = chapterMapper.entityToDTO(chapter);
        chapterDTO.setNextchapter(str);
        return chapterDTO;
    }
    public List<StoryDTO> getIsfull(boolean bool)  {
        List<Story> list_story = storyRebository.findIsFull(bool);
        List<StoryDTO> dto_ = new ArrayList<>();
        for(Story story : list_story){
            dto_.add(storyMapper.covertEntityToDTO(story));
        }
        return dto_;
    }
    public List<ChapterDTO> allChapter(long id) {
        Story story = storyRebository.findById(id);
        if(story == null) throw new NotFoundException("Không tìm thấy truyện!!");
        List<Chapter> chapters = chapterRebository.findByStory(story);
        List<ChapterDTO> dtos= new ArrayList<>();
        for(Chapter c : chapters) {
            String index = c.getIndex();
            ChapterDTO chapterDTO = chapterMapper.entityToDTO(c);
            Integer ind = Integer.valueOf(index) +1;
            String str = ind +"";
            chapterDTO.setNextchapter(str);
            dtos.add(chapterDTO);
        }
        return dtos;
    }
    public List<StoryDTO> search(String name)   {
     //   List<Story> list_story = storyRebository.findByNameLike(name);
        List<Story> list_str = storyRebository.findAll();
        List<Story> str_list = new ArrayList<>();
        String n = name.toLowerCase(Locale.ROOT);
        for(Story s : list_str)   {
            String str = s.getName().toLowerCase(Locale.ROOT);
            if(str.contains(n))   {
                str_list.add(s);
            }
        }
        List<StoryDTO> dto_ = new ArrayList<>();
        for(Story story : str_list){
            StoryDTO dto = storyMapper.covertEntityToDTO(story);
            List<StoryCategory> sc = storyCategoryRebository.findByStory(story);
            List<Category> cate = sc.stream().map(StoryCategory::getCategory).collect(Collectors.toList());
            List<String> ecategories = cate.stream().map(Category::getName).collect(Collectors.toList());
            dto.setCategory(ecategories);
            dto_.add(dto);
        }
        return dto_;
    }
    public List<StoryDTO> hotStory()    {

        List<StoryDTO> dtos = new ArrayList<>();
        for(long i = 0;i<6;i++)  {
            Random rand = new Random();
            int rad = rand.nextInt((42-36)+1) + 36;
            Story story = storyRebository.findById(rad);
            StoryDTO dto = storyMapper.covertEntityToDTO(story);
            dtos.add(dto);
        }
        return dtos;
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
                List<Story> list_story = storyRebository.findByNameLike(csvRecord.get("name"));
                if (list_story.isEmpty()) {
                    throw new NotFoundException("story not found!!!");
                }
                Story story = list_story.get(0);
                System.out.println(story.getName());
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
    public void upLoadImageForStory(MultipartFile multipartFile, long id)    {
        Story story = storyRebository.findById(id);
        String name = multipartFile.getOriginalFilename();
        try{
            FileCopyUtils.copy(multipartFile.getOriginalFilename().getBytes(StandardCharsets.UTF_8), new File
                    (this.image + name));
            story.setImageUrl(this.image + name);
            storyRebository.save(story);
        } catch (IOException e) {
            logger.info("Upload image fail :" + e.getMessage());
        }
    }
//    public void upLoadImageForCategory(MultipartFile multipartFile, long id)    {
//        Category category = categoryRebository.getById(id);
//        String name = multipartFile.getOriginalFilename();
//        try{
//            FileCopyUtils.copy(multipartFile.getOriginalFilename().getBytes(StandardCharsets.UTF_8), new File
//                    (this.image + name));
//            category.setImgUrl(this.image + name);
//            storyRebository.save(story);
//        } catch (IOException e) {
//            logger.info("Upload image fail :" + e.getMessage());
//        }
//    }
}
