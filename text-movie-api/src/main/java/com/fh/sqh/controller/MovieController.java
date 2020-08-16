package com.fh.sqh.controller;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fh.sqh.common.JsonData;
import com.fh.sqh.common.RedisUse;
import com.fh.sqh.model.Home;
import com.fh.sqh.model.Movie;
import com.fh.sqh.model.MovieSelect;
import com.fh.sqh.service.MovieService;
import com.fh.sqh.utils.DataTableResult;
import com.fh.sqh.utils.FileReadName;
import com.fh.sqh.utils.MessageUtils;
import com.fh.sqh.utils.OssUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("movieController")
public class MovieController {

    @Resource
    private MovieService movieService;

    @RequestMapping("queryMovie")
    public DataTableResult queryMovie(MovieSelect movieSelect){
        return movieService.queryMovie(movieSelect);
    }

    @RequestMapping("queryHome")
    public JsonData queryHome(){
        String movieHome_sqh = RedisUse.get("movieHome_sqh");
        if(movieHome_sqh==null){
            List<Home> list = movieService.queryHome();
            String s = JSONObject.toJSONString(list);
            RedisUse.set("movieHome_sqh",s);
        }
        return JsonData.getJsonSuccess(movieHome_sqh);
    }

    @RequestMapping("updateOss")
    public Map<String,Object> updateOss(MultipartFile imgs){
        Map map = new HashMap();
        try {
            File file = FileReadName.readFiles(imgs);
            String s = OssUtils.uploadFile(file);
            map.put("success",true);
            map.put("filePath",s);
        }catch (Exception e){
            map.put("error",false);
            e.printStackTrace();
        }
        return map;
    }

    @RequestMapping("addMovie")
    public JsonData addMovie(Movie movie){
        movieService.addMovie(movie);
        return JsonData.getJsonSuccess("新增成功");
    }

    @RequestMapping("buyMovieNum")
    public Map buyMovieNum(Integer movieId){
        Map map = new HashMap();
        movieService.updateMovieById(movieId);
        Movie movie = movieService.selectMovieById(movieId);
        String userIphone = movie.getUserIphone();
        MessageUtils.sendMsg(userIphone);
        map.put("code",200);
        map.put("message","购买成功  注意查收短信");
        return map;
    }

}
