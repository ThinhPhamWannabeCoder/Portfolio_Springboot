package com.example.portfolio.service;

import com.example.portfolio.form.response.FormSkillResponse;
import com.example.portfolio.service.dto.DomainDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SkillsSiteService {
    private final SkillService skillService;
    private final DomainService domainService;
    private final DomainSkillRefService domainSkillRefService;

//    Lấy cả cả skill
    public List<FormSkillResponse> getAllSkills(){
        return skillService.getAll().stream().map(skillDTO -> {
            FormSkillResponse response = new FormSkillResponse();
            response.setId(skillDTO.getId());
            response.setName(skillDTO.getName());
            response.setDesc(skillDTO.getDesc());
            response.setDomainName(domainSkillRefService.getBySkillId(skillDTO.getId()).stream()
                    .map(domainSkillRefDTO ->  domainService.getByDomainId(domainSkillRefDTO.getDomainId())
                                                .getName())
                    .collect(Collectors.toList()));
            return response;
        }).collect(Collectors.toList());
    }
//    Filter theo domain
//public List<FormSkillResponse> getAllSkillsByDomain(String domainName){
//    DomainDTO domainDTO = domainService.getByDomainName(domainName);
//
//    return skillService.getAll().stream().map(skillDTO -> {
//        FormSkillResponse response = new FormSkillResponse();
//        response.setId(skillDTO.getId());
//        response.setName(skillDTO.getName());
//        response.setDesc(skillDTO.getDesc());
//        return response;
//    }).collect(Collectors.toList());
//}
//    Filte theo skill type
//    Filter theo ca 2
}
