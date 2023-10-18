package com.olofofo.data.models;

import lombok.Data;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;

@Data
public class Entry {

    @Id
    private  String  id;
    private String title;
    private String body;
    private String OwnerName;
    private LocalDateTime createdDate = LocalDateTime.now();

}
