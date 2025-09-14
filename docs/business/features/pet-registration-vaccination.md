# 🐾 Feature: Pet Registration + Vaccination

## Overview
This feature simplifies the experience for new pets visiting PawPalace for the first time. If a pet is not registered yet, owners can register and schedule a vaccination in a single flow.

## User Story
As a walk-in visitor, if my pet is not yet in the PawPalace system, I want to register my pet and immediately schedule a vaccination appointment in one step.

## Flow
1. Call **Pet Registration API** to create a new pet.
2. Call **Pet Vaccination API** with the new `PetId`.
3. Provide a single combined endpoint `Register and Vaccinate` that internally chains both APIs.

## Inputs
- All inputs from **Pet Registration**
- All inputs from **Pet Vaccination**

## Outcomes
- The pet is registered and assigned a unique `PetId`.
- A vaccination appointment is scheduled for the registered pet.