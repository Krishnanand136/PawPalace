# 🐾 Feature: Pet Vaccination

## Overview
Pet Vaccination enables PawPalace to record vaccination appointments for registered pets.

## User Story
As a pet owner, if my pet is already registered in PawPalace, I should be able to schedule a vaccination with a veterinarian.

## Inputs
- `PetId` (must exist in system)
- `DoctorId` (vet assigned for vaccination)
- Vaccination type (Rabies, Distemper, etc.)
- Appointment date

## Outcomes
- A vaccination appointment is created and linked to the pet’s health record.
- Appointment status is tracked (`SCHEDULED`, `COMPLETED`, `CANCELLED`).
- Owner receives confirmation of the booking.