package com.cos.capybara.Profile;

import org.springframework.stereotype.Service;

@Service
public class ProfileService implements DefaultProfileService{

    public final ProfileRepository profileRepository;

    public ProfileService(com.cos.capybara.Profile.ProfileRepository profileRepository){
        this.profileRepository = profileRepository;
    }

    public Profile getProfile(Long id){
        return profileRepository.getById(id);
    }
}
