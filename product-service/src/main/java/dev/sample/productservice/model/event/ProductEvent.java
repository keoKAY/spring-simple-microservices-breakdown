package dev.sample.productservice.model.event;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProductEvent<T> {
    String eventName;
    T data;
}
