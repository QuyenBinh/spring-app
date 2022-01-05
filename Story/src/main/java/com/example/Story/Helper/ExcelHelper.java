package com.example.Story.Helper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.example.Story.Entity.Author;
import com.example.Story.Entity.Category;
import com.example.Story.Entity.Chapter;
import com.example.Story.Entity.Story;
import com.example.Story.Exception.NotFoundException;
import com.example.Story.Rebository.StoryRebository;
import com.example.Story.Request.storyRequest;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import org.h2.util.Cache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

public class ExcelHelper {

    public static String TYPE = "text/csv";
    static String[] HEADERs = { "Id", "Title", "Description", "Published" };
    @Autowired
    private StoryRebository storyRebository;

    public static boolean hasCSVFormat(MultipartFile file) {

        if (!TYPE.equals(file.getContentType())) {
            return false;
        }

        return true;
    }

    public static List<storyRequest> csvToStory(InputStream is) {
        try (BufferedReader fileReader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
             CSVParser csvParser = new CSVParser(fileReader,
                     CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim());) {

            List<storyRequest> request = new ArrayList<>();

            Iterable<CSVRecord> csvRecords = csvParser.getRecords();

            for (CSVRecord csvRecord : csvRecords) {
                String str = ", ";
                String [] category = csvRecord.get("category").split(", ");
                List<String> categories = new ArrayList<>();
                for(String s : category)    {
                    categories.add(s);
                }
                System.out.println("++++++++++++++++++++++++++++++++++++");
                for(int  i = 0;i<categories.size();i++)
                    System.out.println(categories.get(i));
                storyRequest str_request = new storyRequest(csvRecord.get("name"), csvRecord.get("author"), csvRecord.get("img"), csvRecord.get("intro"),csvRecord.get("isFull").equals("Full")?true:false,categories);
                request.add(str_request);
            }
            return request;
        } catch (IOException e) {
            throw new RuntimeException("fail to parse CSV file: " + e.getMessage());
        }
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
                Story story = storyRebository.findByName(csvRecord.get("name"));
                if(story == null)   {
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