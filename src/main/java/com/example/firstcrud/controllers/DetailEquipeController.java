package com.example.firstcrud.controllers;

import com.example.firstcrud.entities.DetailEquipe;
import com.example.firstcrud.services.IDetailEquipeService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@Tag(name = "Detail Equipe Management")
@RestController
@AllArgsConstructor
@RequestMapping("/DetailEquipe")
@CrossOrigin(origins = "http://localhost:4200/")
public class DetailEquipeController {
    IDetailEquipeService detailEquipeService;

    @GetMapping("/retrieve-all-detailEquipe")
    public List<DetailEquipe> getDetailEquipes() {
        List<DetailEquipe> listDetailEquipe = detailEquipeService.retreiveAllDeteq();
        return listDetailEquipe;
    }

    @GetMapping("/retrieve-detailEquipe/{DetailEquipe-id}")
    public Optional<DetailEquipe> retrieveDetailEquipe(@PathVariable("DetailEquipe-id") Long detailEquId ) {
        return detailEquipeService.retrieveDetEq(detailEquId);
    }

    @GetMapping("/retrieve-detailEquipe-by-equipe/{Equipe-id}")
    public DetailEquipe getDetailEquipeByIdEquipe(@PathVariable("Equipe-id") Long EquId ) {
        return detailEquipeService.getDetailEquipeByEquipeId(EquId);
    }

    @PostMapping("/add-detailequipe")
    public DetailEquipe addDetailEquipe(@RequestBody  DetailEquipe de) {

        return detailEquipeService.addDeteq(de);
    }

    @DeleteMapping("/remove-detailEquipe/{DetailEquipe-id}")
    public void removeDetailEquipe(@PathVariable("DetailEquipe-id") Long detailEquId) {
        detailEquipeService.removeDeteq(detailEquId);
    }
    @PutMapping("/update-detailEquipe")
    public DetailEquipe updateDetailEquipe(@RequestBody DetailEquipe de) {
        DetailEquipe Deq= detailEquipeService.updateDeteq(de);
        return Deq;
    }



}
