package com.library.config;

import com.library.entity.BookEntity;
import com.library.service.BookService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class DataConfig {
    @Bean
    public CommandLineRunner demo(BookService bookService) {
        return args -> {
            bookService.saveBook(BookEntity.of("Wiedzmin Miecz przeznaczenia", "Andrzej Sapkowski", "zbiór opowiadań z gatunku fantasy z 1992 roku opowiadąjacy o wiedźminie Geralcie walczącego z potworami.", 2001L));
            bookService.saveBook(BookEntity.of("Władca Pierścieni", "J.R.R. Tolkien", "powieść high fantasy J.R.R. Tolkiena, której akcja rozgrywa się w mitologicznym świecie Śródziemia.", 1954L));
            bookService.saveBook(BookEntity.of("Virion Wyrocznia", "Andrzej Ziemiański", "Virion– szermierz natchniony który wraz dwudziestoma innymi straceńcami pokonał legion Moy. Jak Chłopak z dobrego domu został bezlitosną maszyną do zabijania?", 2017L));
            bookService.saveBook(BookEntity.of("Harry Potter i Kamień Filozoficzny", " J.K. Rowling", " powieść fantasty która jest pierwszą częścią siedmiotomowej serii powieści Harry Potter i stanowi debiut literacki Rowling. ", 1997L));
            bookService.saveBook(BookEntity.of("Pan Lodowego Ogrodu", "Jarosław Grzędowicz", " Planeta powitała go mgłą i śmiercią. Dalej jest tylko gorzej...Vuko Drakkainen ląduje samotnie na odległej, zamieszkanej przez człekopodobną cywilizację planecie Midgaard.", 2005L));
            bookService.saveBook(BookEntity.of("Gra o tron", "George R. R. Martin", " Powieść z gatunku fantasy, pierwszy tom sagi Pieśń lodu i ognia George’a R.R. Martina. Opowiada o dążeniu do władzy rodów gotowych poświecić wszystko aby osiągnąć swój cel.", 1996L));
        };
    }
}
