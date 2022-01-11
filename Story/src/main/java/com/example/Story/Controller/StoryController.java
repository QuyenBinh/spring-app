package com.example.Story.Controller;

import com.example.Story.DTO.CategoryDTO;
import com.example.Story.DTO.ChapterDTO;
import com.example.Story.DTO.StoryDTO;
import com.example.Story.Entity.Category;
import com.example.Story.Entity.Chapter;
import com.example.Story.Entity.Story;
import com.example.Story.Helper.ExcelHelper;
import com.example.Story.Mapper.CategoryMapper;
import com.example.Story.Mapper.ChapterMapper;
import com.example.Story.Mapper.StoryMapper;
import com.example.Story.Rebository.CategoryRebository;
import com.example.Story.Rebository.ChapterRebository;
import com.example.Story.Request.storyRequest;
import com.example.Story.Service.StoryService;
import com.example.Story.messagse.ResponseMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/story")
public class StoryController {

    @Autowired
    StoryService service;
    @Autowired
    StoryMapper mapper;
    @Autowired
    ChapterMapper chapterMapper;
    @Autowired
    private CategoryRebository categoryRebository;
    @Autowired
    CategoryMapper categoryMapper;

    // Thêm truyện
    @PostMapping("/add")
    public ResponseEntity<StoryDTO> addStory(@RequestBody storyRequest request)  {
        Story story = service.addStory(request);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    @PostMapping("/save-all")
    public ResponseEntity<ResponseMessage> saveAll(@RequestParam("file")MultipartFile file)  {
        return service.saveAll(file);
    }

    // Lấy truyện theo id
    @GetMapping("/{id}/detail")
    public ResponseEntity<StoryDTO> getStory(@PathVariable long id)  {
        StoryDTO dto = service.getStory(id);
        return new ResponseEntity(dto, HttpStatus.OK);
    }

    //Lấy truyện theo thể loại
    @GetMapping("/category/{id}")
    public ResponseEntity<List<StoryDTO>> getCategory(@PathVariable long id)   {
        List<StoryDTO> stories_dto = service.getStoryByCategory(id);
        return new ResponseEntity<>(stories_dto, HttpStatus.OK);
    }

    // Thêm chapter
    @PostMapping("/add-chapter/{id}")
    public ResponseEntity<?> addChapter(@RequestBody ChapterDTO chapter,@PathVariable("id") long id) {

        Chapter ct =  service.addChapter(id,chapter);
        return new ResponseEntity<>(ct, HttpStatus.OK);

    }
    @PostMapping("/add-chapter")
    public ResponseEntity<ResponseMessage> Addchapter(@RequestParam("file")  MultipartFile file) throws IOException {
        return service.add_chapters(file);
    }
    // Lấy chapter theo truyện
    @GetMapping("/{id}/chapter/{index}")
    public ResponseEntity<ChapterDTO> getChapter(@PathVariable("id") long id,@PathVariable("index") String index)  {
            ChapterDTO chapterDTO = service.getChapter(id, index);
            return new ResponseEntity<ChapterDTO>(chapterDTO, HttpStatus.OK);
    }
    //lấy tất cả chapter của truyện
    @GetMapping("/{id}/chapter/all")
    public ResponseEntity<List<ChapterDTO>> allChapter(@PathVariable("id") long id)   {
        return new ResponseEntity<>(service.allChapter(id),HttpStatus.OK);
    }

    // Lấy danh sách truyện full / chưa full theo param
    @GetMapping("/isfull")
    public ResponseEntity<List<StoryDTO>> getIsFull(@RequestParam(required = false) boolean bool)  {
        return new ResponseEntity<>(service.getIsfull(bool), HttpStatus.OK);
    }

    //tìm kiếm truyện
    @GetMapping("/search")
    public ResponseEntity<List<StoryDTO>> search(@RequestParam(required = false) String name)   {
            return new ResponseEntity<>(service.search(name), HttpStatus.OK);
    }
    @GetMapping("/categories")
    public ResponseEntity<List<CategoryDTO>> getAllCategories()    {
        return new ResponseEntity<>(service.allCategory(),HttpStatus.OK);
    }
    @PostMapping("/{id}/upload/image")
    public ResponseEntity<String> uploadImage(@RequestParam("image") MultipartFile multipartFile, @PathVariable("id") long id)    {
        service.upLoadImageForStory(multipartFile,id);
        return new ResponseEntity<>("Upload image successfully", HttpStatus.OK);
    }
    @GetMapping("/all")
    public ResponseEntity<List<StoryDTO>> getAllStory() {
        return new ResponseEntity<>(service.getAllStory(),HttpStatus.OK);
    }
    // Truyện hot
    @GetMapping("/hot")
    public ResponseEntity<List<StoryDTO>> hotStory()    {
        return new ResponseEntity<>(service.hotStory(), HttpStatus.OK);
    }
    // Truyện full
    @GetMapping("/full")
    public ResponseEntity<List<StoryDTO>> sotryIsFull() {
        return new ResponseEntity<>(service.storyIsFull(),HttpStatus.OK);
    }
    // Truyện chưa full
    @GetMapping("/not-full")
    public ResponseEntity<List<StoryDTO>> sotryIsNotFull() {
        return new ResponseEntity<>(service.storyIsNotFull(),HttpStatus.OK);
    }
}
