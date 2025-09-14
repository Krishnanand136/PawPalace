package com.somanathdevs.pawpalace.controller;

import com.somanathdevs.pawpalace.dto.VaccinationRecordDTO;
import com.somanathdevs.pawpalace.service.VaccinationRecordService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/vaccination")
public class VaccinationRecordController {

    private final VaccinationRecordService service;

    public VaccinationRecordController(VaccinationRecordService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<VaccinationRecordDTO> createRecord(@RequestBody VaccinationRecordDTO dto) {
        return ResponseEntity.status(201).body(service.createVaccinationRecord(dto));
    }

    @GetMapping("/vaccinationRecordId/{vaccinationRecordId}")
    public ResponseEntity<VaccinationRecordDTO> fetchRecordById(@PathVariable String vaccinationRecordId) {
        return ResponseEntity.ok(service.fetchVaccinationRecordById(vaccinationRecordId));
    }
}
