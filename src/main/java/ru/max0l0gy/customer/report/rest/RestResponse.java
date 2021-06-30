package ru.max0l0gy.customer.report.rest;

import lombok.Data;
import lombok.experimental.Accessors;

import java.time.Instant;

@Data
@Accessors(chain = true)
public class RestResponse<T> {
    private String status;
    private Long currentTimestamp;
    private T data;

    public static <T> RestResponse<T> success(T data) {
        return new RestResponse<T>()
                .setCurrentTimestamp(Instant.now().toEpochMilli())
                .setStatus("success")
                .setData(data);
    }

}
