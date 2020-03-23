package com.dharam.sample;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;

@AllArgsConstructor
@Value
@Builder
public class SampleMessage {
    String message;
    Object data;

}
