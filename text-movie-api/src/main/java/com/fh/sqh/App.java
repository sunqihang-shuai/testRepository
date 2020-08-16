package com.fh.sqh;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Hello world!
 *
 */
@SpringBootApplication
@MapperScan("com.fh.sqh.mapper")
public class App 
{
    public static void main( String[] args )
    {
        System.out.println("123");
        SpringApplication.run(App.class,args);
    }
}
