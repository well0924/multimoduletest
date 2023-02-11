package dev.be.modulecommon.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CommonDemoService {
    public String commonService(){
        return "commonService";
    }
}
