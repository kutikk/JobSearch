package kg.attractor.jobsearch.controller;

import jakarta.validation.Valid;
import kg.attractor.jobsearch.dto.ProfileDto;
import kg.attractor.jobsearch.exceptions.UserNotFoundException;
import kg.attractor.jobsearch.service.ProfileService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("profile")
@RequiredArgsConstructor
public class ProfileController {
    private final ProfileService profileService;

    @GetMapping("{id}")
    public ProfileDto getProfileById(@PathVariable  int id) throws UserNotFoundException {
        return profileService.getProfileById(id);
    }
    @PostMapping("{id}")
    public ProfileDto updateProfile(@Valid  @PathVariable int id, @RequestBody ProfileDto profileDto) throws UserNotFoundException {
        return profileService.updateProfile(id, profileDto);
    }

}
