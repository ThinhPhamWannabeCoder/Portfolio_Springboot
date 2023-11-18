package com.example.portfolio.service;

import com.example.portfolio.form.response.FormProjectResponse;
import com.example.portfolio.service.dto.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProjectSiteService {
    private final  ProjectService projectService;
    private final TopicService topicService;
    private final DomainService domainService;
    private final ProjectLanguageRefService languageRefService;
    private final ProjectToolRefService toolRefService;
    private final SkillService skillService;


    public List<FormProjectResponse> getAllProjectsByDomainName(String domainName){
//        nho kiem tra null trong qua trinh lam
        DomainDTO domainDTO = domainService.getByName(domainName);
        List<TopicDTO> topicDTOS = topicService.getAllByDomainId(domainDTO.getId());
//        Thon tin project
        List<ProjectDTO> projectDTOS =  new ArrayList<>();
        topicDTOS.stream().forEach(topicDTO -> {
            projectDTOS.addAll(projectService.getAllByTopicId(topicDTO.getId()));
        });
//        Chinh thuc add thong tin de gui ve
        List<FormProjectResponse> responses = new ArrayList<>();
        projectDTOS.stream().forEach( projectDTO -> {
            FormProjectResponse response  = new FormProjectResponse();
            response.setId(projectDTO.getId());
            response.setName(projectDTO.getName());
            response.setDesc(projectDTO.getDesc());
            response.setDate(projectDTO.getDate());
            response.setDomainName(domainName);
            response.setTopicName(topicService.getById(projectDTO.getTopicId()).getName());
            response.setLanguages(languageRefService.getAllByProjectId(projectDTO.getId())
                            .stream()
                            .map(languageRef -> languageRef.getLanguageDTO().getName())
                            .collect(Collectors.toList()));
            response.setTools(toolRefService.getAllByProjectId(projectDTO.getId())
                            .stream()
                            .map(toolRef -> toolRef.getToolDTO().getName())
                            .collect(Collectors.toList()));
            responses.add(response);
        });
        return responses;

    }
    public List<FormProjectResponse> getAllProjects(){
        List<ProjectDTO> projectDTOS = projectService.getAll();
        List<FormProjectResponse> responses = new ArrayList<>();

        projectDTOS.stream().forEach(
                projectDTO -> {
                    FormProjectResponse response = new FormProjectResponse();
                    response.setId(projectDTO.getId());
                    response.setName(projectDTO.getName());
                    response.setDesc(projectDTO.getName());
                    response.setDate(projectDTO.getDate());
                    response.setTopicName(topicService.getById(projectDTO.getTopicId()).getName());
                    response.setDomainName(domainService.getById(topicService.getById(projectDTO.getTopicId()).getDomainId()).getName());
                    response.setLanguages(languageRefService.getAllByProjectId(projectDTO.getId())
                            .stream()
                            .map(languageRef -> languageRef.getLanguageDTO().getName())
                            .collect(Collectors.toList()));
                    response.setTools(toolRefService.getAllByProjectId(projectDTO.getId())
                            .stream()
                            .map(toolRef -> toolRef.getToolDTO().getName())
                            .collect(Collectors.toList()));
                    responses.add(response);
                });
        return responses;
    }
}
