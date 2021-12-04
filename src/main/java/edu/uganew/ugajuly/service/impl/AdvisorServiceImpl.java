package edu.uganew.ugajuly.service.impl;

import antlr.StringUtils;
import edu.uganew.ugajuly.entity.Advisor;
import edu.uganew.ugajuly.repository.AdvisorRepository;
import edu.uganew.ugajuly.service.AdvisorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.*;

@Service
public class AdvisorServiceImpl implements AdvisorService {

    @Autowired
    private AdvisorRepository advisorRepository;

    public AdvisorServiceImpl(AdvisorRepository advisorRepository) {
        this.advisorRepository = advisorRepository;
    }

    @Override
    public List<Advisor> getAllAdvisors()
    {
        return advisorRepository.findAll();
    }
    @Override
    public Advisor saveAdvisor(Advisor advisor)
    {
        return advisorRepository.save(advisor);
    }
    @Override
    public Advisor getAdvisorById(Long id){ return advisorRepository.findById(id).get();}
    @Override
    public Advisor updateAdvisor(Advisor advisor){ return advisorRepository.save(advisor);}
    @Override
    public void deleteAdvisorById(Long id) {
        advisorRepository.deleteById(id);
    }

    public List<Advisor> findByStuLastName(String studendName,String majorname) {

        return advisorRepository.findByStuLastName(studendName.substring(0,2),majorname);
    }

    public List<Advisor> findByKeyword(String keyword)
    {
        return advisorRepository.findByKeyword(keyword);
    }
}
