package ru.itis.mq.app;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Message {

    private String name;
    private String email;
    @JsonProperty(value = "phone_number")
    private String phoneNumber;
    private String message;
}
