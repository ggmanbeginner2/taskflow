package com.taskflow.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// TODO – Fase 4
// GET    /api/tasks       -> alle taken van ingelogde gebruiker
// POST   /api/tasks       -> nieuwe taak aanmaken
// PUT    /api/tasks/{id}  -> taak bijwerken
// DELETE /api/tasks/{id}  -> taak verwijderen

@RestController
@RequestMapping("/api/tasks")
public class TaskController {
}
